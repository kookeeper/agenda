package br.com.msystem.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the observacao database table.
 * 
 */
@Entity
@Table(name="observacao")
@NamedQuery(name="Observacao.findAll", query="SELECT o FROM Observacao o")
public class Observacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="observacao_sq", unique=true, nullable=false)
	private Integer observacaoSq;

	@Column(name="data_observacao", insertable=false, updatable=false, nullable=false)
	private Timestamp dataObservacao;

	@Column(nullable=false, length=2147483647)
	private String observacao;

	//bi-directional many-to-one association to Compromisso
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="compromisso_sq", nullable=false)
	private Compromisso compromisso;

	public Observacao() {
	}

	public Integer getObservacaoSq() {
		return this.observacaoSq;
	}

	public void setObservacaoSq(Integer observacaoSq) {
		this.observacaoSq = observacaoSq;
	}

	public Timestamp getDataObservacao() {
		return this.dataObservacao;
	}

	public void setDataObservacao(Timestamp dataObservacao) {
		this.dataObservacao = dataObservacao;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Compromisso getCompromisso() {
		return this.compromisso;
	}

	public void setCompromisso(Compromisso compromisso) {
		this.compromisso = compromisso;
	}

}