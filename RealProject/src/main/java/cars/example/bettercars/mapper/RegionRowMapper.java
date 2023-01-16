package cars.example.bettercars.mapper;

import cars.example.bettercars.model.Brand;
import cars.example.bettercars.model.Region;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RegionRowMapper implements RowMapper<Region> {

    @Override
    public Region mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Region(
                rs.getInt("id"),
                rs.getString("region_name")
        );
    }
}
