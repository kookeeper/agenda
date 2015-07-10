package br.com.msystem.mbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.msystem.db.bo.ConsultorioBo;
import br.com.msystem.db.entity.Consultorio;
import br.com.msystem.db.entity.ConsultorioPessoa;
import br.com.msystem.util.Constantes;

@ManagedBean
@ViewScoped
public class ConsultorioBean extends AbstractBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -891997996012715399L;

	@ManagedProperty("#{consultorioBo}")
	private ConsultorioBo bo;

	private Consultorio consultorio;
	private List<Consultorio> listaConsultorio;

	@PostConstruct
	public void init() {
		setConsultorio(new Consultorio());
		
		setListaConsultorio(bo.listar(getSession().getUser().getUsuario().getPessoa().getPessoaSq()));

	}

	public void editarConsultorio(Consultorio consultorio) {
		setConsultorio(consultorio);
	}

	public void excluirConsultorio(Consultorio consultorio) {
		
		bo.excluir(consultorio.getConsultorioSq());

		getListaConsultorio().remove(consultorio);
	}

	public void adicionarConsultorio() {
		setConsultorio(new Consultorio());
		getConsultorio().setConsultorioPessoas(new ArrayList<ConsultorioPessoa>());
	}

	public void salvarConsultorio() {

		ConsultorioPessoa e = new ConsultorioPessoa();
		e.setConsultorio(getConsultorio());
		e.setPessoa(getSession().getUser().getUsuario().getPessoa());
		e.setTipoPessoa(Constantes.TIPO_PESSOA_MEDICO);
		getConsultorio().getConsultorioPessoas().add(e );
		bo.incluirConsultorio(getConsultorio());
		
		setListaConsultorio(bo.listar(getSession().getUser().getUsuario().getPessoa().getPessoaSq()));

	}

	/**
	 * @return the listaConsultorio
	 */
	public List<Consultorio> getListaConsultorio() {
		return listaConsultorio;
	}

	/**
	 * @param listaConsultorio the listaConsultorio to set
	 */
	public void setListaConsultorio(List<Consultorio> listaConsultorio) {
		this.listaConsultorio = listaConsultorio;
	}

	/**
	 * @return the consultorio
	 */
	public Consultorio getConsultorio() {
		return consultorio;
	}

	/**
	 * @param consultorio
	 *            the consultorio to set
	 */
	public void setConsultorio(Consultorio consultorio) {
		this.consultorio = consultorio;
	}

	/**
	 * @return the bo
	 */
	public ConsultorioBo getBo() {
		return bo;
	}

	/**
	 * @param bo the bo to set
	 */
	public void setBo(ConsultorioBo bo) {
		this.bo = bo;
	}

}