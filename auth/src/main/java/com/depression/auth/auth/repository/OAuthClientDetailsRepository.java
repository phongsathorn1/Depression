package com.depression.auth.auth.repository;

import com.depression.auth.auth.model.OAuth2Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface OAuthClientDetailsRepository extends JpaRepository<OAuth2Client, Long> {

}
