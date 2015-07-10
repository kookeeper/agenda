package br.com.msystem.db.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-05-29T10:00:41.534-0300")
@StaticMetamodel(TipoPessoa.class)
public class TipoPessoa_ {
	public static volatile SingularAttribute<TipoPessoa, Integer> tipoPessoaSq;
	public static volatile SingularAttribute<TipoPessoa, String> descricaoTipoPessoa;
	public static volatile ListAttribute<TipoPessoa, ConsultorioPessoa> consultorioPessoas;
}
