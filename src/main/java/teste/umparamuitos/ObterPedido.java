package teste.umparamuitos;

import infra.DAO;
import modelo.umparamuitos.Pedido;

public class ObterPedido {

	public static void main(String[] args) {
		
		
		DAO<Pedido> dao = new DAO<>(Pedido.class);
		
		Pedido pedido = dao.obterPorId(dao);
		
		
	}
	
	
}
