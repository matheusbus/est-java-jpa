package teste.muitosparamuitos;

import infra.DAO;
import modelo.muitosparamuitos.Ator;
import modelo.muitosparamuitos.Filme;

public class NovoFilmeAtor {

	public static void main(String[] args) {
		
		Filme filmeA = new Filme("As cronicas de Nárnia", 9.9);
		Filme filmeB = new Filme("007", 7.5);
		
		
		Ator atorA = new Ator("Vin Diesel");
		Ator atorB = new Ator("Angelina Julie");
		
		filmeA.adicionarAtor(atorA);
		filmeA.adicionarAtor(atorB);
		
		filmeB.adicionarAtor(atorB);
		
		DAO<Filme> dao = new DAO<>();
		dao.incluirDireto(filmeA);
		// Aqui, o JPA vai persistir todos os objetos no banco de dados, por conta do CASCADE
		// na classe Filme e na classe Ator.
		
	}
	
}
