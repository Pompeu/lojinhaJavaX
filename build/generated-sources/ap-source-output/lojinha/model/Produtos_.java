package lojinha.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Produtos.class)
public abstract class Produtos_ {

	public static volatile SingularAttribute<Produtos, Integer> pkprodutos;
	public static volatile SingularAttribute<Produtos, BigDecimal> valor;
	public static volatile CollectionAttribute<Produtos, Valor> valorCollection;
	public static volatile SingularAttribute<Produtos, Integer> estoqueMinimo;
	public static volatile CollectionAttribute<Produtos, Qtd> qtdCollection;
	public static volatile SingularAttribute<Produtos, String> descricao;

}

