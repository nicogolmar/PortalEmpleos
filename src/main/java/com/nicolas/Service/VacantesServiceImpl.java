package com.nicolas.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nicolas.model.Vacante;


@Service
public class VacantesServiceImpl implements IVacantesService {

		private List<Vacante> lista = null;
	

	public VacantesServiceImpl() {
SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
	
			lista = new LinkedList<Vacante>();
		
		try {
			
			Vacante vacante1=new Vacante();
			vacante1.setId(1);
			vacante1.setNombre("Ingeniero Civil");
			vacante1.setDescripcion("Se solicita Ingeniero Civil para la construccion de Puentes");
			vacante1.setFecha(sdf.parse("04-04-2023"));
			vacante1.setSalario(3000d);
			vacante1.setDestacado(1);
			vacante1.setImagenVacante("logo1.png");
			
			Vacante vacante2=new Vacante();
			vacante2.setId(2);
			vacante2.setNombre("Ingeniero Mecanico");
			vacante2.setDescripcion("Se solicita Ingeniero Mecanico para la construccion de Motores");
			vacante2.setFecha(sdf.parse("04-04-2023"));
			vacante2.setSalario(1500d);
			vacante2.setDestacado(0);
			vacante2.setImagenVacante("logo2.png");
			
			Vacante vacante3=new Vacante();
			vacante3.setId(3);
			vacante3.setNombre("Ingeniero de Software");
			vacante3.setDescripcion("Se solicita Ingeniero de Software para la creacion de un nuevo sistema");
			vacante3.setFecha(sdf.parse("04-04-2023"));
			vacante3.setSalario(6500d);
			vacante3.setDestacado(0);
			
			
			Vacante vacante4=new Vacante();
			vacante4.setId(4);
			vacante4.setNombre("Ingeniero Nautico");
			vacante4.setDescripcion("Se solicita Ingeniero Nautico para la reparacion de motores de Navios");
			vacante4.setFecha(sdf.parse("04-04-2023"));
			vacante4.setSalario(2500d);
			vacante4.setDestacado(1);
			vacante4.setImagenVacante("logo4.png");
			
			lista.add(vacante1);
			lista.add(vacante2);
			lista.add(vacante3);
			lista.add(vacante4);
			
		}
		catch(ParseException e) {
			System.out.print(e);
			
		}
		
	}
	
	
	
	@Override
	public List<Vacante> buscarTodas() {
		
		
		return lista;
	}



	@Override
	public Vacante buscarPorId(Integer idVacante) {

		
		for(Vacante v : lista)
		{
			
			if(v.getId()==idVacante) {
				
				return v;
			}
		}
		
		return null;
	}

	
	
	
	
	
}
