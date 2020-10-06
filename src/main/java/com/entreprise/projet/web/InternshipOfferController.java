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
    public InternshipOffer addInternshipOffer(@RequestParam(value = "studentId") Long studentId,
                                              @RequestBody InternshipOffer internshipOffer
                                              ) {
        Student studentX = studentRepo.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found :: " + studentId));
        studentX.setId(studentId);
        //studentX.setUsername(student.getUsername());
        //studentX.setEmail(student.getEmail());
        internshipOffer.setStudent(studentX);
        return internshipOfferRepo.save(internshipOffer);
        //return ResponseEntity.ok(internshipOffer);
    }
    /*
    //Add an inernship offer
    @PostMapping("/internshipoffers/student/{studentId}")
    public InternshipOffer addInternshipOffer(@PathVariable(value = "id") Long studentId,
                                              @RequestBody InternshipOffer internshipOffer) {
        Student student = studentRepo.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor not found :: " + instructorId));
        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setEmail(userDetails.getEmail());
        final Instructor updatedUser = instructorRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }
    */


    //delete an internship offer
    @DeleteMapping("/internshipoffers/delete/{id}")
    public void deleteInternshipOffer(@PathVariable long id) {
        internshipOfferRepo.deleteById(id);
    }
}
