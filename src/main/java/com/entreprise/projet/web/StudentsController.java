package com.entreprise.projet.web;


import com.entreprise.projet.domain.Student;
import com.entreprise.projet.domain.StudentRepo;
import com.entreprise.projet.domain.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentsController {
        @Autowired
        private PasswordEncoder passwordEncoder;

        @Autowired
        private StudentRepo repo ;

        @RequestMapping("/students")
        public Iterable<Student> getAllStudents(){
            return repo.findAll();
        }

        @PostMapping("/addstudent")
        public Utilisateur newUser(@RequestBody Student newUser) {
                String password = passwordEncoder.encode(newUser.getPassword()) ;
                newUser.setPassword(password);
                return repo.save(newUser);
        }

}
