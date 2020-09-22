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

    @NotNull
    private String streetaddress;

    @NotNull
    private String city;

    @NotNull
    private String state;

    @NotNull
    private String zipcode;

    @NotNull
    private String phonenumber;

    @NotNull
    private String creditcardnumber;

    @NotNull
    private String cardverificationnumber;

    @NotNull
    private String expirationmonth;

    @NotNull
    private String expirationyear;


    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

//    public User(String username, String password, String email, String firstname, String lastname, String streetaddress, String city, String state, String zipcode, String phonenumber) {}

    public User() {}

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }

    public User(String username, String pwHash, String email, String firstname, String lastname, String streetaddress,
                String city, String state, String zipcode, String phonenumber,
                String creditcardnumber , String cardverificationnumber , String expirationmonth , String expirationyear) {
        this.username = username;
        this.pwHash = pwHash;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.streetaddress = streetaddress;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.phonenumber = phonenumber;
        this.creditcardnumber = creditcardnumber;
        this.cardverificationnumber = cardverificationnumber;
        this.expirationmonth = expirationmonth;
        this.expirationyear = expirationyear;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwHash() {
        return pwHash;
    }

    public void setPwHash(String pwHash) {
        this.pwHash = pwHash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getStreetaddress() {
        return streetaddress;
    }

    public void setStreetaddress(String streetaddress) {
        this.streetaddress = streetaddress;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public static BCryptPasswordEncoder getEncoder() {
        return encoder;
    }

    public String getCreditcardnumber() {
        return creditcardnumber;
    }

    public void setCreditcardnumber(String creditcardnumber) {
        this.creditcardnumber = creditcardnumber;
    }

    public String getCardverificationnumber() {
        return cardverificationnumber;
    }

    public void setCardverificationnumber(String cardverificationnumber) {
        this.cardverificationnumber = cardverificationnumber;
    }

    public String getExpirationmonth() {
        return expirationmonth;
    }

    public void setExpirationmonth(String expirationmonth) {
        this.expirationmonth = expirationmonth;
    }

    public String getExpirationyear() {
        return expirationyear;
    }

    public void setExpirationyear(String expirationyear) {
        this.expirationyear = expirationyear;
    }
}