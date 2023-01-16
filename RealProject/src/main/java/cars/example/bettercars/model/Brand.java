package cars.example.bettercars.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class Brand {
    @JsonProperty("id")
    private int id;

    public int getId() {
        return id;
    }

    @NotBlank
    @JsonProperty("brand_name")
    private String brandName;

    public Brand(String brandName) {
        this.brandName = brandName;
    }

    public Brand(int id, String brandName) {
        this.id = id;
        this.brandName = brandName;
    }

    public String getBrandName() {
        return this.brandName;
    }
}
