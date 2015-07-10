package br.com.msystem.mbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.msystem.db.bo.ConsultorioBo;
import br.com.msystem.db.bo.PessoaBo;
import br.com.msystem.db.bo.TipoEnderecoBo;
import br.com.msystem.db.bo.TipoTelefoneBo;
import br.com.msystem.db.entity.Consultorio;
import br.com.msystem.db.entity.ConsultorioPessoa;
import br.com.msystem.db.entity.Endereco;
import br.com.msystem.db.entity.Pessoa;
import br.com.msystem.db.entity.Telefone;
import br.com.msystem.db.entity.TipoEndereco;
import br.com.msystem.db.entity.TipoTelefone;
import br.com.msystem.util.Constantes;

@ManagedBean
@ViewScoped
public class MedicoBean extends AbstractBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -214550466667643894L;

	@ManagedProperty("#{pessoaBo}")
	private PessoaBo bo;

	@ManagedProperty("#{consultorioBo}")
	private ConsultorioBo consultorioBo;
	
	@ManagedProperty("#{tipoTelefoneBo}")
	private TipoTelefoneBo tipoTelefoneBo;
	
	@ManagedProperty("#{tipoEnderecoBo}")
	private TipoEnderecoBo tipoEnderecoBo;

	private Pessoa medico;
	private Consultorio consultorio;
	private List<TipoEndereco> listaTipoEndereco;
	private List<TipoTelefone> listaTipoTelefone;
	private List<Pessoa> listaMedico;

	private Integer pessoaSq;

	@PostConstruct
	public void init() {
		setMedico(new Pessoa());

		pessoaSq = getSession().getUser().getUsuario().getPessoa()
				.getPessoaSq();

		atualizarListaMedico();
		
		setListaTipoEndereco(tipoEnderecoBo.listar());
		setListaTipoTelefone(tipoTelefoneBo.listar());

	}

	private void atualizarListaMedico() {

		if ((consultorio != null) && (consultorio.getConsultorioSq() != null)) {
			setListaMedico(bo.listarMedicoPorConsultorio(consultorio.getConsultorioSq()));
		} else {
			setListaMedico(new ArrayList<Pessoa>());
		}

	}

	public void editarMedicos(Consultorio consultorio) {
		
		setConsultorio(consultorio);
		
		atualizarListaMedico();
		
	}

	public void editarMedico(Pessoa medico) {

		setMedico(bo.buscar(medico.getPessoaSq()));

	}

	public void excluirMedico(Pessoa medico) {

		bo.excluir(medico.getPessoaSq());

		atualizarListaMedico();

	}

	public void incluirEndereco() {
		Endereco e = new Endereco();
		e.setPessoa(getMedico());
		getMedico().getEnderecos().add(e);
	}

	public void removerEndereco(Endereco endereco) {
		getMedico().getEnderecos().remove(endereco);
	}
	
	public void incluirTelefone() {
		Telefone e = new Telefone();
		e.setPessoa(getMedico());
		getMedico().getTelefones().add(e);
	}

	public void removerTelefone(Telefone telefone) {
		getMedico().getTelefones().remove(telefone);
	}

	public void adicionarMedico() {
		setMedico(new Pessoa());
		getMedico().setTelefones(new ArrayList<Telefone>());
		getMedico().setEnderecos(new ArrayList<Endereco>());
		getMedico().setConsultorioPessoas(new ArrayList<ConsultorioPessoa>());

	}

	public void salvarMedico() {

		ConsultorioPessoa e = new ConsultorioPessoa();
		e.setConsultorio(getConsultorio());
		e.setPessoa(getMedico());
		e.setTipoPessoa(Constantes.TIPO_PESSOA_MEDICO);
		getMedico().getConsultorioPessoas().add(e);
		
		bo.incluirMedico(getMedico());

		atualizarListaMedico();
		
	}

	public boolean medicoUsuario(Pessoa medico) {
		return (medico.getPessoaSq().equals(pessoaSq));
	}

	/**
	 * @return the bo
	 */
	public PessoaBo getBo() {
		return bo;
	}

	/**
	 * @param bo
	 *            the bo to set
	 */
	public void setBo(PessoaBo bo) {
		this.bo = bo;
	}

	/**
	 * @return the medico
	 */
	public Pessoa getMedico() {
		return medico;
	}

	/**
	 * @param medico
	 *            the medico to set
	 */
	public void setMedico(Pessoa medico) {
		this.medico = medico;
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

	/**
	 * @return the listaTipoEndereco
	 */
	public List<TipoEndereco> getListaTipoEndereco() {
		return listaTipoEndereco;
	}

	/**
	 * @param listaTipoEndereco the listaTipoEndereco to set
	 */
	public void setListaTipoEndereco(List<TipoEndereco> listaTipoEndereco) {
		this.listaTipoEndereco = listaTipoEndereco;
	}

	/**
	 * @return the listaTipoTelefone
	 */
	public List<TipoTelefone> getListaTipoTelefone() {
		return listaTipoTelefone;
	}

	/**
	 * @param listaTipoTelefone the listaTipoTelefone to set
	 */
	public void setListaTipoTelefone(List<TipoTelefone> listaTipoTelefone) {
		this.listaTipoTelefone = listaTipoTelefone;
	}

	/**
	 * @return the tipoTelefoneBo
	 */
	public TipoTelefoneBo getTipoTelefoneBo() {
		return tipoTelefoneBo;
	}

	/**
	 * @param tipoTelefoneBo the tipoTelefoneBo to set
	 */
	public void setTipoTelefoneBo(TipoTelefoneBo tipoTelefoneBo) {
		this.tipoTelefoneBo = tipoTelefoneBo;
	}

	/**
	 * @return the tipoEnderecoBo
	 */
	public TipoEnderecoBo getTipoEnderecoBo() {
		return tipoEnderecoBo;
	}

	/**
	 * @param tipoEnderecoBo the tipoEnderecoBo to set
	 */
	public void setTipoEnderecoBo(TipoEnderecoBo tipoEnderecoBo) {
		this.tipoEnderecoBo = tipoEnderecoBo;
	}

}