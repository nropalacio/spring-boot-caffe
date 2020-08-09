package com.nebulastorm.springboot.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nebulastorm.springboot.app.models.dao.IReciboDao;
import com.nebulastorm.springboot.app.models.entity.Recibo;

@Service
public class IReciboServiceImpl implements IReciboService{

	@Autowired
	private IReciboDao reciboDao;
	
	@Transactional(readOnly = true)
	@Override
	public List<Recibo> findAll() {
		return (List<Recibo>)reciboDao.findAll();
	}

	@Transactional
	@Override
	public void save(Recibo recibo) {
		reciboDao.save(recibo);
	}

	@Transactional(readOnly = true)
	@Override
	public Recibo findOne(Long id) {
		return reciboDao.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public void delete(Long id) {
		reciboDao.deleteById(id);
		
	}

}
