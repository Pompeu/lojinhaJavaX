package lojinha.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EnderecoFornecedor.class)
public abstract class EnderecoFornecedor_ {

	public static volatile SingularAttribute<EnderecoFornecedor, String> cidade;
	public static volatile SingularAttribute<EnderecoFornecedor, String> estado;
	public static volatile SingularAttribute<EnderecoFornecedor, String> complemento;
	public static volatile SingularAttribute<EnderecoFornecedor, Fornecedor> fkFornecedor;
	public static volatile SingularAttribute<EnderecoFornecedor, String> logradouro;
	public static volatile SingularAttribute<EnderecoFornecedor, String> bairro;
	public static volatile SingularAttribute<EnderecoFornecedor, Integer> pkendereco;
	public static volatile SingularAttribute<EnderecoFornecedor, String> cep;

}

