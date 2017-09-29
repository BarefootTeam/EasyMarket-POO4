package tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import dao.CompraDAO;
import dao.ItemCompraDAO;
import dao.ProdutoDAO;
import model.ItemCompra;

public class ItemCompraDAOTest {

	@Test
	public void buscarTodosTest() {
		List<ItemCompra> itens = ItemCompraDAO.getInstance().buscarTodos();
		assertTrue(itens.size() > 0);
	}
	
	@Test
	public void buscarPorIdTest() {
		Long id = ItemCompraDAO.getInstance().buscarTodos().get(0).getId();
		assertNotNull(ItemCompraDAO.getInstance().buscarPorId(id));
	}
	
	@Test
	public void persistirTest() {
		ItemCompra item = new ItemCompra();
		item.setQuantidade(10);
		item.setValorUnitario(100f);
		item.setProduto(ProdutoDAO.getInstance().buscarTodos().get(0));
		item.setCompra(CompraDAO.getInstance().buscarTodos().get(0));
		assertNotNull(ItemCompraDAO.getInstance().persistir(item));
	}
	
	@Test
	public void deletarTest() {
		ItemCompra item = ItemCompraDAO.getInstance().buscarTodos().get(0);
		assertTrue(ItemCompraDAO.getInstance().deletar(item));
	}

}
