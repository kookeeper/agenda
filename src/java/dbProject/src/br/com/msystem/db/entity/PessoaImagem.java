package br.com.msystem.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pessoa_imagem database table.
 * 
 */
@Entity
@Table(name="pessoa_imagem")
@NamedQuery(name="PessoaImagem.findAll", query="SELECT p FROM PessoaImagem p")
public class PessoaImagem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pessoa_imagem_sq", unique=true, nullable=false)
	private Integer pessoaImagemSq;

	//bi-directional many-to-one association to Pessoa
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="pessoa_sq", nullable=false)
	private Pessoa pessoa;

	//bi-directional many-to-one association to PessoaImagemMetadado
	@OneToMany(mappedBy="pessoaImagem", cascade={CascadeType.ALL})
	private List<PessoaImagemMetadado> pessoaImagemMetadados;

	public PessoaImagem() {
	}

	public Integer getPessoaImagemSq() {
		return this.pessoaImagemSq;
	}

	public void setPessoaImagemSq(Integer pessoaImagemSq) {
		this.pessoaImagemSq = pessoaImagemSq;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<PessoaImagemMetadado> getPessoaImagemMetadados() {
		return this.pessoaImagemMetadados;
	}

	public void setPessoaImagemMetadados(List<PessoaImagemMetadado> pessoaImagemMetadados) {
		this.pessoaImagemMetadados = pessoaImagemMetadados;
	}

	public PessoaImagemMetadado addPessoaImagemMetadado(PessoaImagemMetadado pessoaImagemMetadado) {
		getPessoaImagemMetadados().add(pessoaImagemMetadado);
		pessoaImagemMetadado.setPessoaImagem(this);

		return pessoaImagemMetadado;
	}

	public PessoaImagemMetadado removePessoaImagemMetadado(PessoaImagemMetadado pessoaImagemMetadado) {
		getPessoaImagemMetadados().remove(pessoaImagemMetadado);
		pessoaImagemMetadado.setPessoaImagem(null);

		return pessoaImagemMetadado;
	}

}