package modelo.basico;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbproduto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pdcodigo")
	private Long id;
	
	@Column(name = "pddescri", length = 120, nullable = false)
	private String descricao;
	
	@Column(name = "pdpreco", precision = 6, scale = 3, nullable = false)
	private Double preco;
	
	@Column(name = "pdunidmed", length = 3)
	private String unidMedida;

	public Produto() {
		
	}

	public Produto(String descricao, Double preco) {
		super();
		this.descricao = descricao;
		this.preco = preco;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Double getPreco() {
		return preco;
	}


	public void setPreco(Double preco) {
		this.preco = preco;
	}


	@Override
	public String toString() {
		return "Produto [id=" + id + ", descricao=" + descricao + ", preco=" + preco + "]";
	}
	
	
}
