package com.depression.resourceserv.resourceserv.services;

import com.depression.resourceserv.resourceserv.model.AuthenticationClient;
import com.depression.resourceserv.resourceserv.model.OAuth2Client;
import com.depression.resourceserv.resourceserv.repository.OAuth2ClientRepository;
import com.depression.resourceserv.resourceserv.repository.OAuthClientDetailsRepository;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
@Transactional
public class ClientRequestService {

    @Autowired
    private OAuth2ClientRepository oauth2ClientRepository;

    @Autowired
    private OAuthClientDetailsRepository oauthClientDetailsRepository;

    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public AuthenticationClient addClient(AuthenticationClient client, String redirectUrl){
        String newClientId = UUID.randomUUID().toString();
        String newClientSecret = RandomStringUtils.randomAlphanumeric(30);
        int tokenValidity = 60*60*24*30;
        long refreshValidity = 60*60*24*31;

        OAuth2Client oauth2Client = new OAuth2Client();
        oauth2Client.setClientId(newClientId);
        oauth2Client.setClientSecret(bCryptPasswordEncoder().encode(newClientSecret));
        oauth2Client.setAccessTokenValidity(tokenValidity);
        oauth2Client.setRefreshTokenValidity(refreshValidity);
        oauth2Client.setAuthorities("ROLE_USER");
        oauth2Client.setGrantTypes("password,authorization_code,refresh_token");
        oauth2Client.setScope("read,write");
        oauth2Client.setWebServerRedirectUri(redirectUrl);

        OAuth2Client oauthClientDetailsResult = oauthClientDetailsRepository.save(oauth2Client);

        client.setOauth_client_id(oauthClientDetailsResult);
        AuthenticationClient tempClientResult = oauth2ClientRepository.save(client);

        AuthenticationClient clientResult = new AuthenticationClient(tempClientResult);
        OAuth2Client oAuth2ClientResult = new OAuth2Client(oauthClientDetailsResult);
        oAuth2ClientResult.setClientSecret(newClientSecret);
        clientResult.setOauth_client_id(oAuth2ClientResult);

        return clientResult;
    }
}
