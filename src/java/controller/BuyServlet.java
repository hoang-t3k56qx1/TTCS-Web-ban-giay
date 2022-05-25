package controller;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cart;
import model.User;

public class BuyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String thanhcong = "Đặt hàng thành công!";
        HttpSession session = request.getSession();
        DAO dao = new DAO();
        User user = (User) session.getAttribute("user");
        Cart cart = (Cart) session.getAttribute("cart");
        if (user != null) {
            dao.addOrder(user, cart);
            request.setAttribute("thanhcong", thanhcong);
            session.removeAttribute("cart");
            request.getRequestDispatcher("Cart.jsp").forward(request, response);
        }
        request.getRequestDispatcher("Login.jsp").forward(request, response);
    }

}
