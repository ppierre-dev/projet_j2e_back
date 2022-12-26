package com.univlittoral.projetback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univlittoral.projetback.model.LivresEntity;
import com.univlittoral.projetback.repository.UlcothequeRepository;

@Service
public class UlcothequeServices {
	@Autowired
	private UlcothequeRepository ulcothequeRepository;
	
	public List<LivresEntity> findAllLivres() {
		return ulcothequeRepository.findAll();
	}
	
	public LivresEntity findOneLivreById(long id) {
		return ulcothequeRepository.findById(id).orElse(null);
	}
	
	public void addOneLivre(LivresEntity livre) {
		ulcothequeRepository.save(livre);
	}
	
	public void deleteOneLivre(LivresEntity livre) {
		ulcothequeRepository.delete(livre);
	}
	
	public void updateOneLivre(LivresEntity livre) {
		ulcothequeRepository.save(livre);
	}
	
	public List<LivresEntity> findAllLivresByGenre(String genre) {
		return ulcothequeRepository.findAllLivresByGenre(genre);
	}
}
