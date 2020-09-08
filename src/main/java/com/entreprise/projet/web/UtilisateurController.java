package com.entreprise.projet.web;

import com.entreprise.projet.domain.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entreprise.projet.domain.UserRepository;
import com.entreprise.projet.domain.Utilisateur;


@RestController
public class UtilisateurController{

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository repository;
	

	@PostMapping("/adduser")
	public Utilisateur newUser(@RequestBody Utilisateur newUser) {
		
		String password = passwordEncoder.encode(newUser.getPassword()) ;
		newUser.setPassword(password);
		return repository.save(newUser);
		
	}

	@RequestMapping("/users")
	public Iterable<Utilisateur> getUsers() {
		return repository.findAll();
	}
}
