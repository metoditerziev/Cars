package cars.example.bettercars.dao;

import cars.example.bettercars.model.Brand;
import cars.example.bettercars.model.Region;

import java.util.List;
import java.util.Optional;

public interface RegionDAO {
    List<Region> findAll();
    int addRegion(Region region);
    Optional<Region> findById(int id);
    Optional<Region> findByRegionName(String regionName);
    int deleteRegion(int id);
}
