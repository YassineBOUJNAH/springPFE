package com.entreprise.projet.web;

import com.entreprise.projet.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@CrossOrigin("*")
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

    @GetMapping("/internships/sup/{id}/report")
    public ResponseEntity getReportByInternship(@PathVariable(required = false) Long id) {
         Internship internship = intern.findById(id).orElseThrow(() -> new ResourceNotFoundException("Internship not found for this id :" + id ));
         while(internship.getReportfile().getData() != null ) {
               byte [] data = internship.getReportfile().getData();
               return ResponseEntity
                        .ok()
                        .contentType(MediaType.APPLICATION_PDF)
                        .body(data);
         }

         return ResponseEntity.ok("no report is set for this internship");

    }


    @PutMapping(value = "internships/{id}/setreport" , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Internship setReport (@RequestParam(value = "file") MultipartFile report,@RequestParam(value = "description") String description, @PathVariable Long id ) {
        return intern.findById(id).map(internship1 -> {
            report r = new report();
            try {
                r.setData(report.getBytes());
                r.setType(report.getContentType());
            } catch (IOException e) {
                e.printStackTrace();
            }
            r.setDescription(description);
            internship1.setReportfile(r);
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

    @PostMapping(value = "internships/{id}/setreport" , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Internship addReport (@RequestParam(value = "file") MultipartFile report,@RequestParam(value = "description") String description, @PathVariable Long id ) {
        return intern.findById(id).map(internship1 -> {
            report r = new report();
            try {
                r.setData(report.getBytes());
                r.setType(report.getContentType());
            } catch (IOException e) {
                e.printStackTrace();
            }
            r.setDescription(description);
            internship1.setReportfile(r);
            return intern.save(internship1);
        }).orElseGet(() -> {
            return null ;
        });
    }






}
