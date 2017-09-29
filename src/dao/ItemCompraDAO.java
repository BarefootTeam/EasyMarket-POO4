package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Compra;
import model.ItemCompra;
import utils.PersistenceUtil;

public class ItemCompraDAO {

	private static ItemCompraDAO itemCompraDAO;
	
	public static ItemCompraDAO getInstance() {
		if(itemCompraDAO == null) {
			itemCompraDAO = new ItemCompraDAO();
		}
		return itemCompraDAO;
	}

	@SuppressWarnings("unchecked")
	public List<ItemCompra> buscarTodos() {
		EntityManager em = PersistenceUtil.getEntityManager();
		List<ItemCompra> itens = null;
		try {
			Query query = em.createQuery("FROM ItemCompra AS ic");
			itens = query.getResultList();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return itens;
	}
	
	public ItemCompra buscarPorId(Long id) {
		EntityManager em = PersistenceUtil.getEntityManager();
		Query query = em.createQuery("FROM ItemCompra AS ic WHERE ic.id = :id");
		query.setParameter("id", id);
		return (ItemCompra) query.getSingleResult();
	}
	
	public ItemCompra persistir(ItemCompra item) {
		EntityManager em = PersistenceUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			item = em.merge(item);
			em.getTransaction().commit();
		} catch(Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
		return item;
	}
	
	public boolean deletar(ItemCompra item) {
		EntityManager em = PersistenceUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(item);
			em.getTransaction().commit();
			return true;
		} catch(Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			return false;
		}
	}
}
