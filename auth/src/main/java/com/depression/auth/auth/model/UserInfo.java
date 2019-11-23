package com.depression.auth.auth.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", length = 10)
    private Integer id;

    @Column(name = "username", length = 50)
    private String username;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @Column(name = "password", length = 225)
    private String password;

    @Column(name = "email", length = 225)
    private String email;

    @Column(name = "role", length = 50)
    private String role;

    @Column(name = "enabled")
    private boolean enabled;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JsonIgnore
    @JsonProperty(value = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean is_enabled() {
        return enabled;
    }

    public void setEnabled(boolean is_enabled) {
        this.enabled = is_enabled;
    }
}
