package lojinha.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Fornecedores.class)
public abstract class Fornecedores_ {

	public static volatile CollectionAttribute<Fornecedores, EnderecoFornecedor> enderecoFornecedorCollection;
	public static volatile SingularAttribute<Fornecedores, String> nomeFantasia;
	public static volatile CollectionAttribute<Fornecedores, TelefoneFornecedores> telefoneFornecedoresCollection;
	public static volatile SingularAttribute<Fornecedores, Integer> pkfornecedores;
	public static volatile CollectionAttribute<Fornecedores, Valor> valorCollection;
	public static volatile SingularAttribute<Fornecedores, String> cnpj;
	public static volatile SingularAttribute<Fornecedores, String> razaoSocial;

}

