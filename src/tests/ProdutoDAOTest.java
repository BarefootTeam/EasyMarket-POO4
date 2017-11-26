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
	public void persistirTest() {
		for (int i = 0; i < 3; i++) {
		Produto produto = new Produto();
		produto.setNome("Produto Teste");
		produto.setCodigo("PROD00001");
		produto.setDescricao("Produto descrição");
		produto.setImagem("imagem.png");
		produto.setDataCadastro(new Date());
		produto.setUsuario(UsuarioDAO.getInstance().buscarTodos().get(0));
		assertNotNull(ProdutoDAO.getInstance().persistir(produto));
		}
	}
	
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
	public void deletarTest() {
		int ultimo = ProdutoDAO.getInstance().buscarTodos().size() - 1;
		Produto produto = ProdutoDAO.getInstance().buscarTodos().get(ultimo);
		assertTrue(ProdutoDAO.getInstance().deletar(produto));
	}

}
