package com.entreprise.projet.web;

import com.entreprise.projet.domain.Internship;
import com.entreprise.projet.domain.SupervisorRepo;
import com.entreprise.projet.domain.internshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SupervisorController {

    @Autowired
    private SupervisorRepo repo ;

    @Autowired
    private internshipRepository internshipRepository ;

    @GetMapping("/supervisor/{id}/internships")
    public List<Internship> getInternshipBySupervisor(@PathVariable(required = false) Long id) {
        return internshipRepository.findBySupervisor(id) ;
    }

}
