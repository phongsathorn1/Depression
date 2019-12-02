package com.depression.resourceserv.resourceserv.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@EnableGlobalMethodSecurity(securedEnabled = true)
//@EnableGlobalMethodSecurity(prePostEnabled = true,
//        securedEnabled = true,
//        jsr250Enabled = true
//)
@EnableWebSecurity
@EnableResourceServer
public class SecurityConfig extends ResourceServerConfigurerAdapter {

    private static final String RESOURCE_ID = "authentication-resource-server";
    private static final String SECURED_READ_SCOPE = "#oauth2.hasScope('read')";
    private static final String SECURED_WRITE_SCOPE = "#oauth2.hasScope('write')";

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(RESOURCE_ID);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        //restrict access using @Secured or @PreAuthorize annotation
        http.authorizeRequests().anyRequest().permitAll();

//        http.antMatcher("/**").authorizeRequests()
//                .antMatchers("/oauth**", "/oauth/authorize").permitAll()
//                .antMatchers("/api/v1.0/register").permitAll()
//                .antMatchers("/login**").permitAll()
//                .antMatchers("/api/v1.0/**").access(SECURED_READ_SCOPE);
//        http.csrf().disable();
    }
}
