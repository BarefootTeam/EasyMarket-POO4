package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import dao.ItemCompraDAO;
import dao.ItemVendaDAO;
import dao.ProdutoDAO;
import dao.UsuarioDAO;
import dao.VendaDAO;
import model.ItemCompra;
import model.ItemVenda;
import model.Venda;

public class VendaDAOTest {
	
	@Test
	public void persistirTest() {
		for (int i = 0; i < 3; i++) {
		Venda venda = new Venda();
		venda.setData(new Date());
		venda.setUsuario(UsuarioDAO.getInstance().buscarTodos().get(0));
		venda.setItens(new ArrayList<ItemVenda>());
		assertNotNull(VendaDAO.getInstance().persistir(venda));
		}
	}

	@Test
	public void buscarTodosTest() {
		List<Venda> vendas = VendaDAO.getInstance().buscarTodos();
		assertTrue(vendas.size() > 0);
	}
	
	@Test
	public void buscarPorId() {
		Long id = VendaDAO.getInstance().buscarTodos().get(0).getId();
		assertNotNull(VendaDAO.getInstance().buscarPorId(id));
	}	
	
	@Test
	public void deletarTest() {
		int ultimo = UsuarioDAO.getInstance().buscarTodos().size() - 1;
		Venda venda = VendaDAO.getInstance().buscarTodos().get(ultimo);
		assertTrue(VendaDAO.getInstance().deletar(venda));
	}

}
