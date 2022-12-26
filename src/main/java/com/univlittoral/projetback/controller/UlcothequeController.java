package com.univlittoral.projetback.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.univlittoral.projetback.dto.AuteurDTO;
import com.univlittoral.projetback.dto.DataGraphDTO;
import com.univlittoral.projetback.dto.GenresDTO;
import com.univlittoral.projetback.dto.HomeDTO;
import com.univlittoral.projetback.dto.IndicateursDTO;
import com.univlittoral.projetback.dto.LivresDTO;
import com.univlittoral.projetback.enums.GenresEnum;
import com.univlittoral.projetback.mapper.AuteursMappers;
import com.univlittoral.projetback.mapper.UlcothequeMappers;
import com.univlittoral.projetback.model.AuteursEntity;
import com.univlittoral.projetback.model.LivresEntity;
import com.univlittoral.projetback.service.AuteurServices;
import com.univlittoral.projetback.service.UlcothequeServices;

@RestController
@RequestMapping(value="/rest/bd/")
public class UlcothequeController {
	@Autowired
	private UlcothequeServices ulcothequeServices;
	@Autowired
	private AuteurServices auteurServices;
	
	@GetMapping("home/")
	public HomeDTO findAllLivres() {
		HomeDTO homeDTO = new HomeDTO();
		List<LivresEntity> livres = ulcothequeServices.findAllLivres();
		List<LivresDTO> livresDTO = new ArrayList<LivresDTO>();
		for (LivresEntity livre : livres) {
			AuteursEntity auteurEntity = auteurServices.findOneAuteurById(livre.getAuteur());
			AuteurDTO auteurDTO = AuteursMappers.getAuteurDtoFromEntity(auteurEntity);
			LivresDTO livreDTO = UlcothequeMappers.getLivresDtoFromEntity(livre);
			livreDTO.setAuteur(auteurDTO);
			livresDTO.add(livreDTO);
		}
		homeDTO.setLivres(livresDTO);
		
		List<String> genreTrouves = new ArrayList<String>();
		List<Long> auteurTrouves = new ArrayList<Long>();
		GenresDTO genres = new GenresDTO();
		
		for (LivresDTO livre : livresDTO) {
			if (!genreTrouves.contains(livre.getGenre().toString())) {
				genreTrouves.add(livre.getGenre().toString());
			}
			
			if (!auteurTrouves.contains(livre.getAuteur().getId())) {
				auteurTrouves.add(livre.getAuteur().getId());
			}
			
			switch (livre.getGenre().toString()) {
				case "ROMAN":
					genres.addROMAN();
					break;
				case "MANGA":
					genres.addMANGA();
					break;
				case "POESIE":
					genres.addPOESIE();
					break;
				case "BD":
					genres.addBD();
					break;
				case "NOUVELLE":
					genres.addNOUVELLE();
					break;
				default:
					break;
				
			}
		}
		
		IndicateursDTO indicateursDTO = new IndicateursDTO();
		indicateursDTO.setNbAuteurs(auteurTrouves.size());
		indicateursDTO.setNbGenres(genreTrouves.size());
		indicateursDTO.setNbLivres(livres.size());
		homeDTO.setIndicateurs(indicateursDTO);
		homeDTO.setGenres(genres);
		
		DataGraphDTO datasGraph = new DataGraphDTO();
		List<String> labels = new ArrayList<String>();
		List<String> colors = new ArrayList<String>();
		List<Integer> values = new ArrayList<Integer>();
		
		for (String genre : genreTrouves) {
			labels.add(genre);
			
			switch(genre) {
				case "MANGA":
					values.add(genres.getMANGA());
					colors.add("#14BDEB");
					break;
				case "ROMAN":
					values.add(genres.getROMAN());
					colors.add("#D99AC5");
					break;
				case "BD":
					values.add(genres.getBD());
					colors.add("#DE6B48");
					break;
				case "POESIE":
					values.add(genres.getPOESIE());
					colors.add("#35FF69");
					break;
				case "NOUVELLE":
					values.add(genres.getNOUVELLE());
					colors.add("#E0CA3C");
					break;
			}
		}
		
		datasGraph.setColors(colors);
		datasGraph.setLabels(labels);
		datasGraph.setValues(values);
		
		homeDTO.setDatasGraph(datasGraph);
		
		
		return homeDTO;
	}
	
	@GetMapping("livres/{id}")
	public LivresDTO openOneLivreDetails(@PathVariable long id) {
		LivresEntity livre = ulcothequeServices.findOneLivreById(id);
		return UlcothequeMappers.getLivresDtoFromEntity(livre);
	}
	
	@PostMapping("livres/")
	public void saveOneLivre(@RequestBody LivresDTO livre) {
		ulcothequeServices.addOneLivre(UlcothequeMappers.getLivresEntityFromDto(livre));
	}
	
	@DeleteMapping("livres/{id}")
	public void deleteOneLivre(@PathVariable long id) {
		ulcothequeServices.deleteOneLivre(ulcothequeServices.findOneLivreById(id));
	}
	
	@PutMapping("livres/{id}")
	public void updateOneLivre(@PathVariable long id, @RequestBody LivresDTO livre) {
		LivresEntity livresToUpdate = UlcothequeMappers.getLivresEntityFromDto(livre);
		livresToUpdate.setId(id);
		ulcothequeServices.updateOneLivre(livresToUpdate);
	}
	
	@GetMapping("livres")
	public List<LivresDTO> showLivresByGenre(@RequestParam("genre") String genre) {
		return UlcothequeMappers.getListLivresDtoFromEntity(ulcothequeServices.findAllLivresByGenre(genre));
	}
	
	@GetMapping("auteurs/")
	public List<AuteurDTO> findAllAuteurs() {
		return AuteursMappers.getListAuteursDtoFromEntity(auteurServices.findAllAuteurs());
	}
	
	@GetMapping("auteurs/{id}")
	public AuteurDTO findOneAuteurById(@PathVariable long id) {
		return AuteursMappers.getAuteurDtoFromEntity(auteurServices.findOneAuteurById(id));
	}
}
