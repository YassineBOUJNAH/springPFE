package com.entreprise.projet;

import com.entreprise.projet.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class SpringApp {
	@Autowired	
	private CarRepository repository;

	@Autowired	
	private OwnerRepository orepository;

	@Autowired	
	private UserRepository urepository;


	@Autowired
	private internshipRepository internRep ;

	@Autowired
	private StudentRepo studentRepo ;

	@Autowired
	private SupervisorRepo supervisorRepo ;
	
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
			
			urepository.save(new Student("user", "$2a$10$g0pWFlU8Wfzvm5oXr7OzHewreRBvJfnlNuaX.xM9U7lqYT1eFDY42", "STUDENT","dd"));
			urepository.save(new Utilisateur("admin","$2a$10$g0pWFlU8Wfzvm5oXr7OzHewreRBvJfnlNuaX.xM9U7lqYT1eFDY42" , "ADMIN"));
			urepository.save(new Supervisor("supervi", "$2a$10$g0pWFlU8Wfzvm5oXr7OzHewreRBvJfnlNuaX.xM9U7lqYT1eFDY42", "SUPERVISOR","dd"));

			//Internship
			Student student = new Student("student", "$2a$10$g0pWFlU8Wfzvm5oXr7OzHewreRBvJfnlNuaX.xM9U7lqYT1eFDY42", "STUDENT" , "tt","gz","sj","jz","jz","hz","dd") ;
			Supervisor supervisor = new Supervisor("supervisor", "$2a$10$g0pWFlU8Wfzvm5oXr7OzHewreRBvJfnlNuaX.xM9U7lqYT1eFDY42", "SUPERVISOR" , "tt","gz","sj","jz","jz","hz","dd");

			studentRepo.save(student);
			supervisorRepo.save(supervisor);

           //this task will be performed by the admin
			Internship internship = new Internship("title","entreprise","description", new Date(622790105000L),new Date());
			Internship internship2 = new Internship("title","entreprise","description", new Date(622790105000L),new Date());

			internship.setStudent(student);
			internship.setSupervisor(supervisor);

			internship2.setSupervisor(supervisor);
			internship2.setStudent(student);


			internRep.save(internship) ;
			internRep.save(internship2) ;


		};
	}	
}
