package control;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProdutoDAO;

public class CarrinhoController extends HttpServlet {
	
	@Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            String strAction = request.getParameter("action");

            if (strAction != null && !strAction.equals("")) {
                if (strAction.equals("add")) {
                    addToCart(request);
                } else if (strAction.equals("Atualizar")) {
                    updateCart(request);
                } else if (strAction.equals("Retirar")) {
                    deleteCart(request);
                } else if (strAction.equals("Finalizar")) {
                    finalizar(request);
                }
            }
            response.sendRedirect("../compra/novo.jsp");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
	
	protected void deleteCart(HttpServletRequest request) {
        HttpSession session = request.getSession();
      /*  String strItemIndex = request.getParameter("itemIndex");
        ProdutoDAO cartBean = null;

        */
    }

    protected void updateCart(HttpServletRequest request) {
        HttpSession session = request.getSession();
      /*  String strQuantity = request.getParameter("quantity");
        String strItemIndex = request.getParameter("itemIndex");

       */
    }

    protected void addToCart(HttpServletRequest request) {
        HttpSession session = request.getSession();
      /*  String strModelNo = request.getParameter("modelNo");
        String strPrice = request.getParameter("price");
        String strQuantity = request.getParameter("quantity");
        */        
    }

    protected void finalizar(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
    }
}
