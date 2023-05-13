package com.nicolas.Service.db;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nicolas.Service.IVacantesService;
import com.nicolas.model.Vacante;
import com.nicolas.repository.VacantesRepository;


@Service
@Primary
public class VacantesServiceJpa implements IVacantesService {

	@Autowired
	private VacantesRepository vacanteRepo;
	
	@Override
	public List<Vacante> buscarTodas() {
		
		return vacanteRepo.findAll();
	}

	@Override
	public Vacante buscarPorId(Integer idVacante) {
		
		Optional<Vacante> vacanteById = vacanteRepo.findById(idVacante);
		
		if(vacanteById.isPresent())
		{
			return vacanteById.get();
			
		}
		return null;
	}

	@Override
	public void guardar(Vacante vacante) {
		
		vacanteRepo.save(vacante);

	}

	@Override
	public List<Vacante> buscarDestacadas() {
		
		return vacanteRepo.findByDestacadoAndEstatusOrderByIdDesc(1, "Aprobada");
		
	
	}

	@Override
	public void eliminar(Integer idVacante) {
		
		vacanteRepo.deleteById(idVacante);
		
		
	}

	@Override
	public List<Vacante> BuscarByExample(Example<Vacante> vacante) {
		
		return vacanteRepo.findAll(vacante);
	}

	@Override
	public Page<Vacante> buscarTodas(Pageable page) {
		
		return vacanteRepo.findAll(page);

	}

}
