package com.nicolas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nicolas.model.Categorias;

public interface CategoriasRepository extends JpaRepository<Categorias, Integer> {
	

}
