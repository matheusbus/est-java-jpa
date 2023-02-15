package teste.embeddable;

import infra.DAO;
import modelo.composicao.Endereco;
import modelo.composicao.Fornecedor;
import modelo.composicao.Funcionario;

public class NovoFuncFornEndereco {

	public static void main(String[] args) {
		
		
		DAO<Object> dao = new DAO<>();
		
		Endereco end1 = new Endereco("Rua", "Em frente ao supermercado");
		Endereco end2 = new Endereco("Morro", "morro da cruz");
		
		Funcionario func = new Funcionario("Matheus", end1);
		Fornecedor forn = new Fornecedor("Santa Cruz Bebidas", end2);
		
		dao.abrirTransacao()
			.incluir(func)
			.incluir(forn)
			.commitTransacao()
			.fechar();
		
	}
	
}
