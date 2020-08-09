package com.nebulastorm.springboot.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.nebulastorm.springboot.app.models.entity.Placa;

public interface IPlacaDao extends CrudRepository<Placa, Long> {

}
