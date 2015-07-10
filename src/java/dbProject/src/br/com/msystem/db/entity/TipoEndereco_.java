package br.com.msystem.db.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-05-29T10:00:41.532-0300")
@StaticMetamodel(TipoEndereco.class)
public class TipoEndereco_ {
	public static volatile SingularAttribute<TipoEndereco, Integer> tipoEnderecoSq;
	public static volatile SingularAttribute<TipoEndereco, String> descricaoTipoEndereco;
	public static volatile ListAttribute<TipoEndereco, Endereco> enderecos;
}
