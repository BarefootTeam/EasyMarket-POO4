package control;

import java.util.List;

import dao.ProdutoDAO;
import model.Produto;

public class ProdutoController {

	public boolean persistir(Produto produto) {
		return ProdutoDAO.getInstance().persistir(produto) != null;
	}
	
	public List<Produto> buscarTodos() {
		return ProdutoDAO.getInstance().buscarTodos();
	}
	
	public Produto buscarPorId(long id) {
		return ProdutoDAO.getInstance().buscarPorId(id);
	}

	public boolean deletar(Produto produto) {
		return ProdutoDAO.getInstance().deletar(produto);
	}
	
}
