package teste.basico;

import infra.DAO;
import modelo.basico.Produto;

public class NovoProduto {

	public static void main(String[] args) {
		
		Produto pd = new Produto("Monitor 23.9''", 799.90, "UND");
		
		DAO<Produto> dao = new DAO<>(Produto.class);
		dao.abrirTransacao().incluir(pd).commitTransacao().fechar();
		
		
	}
	
}
