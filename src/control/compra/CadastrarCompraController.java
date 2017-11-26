package control.compra;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CompraDAO;
import dao.ProdutoDAO;
import dao.UsuarioDAO;
import model.Compra;
import model.ItemCompra;

public class CadastrarCompraController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		super.doGet(req, resp);
	}
	
	protected void Post(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		try {
			String acao =req.getParameter("acao");

            if (acao != null && !acao.equals("")) {
            	if(acao == "cadastrarCompra"){  
            		Compra compra = new Compra();
            		compra.setData(new Date());
            		compra.setUsuario(UsuarioDAO.getInstance().buscarPorId(3l));
            		compra.setItens(finalizar(req));
            		CompraDAO.getInstance().persistir(compra);
            	}
            }
            resp.sendRedirect("../compra/novo.jsp");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }		
	}
	
	protected void UpdateItem(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
    	List<ItemCompra> listaItens = (List) session.getAttribute("lista");
    	
    	for (ItemCompra item : listaItens) {
			if(item.getId() == Long.parseLong(request.getParameter("id"))){
				listaItens.remove(item.getId());
		    	item.setProduto(ProdutoDAO.getInstance().buscarPorId(Long.parseLong(request.getParameter("id"))));
		    	item.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
		    	item.setValorUnitario(Float.parseFloat(request.getParameter("valor"))); 
			}
		} 	
		   	
    	request.getSession().setAttribute("lista", listaItens);     
    }

    protected void AddItem(HttpServletRequest request) {
    	ItemCompra item = new ItemCompra();
    	item.setProduto(ProdutoDAO.getInstance().buscarPorId(Long.parseLong(request.getParameter("id"))));
    	item.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
    	item.setValorUnitario(Float.parseFloat(request.getParameter("valor")));    	
    	HttpSession session = request.getSession();
    	List<ItemCompra> listaItens = (List) session.getAttribute("lista");
    	item.setId(listaItens.size());
    	listaItens.add(item);
    	request.getSession().setAttribute("lista", listaItens);                
    }
    
    protected void RemoveItem(HttpServletRequest request) {
    	HttpSession session = request.getSession();
    	List<ItemCompra> listaItens = (List) session.getAttribute("lista");
    	
    	for (ItemCompra item : listaItens) {
			if(item.getId() == Long.parseLong(request.getParameter("id"))){
				listaItens.remove(item.getId());
			}
		} 	
    	
    	request.getSession().setAttribute("lista", listaItens);
    }

    protected List<ItemCompra> finalizar(HttpServletRequest request) {
        HttpSession session = request.getSession();        
        List<ItemCompra> listaItens = (List) session.getAttribute("lista");
        session.invalidate();
        return listaItens;
    }
	
}
