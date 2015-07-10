package br.com.msystem.mbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.msystem.db.bo.PessoaBo;
import br.com.msystem.db.bo.TipoEnderecoBo;
import br.com.msystem.db.bo.TipoTelefoneBo;
import br.com.msystem.db.entity.Endereco;
import br.com.msystem.db.entity.Pessoa;
import br.com.msystem.db.entity.Telefone;
import br.com.msystem.db.entity.TipoEndereco;
import br.com.msystem.db.entity.TipoTelefone;

@ManagedBean
@ViewScoped
public class PacienteBean extends AbstractBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8267659686435288213L;

	@ManagedProperty("#{pessoaBo}")
	private PessoaBo bo;

	@ManagedProperty("#{tipoTelefoneBo}")
	private TipoTelefoneBo tipoTelefoneBo;
	
	@ManagedProperty("#{tipoEnderecoBo}")
	private TipoEnderecoBo tipoEnderecoBo;

	private Pessoa paciente;
	private List<TipoEndereco> listaTipoEndereco;
	private List<TipoTelefone> listaTipoTelefone;
	private List<Pessoa> listaPaciente;

	private Integer pessoaSq;

	@PostConstruct
	public void init() {
		setPaciente(new Pessoa());

		pessoaSq = getSession().getUser().getUsuario().getPessoa()
				.getPessoaSq();

		setListaPaciente(bo.listarPacientePorPessoa(pessoaSq));
		
		setListaTipoEndereco(tipoEnderecoBo.listar());
		setListaTipoTelefone(tipoTelefoneBo.listar());

	}

	public void editarPaciente(Pessoa paciente) {
		setPaciente(bo.buscar(paciente.getPessoaSq()));
	}

	public void excluirPaciente(Pessoa paciente) {

		bo.excluir(paciente.getPessoaSq());

		setListaPaciente(bo.listarPacientePorPessoa(pessoaSq));

	}

	public void incluirEndereco() {
		Endereco e = new Endereco();
		e.setPessoa(getPaciente());
		getPaciente().getEnderecos().add(e);
	}

	public void removerEndereco(Endereco endereco) {
		getPaciente().getEnderecos().remove(endereco);
	}
	
	public void incluirTelefone() {
		Telefone e = new Telefone();
		e.setPessoa(getPaciente());
		getPaciente().getTelefones().add(e);
	}

	public void removerTelefone(Telefone telefone) {
		getPaciente().getTelefones().remove(telefone);
	}

	public void adicionarPaciente() {

		setPaciente(new Pessoa());
		getPaciente().setTelefones(new ArrayList<Telefone>());
		getPaciente().setEnderecos(new ArrayList<Endereco>());

	}

	public void salvarPaciente() {
		bo.incluirPessoa(getPaciente());

		setListaPaciente(bo.listarPacientePorPessoa(pessoaSq));
		
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

	/**
	 * @return the paciente
	 */
	public Pessoa getPaciente() {
		return paciente;
	}

	/**
	 * @param paciente the paciente to set
	 */
	public void setPaciente(Pessoa paciente) {
		this.paciente = paciente;
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
	 * @return the listaPaciente
	 */
	public List<Pessoa> getListaPaciente() {
		return listaPaciente;
	}

	/**
	 * @param listaPaciente the listaPaciente to set
	 */
	public void setListaPaciente(List<Pessoa> listaPaciente) {
		this.listaPaciente = listaPaciente;
	}

	/**
	 * @return the pessoaSq
	 */
	public Integer getPessoaSq() {
		return pessoaSq;
	}

	/**
	 * @param pessoaSq the pessoaSq to set
	 */
	public void setPessoaSq(Integer pessoaSq) {
		this.pessoaSq = pessoaSq;
	}

}