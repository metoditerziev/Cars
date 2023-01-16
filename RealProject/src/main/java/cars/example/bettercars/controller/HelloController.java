package cars.example.bettercars.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    @GetMapping("/")
    public String home() {

        return "<h1>Welcome to Meto Gryka's website<h1>";
    }


    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/usera")
    public String user() {

        return "<h1>Welcome USER<h1>";
    }

    @PreAuthorize("hasRole('MODERATOR')")
    @GetMapping("/moderator")
    public String moderator() {

        return "<h1>Welcome MODERATOR<h1>";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String admin() {

        return "<h1>Welcome ADMIN<h1>";
    }



}

