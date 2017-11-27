package tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import dao.ItemCompraDAO;
import dao.ItemVendaDAO;
import dao.ProdutoDAO;
import dao.VendaDAO;
import model.ItemVenda;

public class ItemVendaDAOTest {
	
	@Test
	public void persistirTest() {
		for (int i = 0; i < 3; i++) {
		ItemVenda item = new ItemVenda();
		item.setQuantidade(10);
		item.setValorUnitario(100f);
		item.setProduto(ProdutoDAO.getInstance().buscarTodos().get(0));
		item.setVenda(VendaDAO.getInstance().buscarTodos().get(0));
		assertNotNull(ItemVendaDAO.getInstance().persistir(item));
		}
	}

	@Test
	public void buscarTodosTest() {
		List<ItemVenda> itens = ItemVendaDAO.getInstance().buscarTodos();
		assertTrue(itens.size() > 0);
	}
	
	@Test
	public void buscarPorIdTest() {
		Long id = ItemVendaDAO.getInstance().buscarTodos().get(0).getId();
		assertNotNull(ItemVendaDAO.getInstance().buscarPorId(id));
	}	
	
	@Test
	public void deletarTest() {
		int ultimo = ItemCompraDAO.getInstance().buscarTodos().size() - 1;
		ItemVenda item = ItemVendaDAO.getInstance().buscarTodos().get(ultimo);
		assertTrue(ItemVendaDAO.getInstance().deletar(item));
	}

}
