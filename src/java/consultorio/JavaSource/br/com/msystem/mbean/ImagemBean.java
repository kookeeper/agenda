package br.com.msystem.mbean;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import br.com.msystem.db.bo.PessoaBo;
import br.com.msystem.db.entity.PessoaImagem;
import br.com.msystem.db.entity.PessoaImagemMetadado;
import br.com.msystem.util.Constantes;

@ManagedBean
@ApplicationScoped
public class ImagemBean {

	@ManagedProperty("#{pessoaBo}")
	private PessoaBo bo;

	public StreamedContent getImagemByPath() throws FileNotFoundException {

		FacesContext ctx = FacesContext.getCurrentInstance();

		DefaultStreamedContent imagem = null;
		if (ctx.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
			// So, we're rendering the view. Return a stub StreamedContent so
			// that it will generate right URL.
			imagem = new DefaultStreamedContent();
		} else {

			Map<String, String> map = ctx.getExternalContext()
					.getRequestParameterMap();

			String fileName = map.get("fileName");

			if (fileName != null && !fileName.trim().equals("")) {
				
				imagem = new DefaultStreamedContent(new FileInputStream(
						new File(Constantes.TEMP_DIR, fileName)));
			}
		}

		return imagem;
	}

	public StreamedContent getImagem() throws FileNotFoundException {

		FacesContext ctx = FacesContext.getCurrentInstance();

		DefaultStreamedContent imagem = null;
		if (ctx.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
			// So, we're rendering the view. Return a stub StreamedContent so
			// that it will generate right URL.
			imagem = new DefaultStreamedContent();
		} else {

			Map<String, String> map = ctx.getExternalContext()
					.getRequestParameterMap();

			System.out.println(map.size());
			System.out.println(map.get("pessoaSq"));

			String id = map.get("pessoaSq");

			if (id != null && !id.trim().equals("")) {

				Integer pessoaSq = Integer.parseInt(id);

				List<PessoaImagem> listaImagem = bo.listarImagem(pessoaSq);

				if (listaImagem != null && listaImagem.size() > 0) {

					String nomeArquivo = null;

					for (PessoaImagemMetadado metadado : listaImagem.get(0)
							.getPessoaImagemMetadados()) {
						if (metadado.getChave().equals(
								Constantes.METADADO_NOME_ARQUIVO)) {
							nomeArquivo = metadado.getValor();
						}
					}

					if (nomeArquivo != null) {

						FileInputStream stream = new FileInputStream(new File(
								Constantes.TEMP_DIR, nomeArquivo));

						imagem = new DefaultStreamedContent(stream);
					}

				}
			}
		}

		return imagem;
	}

	public PessoaBo getBo() {

		return bo;
	}

	public void setBo(PessoaBo bo) {

		this.bo = bo;
	}

}
