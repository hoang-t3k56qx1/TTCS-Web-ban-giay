package controller;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int p_id = Integer.parseInt(request.getParameter("p_id"));
        DAO dao = new DAO();
        dao.deleteProduct(p_id);
        request.getRequestDispatcher("manager").forward(request, response);
    }

  
}
