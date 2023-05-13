package com.nicolas.Service;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nicolas.model.Categorias;

@Service
public class CategoriasServiceImpl implements ICategoriasService {

	private List<Categorias> lista = null;
	
	public CategoriasServiceImpl() throws ParseException {	
		
		lista = new LinkedList<Categorias>();
		
	
	
		Categorias categoria1=new Categorias();
		categoria1.setId(1);
		categoria1.setNombre("BACK END");
		categoria1.setDescripcion("DESARROLLADOR JAVA");
		
		
		Categorias categoria2=new Categorias();
		categoria2.setId(2);
		categoria2.setNombre("FRONT END");
		categoria2.setDescripcion("DESARROLLADOR REACT");
		
		lista.add(categoria1);
		lista.add(categoria2);
		}
		
	@Override
	public List<Categorias> buscarTodas() {
		
		return lista;
	}
	
	@Override
	public Categorias buscarPorId(Integer idCategoria) {
		
		for(Categorias c : lista)
		{
			
			if(c.getId()==idCategoria) {
				
				return c;
			}
		}
		
		return null;
	}

	@Override
	public void guardar(Categorias categoria) {


			lista.add(categoria);
		
	}

	@Override
	public void eliminar(Integer idCategoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Page<Categorias> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}



	
}
