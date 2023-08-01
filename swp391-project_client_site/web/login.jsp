<%-- 
    Document   : login
    Created on : Mar 11, 2023, 7:51:36 PM
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en" dir="ltr">
  <head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="login/css/style.css">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
   </head>
<body>
  <div class="container">
    <input type="checkbox" id="flip">
    <div class="cover">
      <div class="front">
          <img src="./usercss/images/CourseImage/logoedu.jpg" alt="">
        <div class="text">
          <span class="text-1"></span>
          <span class="text-2"></span>
        </div>
      </div>
      <div class="back">
        <img class="backImg" src="img/logomarket.png" alt="">
        <div class="text">
          <span class="text-1">Complete miles of journey <br> with one step</span>
          <span class="text-2">Let's get started</span>
        </div>
      </div>
    </div>
    <div class="forms">
        <div class="form-content">
          <div class="login-form">
            <div class="title">Login</div>
            <form action="login" method="post">                                
            <div class="input-boxes">
              <div class="input-box">
                <i class="fas fa-envelope"></i>               
                <input type="text" placeholder="Enter your username " name="username">
              </div>
              <div class="input-box">
                <i class="fas fa-lock"></i>
                <input type="password" placeholder="Enter your password" name="password">
              </div>
              <div class="text"><a href="forgotPassword.jsp">Forgot password?</a></div>
              <p class="alert-danger" style="color: red">
                    ${mess}
              </p>
              <p class="alert-danger" style="color: red">
                    ${smess}
              </p>
              <div class="button input-box">
                <input type="submit" value="Login">
              </div>
              <div class="text sign-up-text">Don't have an account? <a href="signup.jsp">Signup?</a></div>
            </div>
        </form>
      </div>        
    </div>
    </div>
  </div>
</body>
</html>
