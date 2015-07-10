package br.com.msystem.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario_facebook database table.
 * 
 */
@Entity
@Table(name="usuario_facebook")
@NamedQuery(name="UsuarioFacebook.findAll", query="SELECT u FROM UsuarioFacebook u")
public class UsuarioFacebook implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="usuario_facebook_sq", unique=true, nullable=false)
	private Integer usuarioFacebookSq;

	@Column(name="id_facebook", length=50)
	private String idFacebook;

	@Column(name="usuario_facebook", length=50)
	private String usuarioFacebook;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="usuarioFacebook")
	private List<Usuario> usuarios;

	public UsuarioFacebook() {
	}

	public Integer getUsuarioFacebookSq() {
		return this.usuarioFacebookSq;
	}

	public void setUsuarioFacebookSq(Integer usuarioFacebookSq) {
		this.usuarioFacebookSq = usuarioFacebookSq;
	}

	public String getIdFacebook() {
		return this.idFacebook;
	}

	public void setIdFacebook(String idFacebook) {
		this.idFacebook = idFacebook;
	}

	public String getUsuarioFacebook() {
		return this.usuarioFacebook;
	}

	public void setUsuarioFacebook(String usuarioFacebook) {
		this.usuarioFacebook = usuarioFacebook;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setUsuarioFacebook(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setUsuarioFacebook(null);

		return usuario;
	}

}