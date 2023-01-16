package cars.example.bettercars.dao;

import cars.example.bettercars.mapper.BrandRowMapper;
import cars.example.bettercars.mapper.UserRowMapper;
import cars.example.bettercars.model.Brand;
import cars.example.bettercars.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BrandDAOImpl implements BrandDAO{

    public static final String GET_ALL_BRANDS = """
           SELECT id, brand_name
           FROM brands
           LIMIT 100;
           """;

    public static final String INSERT_BRAND = """
           INSERT into brands(brand_name)
           VALUES (?);
           """;

    public static final String GET_BRAND_BY_BRAND_NAME = """
           SELECT id, brand_name
           FROM brands
           WHERE brand_name = ?;
           """;

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BrandDAOImpl(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Brand> findAll() {
        return jdbcTemplate.query(GET_ALL_BRANDS, new BrandRowMapper());
    }

    @Override
    public int addBrand(Brand brand) {

        return jdbcTemplate.update(INSERT_BRAND,
                brand.getBrandName());
    }

    @Override
    public Optional<Brand> findById(int id) {
        return Optional.empty();
    }

    @Override
    public Optional<Brand> findByBrandName(String brandName) {

        return jdbcTemplate.query(GET_BRAND_BY_BRAND_NAME, new BrandRowMapper(), brandName)
                .stream()
                .findFirst();
    }

    @Override
    public int deleteBrand(int id) {
        return 0;
    }
}
