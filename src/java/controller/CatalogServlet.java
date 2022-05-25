
package controller;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Catalog;
import model.Product;


public class CatalogServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DAO dao = new DAO();
        String c_id_raw = request.getParameter("c_id");
        int c_id = Integer.parseInt(c_id_raw);
        
        List<Product> list_product = dao.getProductByCID(c_id);
        List<Catalog> list_catalog = dao.getAllCatalog();
        Product hot_product = dao.getLast();
        request.setAttribute("c_id_raw", c_id_raw);
        request.setAttribute("list_product", list_product);
        request.setAttribute("list_catalog", list_catalog);
        request.setAttribute("hot_product", hot_product);
        request.getRequestDispatcher("Home.jsp").forward(request, response);
    }


    @Override
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
