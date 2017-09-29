package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Compra;
import utils.PersistenceUtil;

public class CompraDAO {

	private static CompraDAO compraDAO;
	
	public static CompraDAO getInstance() {
		if(compraDAO == null) {
			compraDAO = new CompraDAO();
		}
		return compraDAO;
	}
	
	@SuppressWarnings("unchecked")
	public List<Compra> buscarTodos() {
		EntityManager em = PersistenceUtil.getEntityManager();
		List<Compra> compras = null;
		try {
			Query query = em.createQuery("FROM Compra AS c");
			compras = query.getResultList();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return compras;
	}
	
	public Compra buscarPorId(Long id) {
		EntityManager em = PersistenceUtil.getEntityManager();
		Query query = em.createQuery("FROM Compra AS c WHERE c.id = :id");
		query.setParameter("id", id);
		return (Compra) query.getSingleResult();
	}
	
	public Compra persistir(Compra compra) {
		EntityManager em = PersistenceUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			compra = em.merge(compra);
			em.getTransaction().commit();
		} catch(Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
		return compra;
	}
	
	public boolean deletar(Compra compra) {
		EntityManager em = PersistenceUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(compra);
			em.getTransaction().commit();
			return true;
		} catch(Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			return false;
		}
	}
}
