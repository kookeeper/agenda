package br.com.msystem.db.bo;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.msystem.db.dao.InterfaceDao;
import br.com.msystem.db.dao.UsuarioDao;
import br.com.msystem.db.entity.Usuario;
import br.com.msystem.db.entity.UsuarioFacebook;
import br.com.msystem.db.to.UserDetailsTO;

@Service
@Transactional
public class UsuarioBo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -725945025227331118L;

	@Autowired
	private UsuarioDao dao;
	
	@Autowired
	private InterfaceDao<UsuarioFacebook> usuarioFacebookDao;

	public Usuario pesquisarLogin(String login) {
		List<Usuario> bean = dao.executeNamedQuery("Usuario.pesquisarLogin", login);
		
		if (bean.size() > 0) {
			return bean.get(0);
		}

		return null;
	}

	public UserDetailsTO logarFB(String usernameFB, String idFB) {
		
		List<UsuarioFacebook> lista = usuarioFacebookDao.executeNamedQuery("UsuarioFacebook.pesquisarLogin", usernameFB);

		UsuarioFacebook bean;
		if (lista.size() == 0) {
			bean = new UsuarioFacebook();
			bean.setIdFacebook(idFB);
			bean.setUsuarioFacebook(usernameFB);
			bean = usuarioFacebookDao.salvar(bean);
		} else {
			bean = lista.get(0);
		}
		
		UserDetailsTO to;
		if ((bean.getUsuarios() != null) && (bean.getUsuarios().size() > 0)) {
			to = logar(bean.getUsuarios().get(0).getLogin(), bean.getUsuarios().get(0).getSenha());
		} else {
			to = new UserDetailsTO(bean);
		}
		
		return to;
		
	}

	public UserDetailsTO logar(String login, String senha) {

		UserDetailsTO usuario = dao.login(login, senha);
		usuario.getUsuario().getPessoa().getPessoaSq();
		return usuario;

	}

	public void salvar(Usuario usuario) {
		dao.salvar(usuario);

	}

}
