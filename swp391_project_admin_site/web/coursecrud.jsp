<%-- 
    Document   : coursecrud
    Created on : May 21, 2023, 12:29:30 AM
    Author     : doanq
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>DASHMIN - Bootstrap Admin Template</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="" name="keywords">
        <meta content="" name="description">
        <!-- Icon Source  -->
        <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.no-icons.min.css" rel="stylesheet">
        <link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">

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

        <style>
            body {
                display: flex;
                justify-content: center;
                align-items: center;
                min-height: 100vh;
                background-color: #f1f1f1; /* Màu nền của trang */
            }

            .form-container {
                width: 100%; /* Chiều rộng form tăng gấp đôi */
                padding: 20px;
                background-color: #ffffff; /* Màu nền của form */
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Hiệu ứng bóng đổ */
            }

            .form-group {
                margin-bottom: 15px;
            }

            .form-group label {
                display: block;
                font-weight: bold;
                margin-bottom: 5px;
            }

            .form-group input,
            .form-group textarea,
            .form-group select {
                width: 100%;
                height: 100%;
                padding: 8px;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
            }

            .form-group input[type="submit"],
            .form-group input[type="button"]{
                width: auto;
                cursor: pointer;
                background-color: #4caf50; /* Màu nút "Tạo khóa học" */
                color: #ffffff; /* Màu chữ trắng */
            }

            .form-group input[type="submit"]:hover,
            .form-group input[type="button"]:hover {
                background-color: #45a049; /* Màu nút khi di chuột vào */
            }

            .form-group input[type="submit"]:focus,
            .form-group input[type="button"]:focus {
                outline: none;
            }
            #image_preview {
                max-width: 300px;
                max-height: 300px;
            }
        </style>
        <script>
            function showImagePreview(input) {
                if (input.files && input.files[0]) {
                    var reader = new FileReader();
                    reader.onload = function (e) {
                        var imgElement = document.getElementById('image_preview');
                        imgElement.setAttribute('src', e.target.result);
                    };
                    reader.readAsDataURL(input.files[0]);
                }

            }
            function openLink(link) {
                location.replace(link)
            }
            function formatCurrency() {
                // Lấy giá trị từ ô input
                var input = document.getElementById("course_price");
                var value = input.value;

                // Định dạng giá tiền
                var formattedValue = "";
                if (value) {
                    formattedValue = new Intl.NumberFormat("vi-VN", {style: "currency", currency: "VND"}).format(value);
                }

                // Hiển thị giá tiền đã định dạng trong phần tử span
                var formattedPrice = document.getElementById("formattedPrice");
                formattedPrice.textContent = formattedValue;
            }

        </script>

        <script src="http://code.jquery.com/jquery.min.js" type="text/javascript"></script>
        <script src="https://cdn.tiny.cloud/1/b039d67e7mqgi06o6b5d5eai9uuovuct0812wskor3u0sa9c/tinymce/6/tinymce.min.js" referrerpolicy="origin"></script>
    </head>
    <body>
        <script>
            function openLink(link) {
                location.replace(link)
            }
        </script>
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
                                <span>Management</span>
                            </c:if>                       
                        </div>
                    </div>
                    <div class="navbar-nav w-100">
                                             
                        <c:if test="${sessionScope.account.getAccount_role() == 0}">
                            <a href="admin_acc_manage" class="nav-item nav-link"><i class="fa fa-keyboard me-2"></i>&nbsp;&nbsp;Account Management</a>
                        </c:if>
                        <a href="accountcusmanage" class="nav-item nav-link"><i class="fa fa-table me-2"></i>Account Customer</a>
                        <a href="coursemanage" class="nav-item nav-link active"><i class="fa fa-table me-2"></i>Course Management</a>  
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
                            <div class="bg-light rounded h-100">
                                <div class="form-container">
                                    <c:if test="${mode=='coursecreate'}">
                                        <h1>Tạo khóa học</h1>
                                    </c:if>
                                    <c:if test="${mode=='courseupdate'}">
                                        <h1>Sửa khóa học</h1>
                                    </c:if>
                                    <c:if test="${mode=='coursedetail'}">

                                        <h1>Chi tiết khóa học </h1>
                                    </c:if>
                                    <c:if test="${mode=='coursecreate'}">
                                        <form action="create?&mode=coursecreate" method="POST">
                                        </c:if>
                                        <c:if test="${mode=='courseupdate'}">
                                            <form action="update?mode=courseupdate" method="POST">
                                            </c:if>


                                            <div class="form-group">
                                                <c:if test="${mode=='courseupdate' or mode=='coursedetail'}">
                                                    <label for="course_id">ID khóa học:</label>

                                                    <input type="text" id="course_id" name="course_id" required readonly value="${courseinfo.getCourse_id()}">
                                                </c:if>   

                                            </div>

                                            <c:if test="${mode=='coursedetail'}"> 
                                                <c:set var="isRead" value="readonly"/>
                                            </c:if>

                                            <c:if test="${mode=='courseupdate' or mode=='coursecreate'}">
                                                <c:set var="isRead" value=""/>
                                            </c:if>
                                            <div class="form-group">
                                                <label for="course_name">Tên khóa học:</label>
                                                <input type="text" id="course_name" name="course_name" required ${isRead} value="${courseinfo.getCourse_name()}">    



                                            </div>
                                            <div class="form-group">
                                                <label for="course_description">Mô tả khóa học:</label>
                                                <textarea id="course_description" name="course_description" required ${isRead} >${courseinfo.getCourse_description()}</textarea>

                                            </div>







                                            <div class="form-group">
                                                <label for="course_price">Giá khóa học:</label>
                        <!--                        <input type="text" id="course_price" name="course_price" required ${isRead} value="${courseinfo.getCourse_price()}">-->
                                                <!--<input type="number" id="course_price" onchange="formatCurrency()" name="course_price" required ${isRead} value="${courseinfo.getCourse_price()}">-->
                                                <c:if test="${mode=='courseupdate' or mode=='coursecreate'}">
                                                    <fmt:formatNumber var="formattedPrice" value="${courseinfo.getCourse_price()}" type="currency" currencySymbol="₫" />
                                                    <input type="text" id="course_price" name="course_price" onchange="formatCurrency()" value="${formattedPrice}" required/>
                                                </c:if>
                                                <c:if test="${mode=='coursedetail'}"> 
                                                    <fmt:formatNumber var="formattedPrice" value="${courseinfo.getCourse_price()}" type="currency" currencySymbol="₫" />
                                                    <input type="text" name="course_price" id="course_price" value="${formattedPrice}" readonly/>
                                                </c:if>
                                                <span id="formattedPrice"></span>
                                            </div>
                                            <div class="form-group">
                                                <c:if test="${mode=='coursedetail'}"> 
                                                    <label for="course_create_date">Ngày tạo khóa học:</label>
                                                    <input type="date" id="course_create_date" name="course_create_date" required ${isRead} value="${courseinfo.getCourse_create_date()}">
                                                </c:if>
                                            </div>
                                            <div class="form-group">
                                                <c:if test="${mode=='coursedetail'}">
                                                    <label for="course_modified_date">Ngày sửa khóa học:</label>
                                                    <input type="date" id="course_modified_date" name="course_modified_date" required ${isRead} value="${courseinfo.getCourse_modified_date()}">
                                                </c:if>
                                            </div>
                                            <div class="form-group">
                                                <label for="category_id">Thể loại:</label>
                                                <c:if test="${mode=='coursedetail'}">
                                                    <input type="text" id="category_id" name="category_id" required ${isRead} value="${courseinfo.getCategory_name()}">
                                                </c:if>
                                                <c:if test="${mode == 'coursecreate' or mode == 'courseupdate'}">
                                                    <select name="category_name">
                                                        <option value="" disabled selected hidden>Chọn thể loại</option>
                                                        <c:forEach items="${getListCategories}" var="i">
                                                            <option value="${i.getCategory_name()}" ${courseinfo.getCategory_id()==i.getCategory_id()?"selected":""}>${i.getCategory_name()}</option>
                                                        </c:forEach>

                                                    </select> 
                                                </c:if>
                                            </div>
                                            <div class="form-group">
                                                <label for="supplier_id">Nhà cung cấp:</label>
                                                <c:if test="${mode=='coursedetail'}">
                                                    <input type="text" id="supplier_id" name="supplier_id" required ${isRead} value="${courseinfo.getSupplier_name()}">
                                                </c:if>
                                                <c:if test="${mode == 'coursecreate' or mode == 'courseupdate'}">
                                                    <select name="supplier_name">
                                                        <option value="" disabled selected hidden>Chọn nhà cung cấp</option>
                                                        <c:forEach items="${getListSupplier}" var="i">
                                                            <option value="${i.getSupplier_name()}" ${courseinfo.getSupplier_id()==i.getSupplier_id()?"selected":""}>${i.getSupplier_name()}</option>
                                                        </c:forEach>
                                                    </select>
                                                </c:if>
                                            </div>
                                            <div class="form-group">
                                                <label for="course_short_desc">Mô tả ngắn gọn khóa học:</label>
                                                <textarea id="course_short_desc" name="course_short_desc" required ${isRead} >${courseinfo.getCourse_short_desc()}</textarea>
                                            </div>
                                            <div class="form-group">
                                                <c:if test="${mode=='coursedetail'}">
                                                    <label for="course_create_by">Người tạo khóa học:</label>
                                                    <input type="text" id="course_create_by" name="course_create_by" required ${isRead} value="${courseinfo.getCourse_create_by()}">
                                                </c:if>
                                            </div>
                                            <div class="form-group">
                                                <c:if test="${mode=='coursedetail'}">
                                                    <label for="course_modified_by">Người sửa khóa học:</label>
                                                    <input type="text" id="course_modified_by" name="course_modified_by" required ${isRead} value="${courseinfo.getCourse_modified_by()}">
                                                </c:if>
                                            </div>
                                            <div class="form-group">
                                                <label for="course_img">Hình ảnh khóa học:</label>
                                                <c:if test="${mode == 'coursecreate'}">
                                                    <input type="file" id="course_img" name="course_img" required onchange="showImagePreview(this)" value="${courseinfo.getCourse_img()}">
                                                    <br>
                                                    <img src="./${courseinfo.getCourse_img()}" id="image_preview">
                                                </c:if>
                                                <c:if test="${mode == 'courseupdate'}">
                                                    <input type="file" id="course_img" name="course_img" onchange="showImagePreview(this)" value="${courseinfo.getCourse_img()}">
                                                    <br>
                                                    <img src="./${courseinfo.getCourse_img()}" id="image_preview">
                                                    <input type="hidden" name="course_img_old" value="${courseinfo.getCourse_img()}">
                                                </c:if>

                                                <c:if test="${mode=='coursedetail'}">
                                                    <img src="./${courseinfo.getCourse_img()}" >
                                                </c:if>

                                            </div>
                                            <div class="form-group">
                                                <label for="course_discount">Giảm giá khóa học (%):</label>
                                                <input type="number" id="course_discount" name="course_discount" min="0" max="100" required ${isRead} value="${courseinfo.getCourse_discount()}">
                                            </div>
                                            <div class="form-group">
                                                <c:if test="${mode=='coursecreate'}">
                                                    <input type="submit" value="Tạo khóa học" name="coursecreate">
                                                </c:if>
                                                <c:if test="${mode=='courseupdate'}">
                                                    <input type="submit" value="Sửa khóa học" name="courseupdate">
                                                </c:if>
                                                <input type="button" onclick="openLink('coursemanage')" value="Cancel">    
                                            </div>
                                        </form>
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


<!--        <script>
                                                    tinymce.init({
                                                        selector: 'textarea',
                                                        plugins: 'anchor autolink charmap codesample emoticons image link lists media searchreplace table visualblocks wordcount checklist mediaembed casechange export formatpainter pageembed linkchecker a11ychecker tinymcespellchecker permanentpen powerpaste advtable advcode editimage tinycomments tableofcontents footnotes mergetags autocorrect typography inlinecss',
                                                        toolbar: 'undo redo | blocks fontfamily fontsize | bold italic underline strikethrough | link image media table mergetags | addcomment showcomments | spellcheckdialog a11ycheck typography | align lineheight | checklist numlist bullist indent outdent | emoticons charmap | removeformat',
                                                        tinycomments_mode: 'embedded',
                                                        tinycomments_author: 'Author name',
                                                        mergetags_list: [
                                                            {value: 'First.Name', title: 'First Name'},
                                                            {value: 'Email', title: 'Email'},
                                                        ],
                                                    });
        </script>-->
    </body>
</html>