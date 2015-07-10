package br.com.msystem.db.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.msystem.db.dao.InterfaceDao;
import br.com.msystem.db.entity.ConsultorioPessoa;
import br.com.msystem.db.entity.Pessoa;
import br.com.msystem.db.entity.PessoaImagem;
import br.com.msystem.db.entity.PessoaImagemMetadado;
import br.com.msystem.util.Constantes;

@Service
@Transactional
public class PessoaBo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4975510332006339703L;

	@Autowired
	private InterfaceDao<Pessoa> dao;

	@Autowired
	private InterfaceDao<ConsultorioPessoa> consultorioPessoaDao;

	@Autowired
	private ConsultorioBo consultorioBo;
	
	@Autowired
	private InterfaceDao<PessoaImagem> pessoaImagemDao;

	public Pessoa buscar(Integer pessoaSq) {

		Pessoa pessoa = dao.buscar(pessoaSq);
		return pessoa;
	}

	public List<ConsultorioPessoa> listarConsultorio(Integer pessoaSq) {

		List<ConsultorioPessoa> lista = dao.buscar(pessoaSq)
				.getConsultorioPessoas();
		return lista;

	}

	public List<Pessoa> listarPacientePorPessoa(Integer pessoaSq) {

		List<Pessoa> lista = dao.executeNamedQuery(
				"Pessoa.listarPacientePorPessoa", pessoaSq);

		return lista;
	}

	public List<Pessoa> listarMedicoPorPessoa(Integer pessoaSq) {

		List<Pessoa> lista = dao.executeNamedQuery(
				"Pessoa.listarMedicoPorPessoa", pessoaSq);

		return lista;
	}

	public List<Pessoa> listarPessoaPorConsultorio(Integer consultorioSq,
			Integer tipoPessoaSq) {

		List<Pessoa> lista = dao.executeNamedQuery(
				"Pessoa.listarPessoaPorConsultorio", consultorioSq,
				tipoPessoaSq);

		return lista;
	}

	public List<Pessoa> listarMedicoPorConsultorio(Integer consultorioSq) {

		return listarPessoaPorConsultorio(consultorioSq,
				Constantes.TIPO_PESSOA_MEDICO.getTipoPessoaSq());
	}

	public List<Pessoa> listarPacientePorConsultorio(Integer consultorioSq) {

		return listarPessoaPorConsultorio(consultorioSq,
				Constantes.TIPO_PESSOA_PACIENTE.getTipoPessoaSq());
	}

	public void excluir(Integer pessoaSq) {

		dao.excluir(pessoaSq);
	}

	public Pessoa incluirPessoa(Pessoa pessoa) {

		pessoa = dao.salvar(pessoa);
		return pessoa;
	}

	public Pessoa incluirMedico(Pessoa medico) {

		medico = incluirPessoa(medico);
		return medico;
	}

	public List<PessoaImagem> listarImagem(Integer pessoaSq) {

		List<PessoaImagem> lista = pessoaImagemDao.executeNamedQuery("PessoaImagem.listarImagem", pessoaSq);

		return lista;
	}
	
	public void salvarImagem(Integer pessoaSq, List<PessoaImagemMetadado> listaMetadado) {
		
		Pessoa pessoa = new Pessoa();
		pessoa.setPessoaSq(pessoaSq);

		PessoaImagem entity = new PessoaImagem();
		entity.setPessoaImagemMetadados(new ArrayList<PessoaImagemMetadado>());
		entity.setPessoa(pessoa);
		
		for (PessoaImagemMetadado metadado : listaMetadado) {
			entity.addPessoaImagemMetadado(metadado);
		}

		pessoaImagemDao.salvar(entity);

	}

}