package com.entreprise.projet.web;


import com.entreprise.projet.domain.FileStorage;
import com.entreprise.projet.domain.report;
import com.entreprise.projet.domain.reportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class reportController {

    @Autowired
    private reportRepository repository ;


    @RequestMapping("/reports")
    public Iterable<report> getAllreports() {
        return repository.findAll();
    }
}
