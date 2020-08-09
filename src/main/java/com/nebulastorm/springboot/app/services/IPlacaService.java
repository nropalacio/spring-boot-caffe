package com.nebulastorm.springboot.app.services;

import java.util.List;
import com.nebulastorm.springboot.app.models.entity.Placa;

public interface IPlacaService {

	public List<Placa> findAll();
	
	public void save(Placa placa);
	
	public Placa findOne(Long id);
	
	public void delete(Long id);
	
	
}
