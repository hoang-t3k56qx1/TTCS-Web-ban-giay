<%-- 
    Document   : Fixproduct
    Created on : Apr 1, 2022, 11:08:21 PM
    Author     : HOANG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hồ sơ</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <button type="button" class="btn btn-success"><a class="navbar-brand" href="home">Về trang chủ</a></button>
        <div class="modal-dialog">
            <div class="modal-content">
                <form action="userfile" method="get">
                    <h3 style="color: #2196F3">${thanhcong1}</h3>
                    <div class="modal-header">						
                        <h4 class="modal-title">Sửa đổi thông tin cá nhân</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label>Mã</label>
                            <input type="text" name="id" value="${user.u_id}" class="form-control" readonly>
                        </div>
                        <div class="form-group">
                            <label>Tên</label>
                            <input type="text" name="name" value="${user.u_name}" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label>Ngày sinh</label>
                            <input type="text" name="dateofbirth" value="${user.dateofbirth}" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label>Số điện thoại</label>
                            <input type="text" name="phone" value="${user.phone}"  class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label>Email</label>
                            <input type="text" name="email" value="${user.email}"  class="form-control" required>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <input type="submit" class="btn btn-info" value="Lưu">
                    </div>
                </form>
            </div>
            <div class="modal-content">
                <form action="userfile" method="POST">
                    <h3 style="color: #2196F3">${thanhcong2}</h3>
                    <div class="modal-header">						
                        <h4 class="modal-title">Đổi mật khẩu</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <div class="form-group">
                            <label>Mã</label>
                            <input type="text" name="id" value="${user.u_id}" class="form-control" readonly>
                        </div>
                        <div class="form-group">
                            <label>Mật khẩu mới</label>
                            <input type="password" name="pass1" value="${product.p_name}" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label>Xác nhận mật khẩu</label>
                            <input type="password" name="pass2" value="${product.image}" class="form-control" required>
                        </div>
                        <h4 style="color: #F44336">${loi}</h4>
                    </div>
                    <div class="modal-footer">
                        <input type="submit" class="btn btn-info" value="Thay đổi">
                    </div>
                </form>
            </div>
        </div>

    </body>
</html>
