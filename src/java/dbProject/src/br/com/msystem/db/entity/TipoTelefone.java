package br.com.msystem.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_telefone database table.
 * 
 */
@Entity
@Table(name="tipo_telefone")
@NamedQuery(name="TipoTelefone.findAll", query="SELECT t FROM TipoTelefone t")
public class TipoTelefone implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tipo_telefone_sq", unique=true, nullable=false)
	private Integer tipoTelefoneSq;

	@Column(name="descricao_tipo_telefone", nullable=false, length=50)
	private String descricaoTipoTelefone;

	//bi-directional many-to-one association to Telefone
	@OneToMany(mappedBy="tipoTelefone")
	private List<Telefone> telefones;

	public TipoTelefone() {
	}

	public Integer getTipoTelefoneSq() {
		return this.tipoTelefoneSq;
	}

	public void setTipoTelefoneSq(Integer tipoTelefoneSq) {
		this.tipoTelefoneSq = tipoTelefoneSq;
	}

	public String getDescricaoTipoTelefone() {
		return this.descricaoTipoTelefone;
	}

	public void setDescricaoTipoTelefone(String descricaoTipoTelefone) {
		this.descricaoTipoTelefone = descricaoTipoTelefone;
	}

	public List<Telefone> getTelefones() {
		return this.telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public Telefone addTelefone(Telefone telefone) {
		getTelefones().add(telefone);
		telefone.setTipoTelefone(this);

		return telefone;
	}

	public Telefone removeTelefone(Telefone telefone) {
		getTelefones().remove(telefone);
		telefone.setTipoTelefone(null);

		return telefone;
	}

}