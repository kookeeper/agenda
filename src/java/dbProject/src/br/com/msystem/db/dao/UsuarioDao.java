package br.com.msystem.db.dao;

import br.com.msystem.db.entity.Usuario;
import br.com.msystem.db.to.UserDetailsTO;

public interface UsuarioDao extends InterfaceDao<Usuario>{

	public UserDetailsTO login(String username, String password);

}
