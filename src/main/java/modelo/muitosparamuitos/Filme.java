package modelo.muitosparamuitos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbfilme")
public class Filme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "fil_nome", nullable = false)
	private String nome;
	
	@ManyToMany(cascade = CascadeType.PERSIST) // No momento de inserção de um filme, irá inserir também os atores.
	@JoinTable(
		name = "tbatores_filmes",
		joinColumns = @JoinColumn(name = "filme_id", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name = "ator_id", referencedColumnName = "id")
	)
	private List<Ator> atores;
	
	@Column(name = "fil_nota")
	private double nota;

	public Filme() {
		super();
	}

	public Filme(String nome, double nota) {
		super();
		this.nome = nome;
		this.nota = nota;
	}

	public void adicionarAtor(Ator ator) {
		if(ator != null && !getAtores().contains(ator)) {
			getAtores().add(ator);
			
			if(!ator.getFilmes().contains(this)) {
				ator.getFilmes().add(this);
			}
		}
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Ator> getAtores() {
		if(atores == null) {
			atores = new ArrayList<>();
		}
		return atores;
	}

	public void setAtores(List<Ator> atores) {
		this.atores = atores;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}
	
}
