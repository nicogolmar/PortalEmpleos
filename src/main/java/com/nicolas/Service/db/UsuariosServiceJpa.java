package com.nicolas.Service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nicolas.Service.IUsuariosService;
import com.nicolas.model.Usuario;
import com.nicolas.repository.UsuariosRepository;

@Service
public class UsuariosServiceJpa implements IUsuariosService {

	@Autowired
	private UsuariosRepository usuarioRepo;
	
	
	@Override
	public void guardar(Usuario usuario) {

		usuarioRepo.save(usuario);

	}

	@Override
	public void eliminar(Integer idUsuario) {


		usuarioRepo.deleteById(idUsuario);

	}

	@Override
	public List<Usuario> buscarTodos() {
		
		
		return usuarioRepo.findAll();
	}

	@Override
	public Optional<Usuario> buscar(Integer idUsuario) {
	Optional<Usuario>usuario = usuarioRepo.findById(idUsuario);
		return usuario;
	}

	

}
