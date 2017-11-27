package tests;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import dao.ProdutoDAO;
import dao.UsuarioDAO;
import model.Usuario;

public class UsuarioDAOTest {
	
	@Test
	public void persistirTest() {
		for (int i = 0; i < 3; i++) {
		Usuario usuario = new Usuario();
		usuario.setNome("Usuario Teste");
		usuario.setCpf("000.000.000-00");
		usuario.setLogin("usuario");
		usuario.setSenha("senha");
		usuario.setTipo(1);
		usuario.setDataCadastro(new Date());
		
		assertNotNull(UsuarioDAO.getInstance().persistir(usuario));
		}
	}

	@Test
	public void buscarTodosTest() {
		List<Usuario> usuarios = UsuarioDAO.getInstance().buscarTodos();
		assertTrue(usuarios.size() > 0);
	}
	
	@Test
	public void buscarPorIdTest() {
		Long id = UsuarioDAO.getInstance().buscarTodos().get(0).getId();
		assertNotNull(UsuarioDAO.getInstance().buscarPorId(id));
	}	

	@Test
	public void deletarTest() {
		int ultimo = UsuarioDAO.getInstance().buscarTodos().size() - 1;
		Usuario usuario = UsuarioDAO.getInstance().buscarTodos().get(ultimo);
		assertTrue(UsuarioDAO.getInstance().deletar(usuario));
	}

}
