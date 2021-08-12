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
@Table(name = "T_CLIENTE")
public class ClienteT implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -297761266109141798L;
	@Id
    @Column(name = "ID_CLIENTE")
    private Integer	      id;
    @Column(name = "NOMBRES")
    private String	      nombres;
    @Column(name = "TIPO_DOC")
    private String	      tipoDoc;
    @Column(name = "NUM_DOC")
    private String	      numeroDoc;
    @Column(name = "FEC_NAC")
    private Date	      fechaNacimiento;
}
