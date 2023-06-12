package com.example.autozone;


import com.example.autozone.cart.Cart;
import com.example.autozone.cart.CartService;
import com.example.autozone.product.ProductService;
import com.example.autozone.user.User;
import com.example.autozone.user.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.example.autozone.product.Product;

import java.util.List;


@Controller
public class MainController {

    @Autowired
    private ProductService productservice;

    @Autowired
    private UserService userservice;

    @Autowired
    private CartService cartservice;

    @RequestMapping("/")
    public String viewHomePage(){
        return "index";
    }
////////////////////////////////////////////////////////////////////PRODUCT CONTROLLER//////////////////////////////////////////////////////////////////////////////////
    @RequestMapping("/productlist")
    public String listProducts(Model model) {
        List<Product> listProducts = productservice.listAll();
        model.addAttribute("listProducts", listProducts);

        return "list_products";
    }

    @RequestMapping("/productlistuser")
    public String listProductsUser(Model model) {
        List<Product> listProducts = productservice.listAll();
        model.addAttribute("listProducts", listProducts);

        return "list_products_user";
    }

    @RequestMapping("/productnew")
    public String showNewProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);

        return "new_product";
    }

    @PostMapping("/productsave")
    public String saveProduct(@Valid @ModelAttribute("product") Product product) {
        productservice.save(product);
        return "redirect:/productlist";
    }


    @RequestMapping("/productedit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_product");
        Product product = productservice.get(id);
        mav.addObject("product", product);
        return mav;
    }


    @RequestMapping("/productadd/{id}")
    public ModelAndView addCart(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("add_cart");
        Product product = productservice.get(id);
        mav.addObject("product", product);
        return mav;
    }

    @RequestMapping("/productdelete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id) {
        productservice.delete(id);
        return "redirect:/productlist";
    }

/////////////////////////////////////////////////////////////////////////HOME PAGE///////////////////////////////////////////////////////////////////////////////////////
@RequestMapping("/adminhome")
public String adminHome() {
    return "admin_home";
}
/////////////////////////////////////////////////////////////////////////USER CONTROLLER//////////////////////////////////////////////////////////////////////////////////
    @RequestMapping("/userlist")
    public String listUsers(Model model) {
    List<User> listUsers = userservice.listAll();
    model.addAttribute("listUsers", listUsers);

    return "list_users";
}
    @GetMapping("/usernew")
    public String showForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "new_user";
    }

    @PostMapping("/usersave")
    public String saveUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
            userservice.save(user);
            return "redirect:/userlist";
    }

    @RequestMapping("/useredit/{id}")
    public ModelAndView showEditUserPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_user");
        User user = userservice.get(id);
        mav.addObject("user", user);

        return mav;
    }
    @RequestMapping("/userdelete/{id}")
    public String deleteUser(@PathVariable(name = "id") int id) {
        userservice.delete(id);
        return "redirect:/userlist";
    }
///////////////////////////////////////////////////////////////////SHOPPING CART//////////////////////////////////////////////////////////////////////////////////////

    @PostMapping("/addcartitem")
    public String addCartItem(@RequestParam("id") long productId,
                              @RequestParam("name") String productName,
                              @RequestParam("price") float price,
                              @RequestParam("quantity") int quantity) {
        cartservice.addCartItem(productId, productName, price, quantity);
        return "redirect:/productlistuser";
    }

    @RequestMapping("/cart")
    public String viewCartPage(Model model) {
        List<Cart> cartItems = cartservice.listAll();
        model.addAttribute("listCarts", cartItems);
        double totalCost = cartservice.getTotalCost();
        model.addAttribute("totalCost", totalCost);
        return "cart";
    }

    @PostMapping("/checkout")
    public String checkout() {
        List<Cart> cartItems = cartservice.listAll();
        for (Cart item : cartItems) {
            productservice.subtractFromStock(item.getProductid(), item.getCan());
        }
        cartservice.deleteAll();
        return "redirect:/";
    }
    @RequestMapping("/cartitemdelete/{id}")
    public String deleteCart(@PathVariable(name = "id") int id) {
        cartservice.delete(id);
        return "redirect:/cart";
    }

    @RequestMapping("/cartitemedit/{id}")
    public ModelAndView showEditCartItemPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_item");
        Cart cart = cartservice.get(id);
        mav.addObject("cart", cart);
        return mav;
    }

    @PostMapping("/cartsave")
    public String saveCart(@Valid @ModelAttribute("cart") Cart cart, Model model) {
        cartservice.save(cart);
        return "redirect:/cart";
        }




}