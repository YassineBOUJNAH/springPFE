package com.entreprise.projet.web;


import com.entreprise.projet.domain.Student;
import com.entreprise.projet.domain.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentsController {

        @Autowired
        private StudentRepo repo ;

        @RequestMapping("/students")
        public Iterable<Student> getAllStudents(){
            return repo.findAll();
        }

}
