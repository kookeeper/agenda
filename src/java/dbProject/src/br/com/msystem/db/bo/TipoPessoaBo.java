package br.com.msystem.db.bo;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.msystem.db.dao.InterfaceDao;
import br.com.msystem.db.entity.TipoPessoa;

@Service
@Transactional
public class TipoPessoaBo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4850043916425308069L;
	@Autowired
	private InterfaceDao<TipoPessoa> dao;
	
	public TipoPessoa buscarOuCriar(Integer id, String descricao) {
		
		TipoPessoa entity = dao.buscar(id);

		if (entity == null) {
			entity = new TipoPessoa();
			entity.setDescricaoTipoPessoa(descricao);
			entity.setTipoPessoaSq(id);
			dao.salvar(entity);
		}
		return entity;

	}

}