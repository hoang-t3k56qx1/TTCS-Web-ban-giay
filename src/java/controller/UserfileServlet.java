package controller;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;

/**
 *
 * @author HOANG
 */
public class UserfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String thanhcong = "Thay đổi thông tin thành công";
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String dateofbirth = request.getParameter("dateofbirth");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        DAO dao = new DAO();
        dao.UpdateUser(id, name, dateofbirth, phone, email);
        User user = (User) dao.getUserById(id);
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        request.setAttribute("thanhcong1", thanhcong);
        request.getRequestDispatcher("UserProfile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String pass1 = request.getParameter("pass1");
        String pass2 = request.getParameter("pass2");
        String loi = "Mật khẩu không khớp";
        String thanhcong = "Thay đổi mật khẩu thành công";
        if (pass1.equals(pass2)){
            request.setAttribute("thanhcong2", thanhcong);
            DAO dao = new DAO();
            dao.UpdatePassUser(id, pass2);
            request.getRequestDispatcher("UserProfile.jsp").forward(request, response);
        }
        else{
            request.setAttribute("loi", loi);
            request.setAttribute("pass1", pass1);
            request.setAttribute("pass2", pass2);
            request.getRequestDispatcher("UserProfile.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
