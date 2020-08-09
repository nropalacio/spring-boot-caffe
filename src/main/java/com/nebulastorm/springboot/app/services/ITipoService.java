package com.nebulastorm.springboot.app.services;

import java.util.List;
import com.nebulastorm.springboot.app.models.entity.Tipo;

public interface ITipoService {

	public List<Tipo> findAll();
	
	public void save(Tipo tipo);
	
	public Tipo findById(Long id);	
	
	public void delete(Long id);
}
