package br.com.msystem.db.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-05-29T10:00:41.536-0300")
@StaticMetamodel(TipoTelefone.class)
public class TipoTelefone_ {
	public static volatile SingularAttribute<TipoTelefone, Integer> tipoTelefoneSq;
	public static volatile SingularAttribute<TipoTelefone, String> descricaoTipoTelefone;
	public static volatile ListAttribute<TipoTelefone, Telefone> telefones;
}
