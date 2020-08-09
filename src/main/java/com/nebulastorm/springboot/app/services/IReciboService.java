package com.nebulastorm.springboot.app.services;

import java.util.List;

import com.nebulastorm.springboot.app.models.entity.Recibo;

public interface IReciboService {

	public List<Recibo> findAll();
	
	public void save(Recibo recibo);
	
	public Recibo findOne(Long id);
	
	public void delete(Long id);
}
