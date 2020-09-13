package org.launchcode.shoppingclothing.controllers;

import org.launchcode.shoppingclothing.models.Product;
import org.launchcode.shoppingclothing.models.data.CartItemRepository;
import org.launchcode.shoppingclothing.models.data.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @RequestMapping("man")
    public String displaymen(Model model) {
        model.addAttribute("title", "All men");
        return "man";
    }

    @RequestMapping("woman")
    public String displaywoman(Model model) {
        model.addAttribute("title", "All women");
        return "woman";
    }

    @RequestMapping("baby")
    public String displaybaby(Model model) {
        model.addAttribute("title", "All babies");
        return "baby";
    }

    @RequestMapping("boy")
    public String displayboy(Model model) {
        model.addAttribute("title", "All boys");
        return "boy";
    }

    @RequestMapping("girl")
    public String displaygirl(Model model) {
        model.addAttribute("title", "All girls");
        return "girl";
    }

    @RequestMapping("proceedtocheckout")
    public String displayshippingpayment(Model model) {
        model.addAttribute("title", "Shipping and Payment");
        return "shipping&payment";
    }

    @RequestMapping("thanks")
    public String placeorder(Model model) {
        model.addAttribute("title", "Place order");
        return "thanks";
    }

    @RequestMapping("shop")
    public String gobacktohome(Model model) {
        model.addAttribute("title", "Go back to home");
        return "index";
    }

//    @GetMapping("shoppingcart")
//    public String displaymansuit(Model model) {
//        model.addAttribute("title", "Display shoppingcart");
//        model.addAttribute(new Product());
//        return "product";
//    }


    @RequestMapping("product/{id}")
    public String displayProduct(Model model, @PathVariable int id) {
        // get optProduct by id from database
        Optional<Product> optProduct = productRepository.findById(id);

        // return to different page if id doesn't exist in database
        if( optProduct == null) {
            //return to some other page. Select whatever you want.
            return "redirect:man";
        }

        // get the product and pass it to the front-end
        Product product = optProduct.get();
        model.addAttribute("product", product);
        return "product";
    }
}
