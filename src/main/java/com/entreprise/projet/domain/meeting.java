package com.entreprise.projet.domain;

import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
public class meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false )
    private Long id  ;
    @NonNull
    private String description ;
    @NonNull
    private String datetime;
    @NonNull
    private String place ;

    public meeting(@NonNull String description, @NonNull String datetime, @NonNull String place) {
        this.description = description;
        this.datetime = datetime;
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
    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(@NonNull String datetime) {
        this.datetime = datetime;
    }

    @NonNull
    public String getPlace() {
        return place;
    }

    public void setPlace(@NonNull String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "meeting{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", date=" + datetime +
                ", place='" + place + '\'' +
                '}';
    }
}