<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
        <title>Signup Form</title>
    </head>
    <body>
        <div id="logreg-forms">
           

            <form class="form-signin" action="signup" method="post">
                <h1 class="h3 mb-3 font-weight-normal" style="text-align: center"> Sign up</h1>
                <c:if test="${error_message}" >
                    <div class="alert alert-danger" role="alert">
                        Mật khẩu không đồng nhất!
                    </div>
                </c:if>
                <c:if test="${user_message}" >
                    <div class="alert alert-warning" role="alert">
                        Tài khoản đã tồn tại
                    </div>
                </c:if>
                
                    <input name="user" value="${user}" type="text" id="user-name" class="form-control" placeholder="Tên tài khoản" required="" autofocus="">
                <input name="pass" value="${pass}" type="password" id="user-pass" class="form-control" placeholder="Mật khẩu" required autofocus="">
                <input name="repass" value="${repass}" type="password" id="user-repeatpass" class="form-control" placeholder="Nhập lại mật khẩu" required autofocus="">
                <input name="name" value="${name}"  type="text" id="user-name" class="form-control" placeholder="Tên người dùng" required="" autofocus="">
                <input name="dateofbirth" value="${dateofbirth}" type="text" id="user-name" class="form-control" placeholder="Năm sinh theo định dạng dd/MM/yyyy" required="" autofocus="">
                <input name="email" value="${email}" type="text" id="user-name" class="form-control" placeholder="Email" required="" autofocus="">
                <input name="phone" value="${phone}" type="text" id="user-name" class="form-control" placeholder="Số điện thoại" required="" autofocus="">
                <button class="btn btn-primary btn-block" type="submit"><i class="fas fa-user-plus"></i> Đăng kí</button>
                <a href="Login.jsp" id="cancel_signup"><i class="fas fa-angle-left"></i> Quay lại</a>
            </form>
            <br>

        </div>
        
    </body>
</html>