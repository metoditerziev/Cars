package cars.example.bettercars.controller;

import cars.example.bettercars.Service.UserService;
import cars.example.bettercars.Service.VehicleService;
import cars.example.bettercars.enums.CategoryEnum;
import cars.example.bettercars.enums.EngineTypeEnum;
import cars.example.bettercars.enums.GearBoxEnum;
import cars.example.bettercars.enums.VehicleTypeEnum;
import cars.example.bettercars.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("vehicle")
public class VehicleController {
    @Autowired
    public VehicleService vehicleService;

    @RequestMapping(method = RequestMethod.POST, value = "/fileUpload", consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
    public String sayNothing(@RequestPart("file") MultipartFile imageFile, @RequestParam String vehicleId) throws IOException {

        vehicleService.addImage(vehicleId, imageFile);
        return "nothing";
    }

    @GetMapping("/all_vehicles")
    public ResponseEntity<?> getVehicles() {
        try {

            List<Vehicle> allVehicles = vehicleService.getAllVehicles();
            return new ResponseEntity<>(allVehicles, HttpStatus.OK);

        }catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/brands")
    public ResponseEntity<?> getBrands() {
        try {
            List<Brand> allBrands = vehicleService.getAllBrands();
            return new ResponseEntity<>(allBrands, HttpStatus.OK);

        }catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/brand")
    public ResponseEntity<?> addBrand(@RequestBody VehicleDTO vehicleDTO) {

        try {

            String response = vehicleService.addBrand(vehicleDTO.getBrand());
            return new ResponseEntity<>(response, HttpStatus.CREATED);

        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/region")
    public ResponseEntity<?> addRegion(@RequestBody VehicleDTO vehicleDTO) {
        try {
            String response = vehicleService.addRegion(vehicleDTO.getRegion());
            return new ResponseEntity<>(response, HttpStatus.CREATED);

        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/regions")
    public ResponseEntity<?> getRegions() {
        try {
            List<Region> allRegions = vehicleService.getAllRegions();
            return new ResponseEntity<>(allRegions, HttpStatus.OK);

        }catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/model")
    public ResponseEntity<?> addModel(@RequestBody VehicleDTO vehicleDTO) {
        try {
            String response = vehicleService.addModel(vehicleDTO.getModel(), vehicleDTO.getBrand());
            return new ResponseEntity<>(response, HttpStatus.CREATED);

        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/extra")
    public ResponseEntity<?> addExtra(@RequestBody VehicleDTO vehicleDTO) {
        try {
            String response = vehicleService.addExtra(vehicleDTO.getExtras());
            return new ResponseEntity<>(response, HttpStatus.CREATED);

        }catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/extras")
    public ResponseEntity<?> getExtras() {
        try {
            List<Extra> allExtras = vehicleService.getAllExtras();
            return new ResponseEntity<>(allExtras, HttpStatus.OK);

        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/categories")
    public ResponseEntity<?> getAllCategories() {

        List<CategoryEnum> allCategories = Arrays.asList(CategoryEnum.values());
        return new ResponseEntity<>(allCategories, HttpStatus.OK);
    }

    @GetMapping("/engines")
    public ResponseEntity<?> getAllEngines() {

        List<EngineTypeEnum> allEngines = Arrays.asList(EngineTypeEnum.values());
        return new ResponseEntity<>(allEngines, HttpStatus.OK);
    }

    @GetMapping("/gearboxes")
    public ResponseEntity<?> getAllGearboxes() {

        List<GearBoxEnum> allGearboxes = Arrays.asList(GearBoxEnum.values());
        return new ResponseEntity<>(allGearboxes, HttpStatus.OK);
    }

    @GetMapping("/vehicle_types")
    public ResponseEntity<?> getAllVehicleTypes() {

        List<VehicleTypeEnum> allVehicleTypes = Arrays.asList(VehicleTypeEnum.values());
        return new ResponseEntity<>(allVehicleTypes, HttpStatus.OK);
    }

    @PostMapping("/register_vehicle")
    public ResponseEntity<?> register(@RequestBody VehicleDTO vehicleDTO) {

        try {
            String response = vehicleService.addVehicle(vehicleDTO);
            return new ResponseEntity<>(response, HttpStatus.CREATED);

        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
