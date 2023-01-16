package cars.example.bettercars.dao;


import cars.example.bettercars.model.Model;

import java.util.List;
import java.util.Optional;

public interface ModelDAO {

    List<Model> findAll();
    int addModel(Model model);
    Optional<Model> findById(int id);
    Optional<Model> findByModelName(String modelName);
    int deleteModel(int id);
}
