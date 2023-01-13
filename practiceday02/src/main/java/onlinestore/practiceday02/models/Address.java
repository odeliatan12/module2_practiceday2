package onlinestore.practiceday02.models;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Address {
    
    @NotNull(message = "Please enter a valid street name")
    @Size(min = 1, max = 100, message = "Please enter a street address between 1 and 100 characters")
    private String street;

    @NotNull(message = "Please enter a appropriate city")
    private String city;

    @NotNull(message = "Please enter a valid state code")
    private String state;

    @NotNull(message = "Please enter a valid zip code")
    private String zipcode;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    

}
