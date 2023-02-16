package modelo.heranca;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("AB")
public class AlunoBolsista extends Aluno {

	// O Id vai ser detectado pelo JPA através da herança
	
	private double valorBolsa;

	public AlunoBolsista() {
		
	}

	public AlunoBolsista(Long matricula, String nome, double valorBolsa) {
		super(matricula, nome);
		this.valorBolsa = valorBolsa;
	}

	public double getValorBolsa() {
		return valorBolsa;
	}

	public void setValorBolsa(double valorBolsa) {
		this.valorBolsa = valorBolsa;
	}

	@Override
	public String toString() {
		return "AlunoBolsista [valorBolsa=" + valorBolsa + "]";
	}
	
}
