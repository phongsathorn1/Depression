package com.depression.resourceserv.resourceserv.repository;

import com.depression.resourceserv.resourceserv.model.AuthenticationClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface OAuth2ClientRepository extends JpaRepository<AuthenticationClient, String> {

}
