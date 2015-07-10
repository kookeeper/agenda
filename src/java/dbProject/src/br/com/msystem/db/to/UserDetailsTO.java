package br.com.msystem.db.to;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.msystem.db.entity.Usuario;
import br.com.msystem.db.entity.UsuarioFacebook;

public class UserDetailsTO implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8659569368059959846L;
	private boolean accountNonExpired = true;
	private boolean accountNonLocked = true;
	private boolean credentialsNonExpired = true;
	private boolean enabled = true;
	private Usuario usuario;
	private UsuarioFacebook usuarioFacebook;

	public UserDetailsTO(Usuario usuario) {
		super();
		setUsuario(usuario);
	}

	public UserDetailsTO(UsuarioFacebook bean) {
		super();
		setUsuarioFacebook(bean);
	}

	public UserDetailsTO(Usuario usuario,
			boolean accountNonExpired, boolean accountNonLocked,
			boolean credentialsNonExpired, boolean enabled) {
		super();
		setUsuario(usuario);
		this.accountNonExpired = accountNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.credentialsNonExpired = credentialsNonExpired;
		this.enabled = enabled;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthorityTO> lista = new ArrayList<GrantedAuthorityTO>();
		GrantedAuthorityTO auth = new GrantedAuthorityTO();
		auth.setAuthority("ROLE_USER");
		lista.add(auth);

		return lista;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return getUsuario().getLogin();
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return getUsuario().getSenha();
	}

	/**
	 * @return the accountNonExpired
	 */
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	/**
	 * @param accountNonExpired
	 *            the accountNonExpired to set
	 */
	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	/**
	 * @return the accountNonLocked
	 */
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	/**
	 * @param accountNonLocked
	 *            the accountNonLocked to set
	 */
	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	/**
	 * @return the credentialsNonExpired
	 */
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	/**
	 * @param credentialsNonExpired
	 *            the credentialsNonExpired to set
	 */
	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	/**
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * @param enabled
	 *            the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UsuarioFacebook getUsuarioFacebook() {
		return usuarioFacebook;
	}

	public void setUsuarioFacebook(UsuarioFacebook usuarioFacebook) {
		this.usuarioFacebook = usuarioFacebook;
	}

}
