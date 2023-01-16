package cars.example.bettercars.model;

import cars.example.bettercars.enums.CategoryEnum;
import cars.example.bettercars.enums.EngineTypeEnum;
import cars.example.bettercars.enums.GearBoxEnum;
import cars.example.bettercars.enums.VehicleTypeEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.List;
//import java.text.DecimalFormat;

public class Vehicle {

    @JsonProperty("id")
    private Long id;

    @NotBlank
    @JsonProperty("year")
    private int year;

    @NotBlank
    @JsonProperty("category")
    private CategoryEnum category;


    @NotBlank
    @JsonProperty("km_driven")
    private int kmDriven;
    @NotBlank
    @JsonProperty("description")
    private String description;

    @NotBlank
    @JsonProperty("price")
    private BigDecimal price;

    @NotBlank
    @JsonProperty("horse_power")
    private int horsePower;

    @NotBlank
    @JsonProperty("gearbox")
    private GearBoxEnum gearbox;

    @NotBlank
    @JsonProperty("engine")
    private EngineTypeEnum engine;

    @NotBlank
    @JsonProperty("type")
    private VehicleTypeEnum type;

    @NotBlank
    @JsonProperty("brand")
    private Brand brand;

    public String getType() {
        return type.name();
    }

    @NotBlank
    @JsonProperty("model")
    private Model model;

    public List<Extra> getExtrasList() {
        return extrasList;
    }

    @NotBlank
    @JsonProperty("extras")
    private List<Extra> extrasList;

    @NotBlank
    @JsonProperty("region")
    private Region region;

    public Model getModel() {
        return model;
    }

    @NotBlank
    @JsonProperty("user")
    private User user;

    public Region getRegion() {
        return region;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setExtrasList(List<Extra> extrasList) {
        this.extrasList = extrasList;
    }

    public Vehicle(int year, CategoryEnum category, int kmDriven, String description, BigDecimal price, int horsePower,
                   GearBoxEnum gearbox, EngineTypeEnum engine, Brand brand, Model model, List<Extra> extraList, Region region, VehicleTypeEnum type, User user) {
        this.year = year;
        this.category = category;
        this.kmDriven = kmDriven;
        this.description = description;
        this.price = price;
        this.horsePower = horsePower;
        this.gearbox = gearbox;
        this.engine = engine;
        this.brand = brand;
        this.model = model;
        this.extrasList = extraList;
        this.region = region;
        this.type = type;
        this.user = user;
    }

    public Vehicle(Long id, int year, CategoryEnum category, int kmDriven, String description, BigDecimal price,
                   int horsePower, GearBoxEnum gearbox, EngineTypeEnum engine, Brand brand, Model model, Region region, VehicleTypeEnum type, User user) {
        this.id = id;
        this.year = year;
        this.category = category;
        this.kmDriven = kmDriven;
        this.description = description;
        this.price = price;
        this.horsePower = horsePower;
        this.gearbox = gearbox;
        this.engine = engine;
        this.brand = brand;
        this.model = model;
        this.region = region;
        this.type = type;
        this.user = user;
    }


    @Override
    public String toString() {
        return "Vehicle{" +
                "year=" + year +
                ", category='" + category + '\'' +
                ", kmDriven=" + kmDriven +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", horsePower=" + horsePower +
                ", gearbox='" + gearbox + '\'' +
                ", engine='" + engine + '\'' +
                ", brand=" + brand +
                ", model=" + model +
                ", extrasList=" + extrasList +
                ", region=" + region +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public String getCategory() {
        return category.name();
    }

    public int getKmDriven() {
        return kmDriven;
    }

    public String getDescription() {
        return description;
    }

    public @NotBlank BigDecimal getPrice() {
        return price;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public String getGearbox() {
        return gearbox.name();
    }

    public String getEngine() {
        return engine.name();
    }

    public Brand getBrand() {
        return brand;
    }
}
