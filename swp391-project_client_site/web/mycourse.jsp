<%-- 
    Document   : mycourse
    Created on : Jun 26, 2023, 8:32:04 PM
    Author     : doanq
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags must come first in the head; any other head content must come after these tags -->

        <title>Store</title>

        <!-- Google font -->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">

        <!-- Bootstrap -->
        <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css"/>

        <!-- Slick -->
        <link type="text/css" rel="stylesheet" href="css/slick.css"/>
        <link type="text/css" rel="stylesheet" href="css/slick-theme.css"/>

        <!-- nouislider -->
        <link type="text/css" rel="stylesheet" href="css/nouislider.min.css"/>

        <!-- Font Awesome Icon -->
        <link rel="stylesheet" href="css/font-awesome.min.css">

        <!-- Custom stlylesheet -->
        <link type="text/css" rel="stylesheet" href="css/style.css"/>

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>
    <body>
        <script>
            function openLink(link) {
                location.replace(link)
            }
        </script>

        <jsp:include page="menu.jsp"></jsp:include>
            <!-- NAVIGATION -->
            <nav id="navigation">
                <!-- container -->
                <div class="container">
                    <!-- responsive-nav -->
                    <div id="responsive-nav">
                        <!-- NAV -->
                        <ul class="main-nav nav navbar-nav">
                            <li><a href="home">Home</a></li>
                            <li ><a href="courseofcategory">All Course</a></li>
                            <li class="active"><a href="mycourse">My Course</a></li>
                        </ul>
                        <!-- /NAV -->
                    </div>
                    <!-- /responsive-nav -->
                </div>
                <!-- /container -->
            </nav>
            <!-- /NAVIGATION -->

            <!-- BREADCRUMB -->
            <!--        <div id="breadcrumb" class="section">
                         container 
                        <div class="container">
                             row 
                            <div class="row">
                                <div class="col-md-12">
                                    <ul class="breadcrumb-tree">
                                        <li><a href="#">Home</a></li>
                                        <li><a href="#">All Categories</a></li>
                                    </ul>
                                </div>
                            </div>
                             /row 
                        </div>
                         /container 
                    </div>-->
            <!-- /BREADCRUMB -->

            <!-- SECTION -->
            <div class="section">
                <!-- container -->
                <div class="container">
                    <!-- row -->
                    <div class="row">
                        <!-- ASIDE -->
                        <div id="aside" class="col-md-3">
                            <!-- aside Widget -->
                            <form  id="myFilterCourse" action="filtermycourse" method="get">
                                <div class="aside">
                                    <h3 class="aside-title">Categories</h3>
                                    <div class="checkbox-filter">
                                    <c:forEach items="${listCategories}" var="i">
                                        <div class="input-checkbox">
                                            <input type="checkbox" ${checkedCategories.contains(i.getCategory_id()) ? 'checked' : ''} id="${i.getCategory_id()}" name="category_id" value="${i.getCategory_id()}" onchange="submitForm()" >
                                            <label for="${i.getCategory_id()}">
                                                <span></span>
                                                ${i.getCategory_name()}
                                            </label>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                            <!-- /aside Widget -->

                            <!-- aside Widget -->

                        </form>
                        <script>
                            function submitForm() {
                                document.getElementById("myFilterCourse").submit(); // Gửi yêu cầu khi có thay đổi
                            }
                        </script>

                        <!-- aside Widget -->
                        <!-- /aside Widget -->
                    </div>
                    <!-- /ASIDE -->

                    <!-- STORE -->
                    <div id="store" class="col-md-9">
                        <!-- store top filter -->
                        <div class="store-filter clearfix">

                            <!--                            <ul class="store-grid">
                                                            <li class="active"><i class="fa fa-th"></i></li>
                                                            <li><a href="#"><i class="fa fa-th-list"></i></a></li>
                                                        </ul>-->
                        </div>

                        <!-- /store top filter -->

                        <!-- store products -->
                        <div class="row">
                            <!-- product -->
                            <c:forEach items="${getListMyCourse}" var="i">
                                <div class="col-md-4 col-xs-6" >
                                    <div class="product">
                                        <div class="product-img">
                                            <a href="mycoursedetail?course_id=${i.getCourse_id()}"><img src="${i.getCourse_img()}" style="width: 263px; height: 150px" alt=""></a>
                                        </div>
                                        <div class="product-body" style="width: 262.5px; height: 133.4px">
                                            <p class="product-category">${i.getCategory_name()}</p>
                                            <h3 class="product-name"><a href="mycoursedetail?course_id=${i.getCourse_id()}">${i.getCourse_name()}</a></h3>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>

                            <!-- /product -->

                            <!-- /product -->
                        </div>
                        <!-- /store products -->

                        <!-- store bottom filter -->
                        <div class="store-filter clearfix">
                            <ul class="store-pagination">
                                <c:if test="${endP != 1}">
                                    <c:forEach begin="1" end="${endP}" var="i">
                                        <c:if test="${mode eq 'mycourse'}">
                                            <li><a class="${index == i? "active":""}" href="mycourse?&index=${i}">${i}</a></li>
                                            </c:if>
                                            <c:if test="${mode eq 'filter'}">
                                            <li><a class="${index == i? "active":""}" href="filtermycourse?&index=${i}${selectedCategories}">${i}</a></li>
                                            </c:if>
                                        </c:forEach>
                                    </c:if>
                            </ul>
                        </div>
                        <!-- /store bottom filter -->
                    </div>
                    <!-- /STORE -->
                </div>
                <!-- /row -->
            </div>
            <!-- /container -->
        </div>
        <!-- /SECTION -->

        <!-- NEWSLETTER -->
        <div id="newsletter" class="section">
            <!-- container -->
            <div class="container">
                <!-- row -->
                <div class="row">
                    <div class="col-md-12">
                        <div class="newsletter">
                            <p>Sign Up for the <strong>NEWSLETTER</strong></p>
                            <form>
                                <input class="input" type="email" placeholder="Enter Your Email">
                                <button class="newsletter-btn"><i class="fa fa-envelope"></i> Subscribe</button>
                            </form>
                            <ul class="newsletter-follow">
                                <li>
                                    <a href="#"><i class="fa fa-facebook"></i></a>
                                </li>
                                <li>
                                    <a href="#"><i class="fa fa-twitter"></i></a>
                                </li>
                                <li>
                                    <a href="#"><i class="fa fa-instagram"></i></a>
                                </li>
                                <li>
                                    <a href="#"><i class="fa fa-pinterest"></i></a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <!-- /row -->
            </div>
            <!-- /container -->
        </div>
        <!-- /NEWSLETTER -->

        <jsp:include page="footer.jsp"></jsp:include>

        <!-- jQuery Plugins -->
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/slick.min.js"></script>
        <script src="js/nouislider.min.js"></script>
        <script src="js/jquery.zoom.min.js"></script>
        <script src="js/main.js"></script>

    </body>
</html>
