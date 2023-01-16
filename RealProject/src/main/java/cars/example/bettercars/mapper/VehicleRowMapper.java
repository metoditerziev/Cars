package cars.example.bettercars.mapper;

import cars.example.bettercars.enums.CategoryEnum;
import cars.example.bettercars.enums.EngineTypeEnum;
import cars.example.bettercars.enums.GearBoxEnum;
import cars.example.bettercars.enums.VehicleTypeEnum;
import cars.example.bettercars.model.*;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class VehicleRowMapper implements RowMapper<Vehicle> {

    @Override
    public Vehicle mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Vehicle(
                rs.getLong("id"),
                rs.getInt("year"),
                CategoryEnum.valueOf(rs.getString("category")),
                rs.getInt("km_driven"),
                rs.getString("description"),
                rs.getBigDecimal("price"),
                rs.getInt("horse_power"),
                GearBoxEnum.valueOf(rs.getString("gearbox")),
                EngineTypeEnum.valueOf(rs.getString("engine")),
                new Brand(rs.getInt("brand_id"), rs.getString("brand_name")),
                new Model(rs.getInt("model_id"), rs.getString("model_name"), rs.getInt("brand_id")),
                new Region(rs.getInt("region_id"), rs.getString("region_name")),
                VehicleTypeEnum.valueOf(rs.getString("type")),
                new User(rs.getLong("user_id"), rs.getString("username"), rs.getString("password"),
                        rs.getInt("enabled"), rs.getString("email"), rs.getString("mobile_phone"))

        );
    }
}