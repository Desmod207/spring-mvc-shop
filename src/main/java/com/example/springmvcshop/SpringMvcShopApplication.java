package com.example.springmvcshop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.springmvcshop.data.ProductRepository;
import com.example.springmvcshop.data.UserRepository;

@SpringBootApplication
public class SpringMvcShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcShopApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(ProductRepository productRepository, UserRepository userRepository) {
		return args -> {
			userRepository.deleteAll();
			userRepository.save(new User("user", "$2a$10$5p6F1SSEI5haZOvGcBtXruF2PZvfoUoLEau2pVsjse8nii.KZ/0BS", "user", "address")); // Пароль: 1234
			productRepository.deleteAll();
			productRepository.save(new Product(null, "Product 1", "/images/plug.jpg", "description", 100));
			productRepository.save(new Product(null, "Product 2", "/images/plug.jpg", "description", 100));
		};
	}

}
