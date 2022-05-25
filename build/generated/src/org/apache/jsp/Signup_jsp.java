package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Signup_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<link href=\"//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" rel=\"stylesheet\" id=\"bootstrap-css\">\n");
      out.write("<script src=\"//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\"></script>\n");
      out.write("<script src=\"//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("<!------ Include the above in your HEAD tag ---------->\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.3.1/css/all.css\" integrity=\"sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU\" crossorigin=\"anonymous\">\n");
      out.write("        <link href=\"css/login.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <title>Login Form</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"logreg-forms\">\n");
      out.write("           \n");
      out.write("            <form action=\"signup\" method=\"post\" class=\"form-signup\">\n");
      out.write("                <h1 class=\"h3 mb-3 font-weight-normal\" style=\"text-align: center\"> Sign up</h1>\n");
      out.write("                <input name=\"user\" type=\"text\" id=\"user-name\" class=\"form-control\" placeholder=\"Tên tài khoản\" required=\"\" autofocus=\"\">\n");
      out.write("                <input name=\"pass\" type=\"password\" id=\"user-pass\" class=\"form-control\" placeholder=\"Mật khẩu\" required autofocus=\"\">\n");
      out.write("                <input name=\"repass\" type=\"password\" id=\"user-repeatpass\" class=\"form-control\" placeholder=\"Nhập lại mật khẩu\" required autofocus=\"\">\n");
      out.write("                <input name=\"name\" type=\"text\" id=\"user-name\" class=\"form-control\" placeholder=\"Tên người dùng\" required=\"\" autofocus=\"\">\n");
      out.write("                <input name=\"dateofbirth\" type=\"text\" id=\"user-name\" class=\"form-control\" placeholder=\"Năm sinh theo định dạng dd/MM/yyyy\" required=\"\" autofocus=\"\">\n");
      out.write("                <input name=\"email\" type=\"text\" id=\"user-name\" class=\"form-control\" placeholder=\"Email\" required=\"\" autofocus=\"\">\n");
      out.write("                <input name=\"phone\" type=\"text\" id=\"user-name\" class=\"form-control\" placeholder=\"Số điện thoại\" required=\"\" autofocus=\"\">\n");
      out.write("                <button class=\"btn btn-primary btn-block\" type=\"submit\"><i class=\"fas fa-user-plus\"></i> Đăng kí</button>\n");
      out.write("                <a href=\"Login.jsp\" id=\"cancel_signup\"><i class=\"fas fa-angle-left\"></i> Quay lại</a>\n");
      out.write("            </form>\n");
      out.write("            <br>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
