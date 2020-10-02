package com.entreprise.projet.web;

import com.entreprise.projet.domain.FileRepo;
import com.entreprise.projet.domain.FileStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin("*")
@RestController
public class FileController {

    @Autowired
    private FileRepo fileRepo ;

    @RequestMapping("/postfiles")
    public Iterable<FileStorage> getAllfiles() {
        return fileRepo.findAll();
    }
}