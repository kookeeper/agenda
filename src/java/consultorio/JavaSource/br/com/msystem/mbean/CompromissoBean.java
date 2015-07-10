package br.com.msystem.mbean;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.springframework.util.StringUtils;

import br.com.msystem.db.bo.AbstractBo;
import br.com.msystem.db.bo.CompromissoBo;
import br.com.msystem.db.bo.ConsultorioBo;
import br.com.msystem.db.bo.PessoaBo;
import br.com.msystem.db.entity.Compromisso;
import br.com.msystem.db.entity.Consultorio;
import br.com.msystem.db.entity.Convenio;
import br.com.msystem.db.entity.Observacao;
import br.com.msystem.db.entity.Pessoa;
import br.com.msystem.db.entity.TipoCompromisso;

@ManagedBean
@ViewScoped
public class CompromissoBean extends AbstractBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3078674927980618261L;

	@ManagedProperty("#{compromissoBo}")
	private CompromissoBo bo;

	@ManagedProperty("#{consultorioBo}")
	private ConsultorioBo consultorioBo;

	@ManagedProperty("#{pessoaBo}")
	private PessoaBo pessoaBo;

	@ManagedProperty("#{tipoCompromissoBo}")
	private AbstractBo<TipoCompromisso> tipoCompromissoBo;

	@ManagedProperty("#{convenioBo}")
	private AbstractBo<Convenio> convenioBo;

	private Compromisso compromissoSelecionado = new Compromisso();
	private List<Compromisso> listaCompromisso;

	private Date dataCalendario;
	private String novaObservacao;
	private List<Observacao> listaObservacao;

	private Consultorio consultorioSelecionado;
	private List<Consultorio> listaConsultorio;

	private Pessoa medicoSelecionado;
	private List<Pessoa> listaMedico;

	private List<Pessoa> listaPaciente;
	private List<TipoCompromisso> listaTipoCompromisso;
	private List<Convenio> listaConvenio;

	private Integer pessoaSq;

	@PostConstruct
	public void init() {

		pessoaSq = getSession().getUser().getUsuario().getPessoa()
				.getPessoaSq();

		setListaConsultorio(consultorioBo.listar(getPessoaSq()));
		setListaMedico(new ArrayList<Pessoa>());
		setListaPaciente(new ArrayList<Pessoa>());
		setListaCompromisso(new ArrayList<Compromisso>());
		setListaTipoCompromisso(tipoCompromissoBo.listAll());

		if (getListaConsultorio().size() > 0) {
			setConsultorioSelecionado(getListaConsultorio().get(0));
			atualizarListaPessoa();

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			try {
				setDataCalendario(sdf.parse(sdf.format(new Date())));
			} catch (ParseException e) {
				setDataCalendario(null);
			}
			selecionarData();
		}

	}

	public boolean verificaNovoCompromisso() {

		return false;
	}

	public void atualizarListaPessoa() {

		setListaMedico(pessoaBo
				.listarMedicoPorConsultorio(getConsultorioSelecionado()
						.getConsultorioSq()));
		setMedicoSelecionado(getListaMedico().get(0));

		setListaPaciente(pessoaBo
				.listarPacientePorConsultorio(getConsultorioSelecionado()
						.getConsultorioSq()));

	}

	public void selecionarData() {

		if (getMedicoSelecionado() != null) {
			listaCompromisso.clear();
			listaCompromisso.addAll(bo.listarCompromissoPorMedico(
					getMedicoSelecionado().getPessoaSq(), getDataCalendario()));
		}

	}

	public void onRowSelect(SelectEvent event) {

		setCompromissoSelecionado((Compromisso) event.getObject());

		Pessoa paciente = getCompromissoSelecionado().getPessoaPaciente();

		setListaObservacao(bo.listarObservacao(paciente));

	}

	public void onRowUnselect(UnselectEvent event) {

		setCompromissoSelecionado(new Compromisso());
	}

	public boolean editandoCompromisso() {

		if (getCompromissoSelecionado() == null) {
			return false;
		}

		return !StringUtils.isEmpty(getCompromissoSelecionado()
				.getCompromissoSq());

	}

	public void editarCompromisso(Integer compromissoSq) {

		if (compromissoSq == 0) {
			
			Compromisso e = new Compromisso();
			e.setPessoaMedico(getMedicoSelecionado());
			e.setDataCompromisso(new Timestamp(getDataCalendario().getTime()));

			setCompromissoSelecionado(e);

		} else {
			
			setCompromissoSelecionado(bo.buscar(compromissoSq));

		}
		
		setListaConvenio(convenioBo.executeNamedQuery("Convenio.listarConvenioPorConsultorio", getConsultorioSelecionado().getConsultorioSq()));

		setNovaObservacao("");
	}

	public void salvarCompromisso() {

		bo.salvar(getCompromissoSelecionado(), getNovaObservacao());
	}
	
	public void atualizaValorCobrado() {
		
		getCompromissoSelecionado().setValorCobrado(getCompromissoSelecionado().getConvenio().getValorBase());
		
	}

	/**
	 * @return the bo
	 */
	public CompromissoBo getBo() {

		return bo;
	}

	/**
	 * @param bo
	 *            the bo to set
	 */
	public void setBo(CompromissoBo bo) {

		this.bo = bo;
	}

	/**
	 * @return the consultorioBo
	 */
	public ConsultorioBo getConsultorioBo() {

		return consultorioBo;
	}

	/**
	 * @param consultorioBo
	 *            the consultorioBo to set
	 */
	public void setConsultorioBo(ConsultorioBo consultorioBo) {

		this.consultorioBo = consultorioBo;
	}

	/**
	 * @return the pessoaBo
	 */
	public PessoaBo getPessoaBo() {

		return pessoaBo;
	}

	/**
	 * @param pessoaBo
	 *            the pessoaBo to set
	 */
	public void setPessoaBo(PessoaBo pessoaBo) {

		this.pessoaBo = pessoaBo;
	}

	/**
	 * @return the tipoCompromissoBo
	 */
	public AbstractBo<TipoCompromisso> getTipoCompromissoBo() {

		return tipoCompromissoBo;
	}

	/**
	 * @param tipoCompromissoBo
	 *            the tipoCompromissoBo to set
	 */
	public void setTipoCompromissoBo(
			AbstractBo<TipoCompromisso> tipoCompromissoBo) {

		this.tipoCompromissoBo = tipoCompromissoBo;
	}

	/**
	 * @return the convenioBo
	 */
	public AbstractBo<Convenio> getConvenioBo() {

		return convenioBo;
	}

	/**
	 * @param convenioBo
	 *            the convenioBo to set
	 */
	public void setConvenioBo(AbstractBo<Convenio> convenioBo) {

		this.convenioBo = convenioBo;
	}

	/**
	 * @return the compromissoSelecionado
	 */
	public Compromisso getCompromissoSelecionado() {

		return compromissoSelecionado;
	}

	/**
	 * @param compromissoSelecionado
	 *            the compromissoSelecionado to set
	 */
	public void setCompromissoSelecionado(Compromisso compromissoSelecionado) {

		this.compromissoSelecionado = compromissoSelecionado;
	}

	/**
	 * @return the listaCompromisso
	 */
	public List<Compromisso> getListaCompromisso() {

		return listaCompromisso;
	}

	/**
	 * @param listaCompromisso
	 *            the listaCompromisso to set
	 */
	public void setListaCompromisso(List<Compromisso> listaCompromisso) {

		this.listaCompromisso = listaCompromisso;
	}

	/**
	 * @return the dataCalendario
	 */
	public Date getDataCalendario() {

		return dataCalendario;
	}

	/**
	 * @param dataCalendario
	 *            the dataCalendario to set
	 */
	public void setDataCalendario(Date dataCalendario) {

		this.dataCalendario = dataCalendario;
	}

	/**
	 * @return the novaObservacao
	 */
	public String getNovaObservacao() {

		return novaObservacao;
	}

	/**
	 * @param novaObservacao
	 *            the novaObservacao to set
	 */
	public void setNovaObservacao(String novaObservacao) {

		this.novaObservacao = novaObservacao;
	}

	/**
	 * @return the listaObservacao
	 */
	public List<Observacao> getListaObservacao() {

		return listaObservacao;
	}

	/**
	 * @param listaObservacao
	 *            the listaObservacao to set
	 */
	public void setListaObservacao(List<Observacao> listaObservacao) {

		this.listaObservacao = listaObservacao;
	}

	/**
	 * @return the consultorioSelecionado
	 */
	public Consultorio getConsultorioSelecionado() {

		return consultorioSelecionado;
	}

	/**
	 * @param consultorioSelecionado
	 *            the consultorioSelecionado to set
	 */
	public void setConsultorioSelecionado(Consultorio consultorioSelecionado) {

		this.consultorioSelecionado = consultorioSelecionado;
	}

	/**
	 * @return the listaConsultorio
	 */
	public List<Consultorio> getListaConsultorio() {

		return listaConsultorio;
	}

	/**
	 * @param listaConsultorio
	 *            the listaConsultorio to set
	 */
	public void setListaConsultorio(List<Consultorio> listaConsultorio) {

		this.listaConsultorio = listaConsultorio;
	}

	/**
	 * @return the medicoSelecionado
	 */
	public Pessoa getMedicoSelecionado() {

		return medicoSelecionado;
	}

	/**
	 * @param medicoSelecionado
	 *            the medicoSelecionado to set
	 */
	public void setMedicoSelecionado(Pessoa medicoSelecionado) {

		this.medicoSelecionado = medicoSelecionado;
	}

	/**
	 * @return the listaMedico
	 */
	public List<Pessoa> getListaMedico() {

		return listaMedico;
	}

	/**
	 * @param listaMedico
	 *            the listaMedico to set
	 */
	public void setListaMedico(List<Pessoa> listaMedico) {

		this.listaMedico = listaMedico;
	}

	/**
	 * @return the listaPaciente
	 */
	public List<Pessoa> getListaPaciente() {

		return listaPaciente;
	}

	/**
	 * @param listaPaciente
	 *            the listaPaciente to set
	 */
	public void setListaPaciente(List<Pessoa> listaPaciente) {

		this.listaPaciente = listaPaciente;
	}

	/**
	 * @return the listaTipoCompromisso
	 */
	public List<TipoCompromisso> getListaTipoCompromisso() {

		return listaTipoCompromisso;
	}

	/**
	 * @param listaTipoCompromisso
	 *            the listaTipoCompromisso to set
	 */
	public void setListaTipoCompromisso(
			List<TipoCompromisso> listaTipoCompromisso) {

		this.listaTipoCompromisso = listaTipoCompromisso;
	}

	/**
	 * @return the listaConvenio
	 */
	public List<Convenio> getListaConvenio() {

		return listaConvenio;
	}

	/**
	 * @param listaConvenio
	 *            the listaConvenio to set
	 */
	public void setListaConvenio(List<Convenio> listaConvenio) {

		this.listaConvenio = listaConvenio;
	}

	/**
	 * @return the pessoaSq
	 */
	public Integer getPessoaSq() {

		return pessoaSq;
	}

	/**
	 * @param pessoaSq
	 *            the pessoaSq to set
	 */
	public void setPessoaSq(Integer pessoaSq) {

		this.pessoaSq = pessoaSq;
	}

}