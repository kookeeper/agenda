package br.com.msystem.db.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the telefone database table.
 * 
 */
@Entity
@Table(name="telefone")
@NamedQuery(name="Telefone.findAll", query="SELECT t FROM Telefone t")
public class Telefone implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="telefone_sq", unique=true, nullable=false)
	private Integer telefoneSq;

	@Column(name="numero_telefone", nullable=false, length=20)
	private String numeroTelefone;

	@Column(name="ramal_telefone", nullable=false, length=10)
	private String ramalTelefone;

	//bi-directional many-to-one association to Pessoa
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="pessoa_sq", nullable=false)
	private Pessoa pessoa;

	//bi-directional many-to-one association to TipoTelefone
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tipo_telefone_sq", nullable=false)
	private TipoTelefone tipoTelefone;

	public Telefone() {
	}

	public Integer getTelefoneSq() {
		return this.telefoneSq;
	}

	public void setTelefoneSq(Integer telefoneSq) {
		this.telefoneSq = telefoneSq;
	}

	public String getNumeroTelefone() {
		return this.numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public String getRamalTelefone() {
		return this.ramalTelefone;
	}

	public void setRamalTelefone(String ramalTelefone) {
		this.ramalTelefone = ramalTelefone;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public TipoTelefone getTipoTelefone() {
		return this.tipoTelefone;
	}

	public void setTipoTelefone(TipoTelefone tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}

}