//package com.example.autozone.cart;
//
//public class ShoppingCart {
//
////    UUID cartId;
////    private Hashtable<Item, BigDecimal> items;
////
////    public ShoppingCart(User customer) {
////        this.cartId = UUID.randomUUID();
////        this.items = new Hashtable<Item, BigDecimal>();
////    }
////
////    public void AddItemToCart(Product item, BigDecimal quantity) {
////        if (this.items.containsKey(item)) {
////            quantity = quantity.add(this.items.get(item));
////            UpdateItemInCart(item, quantity);
////        }
////        else {
////            this.items.put(item, quantity);
////        }
////    }
////
////    public void RemoveItemFromCart(Product item) {
////        this.items.remove(item);
////    }
////
////    public void UpdateItemInCart(Product item, BigDecimal quantity) {
////        this.items.replace(item, quantity);
////    }
////
////    public BigDecimal GetItemQuantity(Product item) {
////        return this.items.get(item);
////    }
////
////    public BigDecimal getTotal() {
////        BigDecimal total = new BigDecimal(0);
////        for (Item item : this.items.keySet()) {
////            total = total.add(item.price().multiply(this.items.get(item)));
////        }
////        return total;
////    }
////
////    public Hashtable<Item, BigDecimal> getItems() {
////        return this.items;
////    }
////
////    public void Checkout() {
////    }
//
//}

