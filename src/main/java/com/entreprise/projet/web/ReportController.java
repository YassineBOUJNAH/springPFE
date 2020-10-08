package com.entreprise.projet.web;


import com.entreprise.projet.domain.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Logger;


@CrossOrigin("*")
@RestController
public class ReportController {

    @Autowired
    private reportRepository reportRepository;

    @Autowired
    private internshipRepository internshipRepository;

    @RequestMapping("/reports")
    public Iterable<report> getAllReports() {
        return reportRepository.findAll();
    }

    @RequestMapping("/interships/{id}/reports")
    public Iterable<report> getReportsByInternship( @PathVariable Long id) {
        return  reportRepository.findAllByInternshipId(id);
    }

    @PostMapping(value = "/reports", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<report> addReport(@RequestParam("description") String description , @RequestParam("content") String content , @RequestParam("idsup") Long id_sup , @RequestParam(value = "file",required = false) MultipartFile file) throws IOException {

        Internship internship = internshipRepository.findById(id_sup).orElseThrow(() -> new ResourceNotFoundException("Internship not found for this id :" + id_sup));
        report p = new report();
        //p.setPostedAt(new Timestamp(new Date().getTime()));

        internship.setId(id_sup);
        p.setInternship(internship);
        p.setContent(content);
        p.setVersion(description);

        if (file != null) {
            String filename = StringUtils.cleanPath(file.getOriginalFilename());
            String filetype = file.getContentType();
            byte[] data = file.getBytes();
            FileStorage f = new FileStorage(filename,filetype,data);
            p.setFile(f);
        }

        reportRepository.save(p);

        return ResponseEntity.ok(p);

    }

    @DeleteMapping("/reports/{id}")
    public void deleteReportById( @PathVariable Long id){
        reportRepository.deleteById(id);
    }
}
