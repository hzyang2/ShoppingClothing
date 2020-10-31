package org.launchcode.shoppingclothing.controllers;

import org.launchcode.shoppingclothing.models.Product;
import org.launchcode.shoppingclothing.models.data.CartItemRepository;
import org.launchcode.shoppingclothing.models.data.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @PostMapping("shop")
    public String placeorder(Model model) {
        model.addAttribute("title", "Place order");
        return "thanks";
    }

    @RequestMapping("shop")
    public String gobacktohome(Model model) {
        model.addAttribute("title", "Go back to home");
        return "index";
    }

    @PostMapping("doSearch")
        public String search(Model model, @RequestParam String search) {
        Iterable<Product> products = productRepository.findBySearchText(search);
        // get the products and pass it to the front-end
        model.addAttribute("products", products);
        model.addAttribute("title", "Search Results");
        return "searchresult";
    }

    @RequestMapping("product/{product_line}/{category}")
    public String displayProductCategory(Model model, @PathVariable String product_line, @PathVariable String category) {
        Iterable<Product> products = productRepository.findByProduct_lineAndCategory(product_line, category);
        model.addAttribute("products", products);
        return "product";
    }
}
