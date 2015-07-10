package br.com.msystem.mbean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import br.com.msystem.db.bo.ConsultorioBo;
import br.com.msystem.db.bo.PessoaBo;
import br.com.msystem.db.bo.TipoEnderecoBo;
import br.com.msystem.db.bo.TipoTelefoneBo;
import br.com.msystem.db.bo.UsuarioBo;
import br.com.msystem.db.entity.Consultorio;
import br.com.msystem.db.entity.ConsultorioPessoa;
import br.com.msystem.db.entity.Endereco;
import br.com.msystem.db.entity.Pessoa;
import br.com.msystem.db.entity.PessoaImagem;
import br.com.msystem.db.entity.PessoaImagemMetadado;
import br.com.msystem.db.entity.Telefone;
import br.com.msystem.db.entity.TipoEndereco;
import br.com.msystem.db.entity.TipoPessoa;
import br.com.msystem.db.entity.TipoTelefone;
import br.com.msystem.db.entity.Usuario;
import br.com.msystem.util.Constantes;
import br.com.msystem.util.FileUtil;

@ManagedBean
@ViewScoped
public class PessoaBean extends AbstractBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -214550466667643894L;

	@ManagedProperty("#{pessoaBo}")
	private PessoaBo bo;

	@ManagedProperty("#{usuarioBo}")
	private UsuarioBo usuarioBo;

	@ManagedProperty("#{consultorioBo}")
	private ConsultorioBo consultorioBo;

	@ManagedProperty("#{tipoTelefoneBo}")
	private TipoTelefoneBo tipoTelefoneBo;

	@ManagedProperty("#{tipoEnderecoBo}")
	private TipoEnderecoBo tipoEnderecoBo;

	private TipoPessoa tipoPessoa;
	private Pessoa pessoa;
	private Consultorio consultorio;
	private List<TipoEndereco> listaTipoEndereco;
	private List<TipoTelefone> listaTipoTelefone;
	private List<Pessoa> listaPessoa;
	private String tituloLista = "Editar Medicos";
	private String tituloEditar = "Editar Medico";
	private String novoUsuario;
	private Integer usuarioPessoaSq;
	private List<String> listaImagemUpload;

	@PostConstruct
	public void init() {

		setPessoa(new Pessoa());

		usuarioPessoaSq = getSession().getUser().getUsuario().getPessoa()
				.getPessoaSq();

		atualizarListaPessoa();

		setListaTipoEndereco(tipoEnderecoBo.listar());
		setListaTipoTelefone(tipoTelefoneBo.listar());

	}

	public void setEscolherTipoPessoa(Integer tipoPessoaSq) {

		setTipoPessoa(Constantes.criarTipoPessoa(tipoPessoaSq));

		setTituloEditar("Editar "
				+ (tipoPessoaSq.equals(Constantes.TIPO_PESSOA_MEDICO
						.getTipoPessoaSq()) ? "Medico" : "Paciente"));
		setTituloLista("Editar "
				+ (tipoPessoaSq.equals(Constantes.TIPO_PESSOA_MEDICO
						.getTipoPessoaSq()) ? "Medicos" : "Pacientes"));

	}

	private void atualizarListaPessoa() {

		if ((consultorio != null) && (consultorio.getConsultorioSq() != null)) {
			setListaPessoa(bo.listarPessoaPorConsultorio(consultorio
					.getConsultorioSq(), getTipoPessoa().getTipoPessoaSq()));
		} else {
			setListaPessoa(new ArrayList<Pessoa>());
		}

	}

	public void editarPessoas(Consultorio consultorio) {

		setConsultorio(consultorio);

		atualizarListaPessoa();

	}

	public void editarPessoa(Pessoa pessoa) throws IOException {

		setListaImagemUpload(new ArrayList<String>());

		if (pessoa == null) {

			setPessoa(new Pessoa());
			getPessoa().setTelefones(new ArrayList<Telefone>());
			getPessoa().setEnderecos(new ArrayList<Endereco>());
			getPessoa().setConsultorioPessoas(
					new ArrayList<ConsultorioPessoa>());

		} else {
			setPessoa(bo.buscar(pessoa.getPessoaSq()));
			// lazy init
			getPessoa().getConsultorioPessoas().size();

			for (PessoaImagem pessoaImagem : getPessoa().getPessoaImagems()) {
				for (PessoaImagemMetadado metadado : pessoaImagem
						.getPessoaImagemMetadados()) {
					if (metadado.getChave().equals(
							Constantes.METADADO_NOME_ARQUIVO)) {
						getListaImagemUpload().add(metadado.getValor());
					}
				}
			}
		}

	}

	public void excluirPessoa(Pessoa pessoa) {

		bo.excluir(pessoa.getPessoaSq());

		atualizarListaPessoa();

	}

	public void incluirEndereco() {

		Endereco e = new Endereco();
		e.setPessoa(getPessoa());
		getPessoa().getEnderecos().add(e);
	}

	public void removerEndereco(Endereco endereco) {

		getPessoa().getEnderecos().remove(endereco);
	}

	public void incluirTelefone() {

		Telefone e = new Telefone();
		e.setPessoa(getPessoa());
		getPessoa().getTelefones().add(e);
	}

	public void removerTelefone(Telefone telefone) {

		getPessoa().getTelefones().remove(telefone);
	}

	public void adicionarPessoa() throws IOException {

		editarPessoa(null);

	}

	public void salvarPessoa() throws IOException {

		//inclui vinculo da pessoa com o usuario
		if (getNovoUsuario() != null && !getNovoUsuario().trim().equals("")) {

			Usuario usuario = usuarioBo.pesquisarLogin(getNovoUsuario());

			if (usuario == null) {
				usuario = new Usuario();
				usuario.setLogin(getNovoUsuario());
				usuario.setSenha(getNovoUsuario());
				usuario.setPessoa(getPessoa());
			}

			if (getPessoa().getUsuarios() == null) {
				getPessoa().setUsuarios(new ArrayList<Usuario>());
			}

			getPessoa().getUsuarios().add(usuario);

		}

		//inclui vinculo da pessoa com o consultorio
		if (getPessoa().getPessoaSq() == null) {
			ConsultorioPessoa e = new ConsultorioPessoa();
			e.setConsultorio(getConsultorio());
			e.setPessoa(getPessoa());
			e.setTipoPessoa(getTipoPessoa());
			getPessoa().getConsultorioPessoas().add(e);
		}

		//incluir imagens da pessoa
		for (String imagemUpload : listaImagemUpload) {

			//verifica se a imagem já esta armazenada
			if (buscarPessoaImagem(imagemUpload) != null) {
				continue;
			}
			
			String fileName = FileUtil.efetivarArquivoTemporario(imagemUpload,
					getPessoa().getPessoaSq());

			PessoaImagemMetadado metadado = criarImagemMetadado(
					Constantes.METADADO_NOME_ARQUIVO, fileName);
			
			PessoaImagem pessoaImagem = new PessoaImagem();
			pessoaImagem.setPessoaImagemMetadados(new ArrayList<PessoaImagemMetadado>());
			pessoaImagem.addPessoaImagemMetadado(metadado);

			getPessoa().addPessoaImagem(pessoaImagem);
		}

		setPessoa(bo.incluirPessoa(getPessoa()));

		atualizarListaPessoa();

	}

	private PessoaImagem buscarPessoaImagem(String fileName) {

		for (PessoaImagem pessoaImagem : getPessoa().getPessoaImagems()) {
			for (PessoaImagemMetadado metadado : pessoaImagem.getPessoaImagemMetadados()) {
				if ((metadado.getChave().equals(Constantes.METADADO_NOME_ARQUIVO)) && (metadado.getValor().equals(fileName))) {
					return pessoaImagem;
				}
			}
		}

		return null;
		
	}

	private PessoaImagemMetadado criarImagemMetadado(String chave, String valor) {

		PessoaImagemMetadado bean = new PessoaImagemMetadado();
		bean.setChave(chave);
		bean.setValor(valor);

		return bean;
	}

	public boolean pessoaUsuario(Pessoa pessoa) {

		return (pessoa.getPessoaSq().equals(getUsuarioPessoaSq()));
	}

	public void uploadImagem(FileUploadEvent event) throws IOException {

		UploadedFile file = event.getFile();

		FileOutputStream out = new FileOutputStream(new File(
				Constantes.TEMP_DIR, file.getFileName()));
		byte[] bytes = new byte[file.getInputstream().available()];

		
		file.getInputstream().read(bytes);

		out.write(bytes);
		out.flush();
		out.close();

		listaImagemUpload.add(file.getFileName());

	}

	public void removerImagem() {

		Map<String, String> map = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap();

		String fileName = map.get("fileName");

		for (String imagemUpload : listaImagemUpload) {
			if (imagemUpload.equals(fileName)) {
				listaImagemUpload.remove(imagemUpload);
				break;
			}
		}
		
		getPessoa().getPessoaImagems().remove(buscarPessoaImagem(fileName));
		
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
	 * @return the pessoa
	 */
	public Pessoa getPessoa() {

		return pessoa;
	}

	/**
	 * @param pessoa
	 *            the pessoa to set
	 */
	public void setPessoa(Pessoa pessoa) {

		this.pessoa = pessoa;
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
	 * @return the tipoTelefoneBo
	 */
	public TipoTelefoneBo getTipoTelefoneBo() {

		return tipoTelefoneBo;
	}

	/**
	 * @param tipoTelefoneBo
	 *            the tipoTelefoneBo to set
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
	 * @param tipoEnderecoBo
	 *            the tipoEnderecoBo to set
	 */
	public void setTipoEnderecoBo(TipoEnderecoBo tipoEnderecoBo) {

		this.tipoEnderecoBo = tipoEnderecoBo;
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
	 * @return the listaTipoEndereco
	 */
	public List<TipoEndereco> getListaTipoEndereco() {

		return listaTipoEndereco;
	}

	/**
	 * @param listaTipoEndereco
	 *            the listaTipoEndereco to set
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
	 * @param listaTipoTelefone
	 *            the listaTipoTelefone to set
	 */
	public void setListaTipoTelefone(List<TipoTelefone> listaTipoTelefone) {

		this.listaTipoTelefone = listaTipoTelefone;
	}

	/**
	 * @return the listaPessoa
	 */
	public List<Pessoa> getListaPessoa() {

		return listaPessoa;
	}

	/**
	 * @param listaPessoa
	 *            the listaPessoa to set
	 */
	public void setListaPessoa(List<Pessoa> listaPessoa) {

		this.listaPessoa = listaPessoa;
	}

	public Integer getUsuarioPessoaSq() {

		return usuarioPessoaSq;
	}

	public void setUsuarioPessoaSq(Integer usuarioPessoaSq) {

		this.usuarioPessoaSq = usuarioPessoaSq;
	}

	/**
	 * @return the tipoPessoa
	 */
	public TipoPessoa getTipoPessoa() {

		return tipoPessoa;
	}

	/**
	 * @param tipoPessoa
	 *            the tipoPessoa to set
	 */
	public void setTipoPessoa(TipoPessoa tipoPessoa) {

		this.tipoPessoa = tipoPessoa;
	}

	/**
	 * @return the tituloLista
	 */
	public String getTituloLista() {

		return tituloLista;
	}

	/**
	 * @param tituloLista
	 *            the tituloLista to set
	 */
	public void setTituloLista(String tituloLista) {

		this.tituloLista = tituloLista;
	}

	/**
	 * @return the tituloEditar
	 */
	public String getTituloEditar() {

		return tituloEditar;
	}

	/**
	 * @param tituloEditar
	 *            the tituloEditar to set
	 */
	public void setTituloEditar(String tituloEditar) {

		this.tituloEditar = tituloEditar;
	}

	public String getNovoUsuario() {

		return novoUsuario;
	}

	public void setNovoUsuario(String novoUsuario) {

		this.novoUsuario = novoUsuario;
	}

	public UsuarioBo getUsuarioBo() {

		return usuarioBo;
	}

	public void setUsuarioBo(UsuarioBo usuarioBo) {

		this.usuarioBo = usuarioBo;
	}

	public List<String> getListaImagemUpload() {

		return listaImagemUpload;
	}

	public void setListaImagemUpload(List<String> listaImagemUpload) {

		this.listaImagemUpload = listaImagemUpload;
	}

}