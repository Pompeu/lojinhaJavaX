package lojinha.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Vendedores.class)
public abstract class Vendedores_ {

	public static volatile SingularAttribute<Vendedores, String> nascimento;
	public static volatile SingularAttribute<Vendedores, Integer> pkvendedores;
	public static volatile SingularAttribute<Vendedores, String> cpf;
	public static volatile SingularAttribute<Vendedores, String> nome;
	public static volatile CollectionAttribute<Vendedores, Vendas> vendasCollection;

}

