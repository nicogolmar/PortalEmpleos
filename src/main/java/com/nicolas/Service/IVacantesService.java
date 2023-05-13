package com.nicolas.Service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nicolas.model.Vacante;

public interface IVacantesService {

	List <Vacante> buscarTodas();
	
	Vacante buscarPorId(Integer idVacante);
	
	void guardar(Vacante vacante);
	
	List <Vacante> buscarDestacadas();
	
	void eliminar(Integer idVacante);
	
	//Query para busqueda dinamica , genera WHERE dinamicos
	List<Vacante> BuscarByExample(Example<Vacante> vacante);
	
	Page<Vacante> buscarTodas(Pageable page);
	
}
