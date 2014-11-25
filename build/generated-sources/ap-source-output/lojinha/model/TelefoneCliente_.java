package lojinha.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TelefoneCliente.class)
public abstract class TelefoneCliente_ {

	public static volatile SingularAttribute<TelefoneCliente, Integer> pktelefone;
	public static volatile SingularAttribute<TelefoneCliente, String> numero;
	public static volatile SingularAttribute<TelefoneCliente, String> ddd;
	public static volatile SingularAttribute<TelefoneCliente, Cliente> fkcliente;

}

