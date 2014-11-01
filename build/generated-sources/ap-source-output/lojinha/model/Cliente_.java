package lojinha.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cliente.class)
public abstract class Cliente_ {

	public static volatile SingularAttribute<Cliente, String> nomeFantasia;
	public static volatile SingularAttribute<Cliente, Endereco> fkendereco;
	public static volatile SingularAttribute<Cliente, Integer> pkcliente;
	public static volatile CollectionAttribute<Cliente, Telefone> telefoneCollection;
	public static volatile CollectionAttribute<Cliente, Endereco> enderecoCollection;
	public static volatile SingularAttribute<Cliente, String> cnpj;
	public static volatile SingularAttribute<Cliente, String> razaoSocial;
	public static volatile CollectionAttribute<Cliente, Vendas> vendasCollection;

}

