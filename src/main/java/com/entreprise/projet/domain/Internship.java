package com.entreprise.projet.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Internship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false )
    private Long id  ;
    @Column(nullable = false)
    private String title ;
    @Column(nullable = false)
    private String Entreprise ;
    @Column(nullable = false)
    private String description ;
    @Column(nullable = false)
    private Date startdate ;
    @Column(nullable = false)
    private Date lasttdate ;


    @OneToMany(mappedBy = "internship" , cascade = CascadeType.ALL )
    @JsonIgnore
    private List<report> reportList ;

    @OneToMany(mappedBy = "internship" , cascade = CascadeType.ALL )
    @JsonIgnore
    private List<meeting> meetingtList ;

    public Internship(String title, String entreprise, String description, Date startdate, Date lasttdate) {

        this.title = title;
        Entreprise = entreprise;
        this.description = description;
        this.startdate = startdate;
        this.lasttdate = lasttdate;
    }

    public Internship () {
        
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEntreprise() {
        return Entreprise;
    }

    public void setEntreprise(String entreprise) {
        Entreprise = entreprise;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getLasttdate() {
        return lasttdate;
    }

    public void setLasttdate(Date lasttdate) {
        this.lasttdate = lasttdate;
    }

    public Long getId() { return id; }

    @Override
    public String toString() {
        return "Internship{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", Entreprise='" + Entreprise + '\'' +
                ", description='" + description + '\'' +
                ", startdate=" + startdate +
                ", lasttdate=" + lasttdate +
                ", reportList=" + reportList +
                ", meetingtList=" + meetingtList +
                '}';
    }
}
