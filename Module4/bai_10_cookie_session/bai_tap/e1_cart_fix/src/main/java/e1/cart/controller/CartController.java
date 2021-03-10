package e1.cart.controller;

import e1.cart.model.Product;
import e1.cart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("cart")
public class CartController {
    @Autowired
    ProductService productService;

    @ModelAttribute("cart")
    public List<Product> createCart() {
        return new ArrayList<>();
    }

    @GetMapping("/")
    public String showHome(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "home";
    }

    @GetMapping("/add")
    public String add(@RequestParam("id") Integer id, @ModelAttribute("cart") List<Product> cart) {
        Product product = productService.findById(id);
        if (!cart.isEmpty()) {
            for (Product product1 : cart) {
                if (product.getId() == product1.getId()) {
                    product1.setQuantity(product1.getQuantity() + 1);
                    return "redirect:/";
                }
            }
        }
        product.setQuantity(1);
        cart.add(product);
        return "redirect:/";
    }

    @GetMapping("/view")
    public String view(@RequestParam("id") Integer id, Model model) {
        model.addAttribute(productService.findById(id));
        return "view";
    }

    @GetMapping("/remove")
    public String remove(@RequestParam("id") Integer id, @ModelAttribute("cart") List<Product> cart, Model model) {
        if (id != 0) {
            for (Product product : cart) {
                if (product.getId() == id) {
                    cart.remove(product);
                    model.addAttribute("cart", cart);
                    return "cart";
                }
            }
        }
        cart.clear();
        return "redirect:/";
    }

    @PostMapping("cart")
    public String add(@RequestParam("id") Integer id, @RequestParam("inputQuantity") Integer inputQuantity,
                      @ModelAttribute("cart") List<Product> cart, Model model) {
            for (Product product : cart) {
                if (product.getId() == id) {
                    product.setQuantity(product.getQuantity() + inputQuantity);
                    break;
                }
            }
        model.addAttribute("cart", cart);
        return "cart";
    }

    @GetMapping("/cart")
    public String showCart(@ModelAttribute("cart") List<Product> cart, Model model) {
        model.addAttribute("cart", cart);
        return "cart";
    }
}
