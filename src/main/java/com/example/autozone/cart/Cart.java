package com.example.autozone.cart;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cart {
    @Id
    private Long id;
    private Long productid;
    private String name;
    private int can;
    private float price;

    public Cart() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductid() {return productid;}

    public void setProductid(Long productid) {this.productid = productid;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCan() {return can;}

    public void setCan(int can) {this.can = can;}

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}