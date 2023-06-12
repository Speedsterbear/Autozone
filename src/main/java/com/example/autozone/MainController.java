package com.example.autozone;


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

import java.util.Arrays;
import java.util.List;


@Controller
public class MainController {

    @Autowired
    private ProductService productservice;

    @Autowired
    private UserService userservice;

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

    @RequestMapping("/productnew")
    public String showNewProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);

        return "new_product";
    }

    @RequestMapping(value = "/productsave", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product) {
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

    @RequestMapping("/productdelete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id) {
        productservice.delete(id);
        return "redirect:/productlist";
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

        List<String> listProfession = Arrays.asList("Developer", "Tester", "Architect");
        model.addAttribute("listProfession", listProfession);

        return "register_form";
    }

    @PostMapping("/usersave")
    public String saveUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {

        userservice.save(user);
        if (bindingResult.hasErrors()) {
            List<String> listProfession = Arrays.asList("Developer", "Tester", "Architect");
            model.addAttribute("listProfession", listProfession);
            return "register_form";
        } else {

            return "redirect:/userlist";
        }


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

}