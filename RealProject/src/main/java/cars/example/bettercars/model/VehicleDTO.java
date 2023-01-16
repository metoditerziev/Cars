package cars.example.bettercars.model;

import cars.example.bettercars.dao.ExtraDAO;
import cars.example.bettercars.dao.UserDAO;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

public class VehicleDTO {

    private int year;
    private String category;
    private int kmDriven;
    private String description;
    private BigDecimal price;
    private int horsePower;
    private String gearbox;
    private String engine;
    private String model;
    private String region;
    private List<String> extras;
    private String brand;

    private String username;

    public String getUsername() {
        return username;
    }

    private String type;

    public int getYear() {
        return year;
    }

    public String getCategory() {
        return category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getKmDriven() {
        return kmDriven;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public String getGearbox() {
        return gearbox;
    }

    public String getEngine() {
        return engine;
    }

    public String getModel() {
        return model;
    }

    public String getRegion() {
        return region;
    }

    public List<String> getExtras() {
        return extras;
    }

    public String getBrand() {
        return brand;
    }
}

