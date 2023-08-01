<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Created By CodingLab - www.codinglabweb.com -->
<html lang="en" dir="ltr">
<head>
    <meta charset="UTF-8">
    <title>Responsive Registration Form | CodingLab</title>
    <link rel="stylesheet" href="login/css/signup.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <style>
        .error-message{
            color: red;
        }
    </style>
    <script>
        $(document).ready(function() {
            $('form').on('submit', function(event) {
                event.preventDefault(); // Prevent form submission

                // Perform field validations
                var isValid = true;

                var name = $('#name').val();
                if (name.trim() === '') {
                    isValid = false;
                    $('#name-error').text('Please enter your name');
                } else {
                    $('#name-error').text('');
                }

                var username = $('#username').val();
                if (!isValidUsername(username)) {
                    isValid = false;
                    $('#username-error').text('Invalid username format');
                } else {
                    $('#username-error').text('');
                }

                var email = $('#email').val();
                if (!isValidEmail(email)) {
                    isValid = false;
                    $('#email-error').text('Invalid email format');
                } else {
                    $('#email-error').text('');
                }

                var phoneNumber = $('#phone-number').val();
                if (!isValidPhone(phoneNumber)) {
                    isValid = false;
                    $('#phone-number-error').text('Invalid phone number format');
                } else {
                    $('#phone-number-error').text('');
                }

                var password = $('#password').val();
                if (!isValidPassword(password)) {
                    isValid = false;
                    $('#password-error').text('Invalid password format');
                } else {
                    $('#password-error').text('');
                }

                var confirmPassword = $('#confirm-password').val();
                if (confirmPassword !== password) {
                    isValid = false;
                    $('#confirm-password-error').text('Passwords do not match');
                } else {
                    $('#confirm-password-error').text('');
                }

                // If all fields are valid, submit the form
                if (isValid) {
                    this.submit();
                }
            });

            function isValidPhone(s) {
                var pattern = /^\d{10}$/;
                return pattern.test(s);
            }

            function isValidUsername(username) {
                var regex = /^[A-Za-z]\w{5,29}$/;
                return regex.test(username);
            }

            function isValidPassword(password) {
                var regex = /^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\S+$).{8,20}$/;
                return regex.test(password);
            }

            function isValidEmail(email) {
                var regex = /^[a-zA-Z0-9_+&*-]+(?:\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\.)+[a-zA-Z]{2,7}$/;
                return regex.test(email);
            }
        });
    </script>
</head>
<body>
<div class="container">
    <div class="title">Signup</div>
    <div class="content">
        <form action="signup" method="post">
            <div class="user-details">
                <div class="input-box">
                    <span class="details">Full Name</span>
                    <input type="text" placeholder="Enter your name" id="name" name="customer_name" required>
                    <p class="error-message" id="name-error"></p>
                </div>
                <div class="input-box">
                    <span class="details">Username</span>
                    <input type="text" placeholder="Enter your username" id="username" name="username" required>
                    <p class="error-message" id="username-error"></p>
                </div>
                <div class="input-box">
                    <span class="details">Email</span>
                    <input type="text" placeholder="Enter your email" id="email" name="email" required>
                    <p class="error-message" id="email-error"></p>
                </div>
                <div class="input-box">
                    <span class="details">Phone Number</span>
                    <input type="text" placeholder="Enter your number" id="phone-number" name="customer_phone" required>
                    <p class="error-message" id="phone-number-error"></p>
                </div>
                <div class="input-box">
                    <span class="details">Password</span>
                    <input type="password" placeholder="Enter your password" id="password" name="password" required>
                    <p class="error-message" id="password-error"></p>
                </div>
                <div class="input-box">
                    <span class="details">Confirm Password</span>
                    <input type="password" placeholder="Confirm your password" id="confirm-password" name="repassword" required>
                    <p class="error-message" id="confirm-password-error"></p>
                </div>
                <div class="input-box">
                    <span class="details">Address</span>
                    <input type="text" placeholder="Enter your address" name="customer_address">
                </div>
                <div class="input-box">
                    <span class="details">Date of birth</span>
                    <input type="date" placeholder="" name="customer_dob" required>
                </div>
            </div>
            <p class="alert-danger" style="color: red">
                ${smess}
            </p>
            <div class="button">
                <input type="submit" value="Signup">
            </div>
        </form>
    </div>
</div>
</body>
</html>