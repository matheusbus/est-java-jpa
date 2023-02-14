package teste.basico;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class ObterUsuarios {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		/*
		// Exemplo fazendo em várias linhas
		String jpql = "select u from Usuario u"; // -> JQPL
		TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
		query.setMaxResults(5);
		
		List<Usuario> usuarios = query.getResultList();
		*/
		
		// Exemplo fazendo tudo em uma linha
		List<Usuario> usuarios = em
				.createQuery("select u from Usuario u", Usuario.class)
				.setMaxResults(5)
				.getResultList();
		
		
		for(Usuario usuario : usuarios) {
			System.out.println("Id: "+usuario.getId()+" - Username: "+usuario.getUsername());
		}
		
		em.close();
		emf.close();
		
	}
	
}
