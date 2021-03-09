package e1.cart.controller;

import e1.cart.model.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes({"cart"})
public class CartController {

    @ModelAttribute("cart")
    public Cart createCart() {
        return new Cart();
    }

    @GetMapping("/")
    public String showHome(Model model, @ModelAttribute("cart") Cart cart) {
        if (cart == null) {
            model.addAttribute("cart", new Cart());
        } else {
            model.addAttribute("cart", cart);
        }
        return "home";
    }

    @GetMapping("/cart")
    public String showCart(@ModelAttribute("cart") Cart cart, Model model) {
        model.addAttribute("cart", cart);
        return "cart";
    }

    @GetMapping("/add")
    public String addIphone(@ModelAttribute("cart") Cart cart, @RequestParam("string") String string) {
        switch (string) {
            case "Iphone":
                cart.setIphoneCount(cart.getIphoneCount() + 1);
                break;
            case "SamSung":
                cart.setSamsungCount(cart.getSamsungCount() + 1);
                break;
            case "Nokia":
                cart.setNokiaCount(cart.getNokiaCount() + 1);
                break;
        }
        cart.setTotal(cart.getTotal() + 1);
        return "redirect:/";
    }

    @GetMapping("/remove")
    public String removeIphone(@ModelAttribute("cart") Cart cart, @RequestParam("string") String string) {
        switch (string) {
            case "Iphone":
                cart.setIphoneCount(cart.getIphoneCount() - 1);
                break;
            case "SamSung":
                cart.setSamsungCount(cart.getSamsungCount() - 1);
                break;
            case "Nokia":
                cart.setNokiaCount(cart.getNokiaCount() - 1);
                break;
        }
        cart.setTotal(cart.getTotal() - 1);
        return "redirect:/";
    }
}
