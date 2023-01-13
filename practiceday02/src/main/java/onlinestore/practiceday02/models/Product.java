package onlinestore.practiceday02.models;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Product {

    private Integer id;

    @NotNull(message = "Please enter product name")
    @Size(min = 1, max = 100, message = "Please enter product that is between 1 and 100 characters")
    private String name;

    @NotNull(message = "Please enter price for your product")
    private Float price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    

}
