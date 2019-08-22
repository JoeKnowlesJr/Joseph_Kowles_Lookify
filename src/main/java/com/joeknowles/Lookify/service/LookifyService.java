package com.joeknowles.Lookify.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.joeknowles.Lookify.models.Song;
import com.joeknowles.Lookify.repository.LookifyRepository;

@Service
public class LookifyService {
	private final LookifyRepository repo;
    
    public LookifyService(LookifyRepository lRepo) {
        this.repo = lRepo;
    }
    
    // returns all the languages
    public List<Song> allSongs() { return repo.findAll(); }
    // creates a language
    public Song createSong(Song b) { return repo.save(b); }
    // retrieves a language
    public Song findSong(Long id) {
        Optional<Song> optionalSong = repo.findById(id);
        return optionalSong.orElse(null);
    }
    public List<Song> findByArtist(String artist) {
    	return repo.findByArtist(artist);
    }
    public List<Song> findByArtistFuzzy(String searchString) {
    	return repo.findByArtistFuzzy(searchString);
    }
    public List<Song> findByTitle(String query) {
    	return repo.findByTitle(query);
    }
    public void updateSong(Song song) {
    	Optional<Song> os = repo.findById(song.getId());
    	if (os.isPresent()) {
    		Song s = os.get();
    		s.setTitle(song.getTitle());
    		s.setArtist(song.getArtist());
    		s.setRating(song.getRating());
    		repo.save(s);
    	} else {
    		repo.save(song);
    	}
    }
//    public List<Song> getTopTen() {
//    	return repo.getTopTen();
//    }
    // deletes a language
    public void deleteSong(Long id) {
        Optional<Song> optionalSong = repo.findById(id);
        if(optionalSong.isPresent()) {
        	repo.delete(optionalSong.get());
        } 
    }
}

