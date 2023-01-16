package cars.example.bettercars.dao;

import cars.example.bettercars.mapper.BrandRowMapper;
import cars.example.bettercars.mapper.ExtraRowMapper;
import cars.example.bettercars.model.Brand;
import cars.example.bettercars.model.Extra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Repository
public class ExtraDAOImpl implements ExtraDAO {
    public static final String GET_ALL_EXTRAS = """
           SELECT id, extra_name
           FROM extras
           LIMIT 100;
           """;

    public static final String INSERT_EXTRAS = """
           INSERT into extras(extra_name)
           VALUES (?);
           """;

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ExtraDAOImpl(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Extra> findAll() {

        return jdbcTemplate.query(GET_ALL_EXTRAS, new ExtraRowMapper());
    }


    @Override
    public List<Extra> findAllExtrasByName (List<String> inputExtras) {
        String queryToExecute = String.format("select id, extra_name from extras where extra_name IN (%s);",
                inputExtras.stream()
                        .map(v -> "'" + v + "'")
                        .collect(Collectors.joining(", ")));


        return jdbcTemplate.query(queryToExecute, new ExtraRowMapper());
    }

    @Override
    public int addExtra(Extra extra) {

        return jdbcTemplate.update(INSERT_EXTRAS,
                extra.getExtraType());
    }

    @Override
    public Optional<Extra> findById(int id) {
        return Optional.empty();
    }

    @Override
    public Optional<Extra> findByExtraName(String extraName) {
        return Optional.empty();
    }

    @Override
    public int deleteExtra(int id) {
        return 0;
    }
}

