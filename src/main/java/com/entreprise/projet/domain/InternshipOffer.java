package com.entreprise.projet.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class InternshipOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String entreprise;
    private String state = "inProgress";
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String studentUsername;
    @Column(nullable = false)
    private Date startdate ;
    @Column(nullable = false)
    private Date lasttdate ;

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

    private String response;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student", referencedColumnName = "id")
    private Student student;

    public InternshipOffer(String title, String entreprise, String state, String description) {
        this.title = title;
        this.entreprise = entreprise;
        this.state = state;
        this.description = description;
    }

    public InternshipOffer(String title, String entreprise, String state, String description, Student student) {
        this.title = title;
        this.entreprise = entreprise;
        this.state = state;
        this.description = description;
        this.student = student;
    }

    public InternshipOffer() {
    }

    public String getStudentUsername() {
        return studentUsername;
    }

    public void setStudentUsername(String studentUsername) {
        this.studentUsername = studentUsername;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public InternshipOffer(String title, String entreprise, String state, String description, String studentUsername, Student student,Date startdate,Date lasttdate) {
        this.title = title;
        this.entreprise = entreprise;
        this.state = state;
        this.description = description;
        this.student = student;
        this.studentUsername = studentUsername;
        this.lasttdate = lasttdate;
        this.startdate = startdate;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
