package tests;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import dao.ClienteDAO;
import dao.UsuarioDAO;
import model.Cliente;

public class ClienteDAOTest {

	@Test
	public void buscarTodosTest() {
		assertNotNull(ClienteDAO.getInstance().buscarTodos());
	}
	
	@Test
	public void buscarPorIdTest() {
		Long id = ClienteDAO.getInstance().buscarTodos().get(0).getId();
		assertNotNull(ClienteDAO.getInstance().buscarPorId(id));
	}
	
	@Test
	public void persistirTest() {
		
		Cliente cliente = new Cliente();
		cliente.setNome("Cliente teste");
		cliente.setEmail("cliente@teste.com");
		cliente.setCpf("000.000.000-00");
		cliente.setTelefone("(32) 0000-0000");
		cliente.setDataCadastro(new Date());
		cliente.setUsuario(UsuarioDAO.getInstance().buscarTodos().get(0));
		
		assertNotNull(ClienteDAO.getInstance().persistir(cliente));
	}
	
	@Test
	public void deletarTest() {
		Cliente cliente = ClienteDAO.getInstance().buscarTodos().get(0);
		assertTrue(ClienteDAO.getInstance().deletar(cliente));
	}

}
