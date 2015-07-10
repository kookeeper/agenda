package br.com.msystem.db.bo;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.msystem.db.dao.InterfaceDao;
import br.com.msystem.db.entity.TipoTelefone;

@Service
@Transactional
public class TipoTelefoneBo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1213790758368588905L;
	@Autowired
	private InterfaceDao<TipoTelefone> dao;
	
	public List<TipoTelefone> listar() {
		List<TipoTelefone> lista = dao.executeNamedQuery("TipoTelefone.findAll");
		
		return lista;
	}

}