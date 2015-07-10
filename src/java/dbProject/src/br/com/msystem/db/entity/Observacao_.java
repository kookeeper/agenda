package br.com.msystem.db.entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-05-29T16:24:26.399-0300")
@StaticMetamodel(Observacao.class)
public class Observacao_ {
	public static volatile SingularAttribute<Observacao, Integer> observacaoSq;
	public static volatile SingularAttribute<Observacao, String> observacao;
	public static volatile SingularAttribute<Observacao, Compromisso> compromisso;
	public static volatile SingularAttribute<Observacao, Timestamp> dataObservacao;
}
