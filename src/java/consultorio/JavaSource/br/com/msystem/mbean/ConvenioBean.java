package br.com.msystem.mbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.msystem.db.bo.AbstractBo;
import br.com.msystem.db.entity.Consultorio;
import br.com.msystem.db.entity.Convenio;

@ManagedBean
@ViewScoped
public class ConvenioBean extends AbstractBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2395131619800990147L;

	@ManagedProperty("#{convenioBo}")
	private AbstractBo<Convenio> bo;

	private Consultorio consultorio;
	private Convenio convenio;
	private List<Convenio> listaConvenio;

	@PostConstruct
	public void init() {

	}

	public void listarConvenio(Consultorio consultorio) {

		setConsultorio(consultorio);
		
		setListaConvenio(bo.executeNamedQuery(
				"Convenio.listarConvenioPorConsultorio",
				getConsultorio().getConsultorioSq()));

	}

	public void editarConvenio(Convenio convenio) {

		setConvenio(convenio);
	}

	public void excluirConvenio(Convenio convenio) {

		bo.excluir(convenio.getConvenioSq());
		
		listarConvenio(getConsultorio());

	}

	public void adicionarConvenio() {

		setConvenio(new Convenio());
		getConvenio().setConsultorio(getConsultorio());
	}
	
	public void salvarConvenio() {
		
		bo.salvar(getConvenio());
		
		listarConvenio(getConsultorio());

	}

	/**
	 * @return the bo
	 */
	public AbstractBo<Convenio> getBo() {
	
		return bo;
	}

	/**
	 * @param bo the bo to set
	 */
	public void setBo(AbstractBo<Convenio> bo) {
	
		this.bo = bo;
	}

	/**
	 * @return the listaConvenio
	 */
	public List<Convenio> getListaConvenio() {
	
		return listaConvenio;
	}

	/**
	 * @param listaConvenio the listaConvenio to set
	 */
	public void setListaConvenio(List<Convenio> listaConvenio) {
	
		this.listaConvenio = listaConvenio;
	}

	/**
	 * @return the convenio
	 */
	public Convenio getConvenio() {
	
		return convenio;
	}

	/**
	 * @param convenio the convenio to set
	 */
	public void setConvenio(Convenio convenio) {
	
		this.convenio = convenio;
	}

	/**
	 * @return the consultorio
	 */
	public Consultorio getConsultorio() {
	
		return consultorio;
	}

	/**
	 * @param consultorio the consultorio to set
	 */
	public void setConsultorio(Consultorio consultorio) {
	
		this.consultorio = consultorio;
	}


}