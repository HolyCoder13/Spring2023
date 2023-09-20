package io.gitub.mat3e.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.engine.internal.Cascade;
import org.springframework.lang.NonNull;

import java.util.Set;
@Entity
@Table(name="categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull(message = "Category desc cannot be null")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private Set<Product> products;

    public int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    void setDescription(String description) {
        this.description = description;
    }

    Set<Product> getProducts() {
        return products;
    }

    void setProducts(Set<Product> products) {
        this.products = products;
    }
}
