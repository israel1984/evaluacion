package com.evaluacion.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evaluacion.model.ClienteT;


@Repository
public interface ClienteRepository extends JpaRepository<ClienteT, Serializable>{

	//@Cacheable(value= "cliente", unless = "#result == null or #result.size() == 0")
    List<ClienteT> findAll();
	
	ClienteT findByNombres(String nombres);
	
	ClienteT findByNumeroDocAndTipoDoc(String numeroDoc, String tipoDoc);
}
