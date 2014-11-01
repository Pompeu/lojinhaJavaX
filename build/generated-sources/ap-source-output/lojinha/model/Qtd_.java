package lojinha.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Qtd.class)
public abstract class Qtd_ {

	public static volatile SingularAttribute<Qtd, Produtos> fkprodutos;
	public static volatile SingularAttribute<Qtd, Integer> pkQtd;
	public static volatile SingularAttribute<Qtd, Vendas> fkvendas;

}

