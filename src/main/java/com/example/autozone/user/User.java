package com.example.autozone.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.autozone.product.Product;
import com.example.autozone.product.ProductRepository;

import java.sql.Date;
import java.util.List;

@Entity
public class User {
    @Id
    private Long id;
    @Size(min = 1, max = 50)
    private String name;

    @Email(message = "Please enter a valid e-mail address")
    private String email;

    @NotBlank
    @Size(min = 8, max = 15)
    private String password;

    @NotBlank
    private String dir;

    @NotBlank
    private String phone;

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

//Getters & Setters
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getPhone() {return phone;}

    public void setPhone(String phone) {this.phone = phone;}
}