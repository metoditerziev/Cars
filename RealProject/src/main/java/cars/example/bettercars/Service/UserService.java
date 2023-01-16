package cars.example.bettercars.Service;
import java.util.List;
import java.util.Optional;

import cars.example.bettercars.dao.UserDAO;
import cars.example.bettercars.model.UserDTO;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import cars.example.bettercars.model.User;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {

        this.userDAO = userDAO;
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();


    public List<User> getAllUsers() {

        List<User> allUsers = userDAO.findAll();
        return allUsers;

    }

    @SuppressWarnings("unchecked")
    public String register(UserDTO userDTO) throws Exception {

        if(userDTO.getUsername().isEmpty()){
            throw new Exception("Username should not be empty");
        }
        try {
            Optional<User> existingUser = userDAO.findByUsername(userDTO.getUsername());

            if (existingUser.isEmpty()) {
                if(userDTO.getPassword().equals(userDTO.getRepeatedPassword())){
                    User user = new User(
                    userDTO.getUsername(),
                    bCryptPasswordEncoder.encode(userDTO.getPassword()),
                    1,
                    userDTO.getEmail(),
                    userDTO.getMobilePhone()
                    );

                    userDAO.addUser(user);
                    return "Success";
                } else {
                    return "Passwords not matching";
                }

            } else {
                return "This username already exists!";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @SuppressWarnings("unchecked")
    public String login(UserDTO userDTO) throws Exception {

        Optional<User> existingUser = userDAO.findByUsername(userDTO.getUsername());

        if (existingUser.isEmpty()) {
            throw new Exception("Wrong password");
        }
        if (!(bCryptPasswordEncoder.matches(userDTO.getPassword(), existingUser.get().getPassword()))) {
            throw new Exception("Wrong password");
        } else {
            return existingUser.get().getId().toString();
        }
    }

    public String deleteUser(Long userId) {
        if(userId == null) {
            throw new NullPointerException("User ID cannot be empty!");
        }
        if(userDAO.findById(userId).isEmpty()){
            throw new UsernameNotFoundException("There is no user with such id");
        }
        userDAO.deleteUser(userId);
        return "Deleted user with id: " + userId;
    }
}