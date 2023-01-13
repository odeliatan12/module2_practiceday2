package onlinestore.practiceday02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import onlinestore.practiceday02.models.BillingInformation;
import onlinestore.practiceday02.models.BillingService;
import onlinestore.practiceday02.models.Product;
import onlinestore.practiceday02.models.ProductService;
import onlinestore.practiceday02.models.ShoppingCart;

@Controller
public class ProductController {
    
    @Autowired
    ProductService productService;

    @Autowired
    BillingService billingService;

    // Showing the list of products in the catalog for users to see and select
    @RequestMapping(value = "/products")
    public String showCatalog(Model model){
        List<Product> product = productService.getAllProducts();
        model.addAttribute("product", product);
        return "products";
    }

    // Creating session for the product, product will then be stored as a session
    @PostMapping(path = "/addtoCart")
    public String addToCart(@ModelAttribute Product product, HttpSession session){
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        if(null == cart){
            cart = new ShoppingCart();
            session.setAttribute("cart", cart);
        }
        cart.addItems(product);

        return "shoppingCart";
    }

    // Post method once the user has paid
    @PostMapping(path = "/submitBilling")
    public String submitBilling(@Valid BillingInformation billingInformation, BindingResult bindingResult ,HttpSession session){
        // Retrieving the session cart
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");

        // if statement for when the billing information has any errors, and if there is, it should remain on the same page (billing page)
        if(bindingResult.hasErrors()){
            return "billing";
        }
        billingInformation.setShoppingCart(cart);
        billingService.saveBillingInformation(billingInformation);

        if(billingService.saveBillingInformation(billingInformation)) {
            session.removeAttribute("cart");
            return "redirect:/thankyou";
        } else {
            bindingResult.addError(new ObjectError("billing", "An error occurred while processing your order"));
            return "billing";
        }

    }

}
