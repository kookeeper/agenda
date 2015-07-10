package br.com.msystem.db.dao;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.msystem.db.entity.Usuario;
import br.com.msystem.db.to.UserDetailsTO;

@Repository
public class UsuarioDaoImpl extends AbstractDao<Usuario> implements UsuarioDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1343766060942470639L;

	public UserDetailsTO login(String username, String password) {

		TypedQuery<Usuario> query = em.createNamedQuery("Usuario.login",
				Usuario.class);
		query.setParameter("login", username);
		query.setParameter("senha", password);

		Usuario usuario;
		try {
			usuario = query.getSingleResult();
		} catch (NoResultException e) {
			throw new RuntimeException("Usuario/Senha informado invalido.");
		}

		return new UserDetailsTO(usuario);

	}

}
