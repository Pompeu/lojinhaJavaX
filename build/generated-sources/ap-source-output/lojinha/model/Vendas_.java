package lojinha.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Vendas.class)
public abstract class Vendas_ {

	public static volatile SingularAttribute<Vendas, Date> dataVenda;
	public static volatile SingularAttribute<Vendas, BigDecimal> desconto;
	public static volatile ListAttribute<Vendas, Qtd> qtdList;
	public static volatile SingularAttribute<Vendas, Cliente> fkcliente;
	public static volatile SingularAttribute<Vendas, BigDecimal> comicao;
	public static volatile SingularAttribute<Vendas, Integer> pkvenda;
	public static volatile SingularAttribute<Vendas, Date> dataCompra;
	public static volatile SingularAttribute<Vendas, Vendedor> fkvendedor;

}

