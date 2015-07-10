package br.com.msystem.db.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-05-29T10:00:41.524-0300")
@StaticMetamodel(Pessoa.class)
public class Pessoa_ {
	public static volatile SingularAttribute<Pessoa, Integer> pessoaSq;
	public static volatile SingularAttribute<Pessoa, String> cpfPessoa;
	public static volatile SingularAttribute<Pessoa, String> nomePessoa;
	public static volatile ListAttribute<Pessoa, Compromisso> compromissosPaciente;
	public static volatile ListAttribute<Pessoa, Compromisso> compromissosMedico;
	public static volatile ListAttribute<Pessoa, Consultorio> consultorios;
	public static volatile ListAttribute<Pessoa, ConsultorioPessoa> consultorioPessoas;
	public static volatile ListAttribute<Pessoa, Endereco> enderecos;
	public static volatile ListAttribute<Pessoa, PessoaImagem> pessoaImagems;
	public static volatile ListAttribute<Pessoa, Telefone> telefones;
	public static volatile ListAttribute<Pessoa, Usuario> usuarios;
}
