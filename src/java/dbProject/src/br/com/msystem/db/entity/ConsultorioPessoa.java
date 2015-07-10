package br.com.msystem.db.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the consultorio_pessoa database table.
 * 
 */
@Entity
@Table(name="consultorio_pessoa")
@NamedQuery(name="ConsultorioPessoa.findAll", query="SELECT c FROM ConsultorioPessoa c")
public class ConsultorioPessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="consultorio_pessoa_sq", unique=true, nullable=false)
	private Integer consultorioPessoaSq;

	//bi-directional many-to-one association to Consultorio
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="consultorio_sq", nullable=false)
	private Consultorio consultorio;

	//bi-directional many-to-one association to Pessoa
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="pessoa_sq", nullable=false)
	private Pessoa pessoa;

	//bi-directional many-to-one association to TipoPessoa
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tipo_pessoa_sq", nullable=false)
	private TipoPessoa tipoPessoa;

	public ConsultorioPessoa() {
	}

	public Integer getConsultorioPessoaSq() {
		return this.consultorioPessoaSq;
	}

	public void setConsultorioPessoaSq(Integer consultorioPessoaSq) {
		this.consultorioPessoaSq = consultorioPessoaSq;
	}

	public Consultorio getConsultorio() {
		return this.consultorio;
	}

	public void setConsultorio(Consultorio consultorio) {
		this.consultorio = consultorio;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public TipoPessoa getTipoPessoa() {
		return this.tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

}