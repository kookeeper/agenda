package br.com.msystem.db.dao;

import java.io.Serializable;
import java.util.List;

public interface InterfaceDao<T> {

	public T buscar(Serializable id);

	public void excluir(Serializable id);

	public T salvar(T entity);
	
	public List<T> executeNamedQuery(String namedQuery, Object... parameters);

	public List<T> listAll();
}
