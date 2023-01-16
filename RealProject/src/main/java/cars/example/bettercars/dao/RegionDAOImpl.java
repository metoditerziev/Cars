package cars.example.bettercars.dao;

import cars.example.bettercars.mapper.BrandRowMapper;
import cars.example.bettercars.mapper.RegionRowMapper;
import cars.example.bettercars.model.Brand;
import cars.example.bettercars.model.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class RegionDAOImpl implements RegionDAO {
    public static final String GET_ALL_REGIONS = """
           SELECT id, region_name
           FROM regions
           LIMIT 100;
           """;

    public static final String INSERT_REGION = """
           INSERT into regions(region_name)
           VALUES (?);
           """;

    public static final String GET_REGION_BY_REGION_NAME = """
           SELECT id, region_name
           FROM regions
           WHERE region_name = ?;
           """;

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RegionDAOImpl(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Region> findAll() {
        return jdbcTemplate.query(GET_ALL_REGIONS, new RegionRowMapper());
    }

    @Override
    public int addRegion(Region region) {

        return jdbcTemplate.update(INSERT_REGION,
                region.getRegionName());
    }

    @Override
    public Optional<Region> findById(int id) {
        return Optional.empty();
    }

    @Override
    public Optional<Region> findByRegionName(String regionName) {

        return jdbcTemplate.query(GET_REGION_BY_REGION_NAME, new RegionRowMapper(), regionName)
                .stream()
                .findFirst();
    }

    @Override
    public int deleteRegion(int id) {
        return 0;
    }
}

