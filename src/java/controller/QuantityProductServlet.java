package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cart;
import model.Item;


public class QuantityProductServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int p_id = Integer.parseInt(request.getParameter("p_id"));
        int i = Integer.parseInt(request.getParameter("d"));
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        for (Item item : cart.getItems()) {
            if(item.getProduct().getP_id()== p_id){
                item.setQuantity(item.getQuantity()+i);
                if(item.getQuantity() <1 ) cart.removeItem(p_id);
                break;
            }
        }
        response.sendRedirect("Cart.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
