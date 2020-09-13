package org.launchcode.shoppingclothing.models.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegisterFormDTO extends LoginFormDTO {
    private String verifyPassword;

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }

//    public RegisterFormDTO (int prodId) {
//        super(prodId);
//    }

    @NotNull
    @NotBlank
    @Size(min = 3, max = 20, message = "Invalid first name. Must be between 3 and 20 characters.")
    private String firstname;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 20, message = "Invalid last name. Must be between 3 and 20 characters.")
    private String lastname;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 20, message = "Invalid email. Must be between 3 and 20 characters.")
    private String email;

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

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }
}
