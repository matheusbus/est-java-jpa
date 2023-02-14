package modelo.muitosparamuitos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Sobrinho {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@ManyToMany(mappedBy = "sobrinhos") // Isso quer dizer que na classe de Tio é que está mapeada a relação.
	private List<Tio> tios = new ArrayList<>();
	
	public Sobrinho() {
		
	}

	public Sobrinho(String nome) {
		super();
		this.nome = nome;
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

	public List<Tio> getTios() {
		return tios;
	}

	public void setTios(List<Tio> tios) {
		this.tios = tios;
	}

	@Override
	public String toString() {
		return "Sobrinho [id=" + id + ", nome=" + nome + ", tios=" + tios + "]";
	}
	
}
