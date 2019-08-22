package com.joeknowles.Lookify.controllers;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.joeknowles.Lookify.models.Song;
import com.joeknowles.Lookify.service.LookifyService;


@Controller
public class LookifyController {
    private final LookifyService service;
    
    public LookifyController(LookifyService service) {
    	this.service = service;
    }
    
    @GetMapping("/")
    public String index() {
    	return "/songs/index.jsp";
    }
    
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		List<Song> s = service.allSongs();
		model.addAttribute("songs", s);
		return "/songs/dashboard.jsp";
	}
	
	@GetMapping("/songs/new")
	public String newSong(Model model) {
		model.addAttribute("song", new Song("", "", 1));
		model.addAttribute("action", "New");
		return "/songs/edit.jsp";
	}
	
	@PutMapping("/songs/add")
	public String add(Model model, @Valid @ModelAttribute("song") Song song, BindingResult result) {
        if (result.hasErrors()) {
        	model.addAttribute("action", "New");
            return "/songs/edit.jsp";
        } else {
        	service.createSong(song);
            return "redirect:/dashboard";
        }
	}
	
	@PostMapping("/search/{searchString}")
    public String findByArtist(Model model, @PathVariable("searchString") String searchString) {
		model.addAttribute("results", service.findByArtist(searchString));
		return "/songs/search.jsp";
    }
	
    @GetMapping("/songs/{song_id}")
    public String show(Model model, @PathVariable("song_id") Long song_id) {
    	model.addAttribute("song", service.findSong(song_id));
    	return "/songs/show.jsp";
    }
    
    @GetMapping("/songs/{song_id}/edit")
    public String edit(@PathVariable("song_id") Long song_id, Model model) {
        model.addAttribute("song", service.findSong(song_id));
        model.addAttribute("action", "Edit");
        return "/songs/edit.jsp";
    }
    
    @PutMapping("/songs/{id}")
    public String update(@Valid @ModelAttribute("song") Song song, BindingResult result) {
        if (result.hasErrors()) {
            return "/songs/edit.jsp";
        } else {
        	service.updateSong(song);
            return "redirect:/songs/dashboard";
        }
    }
    
    @GetMapping("/songs/topTen")
    public String topTen(Model model) {
    	List<Song> songs = service.allSongs();
    	songs.sort(Comparator.comparing(Song::getRating).reversed());
    	model.addAttribute("songs", songs.stream().limit(10).collect(Collectors.toList()));
    	return "/songs/topTen.jsp";
    }
    
    @DeleteMapping("/songs/{song_id}")
    public String destroy(@PathVariable("song_id") Long song_id) {
    	service.deleteSong(song_id);
        return "redirect:/dashboard";
    }
}















