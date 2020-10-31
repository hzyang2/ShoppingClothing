package org.launchcode.shoppingclothing.models;

import javax.persistence.Entity;

@Entity
public class Product extends AbstractEntity {

    private String product_line;

    private String image_file_name;

    private String brand;

    private String category;

    private String size;

    private Double price;

    public Product() {}

    @Override
    public boolean isMatchingPassword(String password) {
        return false;
    }

    public String getProduct_line() {
        return product_line;
    }

    public String getImage_file_name() {
        return image_file_name;
    }

    public String getBrand() {
        return brand;
    }

    public String getCategory() {
        return category;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Double getPrice() {
        return price;
    }
}








