package com.bytesw.tyu.examen.dalvarado.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


public class Empresa {
	
	private long id;
	private String name;
	private String nit;
	private Date fundacion;
	private String direccion;
	
	public Empresa() {
		
	}
	
	public Empresa(long id, String name, String nit, Date fundacion, String direccion) {
		super();
		this.id = id;
		this.name = name;
		this.nit = nit;
		this.fundacion = fundacion;
		this.direccion = direccion;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNit() {
		return nit;
	}
	public void setNit(String nit) {
		this.nit = nit;
	}
	public Date getFundacion() {
		return fundacion;
	}
	public void setFundacion(Date fundacion) {
		this.fundacion = fundacion;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	
	

}
