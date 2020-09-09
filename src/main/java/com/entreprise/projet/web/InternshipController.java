package com.entreprise.projet.web;

import com.entreprise.projet.domain.Car;
import com.entreprise.projet.domain.Internship;
import com.entreprise.projet.domain.internshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InternshipController {

    @Autowired
    private internshipRepository intern  ;

    @RequestMapping("/internships")
    public Iterable<Internship> getAllInternship() {
        return  intern.findAll() ;

    }






}
