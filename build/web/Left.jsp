<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


            <div class="col-sm-3">
                    <div class="card bg-light mb-3">
                        <div class="card-header bg-primary text-white text-uppercase "><i class="fa fa-list"></i>Danh Mục</div>
                        <ul class="list-group category_block">
                            <c:forEach items="${list_catalog}" var="catalog">
                                <li class="list-group-item text-white  ${c_id_raw == catalog.c_id ? "active": ""}"><a href="catalog?c_id=${catalog.c_id}">${catalog.c_name}</a></li>
                            </c:forEach>
                            <li class="list-group-item text-white  ${c_id_raw == "0" ? "active": ""}"><a href="catalog?c_id=${0}">Tất cả</a></li>
                        </ul>
                    </div>
                    <div class="card bg-light mb-3">
                        <div class="card-header bg-success text-white text-uppercase">Sản phẩm mới</div>
                        <div class="card-body">
                            <img class="card-img-top" src="${hot_product.image}" alt="Card image cap">
                                    <div class="card-body">
                                        <h4 class="card-title show_txt"><a href="detail?p_id=${hot_product.p_id}" title="View Product">${hot_product.p_name}</a></h4>
                                        <p class="card-text show_txt">${hot_product.title}</p>
                                        <div class="row">
                                            <div class="col">
                                                <p class="btn btn-danger btn-block">${hot_product.priceFomat}</p>
                                            </div>
                                            <div class="col">
                                                <a href="#" class="btn btn-success btn-block">Thêm vào giỏ hàng</a>
                                            </div>
                                        </div>
                                    </div>
                        </div>
                    </div>
                </div>
