package com.entreprise.projet.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Supervisor extends Utilisateur{

    private static final long serialVersionUID = 1L;

    private String speciality;

    @OneToMany(mappedBy = "supervisor" , orphanRemoval = true , fetch = FetchType.EAGER)
    private List<Internship> internships ;


    public Supervisor() {

    }

    public Supervisor( String username, String password, String role, String email, String frstname, String lastname, String address, String phone, String sexe, String speciality) {
        super(username, password, role, email, frstname, lastname, address, phone, sexe);
        this.speciality = speciality;
    }

    public Supervisor(String username, String password, String role, String speciality) {
        super(username, password, role);
        this.speciality = speciality;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public void addIntership(Internship intern){
        internships.add(intern);
    }

}
