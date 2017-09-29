package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Venda;
import utils.PersistenceUtil;

public class VendaDAO {

	private static VendaDAO vendaDAO;
	
	public static VendaDAO getInstance() {
		if(vendaDAO == null) {
			vendaDAO = new VendaDAO();
		}
		return vendaDAO;
	}
	
	@SuppressWarnings("unchecked")
	public List<Venda> buscarTodos() {
		EntityManager em = PersistenceUtil.getEntityManager();
		List<Venda> vendas = null;
		try {
			Query query = em.createQuery("FROM Venda AS v");
			vendas = query.getResultList();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return vendas;
	}
	
	public Venda buscarPorId(Long id) {
		EntityManager em = PersistenceUtil.getEntityManager();
		Query query = em.createQuery("FROM Venda AS v WHERE v.id = :id");
		query.setParameter("id", id);
		return (Venda) query.getSingleResult();
	}
	
	public Venda persistir(Venda venda) {
		EntityManager em = PersistenceUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			venda = em.merge(venda);
			em.getTransaction().commit();
		} catch(Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
		return venda;
	}
	
	public boolean deletar(Venda venda) {
		EntityManager em = PersistenceUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(venda);
			em.getTransaction().commit();
			return true;
		} catch(Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			return false;
		}
	}
	
}
