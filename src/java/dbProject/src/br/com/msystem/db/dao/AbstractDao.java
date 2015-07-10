package br.com.msystem.db.dao;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@SuppressWarnings("unchecked")
public abstract class AbstractDao<T> implements InterfaceDao<T>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2635065747715310680L;

	private Class<T> clazz;

	@PersistenceContext
	protected EntityManager em;

	{
		Type[] args = ((sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl) this
				.getClass().getGenericSuperclass()).getActualTypeArguments();

		if (args.length > 0) {
			clazz = (Class<T>) args[0];
		}
	}

	public T buscar(Serializable id) {

		return em.find(clazz, id);
	}

	public void excluir(Serializable id) {

		T entity = buscar(id);
		em.remove(entity);
	}

	public T salvar(T entity) {

		return em.merge(entity);
	}

	public List<T> executeNamedQuery(String namedQuery, Object... parameters) {

		TypedQuery<T> query = em.createNamedQuery(namedQuery, clazz);

		if (parameters != null) {
			int position = 1;
			for (Object param : parameters) {
				query.setParameter(position++, param);
			}
		}
		List<T> list = query.getResultList();

		return list;

	}

	public List<T> listAll() {

		return executeNamedQuery(clazz.getSimpleName() + ".findAll");

	}

}
