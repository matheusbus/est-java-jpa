package teste.umpraum;

import infra.DAO;
import modelo.umpraum.Assento;
import modelo.umpraum.Cliente;

public class NovoClienteAssento2 {

	public static void main(String[] args) {
		
		
		Assento assento = new Assento("3D");
		Cliente cliente = new Cliente("Rodrigo", assento);
		
		DAO<Cliente> dao = new DAO<>(Cliente.class);
		dao.incluirDireto(cliente); // Vai gerar erro, pois o assento não está persistido no banco de dados
		
	}
	
}