package tests;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import dao.PrecoDAO;
import dao.ProdutoDAO;
import dao.UsuarioDAO;
import model.Preco;
import model.Produto;

public class PrecoDAOTest {

	@Test
	public void persistirTest() {
		for (int i = 0; i < 3; i++) {
		Preco preco = new Preco();
		preco.setProduto(ProdutoDAO.getInstance().buscarPorId(12L));
		preco.setUsuario(UsuarioDAO.getInstance().buscarPorId(3L));
		preco.setValor(145f);
		preco.setDataCadastro(new Date());
		preco.setDataInicio(new Date());
		
		assertNotNull(PrecoDAO.getInstance().persistir(preco));
		}
	}
	
	@Test
	public void buscarTodosTest() {
		List<Preco> precos = PrecoDAO.getInstance().buscarTodos();
		assertTrue(precos.size() > 0);
	}
	
	@Test
	public void buscarPorIdTest() {
		Long id = PrecoDAO.getInstance().buscarTodos().get(0).getId();
		assertNotNull(PrecoDAO.getInstance().buscarPorId(id));
	}
	
	@Test
	public void buscarPorProdutoObjetoTest() {
		Produto produto = ProdutoDAO.getInstance().buscarPorId(12L);
		List<Preco> precos = PrecoDAO.getInstance().buscarPorProduto(produto);
		assertTrue(precos.size() > 0);
	}
	
	@Test
	public void buscarPorProdutoIdTest() {
		List<Preco> precos = PrecoDAO.getInstance().buscarPorProduto(12L);
		assertTrue(precos.size() > 0);
	}
	
	@Test
	public void deletarTest() {
		int ultimo = UsuarioDAO.getInstance().buscarTodos().size() - 1;
		Preco preco = PrecoDAO.getInstance().buscarPorProduto(12L).get(ultimo);
		assertTrue(PrecoDAO.getInstance().deletar(preco));
	}

}
