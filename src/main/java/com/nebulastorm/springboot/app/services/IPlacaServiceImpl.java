package com.nebulastorm.springboot.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nebulastorm.springboot.app.models.dao.IPlacaDao;
import com.nebulastorm.springboot.app.models.entity.Placa;

@Service
public class IPlacaServiceImpl implements IPlacaService{

	@Autowired
	private IPlacaDao placaDao;
	
	@Override
	public List<Placa> findAll() {
		return (List<Placa>)placaDao.findAll();
	}

	@Override
	public void save(Placa placa) {
		placaDao.save(placa);	
	}

	@Override
	public Placa findOne(Long id) {
		return placaDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		placaDao.deleteById(id);
	}

}
