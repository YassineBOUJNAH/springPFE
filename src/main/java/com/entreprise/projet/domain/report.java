package com.entreprise.projet.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

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

    @ManyToOne(optional = false )
    @JoinColumn(name="internship_id", nullable=false )
    private Internship internship ;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="file_id", referencedColumnName = "id")
    private FileStorage file ;

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

    public void setInternship(Internship internship) {
        this.internship = internship;
    }

    public Internship getInternship() {
        return internship;
    }

    public void setFile(FileStorage file) {
        this.file = file;
    }

    public FileStorage getFile() {
        return file;
    }

    public Long getId() {
        return id;
    }
    @Override
    public String toString() {
        return "report{" +
                "id=" + id +
                ", version='" + version + '\'' +
                ", content='" + content + '\'' +
                ", internship=" + internship +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof report)) return false;
        report report = (report) o;
        return getId() == report.getId() &&
                Objects.equals(getContent(), report.getContent()) &&
                Objects.equals(getInternship(), report.getInternship());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getContent(), getInternship());
    }

}
