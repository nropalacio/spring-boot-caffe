package com.nebulastorm.springboot.app.services;

import java.util.List;

import com.nebulastorm.springboot.app.models.entity.Motorista;

public interface IMotoristaService {

	public List<Motorista> findAll();
	
	public void save(Motorista motorista);
	
	public Motorista findOne(Long id);
	
	public void delete(Long id);
	
	
}
