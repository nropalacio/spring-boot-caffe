package com.nebulastorm.springboot.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.nebulastorm.springboot.app.models.entity.Recibo;

public interface IReciboDao extends CrudRepository<Recibo, Long>{

}
