package com.nebulastorm.springboot.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nebulastorm.springboot.app.models.dao.IVariedadDao;
import com.nebulastorm.springboot.app.models.entity.Variedad;

@Service
public class IVariedadServiceImpl implements IVariedadService{

	@Autowired
	private IVariedadDao variedadDao;
	
	@Override
	public List<Variedad> findAll() {
		return (List<Variedad>)variedadDao.findAll();
	}

	@Override
	public void save(Variedad variedad) {
		variedadDao.save(variedad);
	}

	@Override
	public Variedad findById(Long id) {
		return variedadDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		variedadDao.deleteById(id);
	}

}
