package org.launchcode.shoppingclothing.models.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginFormDTO {
    //*** Users should be able to Add to Cart before logging in, then view cart after login.
    public LoginFormDTO(int prodId) {
        productId = prodId;
    }
    public LoginFormDTO() {
        productId = 0;
    }
    private int productId;

    public int getProductId() {
        return productId;
    }

    @NotNull
    @NotBlank
    @Size(min = 3, max = 20, message = "Invalid username. Must be between 3 and 30 characters.")
    private String username;

    @NotNull
    @NotBlank
    @Size(min = 4, max = 20, message = "Invalid password. Must be between 4 and 30 characters.")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
