package cars.example.bettercars.controller;

import cars.example.bettercars.Service.UserService;
import cars.example.bettercars.model.User;
import cars.example.bettercars.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping("/nothing")
    public String sayNothing() {

        return "nothing";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all_users")
    public ResponseEntity<?> getUsers() {

        List<User> allUsers = userService.getAllUsers();

        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody UserDTO userDTO) throws Exception {

        return new ResponseEntity<String>(userService.login(userDTO), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/delete")

    public ResponseEntity<?> deleteUser(@RequestParam Long userId) {
        try {
            return new ResponseEntity<String>(userService.deleteUser(userId), HttpStatus.OK);
        } catch (UsernameNotFoundException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        } catch (NullPointerException exe) {
            return new ResponseEntity<>(exe.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }

    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody UserDTO userDTO) {

        try {

            String response = userService.register(userDTO);
            return new ResponseEntity<>(response, HttpStatus.CREATED);

        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
