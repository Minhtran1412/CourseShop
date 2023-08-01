<%-- 
    Document   : menu
    Created on : Mar 11, 2023, 7:13:04 PM
    Author     : acer
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- HEADER -->
<header>
    <!-- TOP HEADER -->
    <div id="top-header">
        <div class="container">
            <ul class="header-links pull-left">
                <li><a href="#"><i class="fa fa-phone"></i> +84 398665351</a></li>
                <li><a href="#"><i class="fa fa-envelope-o"></i> group1@fpt.edu.vn</a></li>
                <li><a href="https://www.google.com/maps/search/đại+học+fpt/@21.0133255,105.5246749,17z/data=!3m1!4b1?hl=vi"><i class="fa fa-map-marker"></i> FPT University</a></li>
            </ul>
            <ul class="header-links pull-right">
                    <c:if test="${sessionScope.acc != null}">                   
                    <div class="w3-dropdown-hover" >
                        <button class="w3-button" style="color: white; font-size: 12px ; display: inline-block; "><i class="fa fa-user-o" style="color: #1e88e5"></i> Hello-${sessionScope.acc.customer_name}</button>
                        <div class="w3-dropdown-content w3-bar-block w3-border">
                            <a href="loadProfile?customer_id=${sessionScope.acc.customer_id}" style="font-size: 12px;"><i class="fa fa-user-o"style="color: #1e88e5" ></i> Manager My Account</a><br>
                            <a href="cart-list.jsp" style="font-size: 12px;"><i class="fa fa-list-alt"style="color: #1e88e5"></i> My Card</a><br>
                            <a href="#" style="font-size: 12px;"><i class="fa fa-comment"style="color: #1e88e5"></i> My Comment</a><br>
                            <a href="mycourse" style="font-size: 12px;"><i class="fa fas fa-heart"style="color: #1e88e5"></i> My course</a><br>
                            <a href="logout" style="font-size: 12px;"><i class="fa fa-power-off"style="color: #1e88e5"></i> Logout(${sessionScope.acc.customer_name})</a>
                        </div>
                    </div>
                </c:if>
                <c:if test="${sessionScope.acc == null}">
                    <li><a href="login.jsp"><i class="fa fa-user-o"></i> Login</a></li>
                    </c:if>
            </ul>
        </div>
    </div>
    <!-- /TOP HEADER -->

    <!-- MAIN HEADER -->
    <div id="header">
        <!-- container -->
        <div class="container">
            <!-- row -->
            <div class="row">
                <!-- LOGO -->
                <div class="col-md-3">
                    <div class="header-logo">
                        <a href="#" class="logo">
                            <img src="./usercss/images/CourseImage/logoedu.jpg" alt="">
                        </a>
                    </div>
                </div>
                <!-- /LOGO -->

                <!-- SEARCH BAR -->
                <div class="col-md-6">
                    <div class="header-search">
                        <form action="searchcourse" method="get">
                            <select class="input-select" name="filtersearch" required>
                                <c:if test="${not empty filtersearch }" >
                                    <option value="${filtersearch}" selected hidden>${filtersearch}</option>
                                </c:if>
                                <option value="All"> All </option>
                                <option value="Category Name"> Category Name </option>
                                <option value="Course Name"> Course Name </option>
                                <option value="Supplier Name"> Supplier Name </option>
                            </select>
                            <input class="input" placeholder="Search here" name="search" type="text" value="${search}">
                            <button class="search-btn" type="submit">Search</button>
                        </form>
                    </div>
                </div>
                <!-- /SEARCH BAR -->

                <!-- ACCOUNT -->
                <div class="col-md-3 clearfix">
                    <div class="header-ctn">
                        <!-- Wishlist -->
                        
                        <!-- /Wishlist -->

                        <!-- Cart -->
                        <div class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">
                                <i class="fa fa-shopping-cart"></i>
                                <span>Your Cart</span>
                                <div class="qty">
                                    <c:out value="${sessionScope.acc == null || sessionScope.size eq  0 ? '0' : sessionScope.size}" />
                                </div>
                            </a>
                            <div class="cart-dropdown">
                                <div class="cart-list">
                                    <c:forEach items="${listS}" var="o">
                                        <div class="product-widget">
                                            <div class="product-img">
                                                <img src="${o.image}" alt="">
                                            </div>
                                            <div class="product-body">
                                                <p class="product-category">${o.categories.describe}</p>
                                                <h3 class="product-name"><a href="detail?pid=${o.productID}">${o.productName}</a></h3>
                                                <h4 class="product-price">${o.price}</h4>
                                            </div>
                                        </div>

                                    </c:forEach>
                                </div>
                                <div class="cart-summary">
                                    <small>${sessionScope.size} items selected</small>
                                    <fmt:formatNumber var="totalMoney" value="${sessionScope.cart.getTotalMoney()}" type="currency" currencySymbol="" />
                                    <h5 class="price">Total: ${totalMoney} VNĐ</h5>
                                </div>
                                <div class="cart-btns">
                                    <a href="cart-list.jsp">View Cart</a>
                                </div>
                            </div>
                        </div>                         
                        <!-- /Cart -->

                        <!-- Menu Toogle -->
                        <div class="menu-toggle">
                            <a href="#">
                                <i class="fa fa-bars"></i>
                                <span>Menu</span>
                            </a>
                        </div>
                        <!-- /Menu Toogle -->
                    </div>
                </div>
                <!-- /ACCOUNT -->
            </div>
            <!-- row -->
        </div>
        <!-- container -->
    </div>
                                <script>
            var priceElements = document.querySelectorAll('.price');
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
    <!-- /MAIN HEADER -->
</header>
<!-- /HEADER -->