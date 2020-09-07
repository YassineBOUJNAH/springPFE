package com.entreprise.projet.domain;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Date;

@Entity
public class meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false )
    private Long id  ;
    @NonNull
    private String description ;
    @NonNull
    private Date date ;
    @NonNull
    private String place ;

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name="internship_id", nullable=false)
    private Internship internship ;

    public meeting(@NonNull String description, @NonNull Date date, @NonNull String place) {
        this.description = description;
        this.date = date;
        this.place = place;
    }
    public meeting() {
    }

    public Long getId() {
        return id;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    public void setDescription(@NonNull String description) {
        this.description = description;
    }

    @NonNull
    public Date getDate() {
        return date;
    }

    public void setDate(@NonNull Date date) {
        this.date = date;
    }

    @NonNull
    public String getPlace() {
        return place;
    }

    public void setPlace(@NonNull String place) {
        this.place = place;
    }
}