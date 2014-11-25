package lojinha.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EnderecoCliente.class)
public abstract class EnderecoCliente_ {

	public static volatile SingularAttribute<EnderecoCliente, String> estado;
	public static volatile SingularAttribute<EnderecoCliente, Cliente> fkCliente;
	public static volatile SingularAttribute<EnderecoCliente, String> logradouro;
	public static volatile SingularAttribute<EnderecoCliente, Integer> pkendereco;

}

