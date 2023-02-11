package teste.umparamuitos;

import infra.DAO;
import modelo.basico.Produto;
import modelo.umparamuitos.ItemPedido;
import modelo.umparamuitos.Pedido;

public class NovoPedido {

	public static void main(String[] args) {
		
		DAO<Object> dao = new DAO<>();
		
		Pedido pedido = new Pedido();
		Produto produto = new Produto("Arroz", 18.50, "PCT");
		Produto produto2 = new Produto("Carne Moída", 25D, "KG");
		Produto produto3 = new Produto("Farofa", 5.50, "PCT");
		
		ItemPedido item = new ItemPedido(pedido, produto, 2);
		ItemPedido item2 = new ItemPedido(pedido, produto2, 6);
		ItemPedido item3 = new ItemPedido(pedido, produto3, 1);
		
		dao.abrirTransacao()
			.incluir(produto)
			.incluir(produto2)
			.incluir(produto3)
			.incluir(pedido)
			.incluir(item)
			.incluir(item2)
			.incluir(item3)
			.commitTransacao()
			.fechar();
		
	}
	
}
