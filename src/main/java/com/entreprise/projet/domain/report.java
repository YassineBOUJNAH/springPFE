package com.entreprise.projet.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false )
    private Long id  ;

    @NotNull
    private String version;

    @NotNull
    private String content ;

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name="internship_id", nullable=false)
    private Internship internship ;

    public report () {
        super() ;
    }


    public report(@NotNull String version, @NotNull String content) {
        super() ;
        this.version = version;
        this.content = content;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public Long getId() {
        return id;
    }
}
