package org.launchcode.shoppingclothing.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Cart extends AbstractEntity {

    @NotNull
    private int product_id;

    @NotNull
    private int qty;

    @NotNull
    private int user_id;

    public Cart() {}

    public Cart(int product_id, int qty, int user_id) {
        this.qty = qty;
        this.user_id = user_id;
    }

//    public Cart(@NotNull int product_id, @NotNull int qty, @NotNull int user_id) {
//        this.product_id = product_id;
//        this.qty = qty;
//        this.user_id = user_id;
//    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
