package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Produto;
import utils.PersistenceUtil;

public class ProdutoDAO {

	public static ProdutoDAO getInstance() {
			return new ProdutoDAO();
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> buscarTodos() {
		EntityManager em = PersistenceUtil.getEntityManager();
		List<Produto> produtos = null;
		try {
			Query query = em.createQuery("FROM Produto AS p");
			produtos = query.getResultList();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return produtos;
	}
	
	public Produto buscarPorId(Long id) {
		EntityManager em = PersistenceUtil.getEntityManager();
		Query query = em.createQuery("FROM Produto AS p WHERE p.id = :id");
		query.setParameter("id", id);
		return (Produto) query.getSingleResult();
	}
	
	public boolean deletar(Produto produto) {
		EntityManager em = PersistenceUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(produto);
			em.getTransaction().commit();
			return true;
		} catch(Exception e) {
			em.getTransaction().rollback();
			return false;
		}
	}
	
	public Produto persistir(Produto produto) {
		EntityManager em = PersistenceUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			produto = em.merge(produto);
			em.getTransaction().commit();
		} catch(Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
		return produto;
	}

}
