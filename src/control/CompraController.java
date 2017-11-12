package control;

import java.util.List;

import dao.CompraDAO;
import model.Compra;

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
		return CompraDAO.getInstance().deletar(compra);
	}

}
