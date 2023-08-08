<%-- 
    Document   : orderdetail
    Created on : May 24, 2023, 11:37:11 PM
    Author     : doanq
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>DASHMIN - Bootstrap Admin Template</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="" name="keywords">
        <meta content="" name="description">

        <!-- Favicon -->
        <link href="img/favicon.ico" rel="icon">

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600;700&display=swap" rel="stylesheet">

        <!-- Icon Font Stylesheet -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

        <!-- Libraries Stylesheet -->
        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
        <link href="lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />

        <!-- Customized Bootstrap Stylesheet -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Template Stylesheet -->
        <link href="css/style.css" rel="stylesheet">
    </head>

    <body>
        <div class="container-xxl position-relative bg-white d-flex p-0">
            <!-- Spinner Start -->
            <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
                <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
                    <span class="sr-only">Loading...</span>
                </div>
            </div>
            <!-- Spinner End -->


            <!-- Sidebar Start -->
            <div class="sidebar pe-4 pb-3">
                <nav class="navbar bg-light navbar-light">
                    <a href="#" class="navbar-brand mx-4 mb-3">
                        <h3 class="text-primary"><i class="icon-home"></i>ADMIN PAGE</h3>
                    </a>

                    <div class="d-flex align-items-center ms-4 mb-4">
                        <div class="position-relative">
                            <img class="rounded-circle" src="${sessionScope.account.getAccount_avatar()}" alt="" style="width: 40px; height: 40px;">
                            <div class="bg-success rounded-circle border border-2 border-white position-absolute end-0 bottom-0 p-1"></div>
                        </div>
                        <div class="ms-3">
                            <h6 class="mb-0">${sessionScope.account.getAccount_name()}</h6>
                            <c:if test="${sessionScope.account.getAccount_role() == 0}">
                                <span>Admin</span>
                            </c:if>

                            <c:if test="${sessionScope.account.getAccount_role() == 1}">
                                <span>Manager</span>
                            </c:if>                       
                        </div>
                    </div>
                    <div class="navbar-nav w-100">
                                              
                        <c:if test="${sessionScope.account.getAccount_role() == 0}">
                            <a href="admin_acc_manage" class="nav-item nav-link"><i class="fa fa-keyboard me-2"></i>&nbsp;&nbsp;Account Manage</a>
                        </c:if>
                        <a href="accountcusmanage" class="nav-item nav-link"><i class="fa fa-table me-2"></i>Account Customer</a>
                        <a href="coursemanage" class="nav-item nav-link"><i class="fa fa-table me-2"></i>Course Manage</a>  
                        <a href="ordermanage" class="nav-item nav-link active"><i class="fa fa-table me-2"></i>Order Manage</a>             
                        
                    </div>
                </nav>
            </div>
            <!-- Sidebar End -->


            <!-- Content Start -->
            <div class="content">
                <!-- Navbar Start -->
                <nav class="navbar navbar-expand bg-light navbar-light sticky-top px-4 py-0">
                    <a href="" class="navbar-brand d-flex d-lg-none me-4">
                        <h2 class="text-primary mb-0"><i class="fa fa-hashtag"></i></h2>
                    </a>
                    <a href="#" class="sidebar-toggler flex-shrink-0">
                        <i class="fa fa-bars"></i>
                    </a>
                    <form class="d-none d-md-flex ms-4">
                        
                    </form>
                    <div class="navbar-nav align-items-center ms-auto">
                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">
                                <img class="rounded-circle me-lg-2" src="${sessionScope.account.getAccount_avatar()}" alt="" style="width: 40px; height: 40px;">
                                <span class="d-none d-lg-inline-flex">${sessionScope.account.getAccount_name()}</span>
                            </a>
                            <div class="dropdown-menu dropdown-menu-end bg-light border-0 rounded-0 rounded-bottom m-0">
                                <a href="profileinfo?account_id=${sessionScope.account.getAccount_id()}" class="dropdown-item">My Profile</a>
                                <a href="logout" class="dropdown-item">Log Out</a>
                            </div>
                        </div>
                    </div>
                </nav>
                <!-- Navbar End -->


                <!-- Table Start -->
                <div class="container-fluid pt-4 px-4">
                    <div class="row g-4">

                        <div class="bg-light rounded h-100 p-4">

                            <h6 class="mb-4">Order Detail</h6>
                            <form class="content-wrapper forms-sample mt-3">
                                <!--<div class="row ">-->
                                <div class="col-12 grid-margin">
                                    <div class="card">
                                        <div class="card-body">
                                            <div class="row">  
                                                <div class="col-sm-8">
                                                    <h2 style="font-weight: bold" class="card-title col-10">Course Online Shop</h2>
                                                </div>
                                                <div class="col-sm-4" style="padding-left: 50px">
                                                    <label>Đc: Số 1 Vạn Phúc, HĐ</label><br>
                                                    <label>ĐT: 097894859990</label>
                                                </div>
    <!--                                            <a href="OrderIO?OrderId=${order.orderId}">
                                                <button>Export</button>
                                                </a>-->
                                            </div>
                                            <div class="row" style="padding-top: 30px">
                                                <div class="col-sm-8">
                                                    <h3 style="font-weight: bold; padding-left: 300px" class="card-title col-10">ORDER: #${o.getOrder_id()}</h3>
                                                </div>
                                                <div class="col-sm-4" style="padding-left: 50px">
                                                    <label>Ngày:${o.getOrder_date()}</label><br>
                                                </div>
                                            </div>
                                            <h4 class="card-title">Customer Information: </h4>
                                            <div class="form-group" style="margin-bottom: 0px; padding-left: 5px; padding-bottom: 30px">
                                                <label>${o.getCustomer_name()}</label>
                                                <br>
                                                <label>Điện thoại:${o.getCustomer_phone()}</label>
                                                <br>
                                                <label>Email: ${o.getCustomer_email()}</label>
                                                <br>
                                                <label>Address: ${o.getCustomer_address()}</label>
                                            </div>








                                            <table class="table">
                                                <thead>
                                                    <tr>
                                                        <th scope="col">Course Name</th>
                                                        <th scope="col">Image</th>
                                                        <th scope="col">Price</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:set var="total" value="0" />    
                                                    <c:forEach items="${getListCourseByOrderId}" var="i">
                                                        <tr>
                                                            <td>${i.getCourse_name()}</td>
                                                            <td><img src="./${i.getCourse_img()}" style="width: 275px;height: 160px" ></td>
                                                                <fmt:formatNumber var="formattedPrice" value="${i.getCourse_price()*(100-i.getCourse_discount())/100}" type="currency" currencySymbol="₫" />
                                                                <c:set var="total" value="${total + (i.getCourse_price()*(100-i.getCourse_discount())/100)}" />
                                                            <td>${formattedPrice}</td>
                                                        </tr>
                                                    </c:forEach>


                                                </tbody>

                                            </table>
                                            <fmt:formatNumber var="formattedTotal" value="${total}" type="currency" currencySymbol="₫" />
                                            <div style="display: flex; justify-content: space-between;">
                                                <span>Total:</span>
                                                <span>${formattedTotal}</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>


                    </div>
                </div>
                <!-- Table End -->


                <!-- Footer Start -->
                <div class="container-fluid pt-4 px-4">
                    <div class="bg-light rounded-top p-4">
                        <div class="row">
                            <div class="col-12 col-sm-6 text-center text-sm-start">
                                &copy; <a href="#">Your Site Name</a>, All Right Reserved. 
                            </div>
                            <div class="col-12 col-sm-6 text-center text-sm-end">
                                <!--/*** This template is free as long as you keep the footer author’s credit link/attribution link/backlink. If you'd like to use the template without the footer author’s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
                                Designed By <a href="https://htmlcodex.com">HTML Codex</a>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Footer End -->
            </div>
            <!-- Content End -->


            <!-- Back to Top -->
            <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>
        </div>

        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
        <script src="lib/chart/chart.min.js"></script>
        <script src="lib/easing/easing.min.js"></script>
        <script src="lib/waypoints/waypoints.min.js"></script>
        <script src="lib/owlcarousel/owl.carousel.min.js"></script>
        <script src="lib/tempusdominus/js/moment.min.js"></script>
        <script src="lib/tempusdominus/js/moment-timezone.min.js"></script>
        <script src="lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

        <!-- Template Javascript -->
        <script src="js/main.js"></script>
    </body>

</html>