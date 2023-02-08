package teste.umpraum;

import infra.DAO;
import modelo.umpraum.Assento;
import modelo.umpraum.Cliente;

public class NovoClienteAssento1 {

	public static void main(String[] args) {
		
		
		DAO<Object> dao = new DAO<>();
		
		Assento assento = new Assento("4B");
		Cliente cliente = new Cliente("Ana", assento);
		
		dao.abrirTransacao()
			.incluir(assento)
			.incluir(cliente)
			.commitTransacao()
			.fechar();
		
	}
	
}
