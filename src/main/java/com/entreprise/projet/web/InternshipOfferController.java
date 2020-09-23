package com.entreprise.projet.web;

import com.entreprise.projet.domain.Internship;
import com.entreprise.projet.domain.InternshipOffer;
import com.entreprise.projet.domain.InternshipOfferRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InternshipOfferController {
    @Autowired
    private InternshipOfferRepo internshipOfferRepo;

    //Fetch all the internship offers
    @RequestMapping("/internshipoffers")
    public Iterable<InternshipOffer> getAllInternshipOffer() {return  internshipOfferRepo.findAll();}

    //Fetch internships by student
    /*
    * Cause 500 INTERNAL SERVER ERROR !
    * */
    @GetMapping("/internshipoffers/student/{id}")
    @ResponseBody
    public List<Internship> findInternshipByStudent(@PathVariable(required = false) Long id) {
        return internshipOfferRepo.findByStudent((long) id);
    }

    //Add an inernship offer


    //delete an internship offer
    @DeleteMapping("/internshipoffers/{id}")
    public void deleteInternshipOffer(@PathVariable long id) {
        internshipOfferRepo.deleteById(id);
    }
}
