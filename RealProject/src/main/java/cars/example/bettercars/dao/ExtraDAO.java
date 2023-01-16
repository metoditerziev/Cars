package cars.example.bettercars.dao;

import cars.example.bettercars.model.Brand;
import cars.example.bettercars.model.Extra;

import java.util.List;
import java.util.Optional;

public interface ExtraDAO {
    List<Extra> findAll();
    int addExtra(Extra extra);
    Optional<Extra> findById(int id);
    Optional<Extra> findByExtraName(String extraName);
    int deleteExtra(int id);
    public List<Extra> findAllExtrasByName (List<String> inputExtras);
}
