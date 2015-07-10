package br.com.msystem.db.entity;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-05-29T11:24:23.272-0300")
@StaticMetamodel(Convenio.class)
public class Convenio_ {
	public static volatile SingularAttribute<Convenio, Integer> convenioSq;
	public static volatile SingularAttribute<Convenio, Integer> prazoMaximoRetorno;
	public static volatile SingularAttribute<Convenio, BigDecimal> valorBase;
	public static volatile ListAttribute<Convenio, Compromisso> compromissos;
	public static volatile SingularAttribute<Convenio, Consultorio> consultorio;
	public static volatile SingularAttribute<Convenio, String> nomeConvenio;
}
