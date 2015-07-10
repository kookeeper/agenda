package br.com.msystem.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_endereco database table.
 * 
 */
@Entity
@Table(name="tipo_endereco")
@NamedQuery(name="TipoEndereco.findAll", query="SELECT t FROM TipoEndereco t")
public class TipoEndereco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tipo_endereco_sq", unique=true, nullable=false)
	private Integer tipoEnderecoSq;

	@Column(name="descricao_tipo_endereco", nullable=false, length=50)
	private String descricaoTipoEndereco;

	//bi-directional many-to-one association to Endereco
	@OneToMany(mappedBy="tipoEndereco")
	private List<Endereco> enderecos;

	public TipoEndereco() {
	}

	public Integer getTipoEnderecoSq() {
		return this.tipoEnderecoSq;
	}

	public void setTipoEnderecoSq(Integer tipoEnderecoSq) {
		this.tipoEnderecoSq = tipoEnderecoSq;
	}

	public String getDescricaoTipoEndereco() {
		return this.descricaoTipoEndereco;
	}

	public void setDescricaoTipoEndereco(String descricaoTipoEndereco) {
		this.descricaoTipoEndereco = descricaoTipoEndereco;
	}

	public List<Endereco> getEnderecos() {
		return this.enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Endereco addEndereco(Endereco endereco) {
		getEnderecos().add(endereco);
		endereco.setTipoEndereco(this);

		return endereco;
	}

	public Endereco removeEndereco(Endereco endereco) {
		getEnderecos().remove(endereco);
		endereco.setTipoEndereco(null);

		return endereco;
	}

}