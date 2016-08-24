package net.lyugaev.shop.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.lyugaev.shop.model.Product;
import net.lyugaev.shop.service.ProductService;

@Controller
@RequestMapping("/")
public class AppController {

    @Autowired
    ProductService productService;

    @Autowired
    MessageSource messageSource;

    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    public String listProducts(ModelMap model) {

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

        model.addAttribute("success", "Product " + product.getName() + " registered successfully");
        return "success";
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

        model.addAttribute("success", "Product " + product.getName()  + " updated successfully");
        return "success";
    }

    @RequestMapping(value = { "/delete-{id}-product" }, method = RequestMethod.GET)
    public String deleteProduct(@PathVariable int id) {
        productService.deleteProductById(id);
        return "redirect:/list";
    }

}