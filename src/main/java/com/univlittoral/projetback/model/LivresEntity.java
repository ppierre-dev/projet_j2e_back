package com.univlittoral.projetback.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="livres")
public class LivresEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name="nom")
	private String nom;
	@Column(name="auteur")
	private long auteur;
	@Column(name="genre")
	private String genre;
	@Column(name="editeur")
	private String editeur;
	@Column(name="nb_pages")
	private int nbPages;
	@Column(name="lieu_parution")
	private String lieuParution;
	@Column(name="date_parution")
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
	public long getAuteur() {
		return auteur;
	}
	public void setAuteur(long auteur) {
		this.auteur = auteur;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getEditeur() {
		return editeur;
	}
	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}
	public int getNbPages() {
		return nbPages;
	}
	public void setNbPages(int nbPages) {
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
}
