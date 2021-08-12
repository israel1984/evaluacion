package com.evaluacion.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evaluacion.model.ClienteT;
import com.evaluacion.model.LineaT;


@Repository
public interface LineaRepository extends JpaRepository<LineaT, Serializable>{

	//@Cacheable(value= "linea", unless = "#result == null or #result.size() == 0")
    List<LineaT> findAll();
	
	//ClienteT findByNombres(String nombres);
	
}
