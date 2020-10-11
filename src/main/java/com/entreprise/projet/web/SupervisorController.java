package com.entreprise.projet.web;

import com.entreprise.projet.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SupervisorController {

    @Autowired
    private SupervisorRepo repo ;

    @Autowired
    private internshipRepository internshipRepository ;

    @Autowired
    private  PostRepository postRepository ;




    @GetMapping("/supervisor/{id}/internships")
    public List<Internship> getInternshipBySupervisor(@PathVariable(required = false) Long id) {
        return internshipRepository.findBySupervisor(id) ;
    }

    @RequestMapping("/supervisors")
    public Iterable<Supervisor> getAllSupervisors() {
        return  repo.findAll() ;
    }

    @RequestMapping("/supervisors/{id}/students")
    public List<Student> getStudentsBySupervisor( @PathVariable Long id) {
        return internshipRepository.findStudent_idBySupervisor_id(id);
    }

    @RequestMapping("/supervisors/{id}/posts")
    public Iterable<Post> getPostsBySupervisor( @PathVariable Long id) {
        return  postRepository.findAllBySupervisor_idOrderByPostedAtDesc(id);
    }


}
