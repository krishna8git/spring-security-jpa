package org.vit.springsecurityjpa.model;

import org.hibernate.annotations.Generated;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String userName;

    private String password;

    private String roles;

    @Column(name = "account_active")
    private boolean active;

    @Column(name = "account_locked")
    private boolean locked;

    @Column(name = "credential_expired")
    private boolean expired;

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getRoles() {
        return roles;
    }

    public boolean isActive() {
        return active;
    }

    public boolean isLocked() {
        return locked;
    }

    public boolean isExpired() {
        return expired;
    }

}
