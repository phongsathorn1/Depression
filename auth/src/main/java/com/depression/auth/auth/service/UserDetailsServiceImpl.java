package com.depression.auth.auth.service;

import com.depression.auth.auth.model.UserInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    public UserDetailsServiceImpl(){}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo user = userService.getUserInfoByUsername(username);
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());
        return new User(user.getUsername(), user.getPassword(), Arrays.asList(authority));
    }
}
