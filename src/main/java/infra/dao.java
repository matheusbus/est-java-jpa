package infra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DAO<E> {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Class<E> classe;
	
	static {
		try {
			emf = Persistence.createEntityManagerFactory("exercicios-jpa");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public DAO() {
		em = emf.createEntityManager();		
	}
	
	public DAO(Class<E> classe) {
		this.classe = classe;
		em = emf.createEntityManager();
	}
	
	public DAO<E> abrirTransacao(){
		em.getTransaction().begin();
		return this;
	}
	
	public DAO<E> commitTransacao(){
		em.getTransaction().commit();
		return this;
	}
	
	public DAO<E> incluir(E entidade){
		em.persist(entidade);
		return this;
	}
	
	public DAO<E> incluirDireto(E entidade){
		return this.abrirTransacao().incluir(entidade).commitTransacao();
	}
	
	public E obterPorId(Object id) {
		return em.find(classe, id);
	}
	
	public List<E> obterTodos(){
		return this.obterTodos(10,0);
	}
	
	public List<E> obterTodos(int quantidade, int deslocamento){
		if(classe == null) {
			throw new UnsupportedOperationException("Classe nula");
		}
		String jpql = "select e from "+classe.getName() + " e";
		TypedQuery<E> query = em.createQuery(jpql, classe);
		query.setMaxResults(quantidade);
		query.setFirstResult(deslocamento);
		return query.getResultList();	
	}
	
	public DAO<E> atualizar(E entidade){
		em.merge(entidade);
		return this;
	}
	
	public DAO<E> atualizarDireto(E entidade){
		return this.abrirTransacao().atualizar(entidade).commitTransacao();
	}

	public List<E> consultar(String nomeDaConsulta, Object... params){
		TypedQuery<E> query = em.createNamedQuery(nomeDaConsulta, classe);
		
		for(int i = 0; i < params.length; i += 2) {
			query.setParameter(params[i].toString(), params[i + 1]);
		}
		
		return query.getResultList();
	}
	
	public E consultarUm(String nomeDaConsulta, Object... params) {
		List<E> lista = consultar(nomeDaConsulta, params);
		return lista.isEmpty() ? null : lista.get(0);
	}
	
	public void fechar() {
		em.close();
	}
	
}
