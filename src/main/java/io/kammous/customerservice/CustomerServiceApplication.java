package io.BoukriInfo.customerservice;

import io.BoukriInfo.customerservice.entities.Customer;
import io.BoukriInfo.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository, RepositoryRestConfiguration  restConfiguration) {
		restConfiguration.exposeIdsFor(Customer.class);
		return args -> {
			customerRepository.save(new Customer(null, "Boukri", "boukri@gmail.com"));
			customerRepository.save(new Customer(null, "BenHaddar", "Fakir@gmail.com"));
			customerRepository.save(new Customer(null, "Fakir", "Fakir@gmail.com"));
			customerRepository.findAll().forEach(System.out::println);
		};
	}
}
