package com.entreprise.projet;

import com.entreprise.projet.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class SpringApp {

	@Autowired	
	private UserRepository urepository;


	@Autowired
	private internshipRepository internRep ;
	@Autowired
	private InternshipOfferRepo internshipOfferRepo ;

	@Autowired
	private StudentRepo studentRepo ;

	@Autowired
	private SupervisorRepo supervisorRepo ;

	@Autowired
	private PostRepository postRepository ;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringApp.class, args);
	}
	
	@Bean
	CommandLineRunner runner() {
		return args -> {
			Owner owner1 = new Owner("John" , "Johnson");

			Owner owner2 = new Owner("Mary" , "Robinson");

			urepository.save(new Utilisateur("admin","$2a$10$g0pWFlU8Wfzvm5oXr7OzHewreRBvJfnlNuaX.xM9U7lqYT1eFDY42" , "ADMIN"));
			urepository.save(new Supervisor("supervi", "$2a$10$g0pWFlU8Wfzvm5oXr7OzHewreRBvJfnlNuaX.xM9U7lqYT1eFDY42", "SUPERVISOR","dd"));

			//Internship
			Student student = new Student("talhi", "$2a$10$g0pWFlU8Wfzvm5oXr7OzHewreRBvJfnlNuaX.xM9U7lqYT1eFDY42", "STUDENT" , "talhimohammed507@gmail.com","mohammed","talhi","Casa","0659631452","M","BE987465") ;
			Student student1 = new Student("ilyass", "$2a$10$g0pWFlU8Wfzvm5oXr7OzHewreRBvJfnlNuaX.xM9U7lqYT1eFDY42", "STUDENT" , "ilyasstrh@gmail.com","ilyass","tarhri","Rabat","0647985213","M","AA989862") ;
			Student student2 = new Student("yassine", "$2a$10$g0pWFlU8Wfzvm5oXr7OzHewreRBvJfnlNuaX.xM9U7lqYT1eFDY42", "STUDENT" , "yassineboujnah@gmail.com","yassine","boujnah","Casa","0631254698","M","BE989655") ;
			Student student3 = new Student("bader", "$2a$10$g0pWFlU8Wfzvm5oXr7OzHewreRBvJfnlNuaX.xM9U7lqYT1eFDY42", "STUDENT" , "ilyas@507@gmail.com","bader","boussalem","Rabat","065231465879","M","AA984562") ;

			Supervisor supervisor = new Supervisor("supervisor", "$2a$10$g0pWFlU8Wfzvm5oXr7OzHewreRBvJfnlNuaX.xM9U7lqYT1eFDY42", "SUPERVISOR" , "knafil@gmail.com","Khalid","Nafil","Rabat - Ensias","0631452563","M","Web & Mobile");

			studentRepo.save(student);
			studentRepo.save(student1);
			studentRepo.save(student2);
			studentRepo.save(student3);

			supervisorRepo.save(supervisor);

           //this task will be performed by the admin
			Internship internship = new Internship("title1","entreprise1","description1", new Date(622790105000L),new Date());
			Internship internship2 = new Internship("title2","entreprise2","description2", new Date(622790105000L),new Date());

			internship.setStudent(student);
			internship.setSupervisor(supervisor);

			internship2.setSupervisor(supervisor);
			internship2.setStudent(student1);
///////////

			internRep.save(internship) ;
			internRep.save(internship2) ;

			internshipOfferRepo.save(new InternshipOffer("full stack developer", "IBM", "inProgress", "full stack developer Intership at IBM","yassine",student,new Date(622790105000L),new Date()));
			internshipOfferRepo.save(new InternshipOffer("Machine learning", "GOOGLE", "inProgress", "Machine learning developer with at Google","bader",student1,new Date(622790105000L),new Date()));

			internshipOfferRepo.save(new InternshipOffer("full stack developer", "BMCE BANK", "inProgress", "full stack developer Intership at BMCE BANK","ilyass",student,new Date(622790105000L),new Date()));
			internshipOfferRepo.save(new InternshipOffer("Data scientist", "NASA", "inProgress", "Data Scientist at NASA","Talhi",student1,new Date(622790105000L),new Date()));
			internshipOfferRepo.save(new InternshipOffer("Big data", "ENSIAS", "refused", "Big data in ensias","talhi",student1,new Date(622790105000L),new Date()));

		};
	}	
}
