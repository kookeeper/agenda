package br.com.msystem.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_compromisso database table.
 * 
 */
@Entity
@Table(name="tipo_compromisso")
@NamedQuery(name="TipoCompromisso.findAll", query="SELECT t FROM TipoCompromisso t")
public class TipoCompromisso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tipo_compromisso_sq", unique=true, nullable=false)
	private Integer tipoCompromissoSq;

	@Column(name="descricao_tipo_compromisso", nullable=false, length=50)
	private String descricaoTipoCompromisso;

	//bi-directional many-to-one association to Compromisso
	@OneToMany(mappedBy="tipoCompromisso")
	private List<Compromisso> compromissos;

	public TipoCompromisso() {
	}

	public Integer getTipoCompromissoSq() {
		return this.tipoCompromissoSq;
	}

	public void setTipoCompromissoSq(Integer tipoCompromissoSq) {
		this.tipoCompromissoSq = tipoCompromissoSq;
	}

	public String getDescricaoTipoCompromisso() {
		return this.descricaoTipoCompromisso;
	}

	public void setDescricaoTipoCompromisso(String descricaoTipoCompromisso) {
		this.descricaoTipoCompromisso = descricaoTipoCompromisso;
	}

	public List<Compromisso> getCompromissos() {
		return this.compromissos;
	}

	public void setCompromissos(List<Compromisso> compromissos) {
		this.compromissos = compromissos;
	}

	public Compromisso addCompromisso(Compromisso compromisso) {
		getCompromissos().add(compromisso);
		compromisso.setTipoCompromisso(this);

		return compromisso;
	}

	public Compromisso removeCompromisso(Compromisso compromisso) {
		getCompromissos().remove(compromisso);
		compromisso.setTipoCompromisso(null);

		return compromisso;
	}

}