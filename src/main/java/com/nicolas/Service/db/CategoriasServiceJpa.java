package com.nicolas.Service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nicolas.Service.ICategoriasService;
import com.nicolas.model.Categorias;
import com.nicolas.repository.CategoriasRepository;


@Service
@Primary
public class CategoriasServiceJpa implements ICategoriasService {

	@Autowired
	private CategoriasRepository categoriasRepo;
	
	@Override
	public void guardar(Categorias categoria) {
		
		categoriasRepo.save(categoria);
	
	}

	@Override
	public List<Categorias> buscarTodas() {
	
		return categoriasRepo.findAll();
	}

	@Override
	public Categorias buscarPorId(Integer idCategoria) {
		Optional<Categorias> categoriaById = categoriasRepo.findById(idCategoria);
		
		if(categoriaById.isPresent()) {
			
			return categoriaById.get();
		}
		
		return null;
	}

	@Override
	public void eliminar(Integer idCategoria) {
		
		categoriasRepo.deleteById(idCategoria);
		
		
	}

	@Override
	public Page<Categorias> buscarTodas(Pageable page) {
		
		return categoriasRepo.findAll(page);
	}

}
