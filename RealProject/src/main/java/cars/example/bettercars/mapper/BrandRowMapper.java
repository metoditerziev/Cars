package cars.example.bettercars.mapper;

import cars.example.bettercars.model.Brand;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BrandRowMapper implements RowMapper<Brand> {
    @Override
    public Brand mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Brand(
                rs.getInt("id"),
                rs.getString("brand_name")
        );
    }
}
