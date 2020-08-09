package com.nebulastorm.springboot.app.services;

import java.util.List;

import com.nebulastorm.springboot.app.models.entity.Calidad;


public interface ICalidadService {
	
	public List<Calidad> findAll();
	
	public void save(Calidad calidad);
	
	public Calidad findOne(Long id);
	
	public void delete(Long id);

}
