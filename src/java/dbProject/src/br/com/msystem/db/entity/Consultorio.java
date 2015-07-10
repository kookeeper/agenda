package br.com.msystem.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the consultorio database table.
 * 
 */
@Entity
@Table(name="consultorio")
@NamedQuery(name="Consultorio.findAll", query="SELECT c FROM Consultorio c")
public class Consultorio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="consultorio_sq", unique=true, nullable=false)
	private Integer consultorioSq;

	@Column(name="cnpj_consultorio", nullable=false, length=14)
	private String cnpjConsultorio;

	@Column(name="razao_social_consultorio", nullable=false, length=255)
	private String razaoSocialConsultorio;

	//bi-directional many-to-many association to Pessoa
	@ManyToMany
	@JoinTable(
		name="consultorio_pessoa"
		, joinColumns={
			@JoinColumn(name="consultorio_sq", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="pessoa_sq", nullable=false)
			}
		)
	private List<Pessoa> pessoas;

	//bi-directional many-to-one association to ConsultorioPessoa
	@OneToMany(mappedBy="consultorio", cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private List<ConsultorioPessoa> consultorioPessoas;

	//bi-directional many-to-one association to Convenio
	@OneToMany(mappedBy="consultorio", cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private List<Convenio> convenios;

	public Consultorio() {
	}

	public Integer getConsultorioSq() {
		return this.consultorioSq;
	}

	public void setConsultorioSq(Integer consultorioSq) {
		this.consultorioSq = consultorioSq;
	}

	public String getCnpjConsultorio() {
		return this.cnpjConsultorio;
	}

	public void setCnpjConsultorio(String cnpjConsultorio) {
		this.cnpjConsultorio = cnpjConsultorio;
	}

	public String getRazaoSocialConsultorio() {
		return this.razaoSocialConsultorio;
	}

	public void setRazaoSocialConsultorio(String razaoSocialConsultorio) {
		this.razaoSocialConsultorio = razaoSocialConsultorio;
	}

	public List<Pessoa> getPessoas() {
		return this.pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public List<ConsultorioPessoa> getConsultorioPessoas() {
		return this.consultorioPessoas;
	}

	public void setConsultorioPessoas(List<ConsultorioPessoa> consultorioPessoas) {
		this.consultorioPessoas = consultorioPessoas;
	}

	public ConsultorioPessoa addConsultorioPessoa(ConsultorioPessoa consultorioPessoa) {
		getConsultorioPessoas().add(consultorioPessoa);
		consultorioPessoa.setConsultorio(this);

		return consultorioPessoa;
	}

	public ConsultorioPessoa removeConsultorioPessoa(ConsultorioPessoa consultorioPessoa) {
		getConsultorioPessoas().remove(consultorioPessoa);
		consultorioPessoa.setConsultorio(null);

		return consultorioPessoa;
	}

	public List<Convenio> getConvenios() {
		return this.convenios;
	}

	public void setConvenios(List<Convenio> convenios) {
		this.convenios = convenios;
	}

	public Convenio addConvenio(Convenio convenio) {
		getConvenios().add(convenio);
		convenio.setConsultorio(this);

		return convenio;
	}

	public Convenio removeConvenio(Convenio convenio) {
		getConvenios().remove(convenio);
		convenio.setConsultorio(null);

		return convenio;
	}

}