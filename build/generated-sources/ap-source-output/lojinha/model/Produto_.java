package lojinha.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Produto.class)
public abstract class Produto_ {

	public static volatile SingularAttribute<Produto, Integer> pkProdutos;
	public static volatile SingularAttribute<Produto, BigDecimal> valor;
	public static volatile SingularAttribute<Produto, Integer> estoqueMinimo;
	public static volatile SingularAttribute<Produto, String> descricao;

}

