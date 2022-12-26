package com.univlittoral.projetback.mapper;

import java.util.ArrayList;
import java.util.List;

import com.univlittoral.projetback.dto.AuteurDTO;
import com.univlittoral.projetback.model.AuteursEntity;

public class AuteursMappers {
	public static AuteurDTO getAuteurDtoFromEntity(AuteursEntity auteurEntity) {
		AuteurDTO auteurDTO = new AuteurDTO();
		auteurDTO.setId(auteurEntity.getId());
		auteurDTO.setNom(auteurEntity.getNom());
		auteurDTO.setPrenom(auteurEntity.getPrenom());
		auteurDTO.setDateNaissance(auteurEntity.getDateNaissance());
		return auteurDTO;
	}
	
	public static List<AuteurDTO> getListAuteursDtoFromEntity(List<AuteursEntity> auteursEntities) {
		List<AuteurDTO> auteursDTOList = new ArrayList<AuteurDTO>();
		for (AuteursEntity auteursEntity : auteursEntities) {
			auteursDTOList.add(AuteursMappers.getAuteurDtoFromEntity(auteursEntity));
		}
		
		return auteursDTOList;
	}
}
