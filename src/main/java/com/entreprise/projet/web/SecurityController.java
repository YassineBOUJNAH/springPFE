package com.entreprise.projet.web;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entreprise.projet.domain.UserRepository;
import com.entreprise.projet.domain.Utilisateur;

@Controller
public class SecurityController {
	
	@Autowired
	private UserRepository urepository;	
 
    @RequestMapping(value = "/Current", method = RequestMethod.GET)
    @ResponseBody
    public Utilisateur currentUserName(Authentication authentication) {
        String username = authentication.getName();
        return urepository.findByUsername(username);   
    }
    
}