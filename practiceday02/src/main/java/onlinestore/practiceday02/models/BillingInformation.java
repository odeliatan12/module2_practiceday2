package onlinestore.practiceday02.models;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class BillingInformation {
    
    @NotNull(message = "please enter credit card number")
    // a pattern to match credit card number with a valid credit card host, in this case, all visa card, mastercard, discovery card, american express card, etc...
    @Pattern(regexp = "^(?:4[0-9]{12}(?:[0-9]{3})?|5[1-5][0-9]{14}|6(?:011|5[0-9][0-9])[0-9]{12}|3[47][0-9]{13}|3(?:0[0-5]|[68][0-9])[0-9]{11}|(?:2131|1800|35\\d{3})\\d{11})$",
            message = "Invalid credit card number")
    private String creditCardNumber;

    @NotNull(message = "please enter a expiry date")
    @Future(message = "Date has to be in the future, please contact your host if your card has already expired")
    private LocalDate expiryDate;

    @NotNull(message = "Please enter a cvv number")
    private String cvv;
    private Address billingAddress;
    private ShoppingCart shoppingCart;

    public String getCreditCardNumber() {
        return creditCardNumber;
    }
    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }
    public LocalDate getExpiryDate() {
        return expiryDate;
    }
    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }
    public String getCvv() {
        return cvv;
    }
    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
    public Address getBillingAddress() {
        return billingAddress;
    }
    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }
    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    
}
