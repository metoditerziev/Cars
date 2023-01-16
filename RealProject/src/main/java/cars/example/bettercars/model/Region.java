package cars.example.bettercars.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class Region {
    @JsonProperty("id")
    private int id;

    @NotBlank
    @JsonProperty("region_name")
    private String region;

    public int getId() {
        return id;
    }

    public  Region(String region) {
        this.region = region;
    }
    public Region(int id, String region) {
        this.id = id;
        this.region = region;
    }
    public String getRegionName() {
        return this.region;
    }
}
