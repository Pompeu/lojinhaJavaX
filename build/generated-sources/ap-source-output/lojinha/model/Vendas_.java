package lojinha.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Vendas.class)
public abstract class Vendas_ {

	public static volatile SingularAttribute<Vendas, Date> dataVenda;
	public static volatile SingularAttribute<Vendas, BigDecimal> desconto;
	public static volatile SingularAttribute<Vendas, Cliente> fkcliente;
	public static volatile SingularAttribute<Vendas, BigDecimal> comicao;
	public static volatile CollectionAttribute<Vendas, Qtd> qtdCollection;
	public static volatile SingularAttribute<Vendas, Vendedores> fkvendedores;
	public static volatile SingularAttribute<Vendas, Integer> pkvendas;
	public static volatile SingularAttribute<Vendas, Date> dataCompra;

}

