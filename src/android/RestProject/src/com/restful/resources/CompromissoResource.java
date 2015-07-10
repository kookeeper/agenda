package com.restful.resources;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/compromisso")
public class CompromissoResource {
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("{data}")
	public List<Compromisso> listarCompromisso(@PathParam("data") String dataString) {

		Date data;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		try {
			data = sdf.parse(dataString);
		} catch (ParseException e) {
			data = new Date();
		}
		
		System.out.println(data);
		
		List<Compromisso> lista = new ArrayList<Compromisso>();

		Compromisso compromisso = new Compromisso();
		compromisso.setDataCompromisso(data);
		compromisso.setId(new Random().nextInt());
		lista.add(compromisso);
		
		compromisso = new Compromisso();
		compromisso.setDataCompromisso(new Date(new Random().nextLong()));
		compromisso.setId(new Random().nextInt());
		lista.add(compromisso);
		
		compromisso = new Compromisso();
		compromisso.setDataCompromisso(new Date(new Random().nextLong()));
		compromisso.setId(new Random().nextInt());
		lista.add(compromisso);
		
		compromisso = new Compromisso();
		compromisso.setDataCompromisso(new Date(new Random().nextLong()));
		compromisso.setId(new Random().nextInt());
		lista.add(compromisso);
		
		compromisso = new Compromisso();
		compromisso.setDataCompromisso(new Date(new Random().nextLong()));
		compromisso.setId(new Random().nextInt());
		lista.add(compromisso);
		
		compromisso = new Compromisso();
		compromisso.setDataCompromisso(new Date(new Random().nextLong()));
		compromisso.setId(new Random().nextInt());
		lista.add(compromisso);
		
		compromisso = new Compromisso();
		compromisso.setDataCompromisso(new Date(new Random().nextLong()));
		compromisso.setId(new Random().nextInt());
		lista.add(compromisso);
		
		compromisso = new Compromisso();
		compromisso.setDataCompromisso(new Date(new Random().nextLong()));
		compromisso.setId(new Random().nextInt());
		lista.add(compromisso);
		
		return lista;
	}

}