package com.natanaelqneves.playlistml.controller;

import com.natanaelqneves.playlistml.model.Musica;
import com.natanaelqneves.playlistml.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/musicas")
public class MusicaController {

    @Autowired
    private MusicaRepository musicaRepository;

    @PostMapping
    public Musica newMusic(Musica musica){
        musicaRepository.save(musica);
        return musica;
    }

    @GetMapping
    public Iterable<Musica> getMusics(Musica musica){
        return musicaRepository.findAll();
    }

    @GetMapping(path = "/{nome}")
    public Iterable<Musica> getMusicasForName(@PathVariable String nome) {
        return musicaRepository.findByNomeIsContaining(nome);
    }

    @DeleteMapping(path = "/{id}")//SOFT DELETE
    public void delMusica(@PathVariable Integer id) {
        musicaRepository.deleteById(id);
    }







}
