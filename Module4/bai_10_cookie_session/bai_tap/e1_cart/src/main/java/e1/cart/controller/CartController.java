package e1.cart.controller;

import e1.cart.model.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("cart")
public class CartController {

    @ModelAttribute("cart")
    public Cart createCart() {
        return new Cart();
    }

    @GetMapping("/")
    public String showHome(Model model, @CookieValue(name = "counter", defaultValue = "0") Integer counter,
                           @ModelAttribute("cart") Cart cart) {
        if (cart == null) {
            model.addAttribute("cart", new Cart());
        } else {
            model.addAttribute("cart", cart);
        }
        model.addAttribute("counter", counter);
        return "home";
    }

    @GetMapping("/cart")
    public String showCart(@ModelAttribute("cart") Cart cart, Model model) {
        model.addAttribute("cart", cart);
        return "cart";
    }

    @GetMapping("/addIphone")
    public String addIphone(@ModelAttribute("cart") Cart cart) {
        cart.setIphoneCount(cart.getIphoneCount() + 1);
        return "redirect:/";
    }

    @GetMapping("/addSamSung")
    public String addSamSung(@ModelAttribute("cart") Cart cart) {
        cart.setSamsungCount(cart.getSamsungCount() + 1);
        return "redirect:/";
    }

    @GetMapping("/addNokia")
    public String addNokia(@ModelAttribute("cart") Cart cart) {
        cart.setNokiaCount(cart.getNokiaCount() + 1);
        return "redirect:/";
    }

    @GetMapping("/removeIphone")
    public String removeIphone(@ModelAttribute("cart") Cart cart) {
        cart.setIphoneCount(cart.getIphoneCount() - 1);
        return "redirect:/";
    }

    @GetMapping("/removeSamSung")
    public String removeSamSung(@ModelAttribute("cart") Cart cart) {
        cart.setSamsungCount(cart.getSamsungCount() - 1);
        return "redirect:/";
    }

    @GetMapping("/removeNokia")
    public String removeNokia(@ModelAttribute("cart") Cart cart) {
        cart.setNokiaCount(cart.getNokiaCount() - 1);
        return "redirect:/";
    }
}
