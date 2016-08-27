package net.lyugaev.shop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import net.lyugaev.shop.model.Cart;
import net.lyugaev.shop.model.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import net.lyugaev.shop.entity.Product;
import net.lyugaev.shop.service.ProductService;
import net.lyugaev.shop.utils.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@Transactional
@EnableWebMvc
@RequestMapping("/")
public class AppController {

    @Autowired
    ProductService productService;

    @Autowired
    MessageSource messageSource;

    @InitBinder
    public void myInitBinder(WebDataBinder dataBinder) {
        Object target = dataBinder.getTarget();
        if (target == null) {
            return;
        }
        System.out.println("Target=" + target);

        //for cartForm
        if (target.getClass() == Cart.class) {

        }
    }

    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    public String listProducts(HttpServletRequest request, ModelMap model) {

        List<Product> products = productService.findAllProducts();
        model.addAttribute("products", products);

        return "allproducts";
    }

    @RequestMapping(value = { "/new" }, method = RequestMethod.GET)
    public String newProduct(ModelMap model) {
        Product product = new Product();
        model.addAttribute("product", product);
        model.addAttribute("edit", false);
        return "registration";
    }

    @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
    public String saveProduct(@Valid Product product, BindingResult result,
                               ModelMap model) {

        if (result.hasErrors()) {
            return "registration";
        }

        productService.saveProduct(product);

        return "redirect:/list";
    }

    @RequestMapping(value = { "/edit-{id}-product" }, method = RequestMethod.GET)
    public String editProduct(@PathVariable int id, ModelMap model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        model.addAttribute("edit", true);
        return "registration";
    }

    @RequestMapping(value = { "/edit-{id}-product" }, method = RequestMethod.POST)
    public String updateProduct(@Valid Product product, BindingResult result,
                                 ModelMap model, @PathVariable int id) {

        if (result.hasErrors()) {
            return "registration";
        }

        productService.updateProduct(product);

        return "redirect:/list";
    }

//    @RequestMapping(value = { "/delete-{id}-product" }, method = RequestMethod.GET)
//    public String deleteProduct(@PathVariable int id) {
//        productService.deleteProductById(id);
//        return "redirect:/list";
//    }

    //add prodyct to cart
    @RequestMapping(value = { "/add-{id}-to-cart" }, method = RequestMethod.GET)
    public String addProductToCart(HttpServletRequest request, @PathVariable int id) {
        Product product = productService.findById(id);
        Cart cart = SessionManager.getCartInSession(request);
        ProductInfo productInfo = new ProductInfo(product);
        cart.addProduct(productInfo, 1);
        return "redirect:/list";
    }

    @RequestMapping(value = { "/goCart" }, method = RequestMethod.GET)
    public String goShoppingCart(HttpServletRequest request, ModelMap model) {
        Cart cart = SessionManager.getCartInSession(request);
        model.addAttribute("cartForm", cart);
        return "shoppingCart";
    }

    //delete product from cart
    @RequestMapping(value = { "/shoppingCartRemoveProduct{id}" }, method = RequestMethod.GET)
    public String  shoppingCartRemoveProduct(HttpServletRequest request, ModelMap model, @PathVariable int id) {
        Cart cart = SessionManager.getCartInSession(request);
        cart.removeProduct(id);
        return "redirect:/goCart";
    }

    //update quantity of product in cart.
    @RequestMapping(value = { "/shoppingCartUpdateQuantity" }, method = RequestMethod.POST)
    public String shoppingCartUpdateQty(HttpServletRequest request, ModelMap model,
                                        @ModelAttribute("cartForm") Cart cartForm) {

        Cart cart = SessionManager.getCartInSession(request);
        cart.updateQuantity(cartForm);

        // Redirect to shoppingCart page.
        return "redirect:/goCart";
    }
}