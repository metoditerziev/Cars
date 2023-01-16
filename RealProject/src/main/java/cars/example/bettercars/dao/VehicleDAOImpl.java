package cars.example.bettercars.dao;

import cars.example.bettercars.model.Extra;
import cars.example.bettercars.model.Vehicle;
import cars.example.bettercars.mapper.VehicleRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
@Repository
public class VehicleDAOImpl implements VehicleDAO {
    public static final String INSERT_VEHICLE = """
            INSERT into vehicles(year, category, km_driven, description, price, horse_power, gearbox, engine, brand_id, model_id, region_id, user_id, type)
            VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);
            """;

    public static final String INSERT_VEHICLE_EXTRAS = """
            INSERT into vehicle_extra(vehicle_id, extra_id)
            VALUES (?,?);
            """;

    public static final String GET_ALL_VEHICLES = "SELECT v.id, v.category, v.year, v.km_driven, v.description, v.price, v.horse_power, v.gearbox, v.engine, v.brand_id, v.model_id, v.region_id, v.user_id, v.type,\n" +
            "b.brand_name, m.model_name, r.region_name,\n" +
            "u.username, u.password, u.email, u.enabled, u.mobile_phone\n" +
            "FROM vehicles v\n" +
            "JOIN users u ON v.user_id = u.id\n" +
            "JOIN regions r ON v.region_id = r.id\n" +
            "JOIN models m ON v.model_id = m.id\n" +
            "JOIN brands b ON v.brand_id = b.id;";

    public static final String GET_VEHICLE_BY_ID = """
            SELECT id, email, enabled, mobile_phone, password, username
            FROM users
            WHERE id = ?;
            """;
    public static final String GET_VEHICLE_BY_MODEL_NAME = """
            SELECT id, year, category, km_driven, description price, horse_power, gearbox, engine
            FROM vehicles
            WHERE category = ?;
            """;

    public static final String UPDATE_VEHICLE_BY_ID = """
            UPDATE users
            SET  email = ?, enabled = ?, mobile_phone = ?, password = ?, username = ?
            WHERE id = ?;
            """;

    public static final String DELETE_VEHICLE_BY_ID = """
            DELETE FROM users
            WHERE id = ?;
            """;

    public static final String INSERT_IMAGE_TO_VEHICLE = """
            UPDATE vehicles set image = ?
            WHERE id = ?;
            """;

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public VehicleDAOImpl(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addVehicle(Vehicle vehicle) {

        GeneratedKeyHolder holder = new GeneratedKeyHolder();

        jdbcTemplate.update(new PreparedStatementCreator() {
                    @Override
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps = connection.prepareStatement(INSERT_VEHICLE, Statement.RETURN_GENERATED_KEYS);
                        ps.setInt(1, vehicle.getYear());
                        ps.setString(2, vehicle.getCategory());
                        ps.setInt(3, vehicle.getKmDriven());
                        ps.setString(4, vehicle.getDescription());
                        ps.setBigDecimal(5, vehicle.getPrice());
                        ps.setInt(6, vehicle.getHorsePower());
                        ps.setString(7, vehicle.getGearbox());
                        ps.setString(8, vehicle.getEngine());
                        ps.setInt(9, vehicle.getBrand().getId());
                        ps.setInt(10, vehicle.getModel().getId());
                        ps.setInt(11, vehicle.getRegion().getId());
                        ps.setLong(12, vehicle.getUser().getId());
                        ps.setString(13, vehicle.getType());
                        return ps;
                    }
                }, holder);


        for(Extra extra : vehicle.getExtrasList()){

            jdbcTemplate.update(INSERT_VEHICLE_EXTRAS, holder.getKey().intValue(), extra.getId());
        }
    }

    @Override
    public List<Vehicle> findAll() {

        return jdbcTemplate.query(GET_ALL_VEHICLES, new VehicleRowMapper());
    }

    @Override
    public Optional<Vehicle> findById(Long id) {

        return jdbcTemplate.query(GET_VEHICLE_BY_ID, new VehicleRowMapper(),id)
                .stream()
                .findFirst();
    }
    @Override
    public Optional<Vehicle> findByModel(String model_name) {

        return jdbcTemplate.query(GET_VEHICLE_BY_MODEL_NAME, new VehicleRowMapper(), model_name)
                .stream()
                .findFirst();
    }

    @Override
    public int deleteVehicle(int id) {

        return jdbcTemplate.update(DELETE_VEHICLE_BY_ID, id);
    }

    @Override
    public int updateVehicle(int id, Vehicle vehicle) {

        return jdbcTemplate.update(UPDATE_VEHICLE_BY_ID,
                vehicle.getPrice(),
                vehicle.getCategory(),
                vehicle.getGearbox(),
                vehicle.getDescription(),
                vehicle.getEngine(),
                vehicle.getHorsePower(),
                vehicle.getKmDriven(),
                vehicle.getYear(),
                id);
    }

    @Override
    public void addImageToVehicle(String vehicleId, byte[] bytes) {
        jdbcTemplate.update(INSERT_IMAGE_TO_VEHICLE, bytes, vehicleId);
    }
}

