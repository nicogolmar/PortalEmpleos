package com.nicolas.Service;
import java.util.List;
import com.nicolas.model.Categorias;

public interface ICategoriasService {

	void guardar(Categorias categoria);
	List <Categorias> buscarTodas();
	Categorias buscarPorId(Integer idCategoria);
	void eliminar(Integer idCategoria);
	
}
