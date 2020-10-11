package com.entreprise.projet.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.* ;
import javax.validation.constraints.NotNull ;
import java.sql.Timestamp ;
import java.util.Objects ;

@Entity
public class Post {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private long id;


    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp postedAt ;

    @NotNull
    private String Content ;

    @NotNull
    private String Description ;

    @ManyToOne(optional = false )
    @JoinColumn(name ="supervisor_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Supervisor supervisor ;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="file_id", referencedColumnName = "id")
    private FileStorage file ;


    public  Post () {} ;


    public Post(@NotNull Timestamp postedAt, @NotNull String content, @NotNull String description) {

        this.postedAt = postedAt ;
        Content = content ;
        Description = description ;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Timestamp getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(Timestamp postedAt) {
        this.postedAt = postedAt;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    public FileStorage getFile() {
        return file;
    }

    public void setFile(FileStorage file) {
        this.file = file;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;
        Post post = (Post) o;
        return getId() == post.getId() &&
                Objects.equals(getPostedAt(), post.getPostedAt()) &&
                Objects.equals(getContent(), post.getContent()) &&
                Objects.equals(getSupervisor(), post.getSupervisor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPostedAt(), getContent(), getSupervisor());
    }

}
