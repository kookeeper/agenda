package br.com.msystem.db.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-05-29T10:00:41.526-0300")
@StaticMetamodel(PessoaImagem.class)
public class PessoaImagem_ {
	public static volatile SingularAttribute<PessoaImagem, Integer> pessoaImagemSq;
	public static volatile SingularAttribute<PessoaImagem, Pessoa> pessoa;
	public static volatile ListAttribute<PessoaImagem, PessoaImagemMetadado> pessoaImagemMetadados;
}
