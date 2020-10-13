package com.entreprise.projet.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Objects;

@Entity
public class report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false )
    private Long id  ;

    @NotNull
    private String type ;

    @NotNull
    private String description ;

    @Lob
    private byte[] data ;

    public report () {
        super() ;
    }


    public report(@NotNull String description , @NotNull byte[] data , @NotNull String type ) {
         super() ;
         this.description = description ;
         this.data = data ;
         this.type = type ;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public Long getId() {
        return id;
    }




}
