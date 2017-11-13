package control;

import java.util.List;

import dao.VendaDAO;
import model.Venda;

public class VendaController {
	
	public List<Venda> buscarTodos(){
		return VendaDAO.getInstance().buscarTodos();
	}
	
	public Venda buscarPorId(long id){
		return VendaDAO.getInstance().buscarPorId(id);
	}
	
   public boolean persistir(Venda venda){
	   return VendaDAO.getInstance().persistir(venda) != null;
   }
   
   public boolean deletar(Venda venda){
	   return VendaDAO.getInstance().deletar(venda);
   }

}
