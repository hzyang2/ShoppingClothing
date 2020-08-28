package org.launchcode.shoppingclothing.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

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

    @RequestMapping("shoppingcart")
    public String displayshoppingcart(Model model) {
        model.addAttribute("title", "All Shopping List");
        return "shoppingcart";
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


}
