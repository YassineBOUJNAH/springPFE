package com.entreprise.projet.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Student extends Utilisateur{

    private static final long serialVersionUID = 1L;

    private String cne;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="student")
    @JsonIgnore
    private List<InternshipOffer> internshipOffers;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCne() {
        return cne;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    public Student() {
    }

    public Student(Long id, String username, String password, String role, String email, String frstname, String lastname, String address, String phone, String sexe, String cne) {
        super(id, username, password, role, email, frstname, lastname, address, phone, sexe);
        this.cne = cne;
    }

    public Student(String username, String password, String role, String cne) {
        super(username, password, role);
        this.cne = cne;
    }
}
