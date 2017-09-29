package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import dao.CompraDAO;
import dao.UsuarioDAO;
import dao.VendaDAO;
import model.Compra;
import model.ItemCompra;
import model.ItemVenda;
import model.Venda;

public class CompraDAOTest {

	@Test
	public void buscarTodosTest() {
		List<Compra> compras = CompraDAO.getInstance().buscarTodos();
		assertTrue(compras.size() > 0);
	}
	
	@Test
	public void buscarPorId() {
		Long id = CompraDAO.getInstance().buscarTodos().get(0).getId();
		assertNotNull(CompraDAO.getInstance().buscarPorId(id));
	}
	
	@Test
	public void persistirTest() {
		Compra compra = new Compra();
		compra.setData(new Date());
		compra.setUsuario(UsuarioDAO.getInstance().buscarTodos().get(0));
		compra.setItens(new ArrayList<ItemCompra>());
		assertNotNull(CompraDAO.getInstance().persistir(compra));
	}
	
	@Test
	public void deletarTest() {
		Compra compra = CompraDAO.getInstance().buscarTodos().get(0);
		assertTrue(CompraDAO.getInstance().deletar(compra));
	}

}
