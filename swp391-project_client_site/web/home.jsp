<%-- 
    Document   : home
    Created on : Feb 28, 2023, 4:36:02 PM
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

        <title>EDU</title>

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
                            <li class="active"><a href="home">Home</a></li>
                            <li><a href="courseofcategory">All Course</a></li>
                            <li><a href="mycourse">My Course</a></li>

                        </ul>
                        <!-- /NAV -->
                    </div>
                    <!-- /responsive-nav -->
                </div>
                <!-- /container -->
            </nav>
            <!-- /NAVIGATION -->

            <!-- SECTION -->
            <div class="section">
                <!-- container -->
                <div class="container">
                    <!-- row -->
                    <div class="row">

                    </div>
                    <!-- /row -->
                </div>
                <!-- /container -->
            </div>
            <!-- /SECTION -->

            <!-- SECTION -->
            <div class="section">
                <!-- container -->
                <div class="container">
                    <!-- row -->
                    <div class="row">

                        <!-- section title -->
                        <div class="col-md-12">
                            <div class="section-title">
                                <h3 class="title">New Items</h3>
                                <div class="section-nav">
                                    <!--                                <ul class="section-tab-nav tab-nav">
                                                                        <li class="active"><a data-toggle="tab" href="#tab1">Knife</a></li>
                                                                        <li><a data-toggle="tab" href="#tab1">Gloves</a></li>
                                                                        <li><a data-toggle="tab" href="#tab1">Gun</a></li>
                                                                        <li><a data-toggle="tab" href="#tab1">Containers</a></li>
                                                                    </ul>-->
                                </div>
                            </div>
                        </div>
                        <!-- /section title -->

                        <!-- Products tab & slick -->
                        <div class="col-md-12">
                            <div class="row">
                                <div class="products-tabs">
                                    <!-- tab -->
                                    <div id="tab1" class="tab-pane active">
                                        <div class="products-slick" data-nav="#slick-nav-1">
                                        <c:forEach items="${listNewItem}" var="i">
                                            <div class="product">
                                                <div class="product-img">
                                                    <img src="./${i.getCourse_img()}" alt="">
                                                    <div class="product-label">
                                                        <span class="sale">${i.getCourse_discount()}%</span>
                                                        <span class="new">NEW</span>
                                                    </div>
                                                </div>
                                                <div class="product-body">
                                                    <p class="product-category">${i.getCategory_name()}</p>
                                                    <h3 class="product-name"><a href="detail?course_id=${i.getCourse_id()}">${i.getCourse_name()}</a></h3>
                                                        <fmt:formatNumber var="productprice" value="${i.getCourse_price()*(100-i.getCourse_discount())/100}" type="currency" currencySymbol="₫" />

                                                    <h4 class="product-price">${productprice}
                                                        <fmt:formatNumber var="productoldprice" value="${i.getCourse_price()}" type="currency" currencySymbol="₫" />
                                                        <del class="product-old-price">${productoldprice}</del></h4>

                                                </div>
                                                <div class="add-to-cart">
                                                    <form action="addToCart" method="POST">
                                                        <input type="hidden" name="course_id" value="${i.getCourse_id()}" />
                                                        <button type="submit" class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button>
                                                    </form>
                                                </div>
                                            </div>
                                        </c:forEach>


                                    </div>
                                    <div id="slick-nav-1" class="products-slick-nav"></div>
                                </div>
                                <!-- /tab -->
                            </div>
                        </div>
                    </div>
                    <!-- Products tab & slick -->
                </div>
                <!-- /row -->
            </div>
            <!-- /container -->
        </div>
        <!-- /SECTION -->

        <!-- HOT DEAL SECTION -->
        <div id="hot-deal" class="section">
            <!-- container -->
            <div class="container">
                <!-- row -->
                <div class="row">
                    <div class="col-md-12">
                        <div class="hot-deal">
                            <ul class="hot-deal-countdown">
                                <li>
                                    <div>
                                        <h3>02</h3>
                                        <span>Days</span>
                                    </div>
                                </li>
                                <li>
                                    <div>
                                        <h3>10</h3>
                                        <span>Hours</span>
                                    </div>
                                </li>
                                <li>
                                    <div>
                                        <h3>34</h3>
                                        <span>Mins</span>
                                    </div>
                                </li>
                                <li>
                                    <div>
                                        <h3>60</h3>
                                        <span>Secs</span>
                                    </div>
                                </li>
                            </ul>
                            <h2 class="text-uppercase">hot deal this week</h2>
                            <p>New Items Up to 50% OFF</p>
                            <a class="primary-btn cta-btn" href="courseofcategory">Shop now</a>
                        </div>
                    </div>
                </div>
                <!-- /row -->
            </div>
            <!-- /container -->
        </div>
        <!-- /HOT DEAL SECTION -->

        <!-- SECTION -->
        <div class="section">
            <!-- container -->
            <div class="container">
                <!-- row -->
                <div class="row">

                    <!-- section title -->
                    <div class="col-md-12">
                        <div class="section-title">
                            <h3 class="title">Top selling</h3>

                        </div>
                    </div>
                    <!-- /section title -->

                    <!-- Products tab & slick -->
                    <div class="col-md-12">
                        <div class="row">
                            <div class="products-tabs">
                                <!-- tab -->
                                <div id="tab1" class="tab-pane active">
                                    <div class="products-slick" data-nav="#slick-nav-1">




                                        <c:forEach items="${listTopSelling}" var="i">


                                            <div class="product">
                                                <div class="product-img">
                                                    <img  src="./${i.getCourse_img()}" alt="">
                                                    <div class="product-label">
                                                        <span class="sale">-${i.getCourse_discount()}%</span>
                                                        <span class="new">NEW</span>
                                                    </div>
                                                </div>
                                                <div class="product-body">
                                                    <p class="product-category">${i.getCategory_name()}</p>
                                                    <h3 class="product-name"><a href="detail?id=${i.getCourse_id()}">${i.getCourse_name()}</a></h3>

                                                    <fmt:formatNumber var="productprice" value="${i.getCourse_price()*(100-i.getCourse_discount())/100}" type="currency" currencySymbol="₫" />

                                                    <h4 class="product-price">${productprice}
                                                        <fmt:formatNumber var="productoldprice" value="${i.getCourse_price()}" type="currency" currencySymbol="₫" />
                                                        <del class="product-old-price">${productoldprice}</del></h4>
                                                </div>
                                                <div class="add-to-cart">
                                                    <form action="addToCart" method="POST">
                                                        <input type="hidden" name="course_id" value="${i.getCourse_id()}" />
                                                        <button type="submit" class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button>
                                                    </form>
                                                </div>
                                            </div>
                                        </c:forEach>
                                    </div>
                                    <!-- /row -->
                                </div> 
                                <!-- /container -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
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
                                    <a href="https://www.facebook.com/profile.php?id=100044146933366"><i class="fa fa-facebook"></i></a>
                                </li>
                                <li>
                                    <a href="https://twitter.com/s1mpleO"><i class="fa fa-twitter"></i></a>
                                </li>
                                <li>
                                    <a href="https://www.instagram.com/qagmih_/"><i class="fa fa-instagram"></i></a>
                                </li>
                                <li>
                                    <a href="https://www.pinterest.com/egriffith2083/csgo-skins/"><i class="fa fa-pinterest"></i></a>
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
