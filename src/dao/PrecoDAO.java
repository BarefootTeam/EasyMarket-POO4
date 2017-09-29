package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Preco;
import model.Produto;
import utils.PersistenceUtil;

public class PrecoDAO {

	private static PrecoDAO precoDAO;
	
	public static PrecoDAO getInstance() {
		if(precoDAO == null) {
			precoDAO = new PrecoDAO();
		}
		return precoDAO;
	}
	
	@SuppressWarnings("unchecked")
	public List<Preco> buscarTodos() {
		EntityManager em = PersistenceUtil.getEntityManager();
		List<Preco> precos = null;
		try {
			Query query = em.createQuery("FROM Preco AS p");
			precos = query.getResultList();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return precos;
	}
	
	public Preco buscarPorId(Long id) {
		EntityManager em = PersistenceUtil.getEntityManager();
		Query query = em.createQuery("FROM Preco AS p WHERE p.id = :id");
		query.setParameter("id", id);
		return (Preco) query.getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Preco> buscarPorProduto(Long id) {
		EntityManager em = PersistenceUtil.getEntityManager();
		List<Preco> precos = null;
		try {
			Query query = em.createQuery("FROM Preco AS p WHERE p.produto.id = :id");
			query.setParameter("id", id);
			precos = query.getResultList();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return precos;
	}
	
	public List<Preco> buscarPorProduto(Produto produto) {
		return buscarPorProduto(produto.getId());
	}
	
	public Preco persistir(Preco preco) {
		EntityManager em = PersistenceUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			preco = em.merge(preco);
			em.getTransaction().commit();
		} catch(Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
		return preco;
	}
	
	public boolean deletar(Preco preco) {
		EntityManager em = PersistenceUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(preco);
			em.getTransaction().commit();
			return true;
		} catch(Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			return false;
		}
	}
}
