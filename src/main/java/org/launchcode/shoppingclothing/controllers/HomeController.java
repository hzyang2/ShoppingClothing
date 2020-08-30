package org.launchcode.shoppingclothing.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value = "")
    public String displayAllClothes(Model model){
        model.addAttribute("title","All Clothes");
        return "index";
    }
}
