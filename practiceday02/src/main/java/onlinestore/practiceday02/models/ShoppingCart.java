package onlinestore.practiceday02.models;

import java.util.LinkedList;
import java.util.List;

// To have all methods containing adding, removing, and getting the total list of products in the shopping cart
public class ShoppingCart {

    private List<Product> contents = new LinkedList<Product>();
    private Float subTotal;
    private Float Total;

    public List<Product> getItems() {
        return contents;
    }

    public void setItems(List<Product> items) {
        this.contents = items;
    }
    
    public void addItems(Product product) {
        this.contents.add(product);
        subTotal = Float.sum(this.subTotal, product.getPrice());
        Total = Float.sum(this.Total, product.getPrice());

    }

    public void removeItems(Product product) {
        this.contents.remove(product);
        subTotal = this.subTotal - product.getPrice();
        Total = this.Total - product.getPrice();
    }

    public Float getTotal() {
        return Total;
    }

}
