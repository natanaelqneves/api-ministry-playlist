package com.natanaelqneves.playlistml.controller;

import com.natanaelqneves.playlistml.model.Musica;
import com.natanaelqneves.playlistml.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;

@RestController
@RequestMapping("/")
public class MusicaController {

    @Autowired
    private MusicaRepository musicaRepository;

    @PostMapping("/add")
    public String newMusic(Musica musica) throws MalformedURLException {
        musicaRepository.save(musica);
        return musica.toString();
    }

    @GetMapping("/musicas")
    public Iterable<Musica> getMusics(Musica musica){
        return musicaRepository.findAll();
    }

    @GetMapping(path = "/musica/{nome}")
    public Iterable<Musica> getMusicasForName(@PathVariable String nome) {
        return musicaRepository.findByNomeIsContaining(nome);
    }

    @GetMapping(path = "/{numberPage}/{numberItens}")
    public Iterable<Musica> getMusicasPorPagina(
            @PathVariable int numberPage, @PathVariable int numberItens) {
        if(numberItens >= 25) numberItens = 25;

        Pageable page = PageRequest.of(numberPage, numberItens);
        return musicaRepository.findAll(page);
    }

    @DeleteMapping(path = "/del/{id}")//SOFT DELETE
    public void delMusica(@PathVariable Integer id) {
        musicaRepository.deleteById(id);
    }


}
