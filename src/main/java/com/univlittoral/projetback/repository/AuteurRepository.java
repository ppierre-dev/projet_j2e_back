package com.univlittoral.projetback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.univlittoral.projetback.model.AuteursEntity;

@Repository
public interface AuteurRepository extends JpaRepository<AuteursEntity, Long> {}


