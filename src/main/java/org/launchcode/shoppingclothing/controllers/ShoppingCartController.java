package org.launchcode.shoppingclothing.controllers;

import org.launchcode.shoppingclothing.models.CartItem;
import org.launchcode.shoppingclothing.models.Product;
import org.launchcode.shoppingclothing.models.ShippingAndPayment;
import org.launchcode.shoppingclothing.models.User;
import org.launchcode.shoppingclothing.models.data.CartItemRepository;
import org.launchcode.shoppingclothing.models.data.ProductRepository;
import org.launchcode.shoppingclothing.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
public class ShoppingCartController {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    private static final String userSessionKey = "user";

    private User getUserFromRequest(HttpServletRequest request) throws Exception {
        //TODO: Find a better way to get the session User object ---
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        if (userId == null) {
            return null;
        }
        Optional<User> optUser = userRepository.findById(userId);
        if (optUser.isEmpty()) {
            throw new Exception("Registered, logged in? Couldn't find user in repository.");
        }
        return optUser.get();
    }

    @RequestMapping("addtocart/{productId}")
    public String addToCart(HttpServletRequest request, Model model, @PathVariable int productId) throws Exception {
        Optional<Product> optProduct = productRepository.findById(productId);
        if (optProduct.isPresent()) {
            Product product = (Product) optProduct.get();
            var newCartItem = new CartItem();
            newCartItem.setProduct(product);
            newCartItem.setQty(1);
            var user = getUserFromRequest(request);
            if (user == null)
                return "redirect:/login/" + productId;
            newCartItem.setUser(user);
            cartItemRepository.save(newCartItem);
            return viewCart(request, model);
        } else {
            model.addAttribute("error", "Invalid Product ID");
            return ""; //TODO: return to the same page
        }
    }

    @RequestMapping("deleteItem/{cartItemId}")
    public String deleteItem(HttpServletRequest request, Model model,
                             @PathVariable int cartItemId) throws Exception {
        cartItemRepository.deleteById(cartItemId);
        return viewCart(request, model);
    }

//    @RequestMapping("shoppingcart")
//    public String viewCart(HttpServletRequest request, Model model) throws Exception {
//        User user = getUserFromRequest(request);
//        Iterable<CartItem> cartItems = cartItemRepository.findAllByUser(user);
//        model.addAttribute("cartItems", cartItems);
//        model.addAttribute("title", "Shopping Cart");
//        return "shoppingcart";
//    }

    @RequestMapping("shoppingcart")
    public String viewCart(HttpServletRequest request, Model model) throws Exception {
        User user = getUserFromRequest(request);
        if(user == null) {
            model.addAttribute("title", "Index");
            return "index";
        } else {
            Iterable<CartItem> cartItems = cartItemRepository.findAllByUser(user);
            model.addAttribute("cartItems", cartItems);
            model.addAttribute("title", "Shopping Cart");
            return "shoppingcart";
        }
    }

    @PostMapping("shoppingcart")
    public String displayshipping(HttpServletRequest request, Model model) throws Exception {
        User user = getUserFromRequest(request);
        Iterable<CartItem> cartItems = cartItemRepository.findAllByUser(user);
        model.addAttribute("cartItems", cartItems);
        model.addAttribute("title", "Shopping Cart");
        return "redirect:proceedtocheckout";
    }

//    @PostMapping("shoppingcart")
//    public String displayshipping(HttpServletRequest request, Model model, int cartItemId) throws Exception {
//        User user = getUserFromRequest(request);
//        CartItem cartItem = cartItemRepository.findByIdAndUser(cartItemId, user);
//        if(cartItem == null) {
//            return "index";
//        } else {
//            Iterable<CartItem> cartItems = cartItemRepository.findAllByUser(user);
//            model.addAttribute("cartItems", cartItems);
//            model.addAttribute("title", "Shopping Cart");
//            return "redirect:proceedtocheckout";
//        }
//    }

    @PostMapping("saveCartItemQty")
    public String saveCartItemQty(HttpServletRequest request, int cartItemId, int qty) throws Exception {
        //TODO: pass in Principal principal instead of getUserFromRequest()?
        User user = getUserFromRequest(request);
        if (user == null) {
            return "fail sauce"; //TODO: redirect to login
        }
        if (qty < 1) {
            return "fail sauce";
        }
        //TODO: code for exceptions from db
        CartItem cartItem = cartItemRepository.findByIdAndUser(cartItemId, user);
        if (cartItem != null ) {
            cartItem.setQty(qty);
            cartItemRepository.save(cartItem);
            return "success";
        } else {
            return "fail sauce";
        }
    }

    @RequestMapping("proceedtocheckout")
    public String displayshippingpayment(HttpServletRequest request, Model model) throws Exception {
        User user = getUserFromRequest(request);
        if (user == null) {
            return "fail sauce"; //TODO: redirect to login
        }
        model.addAttribute("title", "ShippingAndPayment");
        ShippingAndPayment shippingAndPayment = new ShippingAndPayment(user.getFirstname(), user.getLastname(),
                user.getStreetaddress(), user.getCity(), user.getState(), user.getZipcode(), user.getPhonenumber(),
                user.getCreditcardnumber(), user.getCardverificationnumber(), user.getExpirationmonth(), user.getExpirationyear());
        model.addAttribute("shippingAndPayment", new ShippingAndPayment());
        return "shipping&payment";
    }

    @PostMapping("proceedtocheckout")
    public String checkout(@ModelAttribute @Valid ShippingAndPayment newShippingAndPayment,
                           Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "ShippingAndPayment");
            return "shipping&payment";
        }
        return "thanks";
    }
}
