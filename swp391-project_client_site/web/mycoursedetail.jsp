<%-- 
    Document   : mycoursedetail
    Created on : Jun 26, 2023, 11:06:28 PM
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
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

        <title>Electro - HTML Ecommerce Template</title>

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
        <script src="https://kit.fontawesome.com/8b1830813f.js" crossorigin="anonymous"></script>
    </head>
    <body>

        <script>
            function openLink(link) {
                location.replace(link)
            }
        </script>
        <jsp:include page="menu.jsp"></jsp:include>
        <c:set var="p" value="${requestScope.course}"></c:set>
            <!-- NAVIGATION -->
            <nav id="navigation">
                <!-- container -->
                <div class="container">
                    <!-- responsive-nav -->
                    <div id="responsive-nav">
                        <!-- NAV -->
                        <ul class="main-nav nav navbar-nav">
                            <li ><a href="home">Home</a></li>
                            <li><a href="courseofcategory">All Course</a></li>
                        <li><a href="mycourse">My Course</a></li>
                            <!--                            <li><a href="product">Store</a></li>
                                                        <li><a href="#">Categories</a></li>
                                                        <li><a href="#">Laptops</a></li>
                                                        <li><a href="#">Smartphones</a></li>
                                                        <li><a href="#">Cameras</a></li>
                                                        <li><a href="#">Accessories</a></li>-->
                        </ul>
                        <!-- /NAV -->
                    </div>
                    <!-- /responsive-nav -->
                </div>
                <!-- /container -->
            </nav>
            <!-- /NAVIGATION -->

            <!-- BREADCRUMB -->
            <div id="breadcrumb" class="section">
                <!-- container -->
                <div class="container">
                    <!-- row -->
                    <div class="row">
                        <div class="col-md-12">
                            <ul class="breadcrumb-tree">
                                <li><a href="#">Home</a></li>
                                <li><a href="#">All Categories</a></li>
                                <li><a href="#">Accessories</a></li>
                                <li><a href="#">abcdfjeiwj</a></li>
                                <li class="active">Java Courses</li>
                            </ul>
                        </div>
                    </div>
                    <!-- /row -->
                </div>
                <!-- /container -->
            </div>
            <!-- /BREADCRUMB -->

            <!-- SECTION -->
            <div class="section">
                <!-- container -->
                <div class="container">
                    <!-- row -->
                    <div class="row">
                        <!-- Product main img -->
                        <div class="col-md-5 col-md-push-0">
                            <div id="product-main-img">
                                <div class="product-preview">
                                    <img src="./${p.getCourse_img()}" alt="">
                            </div>

                            <div class="product-preview">
                                <img src="./img/cases.png" alt="">
                            </div>

                            <div class="product-preview">
                                <img src="./img/awpassimov.png" alt="">
                            </div>

                            <div class="product-preview">
                                <img src="./img/akasimod.png" alt="">
                            </div>
                        </div>
                    </div>
                    <!-- /Product main img -->



                    <!-- Product details -->
                    <div class="col-md-5">
                        <div class="product-details">

                            <h2 class="product-name">${p.getCourse_name()}</h2><!-- comment -->
                            <h3>${p.getCourse_short_desc()}</h3>
                            <h4>Supplier: ${p.getSupplier_name()}</h4>
                            <!--                            <div>
                                                            <div class="product-rating">
                                                                <i class="fa fa-star"></i>
                                                                <i class="fa fa-star"></i>
                                                                <i class="fa fa-star"></i>
                                                                <i class="fa fa-star"></i>
                                                                <i class="fa fa-star-o"></i>
                                                            </div>
                                                            <a class="review-link" href="#">10 Review(s) | Add your review</a>
                                                        </div>-->
                            <div>
                                <!--                                <span class="product-available">Quantity have in stock: </span>-->
                            </div>


                            <div class="add-to-cart">
                                
                            </div>
                            <br><!-- <br> -->


                            <!--                            <ul class="product-btns">
                                                            <li style="border: outset; background-color: #6FD6E2; ">
                                                                <a href="#"><i class="fa fa-heart-o"></i> add to wishlist</a>
                                                            </li>
                                                                                                <li>
                                                                                                    <a href="#"><i class="fa fa-exchange"></i> add to compare</a>
                                                                                                </li>
                                                        </ul>-->

                            <ul class="product-links">
                                <li>Category:</li>
                                <li>${p.getCategory_name()}</li>
                                <!--<li><a href="#">FSDFSDFSDFSF</a></li>-->
                            </ul>

                            <!--                                <ul class="product-links">
                                                                <li>Share:</li>
                                                                <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                                                <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                                                <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                                                                <li><a href="#"><i class="fa fa-envelope"></i></a></li>
                                                            </ul>-->

                        </div>
                    </div>
                    <!-- /Product details -->

                    <!-- Product tab -->
                    <div class="col-md-12">
                        <div id="product-tab">
                            <!-- product tab nav -->
                            <ul class="tab-nav">
                                <li class="active"><a data-toggle="tab" href="#tab1">Content</a></li>
                                <!--                                <li><a data-toggle="tab" href="#tab2">Details</a></li>
                                                                <li><a data-toggle="tab" href="#tab3">Reviews</a></li>-->
                            </ul>
                            <!-- /product tab nav -->

                            <!-- product tab content -->
                            <div class="tab-content">
<!--                                                                 tab1  
-->                                                                <div id="tab1" class="tab-pane fade in active">
                                                                    <div class="row">
                                                                        <div class="col-md-12">
                                                                            <textarea style="width: 1140px;height: 1000px">${p.getCourse_description()}</textarea>
                                                                            
                                                                        </div>
                                                                    </div>
                                                                </div><!--
                                                                 /tab1  
                                
                                                                 tab2  
                                                                <div id="tab2" class="tab-pane fade in">
                                                                    <div class="row">
                                                                        <div class="col-md-12">
                                                                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                 /tab2  -->

                                <!-- tab3  -->
                                <div id="tab3" class="tab-pane fade in active">
                                    <div class="row">
                                        <div class="col-md-3">

                                        </div>
                                        <!-- /Rating -->

                                        <!-- Reviews -->
<!--                                        <div class="col-md-6">
                                            <div id="reviews">
                                                <ul class="reviews">
                                                    <c:forEach items="${listComment}" var="i">
                                                        <li>
                                                            <div class="review-heading">
                                                                <h5 class="name">${i.getCustomer_name()}</h5>
                                                                <p class="date">${i.getComment_date()}</p>
                                                                <c:if test="${i.getCustomer_id() eq sess_customer_id}">
                                                                    <a style="color: blue" href="comment?comment_id=${i.getComment_id()}&course_id=${requestScope.course_id}&mode=delete"><i class="fa-solid fa-trash"></i></a>
                                                                    <a style="color: blue" href="comment?comment_id=${i.getComment_id()}&course_id=${requestScope.course_id}&comment_text=${i.getComment_text()}&mode=update"><i class="fa-sharp fa-solid fa-pen"></i></a>
                                                                    </c:if>
                                                            </div>
                                                            <div class="review-body">
                                                                <p>${i.getComment_text()}</p>
                                                            </div>
                                                        </li>
                                                    </c:forEach>

                                                </ul>
                                                <ul class="reviews-pagination">
                                                    <c:if test="${endP != 1}">
                                                        <c:forEach begin="1" end="${endP}" var="i">
                                                            <li><a class="${index == i? "active":""}" href="detail?course_id=${course_id}&index=${i}">${i}</a></li>
                                                        </c:forEach>
                                                        
                                                    </c:if>
                                                    
                                                    
                                                </ul>
                                            </div>
                                        </div>-->
                                        <!-- /Reviews -->

                                        <!-- Review Form -->
<!--                                        <div class="col-md-3">
                                            <div id="review-form">
                                                <form class="review-form" action="comment?mode=add" method="post">
                                                    <textarea class="input" placeholder="Your Review" name="comment_text"></textarea>
                                                    <input type="hidden" value="${requestScope.course_id}" name="course_id">
                                                    <button class="primary-btn">Submit</button>
                                                </form>
                                                <c:if test="${mode1 eq 'update'}">
                                                    <form class="review-form" action="comment?comment_id=${comment_id}&mode=update" method="post">
                                                        <textarea class="input" placeholder="Your Review" name="comment_text">${comment_text}</textarea>
                                                        <input type="hidden" value="${requestScope.course_id}" name="course_id">
                                                        <button class="primary-btn">Update</button>
                                                    </form>
                                                </c:if>
                                            </div>
                                        </div>  -->
                                        <!-- /Review Form -->
                                    </div>
                                </div>
                                <!-- /tab3  -->
                            </div>
                            <!-- /product tab content  -->
                        </div>
                    </div>
                    <!-- /product tab -->
                </div>
                <!-- /row -->
            </div>
            <!-- /container -->
        </div>
        <!-- /SECTION -->

        <!-- Section -->
        <div class="section">
            <!-- container -->
            <div class="container">
                <!-- row -->
                <div class="row">

<!--                    <div class="col-md-12">
                        <div class="section-title text-center">
                            <h3 class="title">Related Products</h3>
                        </div>
                    </div>-->

                    <!-- product -->
                    

                    <!-- /product -->

                    <!-- product -->
                    <!--                    <div class="col-md-3 col-xs-6">
                                            <div class="product">
                                                <div class="product-img">
                                                    <img src="./img/product02.png" alt="">
                                                    <div class="product-label">
                                                        <span class="new">NEW</span>
                                                    </div>
                                                </div>
                                                <div class="product-body">
                                                    <p class="product-category">Category</p>
                                                    <h3 class="product-name"><a href="#">product name goes here</a></h3>
                                                    <h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
                                                    <div class="product-rating">
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star"></i>
                                                    </div>
                                                    <div class="product-btns">
                                                        <button class="add-to-wishlist"><i class="fa fa-heart-o"></i><span class="tooltipp">add to wishlist</span></button>
                                                        <button class="add-to-compare"><i class="fa fa-exchange"></i><span class="tooltipp">add to compare</span></button>
                                                        <button class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">quick view</span></button>
                                                    </div>
                                                </div>
                                                <div class="add-to-cart">
                                                    <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button>
                                                </div>
                                            </div>
                                        </div>-->
                    <!-- /product -->

                    <div class="clearfix visible-sm visible-xs"></div>

                    <!-- product -->
                    <!--                    <div class="col-md-3 col-xs-6">
                                            <div class="product">
                                                <div class="product-img">
                                                    <img src="./img/product03.png" alt="">
                                                </div>
                                                <div class="product-body">
                                                    <p class="product-category">Category</p>
                                                    <h3 class="product-name"><a href="#">product name goes here</a></h3>
                                                    <h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
                                                    <div class="product-rating">
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star-o"></i>
                                                    </div>
                                                    <div class="product-btns">
                                                        <button class="add-to-wishlist"><i class="fa fa-heart-o"></i><span class="tooltipp">add to wishlist</span></button>
                                                        <button class="add-to-compare"><i class="fa fa-exchange"></i><span class="tooltipp">add to compare</span></button>
                                                        <button class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">quick view</span></button>
                                                    </div>
                                                </div>
                                                <div class="add-to-cart">
                                                    <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button>
                                                </div>
                                            </div>
                                        </div>-->
                    <!-- /product -->

                    <!-- product -->
                    <!--                    <div class="col-md-3 col-xs-6">
                                            <div class="product">
                                                <div class="product-img">
                                                    <img src="./img/product04.png" alt="">
                                                </div>
                                                <div class="product-body">
                                                    <p class="product-category">Category</p>
                                                    <h3 class="product-name"><a href="#">product name goes here</a></h3>
                                                    <h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
                                                    <div class="product-rating">
                                                    </div>
                                                    <div class="product-btns">
                                                        <button class="add-to-wishlist"><i class="fa fa-heart-o"></i><span class="tooltipp">add to wishlist</span></button>
                                                        <button class="add-to-compare"><i class="fa fa-exchange"></i><span class="tooltipp">add to compare</span></button>
                                                        <button class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">quick view</span></button>
                                                    </div>
                                                </div>
                                                <div class="add-to-cart">
                                                    <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button>
                                                </div>
                                            </div>
                                        </div>-->
                    <!-- /product -->

                </div>
                <!-- /row -->
            </div>
            <!-- /container -->
        </div>
        <!-- /Section -->

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


