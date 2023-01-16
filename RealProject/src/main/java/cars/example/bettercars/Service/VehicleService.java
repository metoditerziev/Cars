package cars.example.bettercars.Service;

import cars.example.bettercars.dao.*;
import cars.example.bettercars.enums.CategoryEnum;
import cars.example.bettercars.enums.EngineTypeEnum;
import cars.example.bettercars.enums.GearBoxEnum;
import cars.example.bettercars.enums.VehicleTypeEnum;
import cars.example.bettercars.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialStruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VehicleService {

    private final VehicleDAO vehicleDAO;
    private final BrandDAO brandDAO;
    private final RegionDAO regionDAO;
    private final ExtraDAO extraDAO;
    private final ModelDAO modelDAO;
    private final UserDAO userDAO;


    @Autowired
    public VehicleService(VehicleDAO vehicleDAO, BrandDAO brandDAO, RegionDAO regionDAO, ExtraDAO extraDAO, ModelDAO modelDAO, UserDAO userDAO) {

        this.vehicleDAO = vehicleDAO;
        this.brandDAO = brandDAO;
        this.regionDAO = regionDAO;
        this.extraDAO = extraDAO;
        this.modelDAO = modelDAO;
        this.userDAO = userDAO;
    }

//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//

    public List<Vehicle> getAllVehicle() {

        List<Vehicle> allVehicle = vehicleDAO.findAll();
        return allVehicle;

    }

    public String addVehicle(VehicleDTO vehicleDTO) throws Exception {
        if (vehicleDTO.getCategory().isEmpty() || vehicleDTO.getRegion().isEmpty() || vehicleDTO.getModel().isEmpty()
                || vehicleDTO.getExtras().isEmpty() || vehicleDTO.getBrand().isEmpty() || vehicleDTO.getEngine().isEmpty()
                || vehicleDTO.getGearbox().isEmpty() || vehicleDTO.getType().isEmpty() || vehicleDTO.getUsername().isEmpty()) {
            throw new Exception("You have required fields which must not be empty");
        }
        try {
            Optional<Brand> brand = brandDAO.findByBrandName(vehicleDTO.getBrand());
            Optional<Model> model = modelDAO.findByModelName(vehicleDTO.getModel());
            Optional<Region> region = regionDAO.findByRegionName(vehicleDTO.getRegion());
            Optional<User> user = userDAO.findByUsername(vehicleDTO.getUsername());
            List<Extra> extras = extraDAO.findAllExtrasByName(vehicleDTO.getExtras());

            Vehicle vehicle = new Vehicle(
                    vehicleDTO.getYear(),
                    CategoryEnum.valueOf(vehicleDTO.getCategory().toUpperCase()),
                    vehicleDTO.getKmDriven(),
                    vehicleDTO.getDescription(),
                    vehicleDTO.getPrice(),
                    vehicleDTO.getHorsePower(),
                    GearBoxEnum.valueOf(vehicleDTO.getGearbox().toUpperCase()),
                    EngineTypeEnum.valueOf(vehicleDTO.getEngine().toUpperCase()),
                    brand.get(),
                    model.get(),
                    extras,
                    region.get(),
                    VehicleTypeEnum.valueOf(vehicleDTO.getType().toUpperCase()),
                    user.get()
            );

            vehicleDAO.addVehicle(vehicle);

            return "Success";


        } catch (Exception e) {
            return e.getMessage();
        }
    }


    public String addModel(String modelName, String brandName) throws Exception {

        if (modelName.isEmpty()) {
            throw new Exception("This field shouldn't be empty");
        } else {
            Optional<Brand> brand = brandDAO.findByBrandName(brandName);
            Model model = new Model(modelName, brand.get().getId());

            modelDAO.addModel(model);
            return "Success";
        }
    }

    public String addBrand(String brandName) throws Exception {
        if (brandName.isEmpty()) {
            throw new Exception("This field shouldn't be empty");
        } else {
        Brand brand = new Brand(brandName);

        brandDAO.addBrand(brand);
        return "Success";
    }
}
    public String addRegion(String regionName) throws Exception {
        if (regionName.isEmpty()) {
            throw new Exception("This field shouldn't be empty");
        }else {
            Region region = new Region(regionName);

            regionDAO.addRegion(region);
            return "Success";
        }
    }
    public String addExtra(List<String> extras) throws Exception {
        if (extras.size() == 0) {
            throw new Exception("This field shouldn't be empty");
        } else {
            for(String e : extras) {
                Extra extra = new Extra(e);
                extraDAO.addExtra(extra);
            }
        return "Successfully added new extra";
        }
    }

    public List<Extra> getAllExtras() {
        return extraDAO.findAll();
    }

    public List<Region> getAllRegions() {
        return regionDAO.findAll();
    }
    public List<Brand> getAllBrands() {
        return brandDAO.findAll();
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleDAO.findAll();
    }

    public void addImage(String vehicleId, MultipartFile uploadfile) throws IOException {
        vehicleDAO.addImageToVehicle(vehicleId, uploadfile.getBytes());
    }
}
