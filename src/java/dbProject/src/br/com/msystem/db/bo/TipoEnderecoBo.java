package br.com.msystem.db.bo;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.msystem.db.dao.InterfaceDao;
import br.com.msystem.db.entity.TipoEndereco;

@Service
@Transactional
public class TipoEnderecoBo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8315327227264974530L;
	@Autowired
	private InterfaceDao<TipoEndereco> dao;
	
	public List<TipoEndereco> listar() {
		List<TipoEndereco> lista = dao.executeNamedQuery("TipoEndereco.findAll");
		
		return lista;
	}

}