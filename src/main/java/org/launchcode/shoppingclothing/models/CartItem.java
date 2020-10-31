package org.launchcode.shoppingclothing.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class CartItem extends AbstractEntity {

    @ManyToOne //from a list of many users, match one user to this CartItem
    @NotNull
    private User user;

    @ManyToOne //from many Products, match one product to this CartItem.
    @NotNull
    private Product product;

    @NotNull
    private int qty;

    public CartItem() {}

    @Override
    public boolean isMatchingPassword(String password) {
        return false;
    }

    public CartItem(User user, Product product) {
        this.user = user;
        this.product = product;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
