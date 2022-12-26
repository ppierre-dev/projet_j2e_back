package com.univlittoral.projetback.mapper;

import java.util.ArrayList;
import java.util.List;

import com.univlittoral.projetback.dto.AuteurDTO;
import com.univlittoral.projetback.dto.LivresDTO;
import com.univlittoral.projetback.enums.GenresEnum;
import com.univlittoral.projetback.model.LivresEntity;

public class UlcothequeMappers {
	public static LivresDTO getLivresDtoFromEntity(LivresEntity livresEntity) {
		LivresDTO livresDTO = new LivresDTO();
		livresDTO.setEditeur(livresEntity.getEditeur());
		livresDTO.setGenre(GenresEnum.valueOf(livresEntity.getGenre()));
		livresDTO.setId(livresEntity.getId());
		livresDTO.setLieuParution(livresEntity.getLieuParution());
		livresDTO.setNbPages(livresEntity.getNbPages());
		livresDTO.setNom(livresEntity.getNom());
		livresDTO.setDateParution(livresEntity.getDateParution());
		
		return livresDTO;
	}
	
	public static List<LivresDTO> getListLivresDtoFromEntity(List<LivresEntity> livresEntities) {
		List<LivresDTO> livresDTOList = new ArrayList<LivresDTO>();
		for (LivresEntity livresEntity : livresEntities) {
			livresDTOList.add(UlcothequeMappers.getLivresDtoFromEntity(livresEntity));
		}
		
		return livresDTOList;
	}
	
	public static LivresEntity getLivresEntityFromDto(LivresDTO livresDTO) {
		LivresEntity livresEntity = new LivresEntity();
		livresEntity.setNom(livresDTO.getNom());
		livresEntity.setNbPages(livresDTO.getNbPages());
		livresEntity.setEditeur(livresDTO.getEditeur());
		livresEntity.setDateParution(livresDTO.getDateParution());
		livresEntity.setLieuParution(livresDTO.getLieuParution());
		livresEntity.setGenre(livresDTO.getGenre().toString());
		livresEntity.setAuteur(livresDTO.getAuteur().getId());
		
		return livresEntity;
	}
}
