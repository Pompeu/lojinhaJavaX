package lojinha.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Valor.class)
public abstract class Valor_ {

	public static volatile SingularAttribute<Valor, Integer> pkValor;
	public static volatile SingularAttribute<Valor, Fornecedor> fkfornecedores;
	public static volatile SingularAttribute<Valor, Produto> fkprodutos;

}

