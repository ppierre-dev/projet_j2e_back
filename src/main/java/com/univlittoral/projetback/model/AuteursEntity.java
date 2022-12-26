package com.univlittoral.projetback.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="auteurs")
public class AuteursEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name="prenom")
	private String prenom;
	@Column(name="nom")
	private String nom;
	@Column(name="date_naissance")
	private Calendar dateNaissance;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Calendar getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Calendar dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	@Override
	public String toString() {
		return "AuteursEntity [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", dateNaissance=" + dateNaissance
				+ "]";
	}
}
