package org.launchcode.shoppingclothing.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Job extends AbstractEntity{

//    @Id
//    @GeneratedValue
//    private int id;

//    private String name;

    @ManyToOne
    private Product product;

    public Job() {}

    public Job(Product product) {
        this.product = product;
    }

    public Product getProduct() {  //Luke
        return product;
    }

    public void setProduct(Product product) {  //Luke
        this.product = product;
    }
}
