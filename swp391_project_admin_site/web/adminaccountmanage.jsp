<%-- 
    Document   : table
    Created on : May 19, 2023, 10:51:08 PM
    Author     : doanq
--%>

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

        <!-- Icon Source  -->
        <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.no-icons.min.css" rel="stylesheet">
        <link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet"><!-- comment -->
        <script src="https://kit.fontawesome.com/f37fd9a66c.js" crossorigin="anonymous"></script>
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

        <!-- Style button -->
        <style>
            .button {
                background-color: #46CED4;
                border: none;
                padding: 10px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 16px;
                margin: 4px 2px;
                cursor: pointer;
                border-radius: 8px;
            }
            .group input[type="text"] ~ .fa-eye-slash{
                display: none;
            }
            .group input[type="password"] ~ .fa-eye{
                display: none;
            }
        </style>
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
                            <a href="admin_acc_manage" class="nav-item nav-link active"><i class="fa fa-keyboard me-2"></i>Account Management</a>
                        </c:if>
                        <a href="accountcusmanage" class="nav-item nav-link"><i class="fa fa-table me-2"></i>Account Customer</a>
                        <a href="coursemanage" class="nav-item nav-link"><i class="fa fa-table me-2"></i>Course Management</a>  
                        <a href="ordermanage" class="nav-item nav-link"><i class="fa fa-table me-2"></i>Order Management</a>
                        
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
                        <div class="col-12">
                            <div class="bg-light rounded h-100 p-4">
                                <h3 class="mb-4" style="color: #46CED4">Admin Account Manage</h3>  
                                <button class="button" type="submit" onclick="openLink('createaccount')"><span><i class="fa-solid fa-plus"></i> Create New Account</span></button>
                                <div class="table-responsive">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th scope="col">Account Id</th>
                                                <th scope="col">Role</th>
                                                <th scope="col">Name</th>
                                                <th scope="col">Username</th>
                                                <th scope="col">Password</th>
                                                <th scope="col"></th>
                                            </tr>
                                        </thead>
                                        <tbody>


                                            <c:forEach items="${requestScope.listacc}" var="a">
                                                <tr>
                                                    <th scope="row">${a.getAccount_id()}</th>
                                                    <td>${a.getAccount_role()=='0'?"Admin":"Manager"}</td>
                                                    <td>${a.getAccount_name()}</td>
                                                    <td>${a.getAccount_username()}</td>
                                                    <td>                                                        
                                                        <div class="group">
                                                            <input type="password" placeholder=" " id="password${a.getAccount_id()}" value="${a.getAccount_password()}" readonly>
                                                            <i class="fa-regular fa-eye"
                                                               onclick="changeTypePassword(${a.getAccount_id()})"
                                                               ></i>
                                                            <i class="fa-regular fa-eye-slash"
                                                               onclick="changeTypePassword(${a.getAccount_id()})"
                                                               ></i>
                                                        </div>
                                                    </td>

                                                    <c:set var="id" value="${a.getAccount_id()}" />
                                                    <td>
                                                        <a style="color: black" href="updateinfo?id=${a.getAccount_id()}&mode=accupdate"><i class="fa-sharp fa-solid fa-pen"></i></a>
                                                        <a style="color: black" href="profileinfo?account_id=${a.getAccount_id()}&mode=view"><i class="fa-solid fa-circle-info"></i></a>
                                                        <a style="color: black" onclick="checkDelete(${a.getAccount_id()})"><i class="fa-solid fa-trash"></i></a>
                                                    </td>
                                                </tr>
                                            <script>
                                                function changeTypePassword(accid) {
//                                                    alert(accid);
                                                    document.getElementById('password' + accid).type = document.getElementById('password' + accid).type === 'text' ? 'password' : 'text';
                                                }
                                                function checkDelete(accid) {
                                                    if (confirm("Do you want this account with id = " + accid + " ?")) {
                                                        openLink('deleteacc?account_id='+accid);
                                                    }
                                                }
                                            </script>
                                        </c:forEach>   
                                        </tbody>
                                    </table>
                                </div>
                            </div>
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

        <script>
            function openLink(link) {
                location.replace(link);
            }
        </script>

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