package br.com.msystem.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the compromisso database table.
 * 
 */
@Entity
@Table(name="compromisso")
@NamedQuery(name="Compromisso.findAll", query="SELECT c FROM Compromisso c")
public class Compromisso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="compromisso_sq", unique=true, nullable=false)
	private Integer compromissoSq;

	private Boolean compareceu;

	@Column(name="data_cadastro", nullable=false)
	private Timestamp dataCadastro;

	@Column(name="data_compromisso", nullable=false)
	private Timestamp dataCompromisso;

	@Column(name="valor_cobrado", precision=9, scale=2)
	private BigDecimal valorCobrado;

	@Column(name="valor_pago", precision=9, scale=2)
	private BigDecimal valorPago;

	//bi-directional many-to-one association to Convenio
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="convenio_sq", nullable=false)
	private Convenio convenio;

	//bi-directional many-to-one association to Pessoa
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="paciente_sq", nullable=false)
	private Pessoa pessoaPaciente;

	//bi-directional many-to-one association to Pessoa
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="medico_sq", nullable=false)
	private Pessoa pessoaMedico;

	//bi-directional many-to-one association to TipoCompromisso
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tipo_compromisso_sq", nullable=false)
	private TipoCompromisso tipoCompromisso;

	//bi-directional many-to-one association to Observacao
	@OneToMany(mappedBy="compromisso", cascade={CascadeType.ALL})
	private List<Observacao> observacaos;

	public Compromisso() {
	}

	public Integer getCompromissoSq() {
		return this.compromissoSq;
	}

	public void setCompromissoSq(Integer compromissoSq) {
		this.compromissoSq = compromissoSq;
	}

	public Boolean getCompareceu() {
		return this.compareceu;
	}

	public void setCompareceu(Boolean compareceu) {
		this.compareceu = compareceu;
	}

	public Timestamp getDataCadastro() {
		return this.dataCadastro;
	}

	public void setDataCadastro(Timestamp dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Timestamp getDataCompromisso() {
		return this.dataCompromisso;
	}

	public void setDataCompromisso(Timestamp dataCompromisso) {
		this.dataCompromisso = dataCompromisso;
	}

	public BigDecimal getValorCobrado() {
		return this.valorCobrado;
	}

	public void setValorCobrado(BigDecimal valorCobrado) {
		this.valorCobrado = valorCobrado;
	}

	public BigDecimal getValorPago() {
		return this.valorPago;
	}

	public void setValorPago(BigDecimal valorPago) {
		this.valorPago = valorPago;
	}

	public Convenio getConvenio() {
		return this.convenio;
	}

	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}

	public Pessoa getPessoaPaciente() {
		return this.pessoaPaciente;
	}

	public void setPessoaPaciente(Pessoa pessoaPaciente) {
		this.pessoaPaciente = pessoaPaciente;
	}

	public Pessoa getPessoaMedico() {
		return this.pessoaMedico;
	}

	public void setPessoaMedico(Pessoa pessoaMedico) {
		this.pessoaMedico = pessoaMedico;
	}

	public TipoCompromisso getTipoCompromisso() {
		return this.tipoCompromisso;
	}

	public void setTipoCompromisso(TipoCompromisso tipoCompromisso) {
		this.tipoCompromisso = tipoCompromisso;
	}

	public List<Observacao> getObservacaos() {
		return this.observacaos;
	}

	public void setObservacaos(List<Observacao> observacaos) {
		this.observacaos = observacaos;
	}

	public Observacao addObservacao(Observacao observacao) {
		getObservacaos().add(observacao);
		observacao.setCompromisso(this);

		return observacao;
	}

	public Observacao removeObservacao(Observacao observacao) {
		getObservacaos().remove(observacao);
		observacao.setCompromisso(null);

		return observacao;
	}

}