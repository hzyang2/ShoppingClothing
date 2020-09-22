package org.launchcode.shoppingclothing.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Objects;

@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue
    private int id;

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity that = (AbstractEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

//    @NotBlank(message = "Name is required")
//    @Size(min =2, max=100, message = "Name must be between 2 and 100 characters")
//    private String name;

    public AbstractEntity() {}

    public abstract boolean isMatchingPassword(String password);

//    public AbstractEntity(String name) { this.name = name; }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @Override
//    public String toString() {
//        return name;
//    }
}
