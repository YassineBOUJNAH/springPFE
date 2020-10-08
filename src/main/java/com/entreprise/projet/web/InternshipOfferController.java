package com.entreprise.projet.web;

import com.entreprise.projet.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InternshipOfferController {
    @Autowired
    private InternshipOfferRepo internshipOfferRepo;
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private internshipRepository internshipRepo;

    //Fetch all the internship offers
    @RequestMapping("/internshipoffers")
    public Iterable<InternshipOffer> getAllInternshipOffer() {return  internshipOfferRepo.findAll();}

    //Fetch internships by student
    @GetMapping("/internships/student/{id}")
    @ResponseBody
    public List<Internship> findInternshipByStudentId(@PathVariable(required = false) Long id) {
        return internshipRepo.findByStudentId((long) id);
    }

    //Fetch internship offers by student
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
    @ResponseBody
    public ResponseEntity<InternshipOffer> addInternshipOffer(@RequestParam(value = "studentId") Long studentId,
                                              @RequestBody InternshipOffer internshipOffer
                                              ) {
        Student studentX = studentRepo.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found :: " + studentId));
        studentX.setId(studentId);
        internshipOffer.setStudent(studentX);
        internshipOfferRepo.save(internshipOffer);
        return ResponseEntity.ok(internshipOffer);
    }

    //delete an internship offer
    @DeleteMapping("/internshipoffers/delete/{id}")
    public void deleteInternshipOffer(@PathVariable long id) {
        internshipOfferRepo.deleteById(id);
    }

}
