//package cars.example.bettercars.auth;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled=true)
//class SecurityConfig extends WebSecurityConfiguration {
//
//    public void configure(final WebSecurity web) {
//        // if you include spring-boot-starter-security in your dependencies,
//        // it makes your routes authenticated by default.
//        // To remove it, add this magic line.
//        web.ignoring().requestMatchers(new AntPathRequestMatcher("/**"));
//    }
//}
