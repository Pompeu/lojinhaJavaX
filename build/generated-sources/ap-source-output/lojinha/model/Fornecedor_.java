package lojinha.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Fornecedor.class)
public abstract class Fornecedor_ {

	public static volatile ListAttribute<Fornecedor, EnderecoFornecedor> enderecofornecedorList;
	public static volatile SingularAttribute<Fornecedor, String> nomeFantasia;
	public static volatile SingularAttribute<Fornecedor, Integer> pkfornecedores;
	public static volatile ListAttribute<Fornecedor, TelefoneFornecedor> telefonefornecedoresList;
	public static volatile SingularAttribute<Fornecedor, String> cnpj;
	public static volatile SingularAttribute<Fornecedor, String> razaoSocial;

}

