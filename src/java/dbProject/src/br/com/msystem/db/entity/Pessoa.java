package br.com.msystem.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pessoa database table.
 * 
 */
@Entity
@Table(name="pessoa")
@NamedQuery(name="Pessoa.findAll", query="SELECT p FROM Pessoa p")
public class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pessoa_sq", unique=true, nullable=false)
	private Integer pessoaSq;

	@Column(name="cpf_pessoa", nullable=false, length=11)
	private String cpfPessoa;

	@Column(name="nome_pessoa", nullable=false, length=50)
	private String nomePessoa;

	//bi-directional many-to-one association to Compromisso
	@OneToMany(mappedBy="pessoaPaciente")
	private List<Compromisso> compromissosPaciente;

	//bi-directional many-to-one association to Compromisso
	@OneToMany(mappedBy="pessoaMedico")
	private List<Compromisso> compromissosMedico;

	//bi-directional many-to-many association to Consultorio
	@ManyToMany(mappedBy="pessoas")
	private List<Consultorio> consultorios;

	//bi-directional many-to-one association to ConsultorioPessoa
	@OneToMany(mappedBy="pessoa", cascade={CascadeType.ALL})
	private List<ConsultorioPessoa> consultorioPessoas;

	//bi-directional many-to-one association to Endereco
	@OneToMany(mappedBy="pessoa", cascade={CascadeType.ALL})
	private List<Endereco> enderecos;

	//bi-directional many-to-one association to PessoaImagem
	@OneToMany(mappedBy="pessoa", cascade={CascadeType.ALL}, orphanRemoval=true)
	private List<PessoaImagem> pessoaImagems;

	//bi-directional many-to-one association to Telefone
	@OneToMany(mappedBy="pessoa", cascade={CascadeType.ALL})
	private List<Telefone> telefones;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="pessoa", cascade={CascadeType.ALL})
	private List<Usuario> usuarios;

	public Pessoa() {
	}

	public Integer getPessoaSq() {
		return this.pessoaSq;
	}

	public void setPessoaSq(Integer pessoaSq) {
		this.pessoaSq = pessoaSq;
	}

	public String getCpfPessoa() {
		return this.cpfPessoa;
	}

	public void setCpfPessoa(String cpfPessoa) {
		this.cpfPessoa = cpfPessoa;
	}

	public String getNomePessoa() {
		return this.nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	public List<Compromisso> getCompromissosPaciente() {
		return this.compromissosPaciente;
	}

	public void setCompromissosPaciente(List<Compromisso> compromissosPaciente) {
		this.compromissosPaciente = compromissosPaciente;
	}

	public Compromisso addCompromissosPaciente(Compromisso compromissosPaciente) {
		getCompromissosPaciente().add(compromissosPaciente);
		compromissosPaciente.setPessoaPaciente(this);

		return compromissosPaciente;
	}

	public Compromisso removeCompromissosPaciente(Compromisso compromissosPaciente) {
		getCompromissosPaciente().remove(compromissosPaciente);
		compromissosPaciente.setPessoaPaciente(null);

		return compromissosPaciente;
	}

	public List<Compromisso> getCompromissosMedico() {
		return this.compromissosMedico;
	}

	public void setCompromissosMedico(List<Compromisso> compromissosMedico) {
		this.compromissosMedico = compromissosMedico;
	}

	public Compromisso addCompromissosMedico(Compromisso compromissosMedico) {
		getCompromissosMedico().add(compromissosMedico);
		compromissosMedico.setPessoaMedico(this);

		return compromissosMedico;
	}

	public Compromisso removeCompromissosMedico(Compromisso compromissosMedico) {
		getCompromissosMedico().remove(compromissosMedico);
		compromissosMedico.setPessoaMedico(null);

		return compromissosMedico;
	}

	public List<Consultorio> getConsultorios() {
		return this.consultorios;
	}

	public void setConsultorios(List<Consultorio> consultorios) {
		this.consultorios = consultorios;
	}

	public List<ConsultorioPessoa> getConsultorioPessoas() {
		return this.consultorioPessoas;
	}

	public void setConsultorioPessoas(List<ConsultorioPessoa> consultorioPessoas) {
		this.consultorioPessoas = consultorioPessoas;
	}

	public ConsultorioPessoa addConsultorioPessoa(ConsultorioPessoa consultorioPessoa) {
		getConsultorioPessoas().add(consultorioPessoa);
		consultorioPessoa.setPessoa(this);

		return consultorioPessoa;
	}

	public ConsultorioPessoa removeConsultorioPessoa(ConsultorioPessoa consultorioPessoa) {
		getConsultorioPessoas().remove(consultorioPessoa);
		consultorioPessoa.setPessoa(null);

		return consultorioPessoa;
	}

	public List<Endereco> getEnderecos() {
		return this.enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Endereco addEndereco(Endereco endereco) {
		getEnderecos().add(endereco);
		endereco.setPessoa(this);

		return endereco;
	}

	public Endereco removeEndereco(Endereco endereco) {
		getEnderecos().remove(endereco);
		endereco.setPessoa(null);

		return endereco;
	}

	public List<PessoaImagem> getPessoaImagems() {
		return this.pessoaImagems;
	}

	public void setPessoaImagems(List<PessoaImagem> pessoaImagems) {
		this.pessoaImagems = pessoaImagems;
	}

	public PessoaImagem addPessoaImagem(PessoaImagem pessoaImagem) {
		getPessoaImagems().add(pessoaImagem);
		pessoaImagem.setPessoa(this);

		return pessoaImagem;
	}

	public PessoaImagem removePessoaImagem(PessoaImagem pessoaImagem) {
		getPessoaImagems().remove(pessoaImagem);
		pessoaImagem.setPessoa(null);

		return pessoaImagem;
	}

	public List<Telefone> getTelefones() {
		return this.telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public Telefone addTelefone(Telefone telefone) {
		getTelefones().add(telefone);
		telefone.setPessoa(this);

		return telefone;
	}

	public Telefone removeTelefone(Telefone telefone) {
		getTelefones().remove(telefone);
		telefone.setPessoa(null);

		return telefone;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setPessoa(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setPessoa(null);

		return usuario;
	}

}