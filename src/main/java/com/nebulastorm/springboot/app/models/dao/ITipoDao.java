package com.nebulastorm.springboot.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.nebulastorm.springboot.app.models.entity.Tipo;

public interface ITipoDao extends CrudRepository<Tipo, Long>{

}
