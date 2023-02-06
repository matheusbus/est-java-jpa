package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario1 {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Usuario usuario = em.find(Usuario.class, 2L);
		System.out.println(usuario.toString());
		
		usuario.setUsername("Joao Update");
		usuario.setEmail("j.kleberUpdate@gmail.com");
		
		// Método para update
		em.merge(usuario);
		
		em.getTransaction().commit();
		
		System.out.println(usuario.toString());
		
		em.close();
		emf.close();
		
		
	}
	
}
