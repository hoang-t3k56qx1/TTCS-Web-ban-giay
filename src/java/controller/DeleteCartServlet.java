package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cart;

public class DeleteCartServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int p_id = Integer.parseInt(request.getParameter("p_id"));
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        cart.removeItem(p_id);
        session.setAttribute("cart", cart);
        response.sendRedirect("Cart.jsp");
    }

 
}
