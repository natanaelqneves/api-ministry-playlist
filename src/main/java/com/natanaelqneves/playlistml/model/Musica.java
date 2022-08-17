package com.natanaelqneves.playlistml.model;

import javax.persistence.*;

@Entity
@Table(name = "tb_musicas")
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Nome da Musica",unique = true, nullable = false)
    private String nome;

    @ManyToOne
    @Column(name = "Cantor(a)", nullable = false)
    private Cantor cantor;

    @Column(name = "Cifras", nullable = false, length = 512)
    private String cifra;

    @Column(name = "Video", nullable = false, length = 512)
    private String video;

    public Musica() {
    }

    public Musica(String nome, Cantor cantor, String cifra, String video) {
        this.nome = nome;
        this.cantor = cantor;
        this.cifra = cifra;
        this.video = video;
    }

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

    public Cantor getCantor() {
        return cantor;
    }

    public void setCantor(Cantor cantor) {
        this.cantor = cantor;
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
