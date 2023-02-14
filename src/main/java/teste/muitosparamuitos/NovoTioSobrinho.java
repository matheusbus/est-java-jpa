package teste.muitosparamuitos;

import infra.DAO;
import modelo.muitosparamuitos.Sobrinho;
import modelo.muitosparamuitos.Tio;

public class NovoTioSobrinho {

	public static void main(String[] args) {
		
		Tio tio = new Tio("Vitor");
		Tio tia = new Tio("Joana");
		
		Sobrinho sobrinho = new Sobrinho("Matheus");
		Sobrinho sobrinha = new Sobrinho("Franciele");
		
		// Relacionando todos com todos.
		tio.getSobrinhos().add(sobrinho);
		tio.getSobrinhos().add(sobrinha);
		
		tia.getSobrinhos().add(sobrinho);
		tia.getSobrinhos().add(sobrinha);
		
		sobrinho.getTios().add(tio);
		sobrinho.getTios().add(tia);
		
		sobrinha.getTios().add(tio);
		sobrinha.getTios().add(tia);
		
		DAO<Object> dao = new DAO<>();
		
		dao.abrirTransacao()
			.incluir(tio)
			.incluir(tia)
			.incluir(sobrinho)
			.incluir(sobrinha)
			.commitTransacao()
			.fechar();
		
	}
	
}
