package control;

import java.util.List;

import dao.CompraDAO;
import dao.ItemCompraDAO;
import model.Compra;
import model.ItemCompra;

public class CompraController {
	
	public boolean persistir(Compra compra){
		return CompraDAO.getInstance().persistir(compra) != null;
	}
	
	public List<Compra> buscarTodos(){
		return CompraDAO.getInstance().buscarTodos();
	}
	
	public Compra buscarPorId(long id){
		return CompraDAO.getInstance().buscarPorId(id);
	}
	
	public boolean deletar(Compra compra){
		 List<ItemCompra> itens = compra.getItens();
		 
		 for (ItemCompra itemCompra : itens) {		   
			 ItemCompraDAO.getInstance().deletar(itemCompra);
		}		
		return CompraDAO.getInstance().deletar(compra);
	}

}
