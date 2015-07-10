package br.com.msystem.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the convenio database table.
 * 
 */
@Entity
@Table(name="convenio")
@NamedQuery(name="Convenio.findAll", query="SELECT c FROM Convenio c")
public class Convenio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="convenio_sq", unique=true, nullable=false)
	private Integer convenioSq;

	@Column(name="nome_convenio", nullable=false, length=50)
	private String nomeConvenio;

	@Column(name="prazo_maximo_retorno", nullable=false)
	private Integer prazoMaximoRetorno;

	@Column(name="valor_base", nullable=false, precision=9, scale=2)
	private BigDecimal valorBase;

	//bi-directional many-to-one association to Compromisso
	@OneToMany(mappedBy="convenio")
	private List<Compromisso> compromissos;

	//bi-directional many-to-one association to Consultorio
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="consultorio_sq", nullable=false)
	private Consultorio consultorio;

	public Convenio() {
	}

	public Integer getConvenioSq() {
		return this.convenioSq;
	}

	public void setConvenioSq(Integer convenioSq) {
		this.convenioSq = convenioSq;
	}

	public String getNomeConvenio() {
		return this.nomeConvenio;
	}

	public void setNomeConvenio(String nomeConvenio) {
		this.nomeConvenio = nomeConvenio;
	}

	public Integer getPrazoMaximoRetorno() {
		return this.prazoMaximoRetorno;
	}

	public void setPrazoMaximoRetorno(Integer prazoMaximoRetorno) {
		this.prazoMaximoRetorno = prazoMaximoRetorno;
	}

	public BigDecimal getValorBase() {
		return this.valorBase;
	}

	public void setValorBase(BigDecimal valorBase) {
		this.valorBase = valorBase;
	}

	public List<Compromisso> getCompromissos() {
		return this.compromissos;
	}

	public void setCompromissos(List<Compromisso> compromissos) {
		this.compromissos = compromissos;
	}

	public Compromisso addCompromisso(Compromisso compromisso) {
		getCompromissos().add(compromisso);
		compromisso.setConvenio(this);

		return compromisso;
	}

	public Compromisso removeCompromisso(Compromisso compromisso) {
		getCompromissos().remove(compromisso);
		compromisso.setConvenio(null);

		return compromisso;
	}

	public Consultorio getConsultorio() {
		return this.consultorio;
	}

	public void setConsultorio(Consultorio consultorio) {
		this.consultorio = consultorio;
	}

}