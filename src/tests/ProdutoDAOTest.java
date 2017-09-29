package tests;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import dao.ProdutoDAO;
import dao.UsuarioDAO;
import model.Produto;

public class ProdutoDAOTest {

	@Test
	public void buscarTodosTest() {
		List<Produto> produtos = ProdutoDAO.getInstance().buscarTodos();
		assertTrue(produtos.size() > 0);
	}
	
	@Test
	public void buscarPorIdTest() {
		Long id = ProdutoDAO.getInstance().buscarTodos().get(0).getId();
		assertNotNull(ProdutoDAO.getInstance().buscarPorId(id));
	}
	
	@Test
	public void persistirTest() {
		Produto produto = new Produto();
		produto.setNome("Produto Teste");
		produto.setCodigo("PROD00001");
		produto.setDescricao("Produto descrição");
		produto.setImagem("imagem.png");
		produto.setDataCadastro(new Date());
		produto.setUsuario(UsuarioDAO.getInstance().buscarTodos().get(0));
		assertNotNull(ProdutoDAO.getInstance().persistir(produto));
	}
	
	@Test
	public void deletarTest() {
		Produto produto = ProdutoDAO.getInstance().buscarTodos().get(0);
		assertTrue(ProdutoDAO.getInstance().deletar(produto));
	}

}
