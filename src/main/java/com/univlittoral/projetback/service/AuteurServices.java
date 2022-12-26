package com.univlittoral.projetback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univlittoral.projetback.model.AuteursEntity;
import com.univlittoral.projetback.repository.AuteurRepository;

@Service
public class AuteurServices {
	@Autowired
	private AuteurRepository auteurRepository;
	
	public List<AuteursEntity> findAllAuteurs() {
		return auteurRepository.findAll();
	}
	
	public AuteursEntity findOneAuteurById(long id) {
		return auteurRepository.findById(id).orElse(null);
	}
}
