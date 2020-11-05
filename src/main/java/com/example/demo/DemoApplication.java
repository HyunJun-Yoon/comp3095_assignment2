package com.example.demo;

import com.example.demo.domain.User;
import com.example.demo.domain.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	CommandLineRunner runner(UserRepository repository){
		return args -> {
			repository.save(new User("Dan", "Vega", "asdsa@gmail.com"));
		};
	}
}
