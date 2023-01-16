package cars.example.bettercars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"cars.example.bettercars.model"})

public class BettercarsApplication {

	public static void main(String[] args) {

		SpringApplication.run(BettercarsApplication.class, args);
	}

}
