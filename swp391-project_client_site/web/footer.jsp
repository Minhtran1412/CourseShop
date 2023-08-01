<%-- 
    Document   : footer
    Created on : Mar 11, 2023, 7:17:05 PM
    Author     : acer
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- FOOTER -->
<footer id="footer">
    <!-- top footer -->
    <div class="section">
        <!-- container -->
        <div class="container">
            <!-- row -->
            <div class="row">
                <div class="col-md-4 col-xs-6">
                    <div class="footer">
                        <h3 class="footer-title">About Us</h3>
                        <p>FPT University, Ha Noi, Viet Nam.</p>
                        <ul class="footer-links">
                            <li><a href="https://www.google.com/maps/search/đại+học+fpt/@21.0133255,105.5246749,17z/data=!3m1!4b1?hl=vi"><i class="fa fa-map-marker"></i>Đất Thổ Cư Hòa Lạc, Km29, ĐCT08, Thạch Hoà, Thạch Thất, Hà Nội</a></li>
                            <li><a href="blank.html"><i class="fa fa-phone"></i>+84 398665357</a></li>
                            <li><a href="https://www.google.com/intl/vi/gmail/about/"><i class="fa fa-envelope-o"></i>group1@fpt.edu.vn</a></li>
                        </ul>
                    </div>
                </div>

                <div class="col-md-4 col-xs-6">
                    <div class="footer">
                        <h3 class="footer-title">Category</h3>
                        <ul class="footer-links">
                            <c:forEach items="${listCategories}" var="i">
                                <li>${i.getCategory_name()}</li>
                                </c:forEach>
                        </ul>
                    </div>
                </div>
                <!--                <div class="col-md-4 col-xs-6">
                                    <div class="footer">
                                        <h3 class="footer-title">Items</h3>
                                        <ul class="footer-links">
                                            <li><a href="#">Hot deals</a></li>
                                            <li><a href="#">Knife</a></li>
                                            <li><a href="#">Gun</a></li>
                                            <li><a href="#">Gloves</a></li>
                                            <li><a href="#">Other</a></li>
                                        </ul>
                                    </div>
                                </div>-->

                <div class="clearfix visible-xs"></div>

                <!--                <div class="col-md-3 col-xs-6">
                                    <div class="footer">
                                        <h3 class="footer-title">Information</h3>
                                        <ul class="footer-links">
                                            <li><a href="#">About Us</a></li>
                                            <li><a href="#">Contact Us</a></li>
                                            <li><a href="#">Privacy Policy</a></li>
                                            <li><a href="#">Orders and Returns</a></li>
                                            <li><a href="#">Terms & Conditions</a></li>
                                        </ul>
                                    </div>
                                </div>-->

                <div class="col-md-4 col-xs-6">
                    <div class="footer">
                        <h3 class="footer-title">Service</h3>
                        <ul class="footer-links">
                            <li><a href="loadProfile?customer_id=${sess_customer_id}">My Account</a></li>
                            <li><a href="#">View Cart</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- /row -->
        </div>
        <!-- /container -->
    </div>
    <!-- /top footer -->

    <!-- bottom footer -->
    <div id="bottom-footer" class="section">
        <div class="container">
            <!-- row -->
            <div class="row">
                <div class="col-md-12 text-center">
                    <ul class="footer-payments">
                        <li><a href="https://www.visa.com.vn/vi_VN/pay-with-visa/find-a-card/credit-cards.html"><i class="fa fa-cc-visa"></i></a></li>
                        <li><a href="https://mbbank.com.vn/26/213/392/Chi-tiet/the-tin-dung-quoc-te-mb-visa"><i class="fa fa-credit-card"></i></a></li>
                        <li><a href="https://mbbank.com.vn/26/213/392/Chi-tiet/the-tin-dung-quoc-te-mb-visa"><i class="fa fa-cc-paypal"></i></a></li>
                        <li><a href="https://mbbank.com.vn/26/214/1052/Chi-tiet/the-tra-truoc-quoc-te-bankplus-mastercard"><i class="fa fa-cc-mastercard"></i></a></li>
                    </ul>
                    <span class="copyright">
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                        Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                    </span>
                </div>
            </div>
            <!-- /row -->
        </div>
        <!-- /container -->
    </div>
    <!-- /bottom footer -->
</footer>
<!-- /FOOTER -->
