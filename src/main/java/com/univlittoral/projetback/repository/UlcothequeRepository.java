package com.univlittoral.projetback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.univlittoral.projetback.model.LivresEntity;

@Repository
public interface UlcothequeRepository extends JpaRepository<LivresEntity, Long> {
	@Query(value = "SELECT * FROM livres as l WHERE l.genre like :genre", nativeQuery = true)
	List<LivresEntity> findAllLivresByGenre(@Param("genre") String genre);
}

