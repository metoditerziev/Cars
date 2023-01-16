package cars.example.bettercars.mapper;

import cars.example.bettercars.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new User(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getInt("enabled"),
                rs.getString("email"),
                rs.getString("mobile_phone")
        );
    }
}
