package control;

import java.util.List;

import dao.PrecoDAO;
import model.Preco;

public class PrecoController {

	public boolean persistir (Preco preco){
		return PrecoDAO.getInstance().persistir(preco) != null;
	}
	
	public List<Preco> buscarTodos(){
		return PrecoDAO.getInstance().buscarTodos();
	}
	
	public Preco buscarPorId(long id){
		return PrecoDAO.getInstance().buscarPorId(id);
	}
	
	public boolean deletar(Preco preco){
		return PrecoDAO.getInstance().deletar(preco);
	}
	
	
	
}
