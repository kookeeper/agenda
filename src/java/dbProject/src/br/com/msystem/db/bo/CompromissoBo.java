package br.com.msystem.db.bo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import br.com.msystem.db.dao.InterfaceDao;
import br.com.msystem.db.entity.Compromisso;
import br.com.msystem.db.entity.Observacao;
import br.com.msystem.db.entity.Pessoa;

@Service
@Transactional
public class CompromissoBo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -326672850241335636L;

	@Autowired
	private InterfaceDao<Compromisso> dao;

	@Autowired
	private InterfaceDao<Observacao> observacaoDao;

	public Compromisso buscar(Integer compromissoSq) {
		return dao.buscar(compromissoSq);
	}

	public List<Compromisso> listarCompromissoPorMedico(Integer pessoaSq,
			Date dataCalendario) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(dataCalendario);
		cal.set(Calendar.HOUR, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);

		Date dataCalendarioFim = cal.getTime();

		List<Compromisso> listaCompromisso = dao.executeNamedQuery(
				"Compromisso.listarCompromissoPorMedico", pessoaSq,
				dataCalendario, dataCalendarioFim);

		return listaCompromisso;

	}

	public Compromisso salvar(Compromisso entity, String observacao) {

		if (entity.getDataCadastro() == null) {
			entity.setDataCadastro(new Timestamp(new Date().getTime()));
		}

		if (!StringUtils.isEmpty(observacao)) {
			if (entity.getObservacaos() == null) {
				entity.setObservacaos(new ArrayList<Observacao>());
			}

			Observacao observacaoEntity = new Observacao();
			observacaoEntity.setObservacao(observacao);
			entity.addObservacao(observacaoEntity);
		}

		entity = dao.salvar(entity);

		return entity;

	}

	public List<Observacao> listarObservacao(Pessoa paciente) {

		List<Observacao> listaObservacao = observacaoDao.executeNamedQuery(
				"Pessoa.listarObservacao", paciente.getPessoaSq());

		return listaObservacao;

	}

}