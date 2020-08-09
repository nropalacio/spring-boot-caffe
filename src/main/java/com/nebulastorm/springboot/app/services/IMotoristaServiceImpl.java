package com.nebulastorm.springboot.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nebulastorm.springboot.app.models.dao.IMotoristaDao;
import com.nebulastorm.springboot.app.models.entity.Motorista;

@Service
public class IMotoristaServiceImpl implements IMotoristaService{

	@Autowired
	private IMotoristaDao motoristaDao;
	
	@Transactional(readOnly = true)
	@Override
	public List<Motorista> findAll() {
		return (List<Motorista>)motoristaDao.findAll();
	}

	@Transactional
	@Override
	public void save(Motorista motorista) {
		motoristaDao.save(motorista);
	}

	@Transactional(readOnly = true)
	@Override
	public Motorista findOne(Long id) {
		return motoristaDao.findById(id).orElse(null);
	}
	
	@Transactional
	@Override
	public void delete(Long id) {
		motoristaDao.deleteById(id);
		
	}

}
