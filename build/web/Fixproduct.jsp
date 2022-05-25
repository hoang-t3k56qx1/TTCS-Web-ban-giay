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
        <title>Sửa sản phẩm</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <div class="modal-dialog">
            <div class="modal-content">
                <form action="fixproduct" method="POST">
                    <div class="modal-header">						
                        <h4 class="modal-title">Sửa sản phẩm</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label>Mã</label>
                            <input type="text" name="p_id" value="${product.p_id}" class="form-control" readonly>
                        </div>
                        <div class="form-group">
                            <label>Tên</label>
                            <input type="text" name="p_name" value="${product.p_name}" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label>Hình ảnh</label>
                            <input type="text" name="image" value="${product.image}" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label>Giá</label>
                            <input type="text" name="price" value="${product.price}"  class="form-control" required>
                        </div>
                        <div class="form-group">
                                <label>Nội dung</label>
                                <textarea name="title" class="form-control" required>${product.title}</textarea>
                            </div>
                            <div class="form-group">
                                <label>Mô tả</label>
                                <textarea name="discription"  class="form-control" required>${product.discription}</textarea>
                            </div>
                    </div>
                    <div class="modal-footer">
                        <input type="submit" class="btn btn-info" value="Save">
                    </div>
                </form>
            </div>
        </div>

    </body>
</html>
