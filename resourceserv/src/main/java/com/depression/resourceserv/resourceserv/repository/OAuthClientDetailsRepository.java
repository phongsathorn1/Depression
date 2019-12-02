package com.depression.resourceserv.resourceserv.repository;

import com.depression.resourceserv.resourceserv.model.OAuth2Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface OAuthClientDetailsRepository extends JpaRepository<OAuth2Client, Long> {

}
