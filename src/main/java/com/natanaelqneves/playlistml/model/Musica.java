package com.natanaelqneves.playlistml.model;

import javax.persistence.*;

@Entity
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String nome;

    @Column(name = "Cifras", unique = true, nullable = false, length = 512)
    private String cifra;

    @Column(name = "Video", unique = true, nullable = false, length = 512)
    private String video;


    //CONSTRUTORES
    public Musica() {
    }

    public Musica(String nome, String cifra, String video) {
        this.nome = nome;
        this.cifra = cifra;
        this.video = video;
    }


    //GETTERS E SETTERS
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCifra() {
        return cifra;
    }

    public void setCifra(String cifra) {
        this.cifra = cifra;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
}
