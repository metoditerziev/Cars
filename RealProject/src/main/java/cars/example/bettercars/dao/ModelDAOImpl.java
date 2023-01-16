package cars.example.bettercars.dao;

import cars.example.bettercars.mapper.BrandRowMapper;
import cars.example.bettercars.mapper.ModelRowMapper;
import cars.example.bettercars.model.Brand;
import cars.example.bettercars.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class ModelDAOImpl implements ModelDAO{

    public static final String GET_ALL_MODELS = """
           SELECT id, model_name
           FROM brands
           LIMIT 100;
           """;

    public static final String INSERT_MODEL = """
           INSERT into models(model_name, brand_id)
           VALUES (?, ?);
           """;

    public static final String GET_MODEL_BY_MODEL_NAME = """
           SELECT id, model_name, brand_id
           FROM models
           WHERE model_name = ?;
           """;

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ModelDAOImpl(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Model> findAll() {
        return jdbcTemplate.query(GET_ALL_MODELS, new ModelRowMapper());
    }

    @Override
    public int addModel(Model model) {

        return jdbcTemplate.update(INSERT_MODEL,
                model.getModelName(), model.getBrandId());
    }

    @Override
    public Optional<Model> findById(int id) {

        return Optional.empty();
    }

    @Override
    public Optional<Model> findByModelName(String modelName) {

        return jdbcTemplate.query(GET_MODEL_BY_MODEL_NAME, new ModelRowMapper(), modelName)
                .stream()
                .findFirst();
    }

    @Override
    public int deleteModel(int id) {
        return 0;
    }

}
