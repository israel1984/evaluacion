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
@Table(name = "T_MOVIL")
public class LineaT implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7989459023046649448L;
	@Id
    @Column(name = "ID_MOVIL")
    private Integer	      id;
    @Column(name = "TELEFONO")
    private String	      telefono;
    @Column(name = "ESTADO")
    private String	      estado;
    @Column(name = "TIPO")
    private String	      tipo;
    @Column(name = "NRO_DOCUMENTO")
    private String	      numeroDocumento;
    @Column(name = "CODIGO_OFERTA")
    private String	      codigoOferta;
    @Column(name = "PLAN")
    private String	      plan;
    
}
