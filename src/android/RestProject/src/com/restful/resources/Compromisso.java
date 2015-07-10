package com.restful.resources;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "compromisso")
public class Compromisso implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2709443002207694359L;
	
	private Integer id;
	private Pessoa paciente;
	private Pessoa medico;
	private Date dataCompromisso;

	public Compromisso() {
		
	}

	public Integer getId() {

		return id;
	}

	public void setId(Integer id) {

		this.id = id;
	}

	public Pessoa getPaciente() {

		return paciente;
	}

	public void setPaciente(Pessoa paciente) {

		this.paciente = paciente;
	}

	public Pessoa getMedico() {

		return medico;
	}

	public void setMedico(Pessoa medico) {

		this.medico = medico;
	}

	public Date getDataCompromisso() {

		return dataCompromisso;
	}

	public void setDataCompromisso(Date dataCompromisso) {

		this.dataCompromisso = dataCompromisso;
	}

}
