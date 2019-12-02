package com.depression.resourceserv.resourceserv.services;

import com.depression.resourceserv.resourceserv.model.UserInfo;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;

@Repository
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    public UserDetailsServiceImpl(){}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo user = new UserInfo();
        if(EmailValidator.getInstance().isValid(username)){
            user = userService.getUserInfoByEmail(username);
        }else {
            user = userService.getUserInfoByUsername(username);
        }

        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());
        return new User(user.getUsername(), user.getPassword(), Arrays.asList(authority));
    }
}
