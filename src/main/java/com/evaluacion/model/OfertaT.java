package com.evaluacion.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "T_OFERTA")
public class OfertaT implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7340727136208674786L;
	@Id
    @Column(name = "ID_OFERTA")
    private Integer	      id;
    @Column(name = "COD_OFERTA")
    private String	      codigoOferta;
    @Column(name = "DESCRIPCION")
    private String	      descripcion;
    @Column(name = "FEC_INI")
    private Date	      fecIni;
    @Column(name = "FEC_FIN")
    private Date	      fecFin;
}
