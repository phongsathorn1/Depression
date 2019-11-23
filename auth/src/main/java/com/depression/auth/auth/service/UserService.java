package com.depression.auth.auth.service;

import com.depression.auth.auth.model.UserInfo;
import com.depression.auth.auth.repository.UserDetailsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserService {

    @Autowired
    private UserDetailsRepository userDatailsRepository;

    public UserInfo getUserInfoByUserName(String userName) {
        short enabled = 1;
        return userDatailsRepository.findByUserNameAndEnabled(userName, enabled);
    }

    public List<UserInfo> getAllActiveUserInfo() {
        return userDatailsRepository.findAllByEnabled(true);
    }

    public UserInfo getUserInfoById(Integer id) {
        return userDatailsRepository.findById(id);
    }

    public UserInfo addUser(UserInfo user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return userDatailsRepository.save(user);
    }

    public UserInfo updateUser(Integer id, UserInfo userRecord) {
        UserInfo user = userDatailsRepository.findById(id);
        user.setUserName(userRecord.getUserName());
        user.setPassword(userRecord.getPassword());
        user.setRole(userRecord.getRole());
        user.setEnabled(userRecord.is_enabled());
        return userDatailsRepository.save(user);
    }

    public void deleteUser(Integer id) {
        userDatailsRepository.deleteById(id);
    }

    public UserInfo updatePassword(Integer id, UserInfo userRecord) {
        UserInfo user = userDatailsRepository.findById(id);
        user.setPassword(userRecord.getPassword());
        return userDatailsRepository.save(user);
    }

    public UserInfo updateRole(Integer id, UserInfo userRecord) {
        UserInfo user = userDatailsRepository.findById(id);
        user.setRole(userRecord.getRole());
        return userDatailsRepository.save(user);
    }
}