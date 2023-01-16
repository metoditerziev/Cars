package cars.example.bettercars.mapper;

import cars.example.bettercars.model.Brand;
import cars.example.bettercars.model.Extra;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;

public class ExtraRowMapper implements RowMapper<Extra> {

    @Override
    public Extra mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Extra(
                rs.getInt("id"),
                rs.getString("extra_name")
        );
    }
}
