package br.com.msystem.mbean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

import br.com.msystem.db.bo.UsuarioBo;
import br.com.msystem.db.entity.Pessoa;
import br.com.msystem.db.entity.Usuario;
import br.com.msystem.db.entity.UsuarioFacebook;

@ManagedBean
@ViewScoped
public class UsuarioBean extends AbstractBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3803663463709338963L;

	private Usuario usuario;
	
	@ManagedProperty("#{usuarioBo}")
	private UsuarioBo bo;

	@PostConstruct
	public void init() {
		usuario = new Usuario();
		usuario.setPessoa(new Pessoa());
		
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		if (flash.containsKey("usernameFB")) {
			usuario.setLogin((String)flash.get("usernameFB"));
			usuario.getPessoa().setNomePessoa((String)flash.get("nameFB"));
			usuario.setUsuarioFacebook((UsuarioFacebook)flash.get("usuarioFacebook"));
		}
	}

	public String salvarUsuario() {
		Usuario bean = bo.pesquisarLogin(usuario.getLogin());
		
		if (bean != null) {
			FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_ERROR, "O login escolhido já está em uso", null));
			return "";
		}
		
		bo.salvar(usuario);
		return "login";
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

	/**
	 * @return the bo
	 */
	public UsuarioBo getBo() {
		return bo;
	}

	/**
	 * @param bo the bo to set
	 */
	public void setBo(UsuarioBo bo) {
		this.bo = bo;
	}

}
