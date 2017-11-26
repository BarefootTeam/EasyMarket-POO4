package tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import dao.CompraDAO;
import dao.ItemCompraDAO;
import dao.ProdutoDAO;
import dao.UsuarioDAO;
import model.ItemCompra;

public class ItemCompraDAOTest {
	
	@Test
	public void persistirTest() {
		for (int i = 0; i < 3; i++) {
		ItemCompra item = new ItemCompra();
		item.setQuantidade(10);
		item.setValorUnitario(100f);	
		item.setProduto(ProdutoDAO.getInstance().buscarPorId(106L));
		item.setCompra(CompraDAO.getInstance().buscarPorId(110L));
		assertNotNull(ItemCompraDAO.getInstance().persistir(item));
		}
	}

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
	public void deletarTest() {
		int ultimo = ItemCompraDAO.getInstance().buscarTodos().size() - 1;
		ItemCompra item = ItemCompraDAO.getInstance().buscarTodos().get(ultimo);
		assertTrue(ItemCompraDAO.getInstance().deletar(item));
	}

}
