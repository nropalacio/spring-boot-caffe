package com.nebulastorm.springboot.app.services;

import java.util.List;

import com.nebulastorm.springboot.app.models.entity.Variedad;

public interface IVariedadService {

	public List<Variedad> findAll();
	
	public void save(Variedad variedad);
	
	public Variedad findById(Long id);
	
	public void delete(Long id);
	
	
}
