/**
 * 
 */
package br.com.msystem.mbean;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.msystem.db.bo.ConsultorioBo;
import br.com.msystem.db.bo.UsuarioBo;
import br.com.msystem.db.entity.Usuario;
import br.com.msystem.db.to.UserDetailsTO;

/**
 * @author Sergio
 * 
 */
@ManagedBean
@RequestScoped
public class LoginBean extends AbstractBean implements AuthenticationProvider {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6537391445270362713L;

	@ManagedProperty("#{usuarioBo}")
	private UsuarioBo bo;

	@ManagedProperty("#{consultorioBo}")
	private ConsultorioBo consultorioBo;
	
	private String login;
	private String senha;
	private String novaSenha1;
	private String novaSenha2;

	@PostConstruct
	public void init() {
		
	}

	public String logarFB() {
		
		String usernameFB = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("emailFB");
		String idFB = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idFB");
		String nameFB = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("nameFB");

		UserDetailsTO to = bo.logarFB(usernameFB, idFB);

		if (to == null) {
			FacesContext.getCurrentInstance().addMessage(
					"",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario/Senha inválidos", ""));
			return "";
		}
		
		if ((to.getUsuario() == null) && (to.getUsuarioFacebook() != null)) {
			Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
			flash.put("nameFB", nameFB);
			flash.put("usernameFB", usernameFB);
			flash.put("usuarioFacebook", to.getUsuarioFacebook());

			return "novoUsuarioFacebook";
		}
		
		loginSpringSecurity(to);
		getSession().setUser(to);
		
		return "agenda";
	}

	public String logar() {

		try {
			UserDetailsTO user = bo.logar(login, senha);
			
			loginSpringSecurity(user);

			getSession().setUser(user);

			if (user.getUsername().equals(user.getPassword())) {
				return "trocarSenha";
			}

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					"",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e
							.getMessage(), ""));
			return "";
		}

		return "agenda";

	}

	public String trocarSenha() {
		
		Usuario usuario = getSession().getUser().getUsuario();
		
		if (!usuario.getSenha().equals(getSenha())) {
			FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_ERROR, "A senha atual não é válida.", ""));
			FacesContext.getCurrentInstance().validationFailed();
			return "";
		}
		
		if (!getNovaSenha1().equals(getNovaSenha2())) {
			FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_ERROR, "A nova senha informada não confere.", ""));
			FacesContext.getCurrentInstance().validationFailed();
			return "";
		}
		
		usuario.setSenha(getNovaSenha1());
		bo.salvar(usuario);
		
		FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_INFO, "Senha alterada com sucesso.", ""));
		
		return "agenda";
	}

	private void loginSpringSecurity(UserDetails user) {
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
				user.getUsername(), null, user.getAuthorities());
		token.setDetails(user);

		SecurityContextHolder.createEmptyContext();
		SecurityContextHolder.getContext().setAuthentication(token);
	}

	public void logout() throws IOException {
		SecurityContextHolder.clearContext();
		FacesContext.getCurrentInstance().getExternalContext()
				.invalidateSession();

		FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("login.xhtml");

	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login
	 *            the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha
	 *            the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * @return the bo
	 */
	public UsuarioBo getBo() {
		return bo;
	}

	/**
	 * @param bo
	 *            the bo to set
	 */
	public void setBo(UsuarioBo bo) {
		this.bo = bo;
	}

	/**
	 * @return the consultorioBo
	 */
	public ConsultorioBo getConsultorioBo() {
		return consultorioBo;
	}

	/**
	 * @param consultorioBo
	 *            the consultorioBo to set
	 */
	public void setConsultorioBo(ConsultorioBo consultorioBo) {
		this.consultorioBo = consultorioBo;
	}

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		System.out.println("auth");
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		System.out.println("supp");
		return false;
	}

	public String getNovaSenha1() {
		return novaSenha1;
	}

	public void setNovaSenha1(String novaSenha1) {
		this.novaSenha1 = novaSenha1;
	}

	public String getNovaSenha2() {
		return novaSenha2;
	}

	public void setNovaSenha2(String novaSenha2) {
		this.novaSenha2 = novaSenha2;
	}

}