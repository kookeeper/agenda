package br.com.msystem.db.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-05-29T10:00:41.519-0300")
@StaticMetamodel(ConsultorioPessoa.class)
public class ConsultorioPessoa_ {
	public static volatile SingularAttribute<ConsultorioPessoa, Integer> consultorioPessoaSq;
	public static volatile SingularAttribute<ConsultorioPessoa, Consultorio> consultorio;
	public static volatile SingularAttribute<ConsultorioPessoa, Pessoa> pessoa;
	public static volatile SingularAttribute<ConsultorioPessoa, TipoPessoa> tipoPessoa;
}
