package com.nebulastorm.springboot.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.nebulastorm.springboot.app.models.entity.Motorista;

public interface IMotoristaDao extends CrudRepository<Motorista, Long>{

}
