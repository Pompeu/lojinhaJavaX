package lojinha.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TelefoneFornecedores.class)
public abstract class TelefoneFornecedores_ {

	public static volatile SingularAttribute<TelefoneFornecedores, Integer> pktelefone;
	public static volatile SingularAttribute<TelefoneFornecedores, String> numero;
	public static volatile SingularAttribute<TelefoneFornecedores, String> ddd;
	public static volatile SingularAttribute<TelefoneFornecedores, Fornecedores> fkfornecedores;

}

