package lojinha.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cliente.class)
public abstract class Cliente_ {

	public static volatile SingularAttribute<Cliente, Integer> pkcliente;
	public static volatile ListAttribute<Cliente, EnderecoCliente> enderecoClienteList;
	public static volatile SingularAttribute<Cliente, String> nome;
	public static volatile ListAttribute<Cliente, TelefoneCliente> telefoneClienteList;
	public static volatile SingularAttribute<Cliente, String> cnpj;
	public static volatile SingularAttribute<Cliente, String> razaoSocial;

}

