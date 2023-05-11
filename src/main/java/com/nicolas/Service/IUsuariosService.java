package com.nicolas.Service;

import java.util.List;
import java.util.Optional;

import com.nicolas.model.Usuario;

public interface IUsuariosService {
	
	
	void guardar(Usuario usuario);
	void eliminar(Integer idUsuario);
	List<Usuario>buscarTodos();
	Optional<Usuario> buscar(Integer idUsuario);
	

}
