package com.univlittoral.projetback.dto;

import java.util.Calendar;

import com.univlittoral.projetback.enums.GenresEnum;

public class LivresDTO {
	private Long id;
	private String nom;
	private AuteurDTO auteur;
	private GenresEnum genre;
	private String editeur;
	private Integer nbPages;
	private String lieuParution;
	private Calendar dateParution;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public AuteurDTO getAuteur() {
		return auteur;
	}
	public void setAuteur(AuteurDTO auteur) {
		this.auteur = auteur;
	}
	public GenresEnum getGenre() {
		return genre;
	}
	public void setGenre(GenresEnum genre) {
		this.genre = genre;
	}
	public String getEditeur() {
		return editeur;
	}
	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}
	public Integer getNbPages() {
		return nbPages;
	}
	public void setNbPages(Integer nbPages) {
		this.nbPages = nbPages;
	}
	public String getLieuParution() {
		return lieuParution;
	}
	public void setLieuParution(String lieuParution) {
		this.lieuParution = lieuParution;
	}
	public Calendar getDateParution() {
		return dateParution;
	}
	public void setDateParution(Calendar dateParution) {
		this.dateParution = dateParution;
	}
	@Override
	public String toString() {
		return "LivresDTO [id=" + id + ", nom=" + nom + ", auteur=" + auteur + ", genre=" + genre + ", editeur="
				+ editeur + ", nbPages=" + nbPages + ", lieuParution=" + lieuParution + ", dateParution=" + dateParution
				+ "]";
	}
}
