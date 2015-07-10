package br.com.msystem.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_pessoa database table.
 * 
 */
@Entity
@Table(name="tipo_pessoa")
@NamedQuery(name="TipoPessoa.findAll", query="SELECT t FROM TipoPessoa t")
public class TipoPessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tipo_pessoa_sq", unique=true, nullable=false)
	private Integer tipoPessoaSq;

	@Column(name="descricao_tipo_pessoa", nullable=false, length=50)
	private String descricaoTipoPessoa;

	//bi-directional many-to-one association to ConsultorioPessoa
	@OneToMany(mappedBy="tipoPessoa")
	private List<ConsultorioPessoa> consultorioPessoas;

	public TipoPessoa() {
	}

	public Integer getTipoPessoaSq() {
		return this.tipoPessoaSq;
	}

	public void setTipoPessoaSq(Integer tipoPessoaSq) {
		this.tipoPessoaSq = tipoPessoaSq;
	}

	public String getDescricaoTipoPessoa() {
		return this.descricaoTipoPessoa;
	}

	public void setDescricaoTipoPessoa(String descricaoTipoPessoa) {
		this.descricaoTipoPessoa = descricaoTipoPessoa;
	}

	public List<ConsultorioPessoa> getConsultorioPessoas() {
		return this.consultorioPessoas;
	}

	public void setConsultorioPessoas(List<ConsultorioPessoa> consultorioPessoas) {
		this.consultorioPessoas = consultorioPessoas;
	}

	public ConsultorioPessoa addConsultorioPessoa(ConsultorioPessoa consultorioPessoa) {
		getConsultorioPessoas().add(consultorioPessoa);
		consultorioPessoa.setTipoPessoa(this);

		return consultorioPessoa;
	}

	public ConsultorioPessoa removeConsultorioPessoa(ConsultorioPessoa consultorioPessoa) {
		getConsultorioPessoas().remove(consultorioPessoa);
		consultorioPessoa.setTipoPessoa(null);

		return consultorioPessoa;
	}

}