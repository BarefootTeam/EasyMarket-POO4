package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.ItemVenda;
import model.Preco;
import model.Venda;
import utils.PersistenceUtil;

public class ItemVendaDAO {

	private static ItemVendaDAO itemVendaDAO;
	
	public static ItemVendaDAO getInstance() {
		if(itemVendaDAO == null) {
			itemVendaDAO = new ItemVendaDAO();
		}
		return itemVendaDAO;
	}

	@SuppressWarnings("unchecked")
	public List<ItemVenda> buscarTodos() {
		EntityManager em = PersistenceUtil.getEntityManager();
		List<ItemVenda> itens = null;
		try {
			Query query = em.createQuery("FROM ItemVenda AS iv");
			itens = query.getResultList();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return itens;
	}
	
	public ItemVenda buscarPorId(Long id) {
		EntityManager em = PersistenceUtil.getEntityManager();
		Query query = em.createQuery("FROM ItemVenda AS iv WHERE iv.id = :id");
		query.setParameter("id", id);
		return (ItemVenda) query.getSingleResult();
	}
	
	public ItemVenda persistir(ItemVenda item) {
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
	
	public boolean deletar(ItemVenda item) {
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
