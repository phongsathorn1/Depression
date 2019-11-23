package com.depression.auth.auth.repository;

import com.depression.auth.auth.model.UserInfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UserDetailsRepository extends CrudRepository<UserInfo, String> {
    UserInfo findById(Integer id);
    void deleteById(Integer id);
    UserInfo findByUserNameAndEnabled(String userName, short enabled);
    List<UserInfo> findAllByEnabled(boolean enable);
}
