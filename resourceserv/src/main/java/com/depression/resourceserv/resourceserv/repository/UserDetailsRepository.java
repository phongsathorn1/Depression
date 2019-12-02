package com.depression.resourceserv.resourceserv.repository;

import com.depression.resourceserv.resourceserv.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UserDetailsRepository extends JpaRepository<UserInfo, String> {
    UserInfo findById(Integer id);
    void deleteById(Integer id);
    UserInfo findByUsernameAndEnabledTrue(String username);
    List<UserInfo> findAllByEnabled(boolean enable);
    UserInfo findByUsername(String username);

    UserInfo findByEmail(String email);
}
