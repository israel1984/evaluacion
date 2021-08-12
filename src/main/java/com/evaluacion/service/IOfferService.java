package com.evaluacion.service;

import java.text.ParseException;

import com.evaluacion.pojo.ReqDataNroTipoDoc;
import com.evaluacion.pojo.ReqDataRangoFechas;
import com.evaluacion.pojo.RespData;

public interface IOfferService {

	RespData obtenerLIstaXNumeroTipoDocumento(ReqDataNroTipoDoc req);
	
	RespData obtenerLIstaXRangoFechas(ReqDataRangoFechas request)  throws ParseException;
	
}
