package com.restful.resources;

import java.util.Random;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/{usuario}")
public class HelloWorldResource {
	@GET
	@Produces("text/plain")
	@Path("{senha}")
	public String validarUsuarioSenha(@PathParam("usuario") String usuario,
			@PathParam("senha") String senha) {

		System.out.println(usuario);
		System.out.println(senha);
		boolean resp = new Random().nextBoolean();
		return new Boolean(resp).toString();

	}

}