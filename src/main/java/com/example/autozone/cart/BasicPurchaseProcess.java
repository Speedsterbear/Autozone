//package com.example.autozone.cart;
//
//import com.persistance.demo.product.Product;
//import com.persistance.demo.user.User;
//
//import java.math.BigDecimal;
//import java.util.Map;
//
//public class BasicPurchaseProcess implements PurchaseProcess {
//    @Override
//    public ShoppingCart getShoppingCart() {
//        return null;
//    }
//
//    @Override
//    public void setShoppingCart(ShoppingCart shoppingCart) {
//
//    }
//
//    @Override
//    public void AddItemToCart(Integer itemId, BigDecimal quantity) {
//
//    }
//
//    @Override
//    public void RemoveItemFromCart(Integer itemId, BigDecimal quantity) {
//
//    }
//
//    @Override
//    public void Checkout() {
//
//    }
//
//    @Override
//    public User setUser(int customerId) {
//        return null;
//    }
//
//    @Override
//    public User getUser() {
//        return null;
//    }
//
//    @Override
//    public Map<Integer, Product> getItemInventory() {
//        return null;
//    }
//
////        private UserService userService;
////        private ProductService productService;
////        private User user;
////        private ShoppingCart shoppingCart;
////
////        @Override
////        public ShoppingCart getShoppingCart() {
////            return shoppingCart;
////        }
////
////        @Override
////        public void setShoppingCart(ShoppingCart shoppingCart) {
////            this.shoppingCart = shoppingCart;
////        }
////
////        public BasicPurchaseProcess() { // lo ideal sería mandar objeto
////
////            this.userService = new UserService();
////            this.productService = new ProductService();
////
////            user = userService.get(1);
////            this.shoppingCart = new ShoppingCart(user);
////        }
////
////        @Override
////        public void AddItemToCart(Integer productId, BigDecimal quantity) {
////            var product = productService.get(productId);
////            // If not found??
////            // If found??
////            // If repeated??
////            // If not existence??
////            this.shoppingCart.AddItemToCart(product, quantity); // se está sobreescribiendo el valor
////        }
////
////        @Override
////        public void RemoveItemFromCart(Integer productId, BigDecimal quantity) {
////            if (quantity.compareTo(BigDecimal.ZERO) == 0) {
////                return;
////            }
////            var currentQuantity = this.shoppingCart.GetItemQuantity(productService.get(productId));
////            if (currentQuantity.compareTo(quantity) <= 0) {
////                this.shoppingCart.RemoveItemFromCart(productService.get(productId));
////            } else if (currentQuantity.compareTo(quantity) > 0) {
////                this.shoppingCart.UpdateItemInCart(productService.get(productId), currentQuantity.subtract(quantity));
////            }
////        }
////
////        @Override
////        public void Checkout() {
////            // Qué hacer?? Guardar carrito en la bd?, traer info de facturación?
////            System.out.println("Checking out...");
////            //System.out.println("Customer: " + this.user.email());
////            System.out.println("Total: " + this.shoppingCart.getTotal());
////        }
////
////        @Override
////        public User setUser(int userId) {
////            this.user = userService.get(userId);
////            // if not found?? Creo un cliente
////            // if found... Asígnalo...?
////            return this.user;
////        }
////
////        @Override
////        public User getUser() {
////            return this.user;
////        }
////
////        @Override
////        public Map<Integer, Product> getItemInventory() {
////            return (Map<Integer, Product>) productService.listAll();
////        }
////
////        @Override
////        public String toString() {
////            StringBuilder sb = new StringBuilder();
////            sb.append("Customer: " + this.user.getProfession() + "\n");
////            var products = this.shoppingCart.getItems();
////
////            for (Map.Entry<Item, BigDecimal> entry : products.entrySet()) {
////                Product key = entry.getKey();
////                BigDecimal value = entry.getValue();
////                sb.append("Product: " + key.toString() + " Quantity: " + value + "\n");
////            }
////
////            return sb.toString();
////        }
//
//    }
