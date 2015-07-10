package br.com.msystem.util;

import java.io.File;

import br.com.msystem.db.entity.TipoPessoa;


public class Constantes {

	public static final TipoPessoa TIPO_PESSOA_MEDICO = criarTipoPessoa(1);
	public static final TipoPessoa TIPO_PESSOA_PACIENTE = criarTipoPessoa(2);
	
	public static final String METADADO_NOME_ARQUIVO = "nome";
	public static final String METADADO_TAMANHO_ARQUIVO = "tamanho";
	public static final String METADADO_DESCRICAO_ARQUIVO = "descricao";
	public static final String METADADO_TIPO_ARQUIVO = "tipo";
	public static final String METADADO_TIPO_ARQUIVO_PDF = "pdf";
	public static final String METADADO_TIPO_ARQUIVO_IMAGEM = "imagem";
	public static final String METADADO_TIPO_ARQUIVO_DOC = "doc";
	
	public static final File TEMP_DIR = new File("/tmp");

	public static TipoPessoa criarTipoPessoa(Integer id) {
		TipoPessoa tipoPessoa = new TipoPessoa();
		tipoPessoa.setTipoPessoaSq(id);
		return tipoPessoa;
	}

}
