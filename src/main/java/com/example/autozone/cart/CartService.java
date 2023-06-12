package com.example.autozone.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CartService {
    @Autowired
    private CartRepository Cartrepo;

    public List<Cart> listAll() {
        return Cartrepo.findAll();
    }

    public void save(Cart cart) {
        Cartrepo.save(cart);
    }

    public Cart get(long id) {return Cartrepo.findById(id).get();}

    public void delete(long id) {
        Cartrepo.deleteById(id);
    }

    public void deleteAll() {Cartrepo.deleteAll();}

    public void addCartItem(long productId, String productName, float price, int quantity) {
        Cart cartItem = new Cart();
        cartItem.setProductid(productId);
        cartItem.setName(productName);
        cartItem.setPrice(price);
        cartItem.setCan(quantity);
        Cartrepo.save(cartItem);
    }

    public double getTotalCost() {
        List<Cart> cartItems = Cartrepo.findAll();
        double totalCost = 0;
        for (Cart item : cartItems) {
            totalCost += item.getPrice() * item.getCan();
        }
        return totalCost;
    }
}