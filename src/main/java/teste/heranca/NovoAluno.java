package teste.heranca;

import infra.DAO;
import modelo.heranca.Aluno;
import modelo.heranca.AlunoBolsista;

public class NovoAluno {

	public static void main(String[] args) {
		
		DAO<Aluno> dao = new DAO<>();
		
		Aluno aluno = new Aluno(12345L, "Matheus");
		Aluno alunob = new AlunoBolsista(12346L, "João", 1400D);
		
		dao.incluirDireto(aluno);
		dao.incluirDireto(alunob);
		
		dao.fechar();		
		
	}
	
}
