package com.entreprise.projet.web;

import com.entreprise.projet.domain.Car;
import com.entreprise.projet.domain.Internship;
import com.entreprise.projet.domain.internshipRepository;
import com.entreprise.projet.domain.meeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InternshipController {

    @Autowired
    private internshipRepository intern  ;

    @RequestMapping("/internships")
    public Iterable<Internship> getAllInternship() {
        return  intern.findAll() ;

    }

    @GetMapping("/internships/sup/{id}")
    @ResponseBody
    public List<Internship> getInternshipBySupervisor(@PathVariable(required = false) Long id) {
        return intern.findBySupervisor((long) id);
    }

    @PutMapping("internships/{id}")
    public Internship setMeeting (@RequestBody  meeting m , @PathVariable Long id ) {
        return intern.findById(id).map(internship1 -> {
             internship1.setMeeting(m);
             return intern.save(internship1);
        }).orElseGet(() -> {
            return null ;
        });
    }

    @PutMapping("internships/cancelmeeting/{id}")
    public Internship cancelMeeting ( @PathVariable Long id ) {
        return intern.findById(id).map(internship1 -> {
            internship1.setMeeting(null);
            return intern.save(internship1);
        }).orElseGet(() -> {
            return null ;
        });
    }






}
