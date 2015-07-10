package br.com.msystem.agendaclinica.bean;

import java.io.Serializable;

public class Pessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9090456680856262016L;
	private Integer id;
	private String nomePessoa;

	public Integer getId() {

		return id;
	}

	public void setId(Integer id) {

		this.id = id;
	}

	public String getNomePessoa() {

		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {

		this.nomePessoa = nomePessoa;
	}

}
