package br.com.msystem.db.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the endereco database table.
 * 
 */
@Entity
@Table(name="endereco")
@NamedQuery(name="Endereco.findAll", query="SELECT e FROM Endereco e")
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="endereco_sq", unique=true, nullable=false)
	private Integer enderecoSq;

	@Column(nullable=false, length=255)
	private String bairro;

	@Column(nullable=false, length=8)
	private String cep;

	@Column(nullable=false, length=50)
	private String complemento;

	@Column(nullable=false, length=255)
	private String logradouro;

	@Column(nullable=false, length=10)
	private String numero;

	//bi-directional many-to-one association to Pessoa
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="pessoa_sq", nullable=false)
	private Pessoa pessoa;

	//bi-directional many-to-one association to TipoEndereco
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tipo_endereco_sq", nullable=false)
	private TipoEndereco tipoEndereco;

	public Endereco() {
	}

	public Integer getEnderecoSq() {
		return this.enderecoSq;
	}

	public void setEnderecoSq(Integer enderecoSq) {
		this.enderecoSq = enderecoSq;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getLogradouro() {
		return this.logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public TipoEndereco getTipoEndereco() {
		return this.tipoEndereco;
	}

	public void setTipoEndereco(TipoEndereco tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
	}

}