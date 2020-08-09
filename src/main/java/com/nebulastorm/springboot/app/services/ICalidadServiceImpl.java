package com.nebulastorm.springboot.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.nebulastorm.springboot.app.models.dao.ICalidad;
import com.nebulastorm.springboot.app.models.entity.Calidad;

@Service
public class ICalidadServiceImpl implements ICalidadService{

	@Autowired
	private ICalidad icalidad;
	
	@Transactional(readOnly = true)
	@Override
	public List<Calidad> findAll() {
		return (List<Calidad>)icalidad.findAll();
	}

	@Transactional
	@Override
	public void save(Calidad calidad) {
		icalidad.save(calidad);
	}

	@Transactional(readOnly = true)
	@Override
	public Calidad findOne(Long id) {
		return icalidad.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public void delete(Long id) {
		icalidad.deleteById(id);
		
	}

}
