package br.com.msystem.db.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(name="usuario")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="usuario_sq", unique=true, nullable=false)
	private Integer usuarioSq;

	@Column(nullable=false, length=50)
	private String login;

	@Column(nullable=false, length=50)
	private String senha;

	//bi-directional many-to-one association to Pessoa
	@ManyToOne(cascade={CascadeType.MERGE}, fetch=FetchType.LAZY)
	@JoinColumn(name="pessoa_sq", nullable=false)
	private Pessoa pessoa;

	//bi-directional many-to-one association to UsuarioFacebook
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="usuario_facebook_sq")
	private UsuarioFacebook usuarioFacebook;

	public Usuario() {
	}

	public Integer getUsuarioSq() {
		return this.usuarioSq;
	}

	public void setUsuarioSq(Integer usuarioSq) {
		this.usuarioSq = usuarioSq;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public UsuarioFacebook getUsuarioFacebook() {
		return this.usuarioFacebook;
	}

	public void setUsuarioFacebook(UsuarioFacebook usuarioFacebook) {
		this.usuarioFacebook = usuarioFacebook;
	}

}