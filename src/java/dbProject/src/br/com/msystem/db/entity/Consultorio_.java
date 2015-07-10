package br.com.msystem.db.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-05-29T11:10:07.665-0300")
@StaticMetamodel(Consultorio.class)
public class Consultorio_ {
	public static volatile SingularAttribute<Consultorio, Integer> consultorioSq;
	public static volatile SingularAttribute<Consultorio, String> cnpjConsultorio;
	public static volatile SingularAttribute<Consultorio, String> razaoSocialConsultorio;
	public static volatile ListAttribute<Consultorio, Pessoa> pessoas;
	public static volatile ListAttribute<Consultorio, ConsultorioPessoa> consultorioPessoas;
	public static volatile ListAttribute<Consultorio, Convenio> convenios;
}
