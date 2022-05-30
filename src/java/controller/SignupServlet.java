
package controller;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

public class SignupServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String repass = request.getParameter("repass");
        String name = request.getParameter("name");
        name = URLDecoder.decode(name, "UTF-8");
        String dateofbirth = request.getParameter("dateofbirth");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        DAO dao = new DAO();
        User USER = dao.login(user, pass);
        boolean success_message= false;// thong bao ve Login.jsp dk thanh cong
        boolean user_message= false;// thong bao user da ton tai
        boolean error_message= false;// mat khau ko dong nhat
        boolean email_message= false;// email da ton tai
        String url="";
        if(!pass.equals(repass)){// mat ko dong nhat
            error_message=true;
            url="Signup.jsp";
        }
        else if(dao.check_User_user(user)){// tai khoan da ton tai
            user_message=true;
            url="Signup.jsp";
        }
        else if(dao.check_User_email(email)){// email da ton tai
            email_message=true;
            url="Signup.jsp";
        }
        else{
            success_message=true;
            dao.addUser(user, pass, name, dateofbirth, email, phone);
            url="Login.jsp";
        }
            request.setAttribute("email_message", email_message);
            request.setAttribute("success_message", success_message);
            request.setAttribute("error_message", error_message);
            request.setAttribute("user_message", user_message);
            request.setAttribute("user", user);
            request.setAttribute("pass", pass);
            request.setAttribute("repass", repass);
            request.setAttribute("name", name);
            request.setAttribute("dateofbirth", dateofbirth);
            request.setAttribute("email", email);
            request.setAttribute("phone", phone);
            request.getRequestDispatcher(url).forward(request, response);
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
