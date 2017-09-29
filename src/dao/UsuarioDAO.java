package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Usuario;
import utils.PersistenceUtil;

public class UsuarioDAO {

	private static UsuarioDAO usuarioDAO;
	
	public static UsuarioDAO getInstance() {
		if(usuarioDAO == null) {
			usuarioDAO = new UsuarioDAO();
		}
		return usuarioDAO;
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> buscarTodos() {
		List<Usuario> usuarios = null;
		EntityManager em  = PersistenceUtil.getEntityManager();
		try {
			Query query = em.createQuery("SELECT u FROM Usuario AS u");
			usuarios = query.getResultList();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return usuarios;
	}
	
	public Usuario buscarPorId(Long id) {
		EntityManager em = PersistenceUtil.getEntityManager();

		Query query = em.createQuery("FROM Usuario AS u WHERE u.id = :id");
		query.setParameter("id", id);
		
		return (Usuario) query.getSingleResult();
	}
	
	public Usuario persistir(Usuario usuario) {
		EntityManager em = PersistenceUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			usuario = em.merge(usuario);
			em.getTransaction().commit();
		} catch(Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
		return usuario;
	}
	
	public boolean deletar(Usuario usuario) {
		EntityManager em = PersistenceUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(usuario);
			em.getTransaction().commit();
			return true;
		} catch(Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			return false;
		}
	}

}
