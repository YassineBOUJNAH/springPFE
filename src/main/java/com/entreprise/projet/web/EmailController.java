package com.entreprise.projet.web;

import com.entreprise.projet.service.emailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

@RestController
public class EmailController {

    @Autowired
    private com.entreprise.projet.service.emailService emailService ;

    @PostMapping(value = "/sendemail" , consumes = MediaType.MULTIPART_FORM_DATA_VALUE )
    public String sendEmail(@RequestParam(value = "destination")  String destination , @RequestParam(value = "subject") String subject , @RequestParam(value = "content") String content ) throws AddressException, MessagingException, IOException {
        emailService.sendmail(destination , subject , "From your supervisor : "+content );
        return "Email sent successfully";

    }

}
