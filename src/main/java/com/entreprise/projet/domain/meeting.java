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
    private String date ;
    @NonNull
    private String time ;
    @NonNull
    private String place ;



    public meeting(@NonNull String description, @NonNull String date, @NonNull String time, @NonNull String place) {
        this.description = description;
        this.date = date;
        this.time = time;
        this.place = place;
    }

    public meeting() {
    }

    @NonNull
    public String getTime() {
        return time;
    }

    public void setTime(@NonNull String time) {
        this.time = time;
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
    public String getDate() {
        return date;
    }

    public void setDate(@NonNull String date) {
        this.date = date;
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
                ", date=" + date +
                ", place='" + place + '\'' +
                '}';
    }
}