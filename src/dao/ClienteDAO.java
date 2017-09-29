package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Cliente;
import utils.PersistenceUtil;

public class ClienteDAO {

	private static ClienteDAO clienteDAO;
	
	public static ClienteDAO getInstance() {
		if(clienteDAO == null) {
			clienteDAO = new ClienteDAO();
		}
		return clienteDAO;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> buscarTodos() {
		EntityManager em = PersistenceUtil.getEntityManager();
		List<Cliente> clientes = null;
		try {
			Query query = em.createQuery("FROM Cliente AS c");
			clientes = query.getResultList();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return clientes;
	}
	
	public Cliente buscarPorId(Long id) {
		EntityManager em = PersistenceUtil.getEntityManager();
		Query query = em.createQuery("FROM Cliente AS c WHERE c.id = :id");
		query.setParameter("id", id);
		return (Cliente) query.getSingleResult();
	}
	
	public boolean deletar(Cliente cliente) {
		EntityManager em = PersistenceUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(cliente);
			em.getTransaction().commit();
			return true;
		} catch(Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			return false;
		}
	}
	
	public Cliente persistir(Cliente cliente) {
		EntityManager em = PersistenceUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			cliente = em.merge(cliente);
			em.getTransaction().commit();
		} catch(Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
		return cliente;
	}
	
}
