package com.natanaelqneves.playlistml.repository;

import com.natanaelqneves.playlistml.model.Musica;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface MusicaRepository extends PagingAndSortingRepository<Musica, Integer> {


    public Iterable<Musica> findByNomeIsContaining(@Param("nome") String nome);
}
