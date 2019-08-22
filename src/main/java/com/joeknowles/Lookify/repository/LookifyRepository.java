package com.joeknowles.Lookify.repository;


import java.util.List;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.joeknowles.Lookify.models.Song;

@Repository
public interface LookifyRepository extends CrudRepository<Song, Long> {

    List<Song> findAll();
    List<Song> findByArtist(String artist);
    List<Song> findByTitle(String title);
    List<Song> findByArtistFuzzy(@Param("param") String param);
//    List<Song> getTopTen();
}

