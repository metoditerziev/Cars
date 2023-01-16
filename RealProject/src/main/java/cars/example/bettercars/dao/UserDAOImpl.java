package cars.example.bettercars.dao;

import cars.example.bettercars.model.User;
import cars.example.bettercars.mapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDAOImpl implements UserDAO {

    public static final String INSERT_USER = """
           INSERT into users(email, enabled, mobile_phone, password, username)
           VALUES (?,?,?,?,?);
           """;
    public static final String GET_ALL_USERS = """
           SELECT id, email, enabled, mobile_phone, password, username
           FROM users
           LIMIT 100;
           """;
    public static final String GET_USER_BY_ID = """
           SELECT id, email, enabled, mobile_phone, password, username
           FROM users
           WHERE id = ?;
           """;
    public static final String GET_USER_BY_USERNAME = """
           SELECT id, email, enabled, mobile_phone, password, username
           FROM users
           WHERE username = ?;
           """;

    public static final String UPDATE_USER_BY_ID = """
           UPDATE users
           SET  email = ?, enabled = ?, mobile_phone = ?, password = ?, username = ?
           WHERE id = ?;
           """;

    public static final String DELETE_USER_BY_ID = """
           DELETE FROM users
           WHERE id = ?;
           """;

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAOImpl(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int addUser(User user) {

        return jdbcTemplate.update(INSERT_USER,
                user.getEmail(),
                1,
                user.getMobilePhone(),
                user.getPassword(),
                user.getUsername());
    }

    @Override
    public List<User> findAll() {

        return jdbcTemplate.query(GET_ALL_USERS, new UserRowMapper());
    }

    @Override
    public Optional<User> findById(Long id) {

        return jdbcTemplate.query(GET_USER_BY_ID, new UserRowMapper(),id)
                .stream()
                .findFirst();
    }
    @Override
    public Optional<User> findByUsername(String username) {

        return jdbcTemplate.query(GET_USER_BY_USERNAME, new UserRowMapper(), username)
                .stream()
                .findFirst();
    }

    @Override
    public int deleteUser(Long id) {

        return jdbcTemplate.update(DELETE_USER_BY_ID, id);
    }

    @Override
    public int updateUser(int id, User user) {

        return jdbcTemplate.update(UPDATE_USER_BY_ID,
                user.getEmail(),
                user.getEnabled(),
                user.getMobilePhone(),
                user.getPassword(),
                user.getUsername(),
                id);
    }
}
