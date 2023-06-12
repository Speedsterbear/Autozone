package com.example.autozone.product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    private Long id;
    private String name;
    private String brand;
    private String des;
    private int stock;
    private float price;

    public Product() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getStock() {return stock;}

    public void setStock(int stock) {this.stock = stock;}

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}