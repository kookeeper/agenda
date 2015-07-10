package br.com.msystem.db.bo;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.msystem.db.dao.InterfaceDao;
import br.com.msystem.db.entity.Consultorio;

@Service
@Transactional
public class ConsultorioBo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8582028017421937651L;

	@Autowired
	private InterfaceDao<Consultorio> dao;

	public Consultorio buscar(Integer consultorioSq) {
		return dao.buscar(consultorioSq);
	}

	public void excluir(Integer consultorioSq) {
		dao.excluir(consultorioSq);
	}
	
	public Consultorio salvar(Consultorio consultorio) {
		return dao.salvar(consultorio);
	}

	public List<Consultorio> listar(Integer pessoaSq) {
		List<Consultorio> lista = dao.executeNamedQuery("Consultorio.listarPorPessoa", pessoaSq);
		
		return lista;
	}

	public void incluirConsultorio(Consultorio consultorio) {

		salvar(consultorio);
		
	}

}