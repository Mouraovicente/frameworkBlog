package com.spring.blog.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name="TB_Commentary")
public class Commentary {
    @Id
    // Pin the Hibernate 5 behavior (shared "hibernate_sequence", step 1) so existing PostgreSQL data keeps working after the Hibernate 6 upgrade.
    @SequenceGenerator(name = "blog_id_seq", sequenceName = "hibernate_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "blog_id_seq")
    private Long id;

    @NotBlank
    private String autor;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    private LocalDate data;

    @NotBlank
    @Lob
    private String comentario;

    @ManyToOne
    private Post post;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Post getPost() {

        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }



}
