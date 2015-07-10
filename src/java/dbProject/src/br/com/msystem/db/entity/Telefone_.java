package br.com.msystem.db.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-05-29T10:00:41.530-0300")
@StaticMetamodel(Telefone.class)
public class Telefone_ {
	public static volatile SingularAttribute<Telefone, Integer> telefoneSq;
	public static volatile SingularAttribute<Telefone, String> numeroTelefone;
	public static volatile SingularAttribute<Telefone, String> ramalTelefone;
	public static volatile SingularAttribute<Telefone, Pessoa> pessoa;
	public static volatile SingularAttribute<Telefone, TipoTelefone> tipoTelefone;
}
