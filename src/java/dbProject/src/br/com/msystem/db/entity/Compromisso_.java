package br.com.msystem.db.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-05-29T16:41:51.177-0300")
@StaticMetamodel(Compromisso.class)
public class Compromisso_ {
	public static volatile SingularAttribute<Compromisso, Integer> compromissoSq;
	public static volatile SingularAttribute<Compromisso, Boolean> compareceu;
	public static volatile SingularAttribute<Compromisso, Timestamp> dataCadastro;
	public static volatile SingularAttribute<Compromisso, Timestamp> dataCompromisso;
	public static volatile SingularAttribute<Compromisso, Pessoa> pessoaPaciente;
	public static volatile SingularAttribute<Compromisso, Pessoa> pessoaMedico;
	public static volatile ListAttribute<Compromisso, Observacao> observacaos;
	public static volatile SingularAttribute<Compromisso, Convenio> convenio;
	public static volatile SingularAttribute<Compromisso, TipoCompromisso> tipoCompromisso;
	public static volatile SingularAttribute<Compromisso, BigDecimal> valorCobrado;
	public static volatile SingularAttribute<Compromisso, BigDecimal> valorPago;
}
