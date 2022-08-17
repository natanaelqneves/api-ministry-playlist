package com.natanaelqneves.playlistml.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cantor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Nome do(a) Cantor(a)", unique = true)
    private String nome;

    @OneToMany(mappedBy = "cantor", fetch = FetchType.EAGER)
    private List<Musica> musicas;



    //CONSTRUCTORS
    public Cantor() {
    }

    public Cantor(String nome) {
        super();
        this.nome = nome;
    }



    //GETTERS AND SETTERS
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

    public List<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<Musica> musicas) {
        this.musicas = musicas;
    }
}

