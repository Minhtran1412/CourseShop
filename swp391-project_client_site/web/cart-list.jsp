<%-- 
    Document   : cart-list
    Created on : Jun 14, 2023, 1:20:19 AM
    Author     : acer
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Your Cart</title>
        <link rel="stylesheet" href="css/cart.css">
        <link
            href='https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css'
            rel='stylesheet'><!-- comment -->
        <link
            href='https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js'
            rel='stylesheet'>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <link type="text/css" rel="stylesheet" href="css/style.css"/>


    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
            <div class="container px-3 my-5 clearfix">
                <!-- Shopping cart table -->
                <div class="card">
                    <div class="card-header">
                        <h2>Shopping Cart</h2>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered m-0">
                                <thead>
                                    <tr>
                                        <!-- Set columns width -->
                                        <th class="text-center py-3 px-4" style="min-width: 400px;">Course Name</th>
                                        <th class="text-right py-3 px-4" style="width: 100px;">Price</th>
                                        <th class="text-center py-3 px-4" style="width: 120px;">Discount</th>
                                        <th class="text-right py-3 px-4" style="width: 100px;">Total</th>
                                        <th class="text-center align-middle py-3 px-0" style="width: 40px;"><a href="#" class="shop-tooltip float-none text-light" title="" data-original-title="Clear cart"><i class="ino ion-md-trash"></i></a></th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:set var="o" value="${sessionScope.cart}"/>
                                <c:forEach items="${o.items}" var="i">     
                                    <tr>
                                        <td class="p-4">
                                            <div class="media align-items-center">
                                                <img src="${i.course.getCourse_img()}" class="d-block ui-w-40 ui-bordered mr-4" alt="">
                                                <div class="media-body">
                                                    <a href="#" class="d-block text-dark">${i.course.getCourse_name()}</a>
                                                    <small>
                                                        <span class="text-muted"></span>
                                                        <span class="ui-product-color ui-product-color-sm align-text-bottom" style="background:#e81e2c;"></span> &nbsp;
                                                        <span class="text-muted"> </span> 
                                                        <span class="text-muted"> </span> 
                                                    </small>
                                                </div>
                                            </div>
                                        </td>
                                        <fmt:formatNumber var="productprice" value="${i.course.getCourse_price()}" type="currency" currencySymbol="₫" />
                                        <td class="text-right font-weight-semibold align-middle p-4">${productprice}</td>
                                        <td class="text-right font-weight-semibold align-middle p-4">${i.course.getCourse_discount()}</td><br/>
                                        <fmt:formatNumber var="totalPrice" value="${i.course.getCourse_price()*(100-i.course.getCourse_discount())/100}" type="currency" currencySymbol="₫" />
                                <td class="text-right font-weight-semibold align-middle p-4"><br>${totalPrice}</td>
                                        <td class="text-center align-middle px-0">
                                            <form action="removeCart" method="POST">
                                                <input type="hidden" name="id" value="${i.course.getCourse_id()}" />
                                                <input type="submit" value="Return course"/>
                                            </form></td>
                                    </tr>                       
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>

                    <!-- / Shopping cart table -->

                    <div class="d-flex flex-wrap justify-content-between align-items-center pb-4">
                        <div class="mt-4">
                            <label class="text-muted font-weight-normal">Discount Code</label>
                            <input type="text" placeholder="ABC" class="form-control">
                        </div>
                        <div class="d-flex">
                            <div class="text-right mt-4 mr-5">
                                <label class="text-muted font-weight-normal m-0">Size</label>
                                <c:set var="size" value="${sessionScope.size}"/>
                                <div class="text-large"><strong>${sessionScope.size}</strong></div>
                            </div>
                            <div class="text-right mt-4">
                                <label class="text-muted font-weight-normal m-0">Total price</label>
                                <fmt:formatNumber var="totalPrice" value="${o.getTotalMoney()}" type="currency" currencySymbol="₫" />
                                <div class="text-large"><strong>${totalPrice}</strong></div>
                            </div>
                        </div>
                    </div>

                    <div class="float-right">
                        <a href="home" type="button" class="btn btn-lg btn-default md-btn-flat mt-2 mr-3">Back to shopping</a>
                        <form action="checkOut" method="POST">
                            <input type="hidden" name="order_id" value="${i.getCourse_id()}" />
                            <button type="submit" class="btn btn-lg btn-primary mt-2">Checkout</button>
                        </form>
                    </div>

                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
        <script>
            var priceElements = document.querySelectorAll('.text-large, .text-right');
            priceElements.forEach(function (element) {
                var priceText = element.textContent;

                // Kiểm tra xem giá trị có chứa chuỗi ".00" hay không
                if (priceText.includes(".00")) {
                    // Loại bỏ chuỗi ".00" bằng cách sử dụng hàm replace()
                    var formattedPrice = priceText.replace(".00", "");

                    // Gán lại giá trị đã được khử đuôi ".00"
                    element.textContent = formattedPrice;
                }
            });
        </script>

    </body>
</html>