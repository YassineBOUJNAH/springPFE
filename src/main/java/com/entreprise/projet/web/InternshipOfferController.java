package com.entreprise.projet.web;

import com.entreprise.projet.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InternshipOfferController {
    @Autowired
    private InternshipOfferRepo internshipOfferRepo;
    @Autowired
    private StudentRepo studentRepo;

    //Fetch all the internship offers
    @RequestMapping("/internshipoffers")
    public Iterable<InternshipOffer> getAllInternshipOffer() {return  internshipOfferRepo.findAll();}

    //Fetch internships by student
    /*
    * Cause 500 INTERNAL SERVER ERROR !
    * */
    @GetMapping("/internshipoffers/student/{id}")
    @ResponseBody
    public List<InternshipOffer> findInternshipOfferByStudentId(@PathVariable(required = false) Long id) {
        return internshipOfferRepo.findByStudentId((long) id);
    }

    @GetMapping("/internshipoffers/state")
    @ResponseBody
    public List<InternshipOffer> findInternshipOffersByState(@RequestParam(required = false) String state) {
        return internshipOfferRepo.findByState((String) state);
    }

    //Add an inernship offer
    @PostMapping("/internshipoffers")
    public InternshipOffer addInternshipOffer(@RequestBody InternshipOffer internshipOffer) {
        //internshipOffer.setStudent(studentRepo.save(internshipOffer.getStudent()));
        return internshipOfferRepo.save(internshipOffer);
    }

    //delete an internship offer
    @DeleteMapping("/internshipoffers/delete/{id}")
    public void deleteInternshipOffer(@PathVariable long id) {
        internshipOfferRepo.deleteById(id);
    }
}
