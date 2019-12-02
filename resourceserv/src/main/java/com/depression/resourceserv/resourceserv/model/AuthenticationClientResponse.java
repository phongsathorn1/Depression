package com.depression.resourceserv.resourceserv.model;

public class AuthenticationClientResponse extends AuthenticationClient {

    private String client_secret;

    public String getClient_secret() {
        return client_secret;
    }

    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

    public AuthenticationClientResponse(AuthenticationClient authenticationClient) {
        super(authenticationClient);
    }
}
