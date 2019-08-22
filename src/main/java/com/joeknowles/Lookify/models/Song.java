package com.joeknowles.Lookify.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="songs", schema="jbk_merit_db")
@NamedQuery(name="Song.findByArtistFuzzy", query="SELECT s FROM Song s WHERE s.artist LIKE :param")
public class Song implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6522365009438505424L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(min = 5)
	private String title;
	@Size(min = 5)
	private String artist;
	@Range(min=1, max=10)
	private int rating;
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date created;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date updated;
	
	public Song() {}
	public Song(String t, String ar, int r) {
		title = t;
		artist = ar;
		rating = r;
	}
	
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	public String getArtist() { return artist; }
	public void setArtist(String artist) { this.artist = artist; }
	public int getRating() { return rating; }
	public void setRating(int rating) { this.rating = rating; }
	public Date getCreated() { return created; }
	public Date getUpdated() { return updated; }
	public void setUpdated(Date updated) { this.updated = updated; }
	
	@PrePersist
	protected void onCreate() { this.created = new Date(); }
	
	@PreUpdate
	protected void onUpdate() { this.updated = new Date(); }
}
