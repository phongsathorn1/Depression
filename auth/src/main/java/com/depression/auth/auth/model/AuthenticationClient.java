package com.depression.auth.auth.model;

import javax.persistence.*;

@Entity
@Table(name="oauth_clients")
public class AuthenticationClient extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private OAuth2Client oauth_client_id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String homepageUrl;

    @Column
    private String description;

    public AuthenticationClient() { }

    public AuthenticationClient(AuthenticationClient authenticationClient) {
        this.id = authenticationClient.getId();
        this.oauth_client_id = authenticationClient.getOauth_client_id();
        this.name = authenticationClient.getName();
        this.email = authenticationClient.getEmail();
        this.homepageUrl = authenticationClient.getHomepageUrl();
        this.description = authenticationClient.getDescription();
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public OAuth2Client getOauth_client_id() {
        return oauth_client_id;
    }

    public void setOauth_client_id(OAuth2Client oauth_client_id) {
        this.oauth_client_id = oauth_client_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHomepageUrl() {
        return homepageUrl;
    }

    public void setHomepageUrl(String homepageUrl) {
        this.homepageUrl = homepageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
