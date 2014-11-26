package lojinha.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TelefoneFornecedor.class)
public abstract class TelefoneFornecedor_ {

	public static volatile SingularAttribute<TelefoneFornecedor, Integer> pktelefone;
	public static volatile SingularAttribute<TelefoneFornecedor, String> numero;
	public static volatile SingularAttribute<TelefoneFornecedor, String> ddd;
	public static volatile SingularAttribute<TelefoneFornecedor, Fornecedor> fkFornecedor;

}

