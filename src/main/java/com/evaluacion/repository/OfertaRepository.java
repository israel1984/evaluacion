package com.evaluacion.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evaluacion.model.ClienteT;
import com.evaluacion.model.OfertaT;


@Repository
public interface OfertaRepository extends JpaRepository<OfertaT, Serializable>{

	@Cacheable(value= "oferta", unless = "#result == null or #result.size() == 0")
    List<OfertaT> findAll();
	
	//ClienteT findByNombres(String nombres);
	
	List<OfertaT> findByFecFinBetween(Date fecIni, Date fecFin);
	
}
