package br.com.msystem.db.bo;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.msystem.db.dao.InterfaceDao;

@Service
@Transactional
public abstract class AbstractBo<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2462393380275995367L;

	@Autowired
	private InterfaceDao<T> dao;

	public T buscar(Serializable id) {
		
		return dao.buscar(id);

	}

	public void excluir(Serializable id) {
		
		dao.excluir(id);

	}

	public T salvar(T entity) {
		
		return dao.salvar(entity);

	}

	public List<T> executeNamedQuery(String namedQuery, Object... parameters) {
		
		return dao.executeNamedQuery(namedQuery, parameters);

	}

	public List<T> listAll() {
		
		return dao.listAll();
		
	}
}
