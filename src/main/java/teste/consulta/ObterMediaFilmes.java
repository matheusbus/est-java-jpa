package teste.consulta;

import infra.DAO;
import modelo.consulta.NotaFilme;

public class ObterMediaFilmes {

	// Exemplo de named-native-query
	
	public static void main(String[] args) {
		
		DAO<NotaFilme> dao = new DAO<>(NotaFilme.class);
		NotaFilme nota = dao.consultarUm("obterMediaGeralDosFilmes");
		System.out.println("Média dos filmes utilizando named-native-query: " + nota.getMedia());
		dao.fechar();
	}
	
}
