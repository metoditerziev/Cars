package cars.example.bettercars.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class Model {

    @JsonProperty("id")
    private int id;

    public int getId() {
        return id;
    }

    @NotBlank
    @JsonProperty("name")
    private String name;


    @NotBlank
    @JsonProperty("brand_id")
    private int brandId;

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public Model(String name, int brandId) {
        this.name = name;
        this.brandId = brandId;

    }
    public Model(int id, String name, int brandId) {
        this.id = id;
        this.name = name;
        this.brandId = brandId;
    }
    public String getModelName() {
        return this.name;
    }
}
