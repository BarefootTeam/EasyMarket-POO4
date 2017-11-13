package control;
import java.util.ArrayList;
import java.util.List;
import dao.CompraDAO;
import dao.ProdutoDAO;
import dao.VendaDAO;
import model.Compra;
import model.Estoque;
import model.ItemCompra;
import model.ItemVenda;
import model.Produto;
import model.Venda;

public class EstoqueController {
	
	private List<Estoque> estoques = new ArrayList<Estoque>();

	public Estoque obterEstoqueAtualPorProduto(long produtoId){
		
		List<Compra> listaCompras = CompraDAO.getInstance().buscarTodos();
		List<Venda> listaVendas = VendaDAO.getInstance().buscarTodos();	
		Estoque estoque = new Estoque();
		Integer quantidadeTotal = 0;
		
		for (Venda venda : listaVendas) {
			for (ItemVenda item : venda.getItens()) {
				if(item.getProduto().getId() == produtoId){
					quantidadeTotal += item.getQuantidade();				
				}
			}
		}
		
		estoque.setQuantidadeVendida(quantidadeTotal);
		quantidadeTotal = 0;
		
		for (Compra compra : listaCompras) {
			for (ItemCompra item : compra.getItens()) {
				if(item.getProduto().getId() == produtoId){
					quantidadeTotal += item.getQuantidade();				
				}
			}
		}
		
		estoque.setQuantidadeComprada(quantidadeTotal);			
		
		return estoque;		
	}
	
	public List<Estoque> obterEstoqueAtual(){		
		
		List<Produto> produtos = ProdutoDAO.getInstance().buscarTodos();
		
		for (Produto produto : produtos) {
			Estoque add = obterEstoqueAtualPorProduto(produto.getId());
			add.setProduto(produto);
			estoques.add(add);
		}		
			
		return estoques;		
	}
		
}
