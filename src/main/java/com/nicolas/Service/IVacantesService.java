package com.nicolas.Service;

import java.util.List;

import com.nicolas.model.Vacante;

public interface IVacantesService {

	List <Vacante> buscarTodas();
	
	Vacante buscarPorId(Integer idVacante);
	
	void guardar(Vacante vacante);
	
	List <Vacante> buscarDestacadas();
	
}
