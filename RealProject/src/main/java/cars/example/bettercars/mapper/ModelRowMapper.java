package cars.example.bettercars.mapper;

import cars.example.bettercars.model.Brand;
import cars.example.bettercars.model.Model;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;

public class ModelRowMapper implements RowMapper<Model> {
    @Override
    public Model mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Model(
                rs.getInt("id"),
                rs.getString("model_name"),
                rs.getInt("brand_id")
        );

    }
}
