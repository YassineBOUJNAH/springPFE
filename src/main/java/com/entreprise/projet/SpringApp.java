package com.entreprise.projet;

import com.entreprise.projet.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringApp {
	@Autowired	
	private CarRepository repository;

	@Autowired	
	private OwnerRepository orepository;

	@Autowired	
	private UserRepository urepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringApp.class, args);
	}
	
	@Bean
	CommandLineRunner runner() {
		return args -> {
			Owner owner1 = new Owner("John" , "Johnson");
			Owner owner2 = new Owner("Mary" , "Robinson");
			orepository.save(owner1);
			orepository.save(owner2);
			repository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2017, 59000, owner1));
			repository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2014, 29000, owner2));
			repository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2018, 39000, owner2));
			
			urepository.save(new Student("user", "$2a$04$1.YhMIgNX/8TkCKGFUONWO1waedKhQ5KrnB30fl0Q01QKqmzLf.Zi", "CLIENT","dd"));
			urepository.save(new Student("admin","$2a$10$g0pWFlU8Wfzvm5oXr7OzHewreRBvJfnlNuaX.xM9U7lqYT1eFDY42" , "ADMIN","dd"));

		};
	}	
}
