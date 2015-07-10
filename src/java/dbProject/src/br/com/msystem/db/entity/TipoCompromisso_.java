package br.com.msystem.db.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-05-29T11:05:06.923-0300")
@StaticMetamodel(TipoCompromisso.class)
public class TipoCompromisso_ {
	public static volatile SingularAttribute<TipoCompromisso, Integer> tipoCompromissoSq;
	public static volatile SingularAttribute<TipoCompromisso, String> descricaoTipoCompromisso;
	public static volatile ListAttribute<TipoCompromisso, Compromisso> compromissos;
}
