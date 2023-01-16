package cars.example.bettercars.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class Extra {

    @JsonProperty("id")
    private int id;

    public int getId() {
        return id;
    }

    @NotBlank
    @JsonProperty("extra_type")
    private String extraType;

    public Extra(String extraType) {
        this.extraType = extraType;
    }
    public Extra(int id, String extraType) {
        this.id = id;
        this.extraType = extraType;
    }
    public String getExtraType() {
        return this.extraType;
    }
}
