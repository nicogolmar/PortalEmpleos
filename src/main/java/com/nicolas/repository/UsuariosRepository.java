package com.nicolas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nicolas.model.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {

}
