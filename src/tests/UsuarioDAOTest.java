package tests;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import dao.UsuarioDAO;
import model.Usuario;

public class UsuarioDAOTest {

	@Test
	public void buscarTodosTest() {
		assertNotNull(UsuarioDAO.getInstance().buscarTodos());
	}
	
	@Test
	public void buscarPorIdTest() {
		Long id = UsuarioDAO.getInstance().buscarTodos().get(0).getId();
		assertNotNull(UsuarioDAO.getInstance().buscarPorId(id));
	}
	
	@Test
	public void persistirTest() {
		Usuario usuario = new Usuario();
		usuario.setNome("Usuario Teste");
		usuario.setCpf("000.000.000-00");
		usuario.setLogin("usuario");
		usuario.setSenha("senha");
		usuario.setTipo(1);
		usuario.setDataCadastro(new Date());
		
		assertNotNull(UsuarioDAO.getInstance().persistir(usuario));
	}

	@Test
	public void deletarTest() {
		Usuario usuario = UsuarioDAO.getInstance().buscarTodos().get(0);
		assertTrue(UsuarioDAO.getInstance().deletar(usuario));
	}

}
