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
    ProductService service;

    @Autowired
    MessageSource messageSource;

    /*
     * This method will list all existing products.
     */
    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    public String listProducts(ModelMap model) {

        List<Product> products = service.findAllProducts();
        model.addAttribute("products", products);
        return "allproducts";
    }

    /*
     * This method will provide the medium to add a new product.
     */
    @RequestMapping(value = { "/new" }, method = RequestMethod.GET)
    public String newProduct(ModelMap model) {
        Product product = new Product();
        model.addAttribute("product", product);
        model.addAttribute("edit", false);
        return "registration";
    }

    /*
     * This method will be called on form submission, handling POST request for
     * saving product in database. It also validates the user input
     */
    @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
    public String saveProduct(@Valid Product product, BindingResult result,
                               ModelMap model) {

        if (result.hasErrors()) {
            return "registration";
        }
 
        /*
         * Preferred way to achieve uniqueness of field [sku] should be implementing custom @Unique annotation
         * and applying it on field [sku] of Model class [Product].
         * 
         * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
         * framework as well while still using internationalized messages.
         * 
         */
        if(!service.isProductSkuUnique(product.getId(), product.getSku())){
            FieldError skuError =new FieldError("product","sku",messageSource.getMessage("non.unique.sku", new String[]{product.getSku()}, Locale.getDefault()));
            result.addError(skuError);
            return "registration";
        }

        service.saveProduct(product);

        model.addAttribute("success", "Product " + product.getName() + " registered successfully");
        return "success";
    }


    /*
     * This method will provide the medium to update an existing product.
     */
    @RequestMapping(value = { "/edit-{sku}-product" }, method = RequestMethod.GET)
    public String editProduct(@PathVariable String sku, ModelMap model) {
        Product product = service.findProductBySku(sku);
        model.addAttribute("product", product);
        model.addAttribute("edit", true);
        return "registration";
    }

    /*
     * This method will be called on form submission, handling POST request for
     * updating product in database. It also validates the user input
     */
    @RequestMapping(value = { "/edit-{sku}-product" }, method = RequestMethod.POST)
    public String updateProduct(@Valid Product product, BindingResult result,
                                 ModelMap model, @PathVariable String sku) {

        if (result.hasErrors()) {
            return "registration";
        }

        if(!service.isProductSkuUnique(product.getId(), product.getSku())){
            FieldError skuError =new FieldError("product","sku",messageSource.getMessage("non.unique.sku", new String[]{product.getSku()}, Locale.getDefault()));
            result.addError(skuError);
            return "registration";
        }

        service.updateProduct(product);

        model.addAttribute("success", "Product " + product.getName()  + " updated successfully");
        return "success";
    }


    /*
     * This method will delete an product by it's SKU value.
     */
    @RequestMapping(value = { "/delete-{sku}-product" }, method = RequestMethod.GET)
    public String deleteProduct(@PathVariable String sku) {
        service.deleteProductBySku(sku);
        return "redirect:/list";
    }

}