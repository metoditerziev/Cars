package cars.example.bettercars.dao;

import cars.example.bettercars.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDAO {
    List<User> findAll();
    int addUser(User user);
    Optional<User> findById(Long id);
    Optional<User> findByUsername(String username);
    int deleteUser(Long id);
    int updateUser(int id, User user);
}

