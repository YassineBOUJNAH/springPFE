package com.entreprise.projet.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student extends Utilisateur{

    private static final long serialVersionUID = 1L;

    private String cne;

    //@OneToMany(targetEntity = InternshipOffer.class,cascade = CascadeType.ALL, mappedBy = "student")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    @JsonIgnore
    private List<InternshipOffer> internshipOffers;
    //@JoinColumn(name ="internOffer",referencedColumnName = "id")


    public static long getSerialVersionUID() { return serialVersionUID;  }

    public String getCne() {
        return cne;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    public List<InternshipOffer> getInternshipOffers() {
        return internshipOffers;
    }

    public void setInternshipOffers(List<InternshipOffer> internshipOffers) {
        this.internshipOffers = internshipOffers;
    }

    public Student() {
    }

    public Student(String username, String password, String role, String email, String frstname, String lastname, String address, String phone, String sexe, String cne) {
        super(username, password, role, email, frstname, lastname, address, phone, sexe);
        this.cne = cne;
    }

    public Student(String username, String password, String role, String cne) {
        super(username, password, role);
        this.cne = cne;
    }
}
