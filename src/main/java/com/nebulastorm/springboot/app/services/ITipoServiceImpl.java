package com.nebulastorm.springboot.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nebulastorm.springboot.app.models.dao.ITipoDao;
import com.nebulastorm.springboot.app.models.entity.Tipo;

@Service
public class ITipoServiceImpl implements ITipoService{
	
	@Autowired
	private ITipoDao tipoDao;

	@Override
	public List<Tipo> findAll() {
		return (List<Tipo>)tipoDao.findAll();
	}

	@Override
	public void save(Tipo tipo) {
		tipoDao.save(tipo);
	}

	@Override
	public Tipo findById(Long id) {
		return tipoDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		tipoDao.deleteById(id);
	}

}
