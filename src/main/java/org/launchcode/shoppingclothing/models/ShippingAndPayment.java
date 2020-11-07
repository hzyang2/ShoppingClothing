package org.launchcode.shoppingclothing.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ShippingAndPayment {

    @NotNull
    @NotBlank
    private String firstname;

    @NotNull
    @NotBlank
    private String lastname;

    @NotNull
    @NotBlank
    private String streetaddress;

    @NotNull
    @NotBlank
    private String city;

    @NotNull
    @NotBlank
    private String state;

    @NotNull
    @NotBlank
    @Size(min = 5, max= 5, message = "Invalid zip code. Must be 5 numbers.")
    private String zipcode;

    @NotNull
    @NotBlank
    @Size(min = 10, max= 10, message = "Invalid phone number. Must be 10 numbers.")
    private String phonenumber;

    @NotNull
    @NotBlank
    @Size(min = 16, max= 16, message = "Invalid credit card number. Must be 16 numbers.")
    private String creditcardnumber;

    @NotNull
    @NotBlank
    private String expirationmonth;

    @NotNull
    @NotBlank
    private String expirationyear;

    @NotNull
    @NotBlank
    @Size(min = 3, max= 3, message = "Invalid card verification number. Must be 3 numbers.")
    private String cardverificationnumber;

    public ShippingAndPayment() {}

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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
