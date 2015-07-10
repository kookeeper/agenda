package br.com.msystem.db.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pessoa_imagem_metadado database table.
 * 
 */
@Entity
@Table(name="pessoa_imagem_metadado")
@NamedQuery(name="PessoaImagemMetadado.findAll", query="SELECT p FROM PessoaImagemMetadado p")
public class PessoaImagemMetadado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pessoa_imagem_metadado_sq", unique=true, nullable=false)
	private Integer pessoaImagemMetadadoSq;

	@Column(nullable=false, length=255)
	private String chave;

	@Column(nullable=false, length=255)
	private String valor;

	//bi-directional many-to-one association to PessoaImagem
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="pessoa_imagem_sq", nullable=false)
	private PessoaImagem pessoaImagem;

	public PessoaImagemMetadado() {
	}

	public Integer getPessoaImagemMetadadoSq() {
		return this.pessoaImagemMetadadoSq;
	}

	public void setPessoaImagemMetadadoSq(Integer pessoaImagemMetadadoSq) {
		this.pessoaImagemMetadadoSq = pessoaImagemMetadadoSq;
	}

	public String getChave() {
		return this.chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public String getValor() {
		return this.valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public PessoaImagem getPessoaImagem() {
		return this.pessoaImagem;
	}

	public void setPessoaImagem(PessoaImagem pessoaImagem) {
		this.pessoaImagem = pessoaImagem;
	}

}