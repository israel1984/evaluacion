package com.evaluacion.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluacion.common.util.ConvertResponse;
import com.evaluacion.model.ClienteT;
import com.evaluacion.model.LineaT;
import com.evaluacion.model.OfertaT;
import com.evaluacion.pojo.Cliente;
import com.evaluacion.pojo.ReqDataNroTipoDoc;
import com.evaluacion.pojo.ReqDataRangoFechas;
import com.evaluacion.pojo.RespData;
import com.evaluacion.repository.ClienteRepository;
import com.evaluacion.repository.LineaRepository;
import com.evaluacion.repository.OfertaRepository;

@Service
public class OfferService implements IOfferService{

	@Autowired
	private ClienteRepository clienteRepo;
	
	@Autowired
	private OfertaRepository ofertaRepo;
	
	@Autowired
	private LineaRepository lineaRepo;
	
	public RespData obtenerLIstaXNumeroTipoDocumento(ReqDataNroTipoDoc req) {
		
		RespData data = new RespData(new ArrayList<Cliente>());
		
		List<ClienteT> listClient = clienteRepo.findAll();
		
		for (ClienteT clienteT : listClient) {
			System.out.println("Nombres: "+clienteT.getNombres());
		}
		
		//ClienteT clienteSelected = clienteRepo.findByNombres("Israel");
		
		List<ClienteT> listClientF = new ArrayList<ClienteT>();
		
		ClienteT clienteSelected = clienteRepo.findByNumeroDocAndTipoDoc(req.getNro_documento(),req.getTipo_documento());
		
		listClientF.add(clienteSelected);
		
		List<OfertaT> listOferta = ofertaRepo.findAll();
		
		List<LineaT> listLinea = lineaRepo.findAll();
		
		List<LineaT> listLineaFilter = new ArrayList<LineaT>();
		
		List<OfertaT> listOfertaFilter = new ArrayList<OfertaT>();
		
		if(!(clienteSelected==null)) {
			
			
			listLineaFilter = listLinea.stream().filter( l -> l.getNumeroDocumento().equals(clienteSelected.getNumeroDoc())).collect(Collectors.toList());
			
			
			//listLineaFilter.forEach( (final LineaT linea) -> listOferta.stream().filter( o -> o.getCodigoOferta().equals(linea.getCodigoOferta())).collect(Collectors.toList()));
			
			for (LineaT lineaT : listLineaFilter) {
				
				OfertaT result =
						listOferta
					        .stream()
					        .filter( o -> o.getCodigoOferta().equals(lineaT.getCodigoOferta()))
					        .reduce(new OfertaT(), (p1, p2) -> {
					            p1.setCodigoOferta(p2.getCodigoOferta());
					            p1.setDescripcion(p2.getDescripcion());
					            p1.setFecFin(p2.getFecFin());
					            p1.setFecIni(p2.getFecIni());
					            return p1;
					        });
				
				listOfertaFilter.add(result);
				
				//listOferta.stream().filter( o -> o.getCodigoOferta().equals(lineaT.getCodigoOferta())).collect(Collectors.toList());
			}	
			
			//listOfertaFilter = listOferta.stream().filter( o -> o.getCodigoOferta().equals(return() -> ))
			
			data = ConvertResponse.convertToResponse(listClientF,listLineaFilter,listOfertaFilter);
		
		}else {
			System.out.println("No existe el cliente con los valores filtrados");
		}
		
		return data;
		
	}
	
	public RespData obtenerLIstaXRangoFechas(ReqDataRangoFechas request) throws ParseException {
		
		RespData data = new RespData(new ArrayList<Cliente>());
		
		List<OfertaT> listOfertas = ofertaRepo.findByFecFinBetween(new SimpleDateFormat("dd/MM/yyyy").parse(request.getFechaInicio()), new SimpleDateFormat("dd/MM/yyyy").parse(request.getFechaFin()));
		
		List<LineaT> listLinea = lineaRepo.findAll();
		
		List<ClienteT> listCliente = clienteRepo.findAll();
		
		List<LineaT> listLineaFilter = new ArrayList<LineaT>();
		
		List<ClienteT> listClienteFilter = new ArrayList<ClienteT>();
		
		for (OfertaT ofertaT : listOfertas) {
			
			LineaT result =
					listLinea
				        .stream()
				        .filter( o -> o.getCodigoOferta().equals(ofertaT.getCodigoOferta()))
				        .reduce(new LineaT(), (p1, p2) -> {
				            p1.setCodigoOferta(p2.getCodigoOferta());
				            p1.setEstado(p2.getEstado());
				            p1.setNumeroDocumento(p2.getNumeroDocumento());
				            p1.setPlan(p2.getPlan());
				            p1.setTelefono(p2.getTelefono());
				            p1.setTipo(p2.getTipo());
				            return p1;
				        });
			
			listLineaFilter.add(result);
			
			//listOferta.stream().filter( o -> o.getCodigoOferta().equals(lineaT.getCodigoOferta())).collect(Collectors.toList());
		}
		
		/*for (LineaT lineaT : listLineaFilter) {
			
			ClienteT result =
					listCliente
				        .stream()
				        .filter( o -> o.getNumeroDoc().equals(lineaT.getNumeroDocumento()))
				        .reduce(new ClienteT(), (p1, p2) -> {
				            p1.setFechaNacimiento(p2.getFechaNacimiento());
				            p1.setNombres(p2.getNombres());
				            p1.setNumeroDoc(p2.getNumeroDoc());
				            p1.setTipoDoc(p2.getTipoDoc());
				            return p1;
				        });
			
			listClienteFilter.add(result);
			
			//listOferta.stream().filter( o -> o.getCodigoOferta().equals(lineaT.getCodigoOferta())).collect(Collectors.toList());
		}*/
		
		for (ClienteT client : listCliente) {
			
			if(listLineaFilter.stream().filter( l -> l.getNumeroDocumento().equals(client.getNumeroDoc())).collect(Collectors.toList()).size() > 0) {
				
				listClienteFilter.add(client);
				
			}
			
		}
			
		data = ConvertResponse.convertToResponse(listClienteFilter,listLineaFilter,listOfertas);
		
		return data;
		
	}
	
}
