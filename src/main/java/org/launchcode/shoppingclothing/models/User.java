package org.launchcode.shoppingclothing.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class User extends AbstractEntity {

    @NotNull
    private String username;

    @NotNull
    private String pwHash;

    @NotNull
    private String email;

    @NotNull
    private String firstname;

    @NotNull
    private String lastname;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User() {
    } //hibernate requires default constructor(ctor).

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }

    public User(String username, String pw, String email, String firstname, String lastname) {
        this.username = username;
        this.pwHash = encoder.encode(pw);
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
    }
}