package com.nicolas.model;

import java.util.Date;

public class Vacante {
	
	private Integer id;
	private String nombre;
	private String descripcion;
	private String categoria;
	private String estatus;
	private Date fecha;
	private Integer destacado;
	private Double salario;
	private String imagenVacante="sin-imagen.png";
	private String detalles;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	
	
	public Integer getDestacado() {
		return destacado;
	}
	public void setDestacado(Integer destacado) {
		this.destacado = destacado;
	}
	
	
	public String getImagenVacante() {
		return imagenVacante;
	}
	public void setImagenVacante(String imagenVacante) {
		this.imagenVacante = imagenVacante;
	}
	
	
	
	
	public String getDetalles() {
		return detalles;
	}
	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	@Override
	public String toString() {
		return "Vacante [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", categoria=" + categoria
				+ ", estatus=" + estatus + ", fecha=" + fecha + ", destacado=" + destacado + ", salario=" + salario
				+ ", imagenVacante=" + imagenVacante + ", detalles=" + detalles + "]";
	}
	
	

}
