package cars.example.bettercars.dao;

import cars.example.bettercars.model.Brand;

import java.util.List;
import java.util.Optional;

public interface BrandDAO {

    List<Brand> findAll();
    int addBrand(Brand brand);
    Optional<Brand> findById(int id);
    Optional<Brand> findByBrandName(String brandName);
    int deleteBrand(int id);
}
