package com.entreprise.projet.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Supervisor extends Utilisateur{

    private static final long serialVersionUID = 1L;

    private String speciality;

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

}
