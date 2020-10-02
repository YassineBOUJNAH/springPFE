package com.entreprise.projet.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class FileStorage {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @NotNull
    private String name ;

    @NotNull
    private String type ;

    @Lob
    private byte[] data ;

    public FileStorage () { }

    public FileStorage(@NotNull String name, @NotNull String type, byte[] data) {
        this.name = name;
        this.type = type;
        this.data = data;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
