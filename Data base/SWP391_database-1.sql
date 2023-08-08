--create database SWP391_Project

use SWP391_Project
-- Bảng chứa thông tin về danh mục
CREATE TABLE Categories (
    category_id INT PRIMARY KEY IDENTITY(1,1) NOT NULL,
    category_name nVARCHAR(255),
	category_desc nvarchar(1000)
);

-- Bảng chứa thông tin về nhà cung cấp
CREATE TABLE Supplier (
    supplier_id INT PRIMARY KEY IDENTITY(1,1) NOT NULL,
    supplier_name NVARCHAR(255),
    supplier_address NVARCHAR(255),
    supplier_phone VARCHAR(20),
    supplier_email VARCHAR(255),
	supplier_desc nvarchar(500)
);

-- Bảng chứa thông tin về khóa học
CREATE TABLE Courses (
    course_id INT PRIMARY KEY IDENTITY(1,1) NOT NULL,
    course_name NVARCHAR(255),
    course_description TEXT,
    course_price DECIMAL(10,2),
    course_create_date DATE,
    course_modified_date DATE,
    category_id INT,
    supplier_id INT,
	course_short_desc nvarchar(255),
	course_create_by nvarchar(255),
	course_modified_by nvarchar(255),
	course_img nvarchar(50),
	course_discount int,
    FOREIGN KEY (category_id) REFERENCES Categories(category_id),
    FOREIGN KEY (supplier_id) REFERENCES Supplier(supplier_id)
);

-- Bảng chứa thông tin về người dùng
CREATE TABLE Account_Admin (
    account_id INT PRIMARY KEY IDENTITY(1,1) NOT NULL,
    account_name nVARCHAR(255),
	account_username nvarchar(50),
    account_password nVARCHAR(255),
    account_role int,
	account_email varchar(255),
	account_phone VARCHAR(20),
	account_avatar nvarchar(50)
);
-- Bảng chứa thông tin về khách hàng
CREATE TABLE Account_Customer (
	customer_id INT PRIMARY KEY IDENTITY(1,1) NOT NULL,
    customer_name nVARCHAR(255),
	customer_username nVARCHAR(255),
	customer_password nvarchar(50),
	customer_email VARCHAR(255),
    customer_address nVARCHAR(255),
    customer_phone VARCHAR(20),
	customer_dob date,
	customer_avatar nvarchar(50),
	customer_status int
);

-- Bảng chứa thông tin về đơn hàng
CREATE TABLE Orders (
    order_id INT PRIMARY KEY IDENTITY(1,1) NOT NULL,
    customer_id INT,
	order_date date,
    order_total_price DECIMAL(10,2),
	payment_id INT,
    FOREIGN KEY (customer_id) REFERENCES Account_Customer(customer_id),
);

-- Bảng chứa thông tin chi tiết về các khóa học trong đơn hàng
CREATE TABLE OrderDetail (
    order_detail_id INT PRIMARY KEY IDENTITY(1,1) NOT NULL,
	id int,
	course_price DECIMAL(10,2),
	course_id INT,
	FOREIGN KEY (course_id) REFERENCES Courses(course_id)
);



-- Bảng chứa thông tin về nhận xét và đánh giá của người dùng
CREATE TABLE Comments (
    comment_id INT PRIMARY KEY IDENTITY(1,1) NOT NULL,
    customer_id INT,
    course_id INT,
    comment_text TEXT,
    comment_date DATEtime,
	comment_modified datetime,
FOREIGN KEY (customer_id) REFERENCES Account_Customer(customer_id),
    FOREIGN KEY (course_id) REFERENCES Courses(course_id)
);



INSERT INTO [dbo].[Categories] ([category_name] ,[category_desc])
     VALUES
           (N'Java',N'Khóa học Java'),
		   (N'Python',N'Khóa học Python'),
		   (N'C#',N'Khóa học C#'),
		   (N'Web/App',N'Khóa học Web/App'),
		   (N'OS',N'Khóa học OS')
GO

INSERT INTO [dbo].[Supplier] ([supplier_name] ,[supplier_address] ,[supplier_phone] ,[supplier_email]  ,[supplier_desc])
     VALUES
           (N'Trần Quốc Tuấn',N'Ninh Bình',N'0123456789',N'tuan@gmail.com',N'7 năm kinh nghiệm giảng dạy. 
Các ngôn ngữ giảng dạy: HTML, CSS, Javascript, PHP, VueJS, NuxtJS, Wordpress
Tốt nghiệp Chuyên ngành Hệ Thống Thông Tin tại Đại học Cần Thơ
2016-2019: Developer FullStack làm việc tại VietVang Company
2019-2022: Developer Fullstack tại at PrimeLabo Company
2023: PHP Developer tại CMO'),
		   (N'Trần Quốc Toản',N'Hà Nội',N'0123456789',N'toan@gmail.com',N'4 năm kinh nghiệm giảng dạy
Bộ môn giảng dạy: Lập trình Full-Stack
Tốt nghiệp Chuyên ngành lập trình website tại Đại học FPT
2018-2022: Giảng viên lập trình CodeGym
2022-2023: Giảng viên lập trình website đại học Hutech'),
		   (N'Hồ Nguyên Trừng',N'Nam Định',N'0123456789',N'trung@gmail.com',N'Mình đến CodeGym để bắt đầu sự nghiệp lập trình viên khi vừa mới tốt nghiệp Trung học phổ thông. Hiện tại mình đang làm việc tại Agilead Global.
Đối với mình, CodeGym là Sức sống qua ngày'),
		   (N'Lê Tư Thành',N'Sơn La',N'0123456789',N'thanh@gmail.com',N'6 năm kinh nghiệm giảng dạy
Kỹ sư, chuyên ngành Cơ điện tử Đại học Sư phạm và Kỹ Thuật thành phố Hồ Chí Minh,
Thành tích đào tạo: Huấn luyện học sinh tham gia kỳ thi Olympic tháng 4 các môn khoa học (môn Robotics) năm học 2017 và 2018 đạt được 10 huy chương vàng, 6 huy chương bạc và 6 huy chương đồng'),
		   (N'Mạc Đăng Dung',N'Hải Phòng',N'0123456789',N'dung@gmail.com',N'Bệ đỡ hoàn hảo để bắt đầu nghệ lập trình. Nếu bạn đặt mục tiêu học để đi làm, xác định cho mình tâm lý nghiêm túc và chuẩn bị một tâm trí vững vàng, CodeGym sẽ là bệ đỡ hoàn hảo cho bạn để bắt đầu theo đuổi nghề lập trình viên.')
GO

-- insert courses
INSERT INTO [dbo].[Courses]
           ([course_name] ,[course_description] ,[course_price] ,[course_create_date] ,[course_modified_date] ,[category_id] ,[supplier_id] ,[course_short_desc]  ,[course_create_by] ,[course_modified_by] ,[course_img],[course_discount])
     VALUES
           ('The Complete Java Development Bootcamp','Are you ready to take your programming skills to the next level? Our comprehensive Java course is designed to help you build a solid foundation in one of the world most popular programming languages, opening up a world of opportunities for your career.

Join us as we guide you through the essentials of Java, from basic syntax and data structures to advanced concepts like lambda expressions, inheritance, and stream operations. With our interactive course format, you will have access to workbooks and challenges that will help you apply your newfound knowledge and reinforce your learning.

Here is a sneak peek into what you can expect in this course:

Module 1: Java Fundamentals

Variables

Conditionals

Functions

Loops

Arrays

Module 2: Object-Oriented Programming

Objects

Immutable Objects

List Collections

Map Collections

Exception Handling

Enums

Inheritance

Higher-order Functions

Lambda Expressions

Stream Operations

Interfaces

Interactive Learning Experience - Our course is designed with your success in mind. Hundreds of Workbooks and challenges will help you practice and apply what you have learned, ensuring you are ready to tackle real-world problems.

Boost Your Career Prospects - With a thorough understanding of Java, you will be well-equipped to excel in various domains like web development, mobile app development, automation, and more.



Dont miss out on this opportunity to enhance your programming skills and gain a competitive edge in the industry. Enroll in our Java course today and get ready to transform your programming journey! We cannot wait to see you in class!',1899000,'5/9/2023','5/9/2023',1,1,'Become an Experienced Java Developer with Just One Course. Fully Updated with 100+ Coding Challenges!','admin','admin','usercss/images/CourseImage/Java1.PNG',87),
('Java from Zero to First Job, Practical Guide, 2000+ examples','Welcome to the fundamental and the most complete course ''Java from Zero to First Job''.  As it''s declared in the course name, it''s created for people who want to learn programming from scratch. You need to know how to turn on your computer, no other knowledge is required for this course :) The rest will be covered in lessons.

- High concentration of useful material in each lesson

Sometimes you can notice that watching 5 minutes of our lesson is equivalent to watching other 30 minutes lessons.

This is because time spent for preparation for the lesson (script for the lesson, lesson structure) and video editing (to cut boring pieces of the lesson or time when the program loads) sometimes 10 times as much (sometimes even 20) as the final lesson duration after video editing.

Only your homework and coding exercises including the EXAM task might take approximately 20 hours to implement.

Also, each topic is separated from another. In case some concept will be explained in the next lesson and you don''t need to worry about understanding this in the scope of this lesson - the instructor will make an announcement when a specific topic will be covered.

Go and try it yourself! We will appreciate your feedback.

- Relevant knowledge

After our team investigated other Java courses on Udemy we realized that most of them have nothing in common with real life. The information which is shared there is very old and significantly out of date. For example, the instructor teaches a framework which is not been used already for 15 years. Or instructors do stress on the programming design which is not used anymore at all!

The instructor of this course is a consultant in a top-rated IT outsourcing company and helps to bring cutting-edge solutions in IT for all his clients. Feel free to check the LinkedIn page of the instructor and check skills endorsement. More than 18 thousand people across all over the world (BTW most of them are from the top 100 companies of the world) evaluated the skills of Andrii Piatakha.

With this course, you can be sure that you will spend your time learning the right things from one of the best IT consultants in the world.

- Sequence of lessons

After the years of teaching offline, and based on the feedback of students who are passing online courses we realized how important the sequence of lessons is while teaching Java. The same issue is with the books where information is completely unstructured what makes things even more complex. For example, how students can learn object-oriented programming from the first lesson if they don''t know yet the java syntax basics? Or how a student can implement a home task if he/she doesn''t aware of java methods specifics, or doesn''t know yet how to read program input?

So in this course, you can be sure, that you will not get a home task to implement without having enough information to implement it. The program which is in this course is proven by many students who completed it offline and now work as software engineers in outsourcing companies and as freelancers.

- Interview practice tests

Being an IT consultant in different companies, the tutor of this course was in charge of driving the interview process in companies to make sure, that company selects the best people. That''s why the first interview is always test. In case the test is completed, the candidate is invited to have a conversation. That''s why in this course we want to prepare you to complete tests successfully!

Especially for our students, we prepared tests that could be used to evaluate their knowledge during the interview process.

2 tests. 90 questions each (180 interview tests in total). 120 minutes each.

You can read explanations for answers! That also can help you to learn the material better. Don''t wait, try it now!

- Q&A support

The significant difference between the online and offline learning processes is the instructor''s availability. If you are in one room with a tutor he always can help you to get understand the specific concepts or to help fix your code on your computer.
In this course, we are supporting students with answers to any questions flagged in the Q&A section. In case there will be recurring questions - separate video lessons will be created to show how to address the issue.

Hope you enjoy this course! And remember, we appreciate all your feedback! Your feedback will help us to become even better! Your feedback will help us to create to best Java course ever!

See you at the lessons! :)',1799000,'5/19/2023','5/19/2023',1,1,'Java Core, TDD, Streams, Lambdas, JPA/Hibernate, SQL, Build Tools, Git, Web Servers, HTML, Servlets, JSP, Spring etc','admin','admin','usercss/images/CourseImage/Java2.PNG',87),
('Professional Java Developer Career Starter: Java Foundations','In this course, you''ll learn such topics as:

Object Oriented Programming (OOP)

Too many so-called "Java" developers have learned the syntax of the language but have no idea how to harness its actual power to write sophisticated software that''s easier to maintain and collaborate on.

Regular Expressions

Another unfortunate observation is that a majority of Java developers are very weak with Regular Expressions. This is unfortunate because so much of what Java tends to be used for, involves processing text and checking that it is valid or parsing key information out of it. Without the use of Regular Expressions, these tasks require considerable amounts of error-prone code that is inflexible and difficult to maintain.

Functional Programming with Lambdas & Streams API

Another sore-spot among a large number of Java developers. As of 2021, Java 17 is out, but the Functional programming APIs of Lambdas & Streams were introduced into Java with version 8. We''ve observed that developers simply aren''t keeping up with these powerful (not-so-new anymore) techniques that help keep Java competitive and efficient in an increasingly functional programming world. You can sift through large datasets with ease and significantly less code with these APIs.

Optionals

Tony Hoare, the inventor of the programming concept of "null", called its invention his "billion-dollar mistake" dating back to 1965. That mistake has gone on to wreak havoc across numerous programming language ever since. Optionals seek to remedy that mistake. Unfortunately, not enough Java developers have learned and embraced the power of using Optionals. This topic seeks to remedy that shortcoming.

Java 8 Date/Time API

Java was introduced in 1995 and heralded as the great, shiny new programming language of our time. To a large degree, one could argue that it is indeed, that. However, mistakes were made along the way. One of those mistakes was the way dates & times were handled. Java 8 made major strides in fixing those mistakes, but as with Optionals, Lambdas and many other topics mentioned, not enough developers have taken the time to learn the new and greatly improved Java 8 Date/Time API. We''ll show you how to keep time the right way.

Working with Databases & SQL

One of the topics where it seems Java developers actually have kept up (mostly) is in learning modern ways to work with databases in Java - primarily through the use of frameworks like Spring Boot. However, one unfortunate side-effect of the massive levels of abstraction these frameworks afford us, is that many developers have little-to-no idea of what these frameworks are doing or how to use them to maximum effect. We''ll peel back the covers and give a solid foundation of the basics to better empower developers as they inevitably continue to use frameworks to make this work easier.

An Introduction to The Spring Framework & Spring Boot

The Spring Framework & its sibling, Spring Boot, have absolutely revolutionized modern Java software development - particularly for business. Dare I say virtually no company doing Java these days, even considers doing it without Spring or at least one of its few and much less popular competitors. You WILL have to learn Spring to be a true and well-rounded Java developer competitive in the job market. Though this course if focused on the fundamentals of Java, we knew we had to whet your appetite for the full(er) stack of Java development. Spring is what most companies use to enable their Java applications to become web applications and web services and talk to databases. This module will set you up for Neutrino''s upcoming course dedicated to the topic in full (because it deserves its own course).



So, if you''re willing to put in the work, come join us and begin the next phase of your career.',1399000,'5/19/2023','5/19/2023',1,2,'Covers Java 17 & Earlier, Streams/Lambdas, Regex, TDD/Testing, Optionals, JDBC/SQL Intro to Spring & More Using IntelliJ','admin','admin','usercss/images/CourseImage/Java3.PNG',86),

('Practice Java by Building Projects', 'If your goal is to GET HIRED, then you need to PASS THE INTERVIEW!

As a trainer for over 6 years, one of the most common questions I get asked is "I''m new to programming, how can I get better and prepare for a job interview?" My answer is "Practice, practice, practice!" I created this course to help people see the core Java concepts in action. This will help you understand the ideas and know how to apply them in an application. 

The BEST way to prepare for a technical interview is to get practice building applications and applying core principles of object-oriented design. I''ve designed this course to accomplish that objective.


Many people fail interviews because:

They don''t grasp object-oriented programming concepts
They can''t apply object-oriented design in an actual program
They haven''t practiced developing their applications by hand
They haven''t debugged their code and overcome challenges
This course is designed for someone who simply wants to get better at understanding and applying Java design and object-oriented programming. It is perhaps the most effective thing you can do to prepare for your job interview. Forget about flashcards, forget about quizzes. Start practicing!

In my Practical Java course, you will build realistic projects from scratch. We will approach each program analytically and outline our approach to implement the solution. Then, piece by piece we will write the code to create a fully functioning application.

Understand client scenarios and requirements
Approach each problem analytically
Write our solution outline
Implement code step-by-step
Apply core principals of object-oriented design
Everyone hoping to start out in Java needs to practice! It''s not enough to learn and watch, but you must try yourself! So enroll in this course and get typing!

Note: this course was build for someone who has some working knowledge and familiarity of Java or application design. If you are new to Java, I recommend enrolling in my "Become a Junior Java Software Developer" course first.', 1399000,'5/19/2023','5/19/2023',1,2,'Ultimate Java interview prep course! 100% focused on applying object-oriented design in real-world applications','admin','admin','usercss/images/CourseImage/Java4.PNG',84),
('Master Object Oriented Design in Java - Homework + Solutions','SUPER CHARGE OF YOUR PROGRAMMING CAREER and acquire some seriously marketable skills!

Just because you learned how to use a hammer doesn''t mean you are ready to construct a building. Similarly, It''s not enough to just understand a programming language. That''s just a tool that can be used to develop various programs. The real craftsmanship is in software DESIGN. 

This course is designed to take a junior level programmer with limited knowledge about object orientation to a competent level object oriented software designer! I expect you to understand the basics of loops, methods and conditionals in Java. You''ll be completing hands-on HOMEWORK Exercises through out the course! I have provided detailed video solutions to the exercises so that you can check your answers and get step by step instructions of how to tackle the object oriented design assignments. 

You can find plenty of resources online for solving a programming puzzle  or practicing algorithms. But… when it comes to object oriented design,  admittedly, there is limited material out there for you to practice. So  in this course, we use a LEARN-BY-DOING  approach to explore a series of progressively challenging exercises to  discover the 5 core object oriented design PRINCIPLES summarized by an acronym called SOLID: 

  (S). Single Responsibility   

  (O). Open/Closed   

  (L). Liskov Substitution   

  (l). Interface Segregation   

  (D). Dependency Inversion   

During this journey you''ll get practice applying some of the most important DESIGN PATTERNS that competent developers must have under their belt. There are so many design patterns out there, but we''ll be thoroughly covering only the most important ones. Save yourself the time from learning all the design patterns and going on a design frenzy. Focus on the 20% that covers 80% of the scenarios and add miles to your programming efficiency. 

I''m certain that, by practicing the concepts covered, you''ll make a substantial leap forward in your programming career. I hope to see you in the coming lessons.

This course is from This site offers lectures on practical software development topics to immediately impact your programming skills. Things you can take to your interview and feel confident in your abilities!',1399000,'5/19/2023','5/19/2023',1,4,'Don''t just learn Java! Learn to write practical industry standard object oriented software and super charge your career!','admin','admin','usercss/images/CourseImage/Java5.PNG',84),
('100 Days of Code: The Complete Python Pro Bootcamp for 2023','Welcome to the 100 Days of Code - The Complete Python Pro Bootcamp, the only course you need to learn to code with Python.

100 days, 1 hour per day, learn to build 1 project per day, this is how you master Python.

At 60+ hours, this Python course is without a doubt the most comprehensive Python course available anywhere online. Even if you have zero programming experience, this course will take you from beginner to professional. Here''s why:

The course is taught by the lead instructor at the App Brewery, London''s best in-person programming Bootcamp.

The course has been updated to be 2023 ready and you''ll be learning the latest tools and technologies used at large companies such as Apple, Google and Netflix.

This course doesn''t cut any corners, there are beautiful animated explanation videos and tens of real-world projects which you will get to build. e.g. Tinder auto swiper, Snake game, Blog Website, LinkedIn Auto Submit Job Application

The curriculum was developed over a period of 2 years, with comprehensive student testing and feedback.

We''ve taught over 600,000 students how to code and many have gone on to change their lives by becoming professional developers or starting their own tech startup.

You''ll save yourself over $12,000 by enrolling, and still get access to the same teaching materials and learn from the same instructor and curriculum as our in-person programming Bootcamp.

The course is constantly updated with new content, with new projects and modules determined by students - that''s you!

We''ll take you step-by-step through engaging video tutorials and teach you everything you need to know to succeed as a Python developer.

The course includes over 65 hours of HD video tutorials and builds your programming knowledge while making real-world Python projects.',1999000,'5/19/2023','5/19/2023',2,4,'Master Python by building 100 projects in 100 days. Learn data science, automation, build websites, games and apps!','admin','admin','usercss/images/CourseImage/Python1.PNG',88),
('The Complete Python Bootcamp From Zero to Hero in Python','Become a Python Programmer and learn one of employer''s most requested skills of 2023!

This is the most comprehensive, yet straight-forward, course for the Python programming language! Whether you have never programmed before, already know basic syntax, or want to learn about the advanced features of Python, this course is for you! In this course we will teach you Python 3.

With over 100 lectures and more than 21 hours of video this comprehensive course leaves no stone unturned! This course includes quizzes, tests, coding exercises and homework assignments as well as 3 major projects to create a Python project portfolio!

Learn how to use Python for real-world tasks, such as working with PDF Files, sending emails, reading Excel files, Scraping websites for informations, working with image files, and much more!

This course will teach you Python in a practical manner, with every lecture comes a full coding screencast and a corresponding code notebook! Learn in whatever manner is best for you!

We will start by helping you get Python installed on your computer, regardless of your operating system, whether its Linux, MacOS, or Windows, we''ve got you covered.

We cover a wide variety of topics, including:

Command Line Basics

Installing Python

Running Python Code

Strings

Lists 

Dictionaries

Tuples

Sets

Number Data Types

Print Formatting

Functions

Scope

args/kwargs

Built-in Functions

Debugging and Error Handling

Modules

External Modules

Object Oriented Programming

Inheritance

Polymorphism

File I/O

Advanced Methods

Unit Tests

and much more!

You will get lifetime access to over 100 lectures plus corresponding Notebooks for the lectures!

This course comes with a 30 day money back guarantee! If you are not satisfied in any way, you''ll get your money back. Plus you will keep access to the Notebooks as a thank you for trying out the course!

So what are you waiting for? Learn Python in a way that will advance your career and increase your knowledge, all in a fun and practical way!',2199000,'5/19/2023','5/19/2023',2,5,'Learn Python like a Professional Start from the basics and go all the way to creating your own applications and games', 'admin','admin','usercss/images/CourseImage/Python2.PNG',87),
('Complete Python Developer in 2023: Zero to Mastery','Just updated for 2023! It''s time to become a modern and complete Python developer! Join a live online community of over 900,000+ developers and a course taught by an industry expert that has actually worked both in Silicon Valley and Toronto. Graduates of Andrei''s courses are now working at Google, Tesla, Amazon, Apple, IBM, JP Morgan, Meta, + other top tech companies.

Learn Python from scratch, get hired, and have fun along the way with the most modern, up-to-date Python course (we use the latest version of Python). This course is focused on efficiency: never spend time on confusing, out of date, incomplete Python tutorials anymore.

This comprehensive and project based course will introduce you to all of the modern skills of a Python developer (Python 3) and along the way, we will build over 12 real world projects to add to your portfolio (You will get access to all the the code from the 12+ projects we build, so that you can put them on your portfolio right away)!


The curriculum is going to be very hands on as we walk you from start to finish of becoming a professional Python developer. We will start from the very beginning by teaching you Python basics and programming fundamentals, and then going into advanced topics and different career fields in Python so you can get real life practice and be ready for the real world.

The topics covered in this course are:



- Programming Fundamentals

- Python Basics

- Python Fundamentals

- Data Structures

- Object Oriented Programming with Python

- Functional Programming with Python

- Lambdas

- Decorators

- Generators

- Testing in Python

- Debugging

- Error Handling

- Regular Expressions

- Comprehensions

- Modules

- Virtual Environments

- Developer Environments (PyCharm, Jupyter Notebooks, VS Code, Sublime Text + more)

- File Processing: Image, CSV, PDFs, Text + more

- Web Development with Python

- Machine Learning with Python

- Data Science with Python

- Automation with Python and Selenium

- Scripting with Python

- Web Scraping with Python and BeautifulSoup

- Image Detection

- Data Visualizations

- Kaggle, Pandas, NumPy, scikit-learn

- Email and SMS with Python

- Working with APIs (Twitter Bot, Password Checker, Translator)



By the end of this course, you will be a complete Python developer that can get hired at large companies. We are going to use Python to work with Email, Text Messages, CSV files, PDF files, Image Files, Data Visualizations, build our own machine learning model and perform Image detection. We are going to build a web scraper for HackerNews, build a Twitter bot,  build the most secure password checker and we will also build some automation tools using Selenium. But the best part? We will build an actual portfolio website using Python that your future employer and customers can contact you at. By the end, you will have a stack of projects you have built that you can show off to others.',1899000,'5/19/2023','5/19/2023',2,2,'How to become a Python 3 Developer and get hired! Build 12+ projects, learn Web Development, Machine Learning + more!','admin','admin','usercss/images/CourseImage/Python3.PNG',87),
('The Complete Python Course | Learn Python by Doing in 2023','Welcome to the Complete Python Course!

Learn Python from a software developer. If you want to master Python and write efficient, elegant, and simple code, this is the course you''ve been looking for!

Even if you have no programming experience, this course will give you a super-strong foundation and teach you how to use Python to achieve any goal.

We''ve crafted every piece of content to be concise and straightforward, while never leaving you confused:

Hundreds of code-along videos with in-depth explanations

Dozens of presentations with animated diagrams

Quizzes

Coding exercises

Python projects for you to learn to make real Python applications



Why Choose THIS Course?

Get a broader and deeper experience in Python than with any other Udemy course on the market.

Start at zero and become an expert whilst learning all about the inner workings of Python.

Learn how to write professional Python code like a professional Python developer.

Embrace simplicity and develop good programming habits.

Explore advanced Python, such as decorators, asynchronous development, and managing project dependencies

Improve your Python code with formatters and linters

Store data in a database so it''s accessible and searchable.

Learn about web development using Flask, to create websites that you can share with users.

Extract information from existing websites using web scraping.

Control your browser using Selenium, to automate using almost any website!

Learn to interact with REST APIs to fetch data from other web applications.

Create desktop GUIs using Tkinter, and turn them into executable applications you can share with non-technical users.

Start working with unit testing in Python by learning about the unittest library



Who Is This Course For?

Beginners who have never programmed before.

Programmers with experience in other languages who want to kickstart their Python programming.

Programmers who know some Python but want to round off their skills and become truly proficient.



What Am I Going to Get From This Course?

Lifetime access to over 300 code-along lectures covering all aspects of Python, from the foundations to advanced concepts.

Complete written notes and code for you to read and refer to as you progress through the course.

Milestone projects for you to complete throughout the course. These provide a challenge and an opportunity for you to apply what you''ve learned. We always go over the code after to show you how we would tackle them.

Quizzes and coding exercises for you to check your understanding.

High-quality help and support. Every year we personally help thousands of students. We don''t leave a single question unanswered.

Also remember: we have a 30-day money-back guarantee, so sign up and try the course totally risk-free!

I''ll see you on the inside.',1999000,'5/19/2023','5/19/2023',2,3,'Go from Beginner to Expert in Python by building projects. The best investment for your Python journey!','admin','admin','usercss/images/CourseImage/Python4.PNG',88),
('The Python Mega Course: Learn Python in 60 Days with 20 Apps', 'Updated to Python 3.11.

A Course to Learn Both the Theory and Real-World Skills
This is the only course you need to learn both the theoretical and practical aspects of Python. It is ideal for people who do not have a programming background. By the end of the course, you will have a portfolio of Python apps on your GitHub account. You will learn Python by building 20 apps together with the instructor and solve 10 independent Python projects. This will help you code independently and apply for a junior developer job after finishing the course.

Multimodal Learning
The course follows a proven multimodal learning approach that offers students a video course and an environment that simulates real-world programming activities similar to an on-site bootcamp. Students learn Python by building programs from scratch, adding new features to existing programs, improving existing features, fixing bugs, engaging in code experiments, learning programming tools that every programmer should know, deploying apps in the cloud, and interacting with other fellow students. Your skill set will progressively and strongly build up as you build your programming portfolio to list and showcase all your Python projects.

A Course for Absolute Beginners
This course is perfect for those who have never programmed before. It covers every Python concept using real-world examples, making it easy to understand both the Python language and the logic behind programming. From the basics to the advanced features like threading, everything is introduced in the context of a real-world application that you will build. This approach will make abstract programming concepts easy to grasp.

Instructor-Led and Independent Student Projects
In this course, you will build programs daily to develop your skills. Each day, you will work on projects led by your instructor and then work on projects independently to solidify your skills. At the end of the day, you can compare your code with the instructor''s code to identify and address any gaps in your understanding.

Career Change or App Development
If you''re considering a career change to become a Python programmer or looking to turn your idea into a real app, this course is perfect for you. You can take the full course to become a programmer or pick specific projects that interest you if you only want to build a particular app. Additionally, you will learn Git and GitHub so that you can create a portfolio of 20 Python apps on your GitHub account, which you can show to potential employers or share with friends.

From Data Science to Web Development
This course covers a wide range of applications, from creating rich data science web apps that analyze and visualize large amounts of data to building web applications using Python web frameworks such as Streamlit, Flask, and Django. It also covers other aspects of Python, such as automating tedious tasks, ranging from generating PDF invoices to automating emails. In short, this course offers a comprehensive approach to Python, covering various domains, making it an all-in-one solution.

Flexible Learning Schedule
This curriculum is designed to accommodate your schedule. While it is recommended that you study 2-5 hours every day, you can also work through multiple-day modules during the weekend or whenever it is convenient for you. You will also have unlimited access to all the videos and practice activities. By committing to this course, you will be able to achieve better results than a 10,000-dollar boot camp.

Boosted Focus

Keeping yourself focused and motivated with online courses is hard, but not with this course. The course is designed around real-world projects and challenges to keep students interested throughout the entire course. This is a course that you will actually finish.',2499000,'5/19/2023','5/19/2023',2,1,'Take the full course to become a Python programmer, or pick any of the projects to master specific areas of Python.','admin','admin','usercss/images/CourseImage/Python5.PNG',88),
('Complete C# Masterclass', 'The course gets updated frequently - Last update: 23. January 2023



Have you ever had an idea for a program, an app, or a game?

Maybe you want to work as a developer? Then you are in the right place. In this course, you are going to discover how to become a c# developer - one of the best programming languages on earth!

C# is one of the few programming languages which allows you to create amazing cross-platform Mobile Apps, Games, and PC Programs. 

Bringing an Idea to life is one of the best feelings one can have, but the path to get there is often full of challenges. So I have created a course that makes this path as easy as possible all with the help of c# so that you become a skilled c# developer!



You start off by learning the C# basics and C# programming concepts in general:

variables

methods

arrays

if statements

loops

Then you learn the three pillars of Object-oriented programming.

Classes and Objects

Inheritance

Polymorphism

Once you mastered them you will go into advanced C# Topics, such as Databases and LINQ.

In order to really become really good in c# programming, you have to program yourself, so I have created loads of exercises (and quizzes) for you to try for yourself to do c# programming and also to see how it is done afterward. Of course, you learn best programming practices along the way.



Equipped with those skills, you will build beautiful user interfaces with WPF - A framework, which makes creating GUI’s a piece of cake.
By that point, you can create your very own complex programs.
But what comes next is even cooler.

Learn Game Development with Unity and C# - Build 2 awesome games

As C# can be used for multiple different areas of programming, I have decided to cover the most important ones. So I have added a whole bunch of chapters specifically designed for a C# developer and Unity game developer - arguably the best Game Engine in the world. In those chapters, you will discover how to create your very own video games by building pong, the mother of video games and zig-zag, an amazing and successful endless runner game.

We live in a world, where knowledge and work are shared more than ever, so using assets provided by others is a huge boost to your progress.  You will learn how to use 3D assets to make an endless runner. Then you’ll use animations, reset the game, use particle systems, and finally create a map procedurally. That''s quite some advanced stuff right there.



I know that learning to code can be hard at times, and sometimes you just get stuck. But no worries, we are there for you. We answer each question as quickly as we can and make sure that you reach your goal of becoming a developer.',2199000,'5/19/2023','5/19/2023',3,1,'Learn C# Programming - WPF, Databases, Linq, Collections, Game Development with Unity. More than just the C# basics!','admin','admin','usercss/images/CourseImage/Csharp1.PNG',87),
('C# Basics for Beginners: Learn C# Fundamentals by Coding', 'C# is a beautiful cross-platform language that can be used to build variety of applications. With C#, you can build mobile apps (for Windows, Android and iOS), games, web sites and desktop applications.



Once you master fundamentals of C# and programming with .NET framework, you''ll have lots of options in front of you. You can choose to build mobile apps if you prefer, or you can change job and work as a web developer. As long as you know the fundamentals well, switching to different technology stacks is pretty easy.



In this course, Mosh, author of several best-selling C# courses, teaches you the fundamentals of C# programming in a clear, concise and step-by-step way. Note only that, but he''ll also teach you best practices and shortcuts to help you become a better developer.



Every section comes with a few bite-sized video lectures and a quiz or programming exercises. These exercises are carefully chosen from academic and real-world examples to train your "programming brain". If you want to be a successful programmer, who has many high-paid job offers and freedom to "choose", you need to learn how to think like a programmer. And this is what you''re going to get out of these exercises. All exercises come with solutions, so you can compare your solutions with Mosh''s to find areas for improvement.



There are plenty of free tutorials and videos that teach you C# and they are great if all you want to learn is C# constructs. But if you want to learn C# and become a better programmer with a bright future and lots of options, this is the course for you. For every topic, not only will you learn the whats, but you''ll also learn the whys, and hows. You''ll see common errors that pop up as part of developing applications with C#. Mosh explains these errors in detail, and shows you how to resolve them.






THE COMPLETE C# PACKAGE

This course is the first part of Mosh''s complete C# series:

Part 1: C# Basics for Beginners: Learn C# Fundamentals by Coding 
Part 2: C# Intermediate: Classes, Interfaces and Object-oriented Programming
Part 3: C# Advanced: Take Your C# Skills to the Next Level

30-DAY FULL MONEY-BACK GUARANTEE

This course comes with a 30-day full money-back guarantee. Take the course, watch every lecture, and do the exercises, and if you feel like this course is not for you, ask for a full refund within 30 days. All your money back, no questions asked. ',1999000,'5/19/2023','5/19/2023',3,3,'Master C# fundamentals in 6 hours - The most popular course with 50,000+ students, packed with tips and exercises!','admin','admin','usercss/images/CourseImage/Csharp2.PNG',86),
('C# Intermediate: Classes, Interfaces and OOP', 'Whether you want to use C# to build web apps, mobile apps, desktop apps or games, understanding C# classes, interfaces and principles of object-oriented programming is crucial.

This course is the second part of Mosh''s best-selling C# series and is all about classes, interfaces and object-oriented programming. In essence, you''ll learn:


How to work with classes, constructors, fields, properties, methods and indexers

How to use encapsulation to reduce the impact of change

How to improve the robustness of your code

How to re-use code using inheritance and composition

Why composition is better than inheritance

How to build extensible applications using polymorphism

How to develop loosely-coupled, extensible and testable applications using interfaces




There are lots of free tutorials and videos on YouTube. Why would you want to take this course?

The answer is simple: quality of teaching.



Mosh is a passionate software engineer with over 13 years of experience developing applications in C#. He is the author of several best-selling C# courses and knows how to lead you through a series of baby steps in a logical way.



So, from the very beginning to the very end, you''ll be confident that you''ll be in good hands and watching every minute of the course, unlike the reading many free tutorials and videos, does not waste your precious time.



Each section is equipped with a balanced mix of theory and practice. At the end of each section you''ll get exercises to master the concepts you learn in that section.



And one last reason: all videos are produced with high quality video/audio, to provide you the best learning experience.





THE COMPLETE C# PACKAGE

This course is the second part of Mosh''s complete C# series:

Part 1: C# Basics for Beginners: Learn C# Fundamentals by Coding 
Part 2: C# Intermediate: Classes, Interfaces and Object-oriented Programming
Part 3: C# Advanced: Take Your C# Skills to the Next Level


100% MONEY-BACK GUARANTEE

This course comes with a 30-day full money-back guarantee. Take the course, go through the lectures, do the exercises, and if you''re not happy, ask for a refund within 30 days. All your money back, no questions asked.



So do you want to take your C# skills to the next level? Then take this course now and get started!',1799000,'5/19/2023','5/19/2023',3,3,'An in-depth, step-by-step guide to classes, interfaces and object-oriented programming (OOP) with C#','admin','admin','usercss/images/CourseImage/Csharp3.PNG',86),
('C# Advanced Topics: Prepare for Technical Interviews', 'Chances are you''re familiar with the basics of C# and are hungry to learn more. Or you''ve been out of touch with C# for a while and are looking for a quick course as a refresher to get you up to speed with advanced C# constructs. If so, then this course is for you.


In C# Advanced Topics, the third part in Mosh''s best-selling C# series, he walks you through the advanced features of C# that are frequently used in building real-world applications:

Exception Handling
Generics
Delegates
Events
Lambda Expressions
Extensions Methods
LINQ
Nullable Types
Dynamics
Asynchronous Programming with Async / Await
And more


There are lots of free tutorials and videos on YouTube. Why should you take this course?

This course has a clean structure with a perfect pace (not too fast to confuse you, and not too slow to bore you or waste your time). It gives you an in-depth understanding of advanced C# features, and is created by a C# expert and best-selling author with in-depth knowledge of the C# language and .NET Framework as well as 13 years of professional experience in the industry. So, from the very beginning to the very end, you''ll be confident that you''ll be in good hands. If you got questions along the way, Mosh is here to help you.

THE COMPLETE C# PACKAGE

This course is the third part of Mosh''s complete C# series :

Part 1: C# Basics for Beginners: Learn C# Fundamentals by Coding 
Part 2: C# Intermediate: Classes, Interfaces and Object-oriented Programming
Part 3: C# Advanced: Take Your C# Skills to the Next Level

Do you want to take your C# knowledge to the advanced level?

Then take this course and get started.',1699000,'5/19/2023','5/19/2023',3,3,'Master the confusing C# constructs: Events, Delegates, Lambda Expressions, LINQ, Async/Await and more!','admin','admin','usercss/images/CourseImage/Csharp4.PNG',85),

('Complete C# Unity Game Developer 3D', 'This is the long-awaited sequel to the Complete Unity Developer - one of the most popular e-learning courses on the internet! Completely re-worked from scratch with brand-new projects and our latest teaching techniques. You will benefit from the fact we have already taught over a million students programming and game development, many shipping commercial games as a result.

Unity is an incredible 3D package used for making video games, architectural and medical imaging and more. The challenge is that it''s big and complicated to use, especially for complete beginners to coding and game development. We make learning to code easy and fun by leading you step-by-step through the process of creating exciting games.

Get plugged into our communities of amazing developers on Facebook (nearly 20k), in our own Teaching Assistant-curated Community, and our student Discord chat channel.

This course has full professional-produced English closed-captions.

If you''re reading this you probably already have everything you need to get started. Unity is a free download. With regular access to an internet connection you''ll be able to engage in our thriving community. Even if you have no experience with coding, or with 3D packages, we will guide you through everything from first principles. Starting slow, then building on what you learn, you''ll soon have a very solid working knowledge of Unity.

Don''t take our word for it, please see the amazing reviews students have taken the time to write. We are proud to be transforming lives, and equipping 1000s of people with valuable new skills. We would love you to become one of them now.

The course is project-based, so you will not just be learning dry programming concepts, but applying them immediately to real indie games as you go. All the project files will be included, as well as additional references and resources - you''ll never get stuck. There are "talking heads", powerful diagrams, quality screencasts and more.

For each demo game you build you will follow this process...

Be challenged to build the entire game yourself.

Be shown step-by step how to build it.

Be challenged to apply, and re-apply your knowledge regularly.

Prefer to focus on 2D? Check-out our Complete Unity Developer 2D course. Want something a little more advanced? Check-out our epic Unity RPG course. Want to get certified, get a job, or learn environment art - we''ve got you covered. The green leaf logo is your sign of quality.

You will get full lifetime access for a single one-off fee. The creators are qualified and experienced coders and avid gamers, so are able to explain complex concepts clearly, as well as entertain along the way.

What this course DOESN''T cover...

Here are some things we will not be covering in detail...

Art asset creation (assets provided but not made on-screen).

Advanced performance optimization.

Editor plugins or modifications.

Physics engine modification.

Anyone who wants to learn to create games: Unity 3D is a fantastic platform which enables you to make production-quality games. Furthermore these games can be created for Windows, MacOS, iOS (even iOS 9), Android and Web from a single source!

Dive in now, you won''t be disappointed!',2199000,'5/19/2023','5/19/2023',3,5,'Design & Develop Video Games. Learn C# in Unity Engine. Code Your first 3D Unity games for web, Mac & PC.','admin','admin','usercss/images/CourseImage/Csharp5.PNG',89),
('The Complete 2023 Web Development Bootcamp', 'Welcome to the Complete Web Development Bootcamp, the only course you need to learn to code and become a full-stack web developer.

At 65+ hours, this Web Development course is without a doubt the most comprehensive web development course available online. Even if you have zero programming experience, this course will take you from beginner to mastery. Here''s why:

The course is taught by the lead instructor at the App Brewery, London''s leading in-person programming bootcamp.

The course has been updated to be 2023 ready and you''ll be learning the latest tools and technologies used at large companies such as Apple, Google and Netflix.

This course doesn''t cut any corners, there are beautiful animated explanation videos and tens of real-world projects which you will get to build.

The curriculum was developed over a period of four years, with comprehensive student testing and feedback.

We''ve taught over a million students how to code and many have gone on to change their lives by becoming professional developers or starting their own tech startup.

You''ll save yourself over $12,000 by enrolling, but still get access to the same teaching materials and learn from the same instructor and curriculum as our in-person programming bootcamp.

The course is constantly updated with new content, with new projects and modules determined by students - that''s you!



We''ll take you step-by-step through engaging video tutorials and teach you everything you need to know to succeed as a web developer.

The course includes over 65 hours of HD video tutorials and builds your programming knowledge while making real-world websites and web apps.



Throughout this comprehensive course, we cover a massive amount of tools and technologies, including:

Front-End Web Development

HTML 5

CSS 3

Flexbox

Grid

Bootstrap 5

Javascript ES6

DOM Manipulation

jQuery

Bash Command Line

Git, GitHub and Version Control

Backend Web Development

Node.js

NPM

Express.js

EJS

REST

APIs

Databases

SQL

MongoDB

Mongoose

Authentication

Firebase

React.js

React Hooks

Web Design

Deployment with GitHub Pages, Heroku and MongoDB Atlas

Web3 Development on the Internet Computer

Blockchain technology

Token contract development

NFT minting, buying and selling logic

By the end of this course, you will be fluently programming and be ready to make any website you can dream of.

You''ll also build a portfolio of over 32+ websites that you can show off to any potential employer.

Sign up today, and look forward to:

Animated Video Lectures

Code Challenges and Coding Exercises

Beautiful Real-World Projects

Quizzes & Practice Tests

Downloadable Programming Resources and Cheatsheets

Our best selling 12 Rules to Learn to Code eBook

$12,000+ worth of web development bootcamp course materials and course curriculum',2199000,'5/19/2023','5/19/2023',4,1,'Become a Full-Stack Web Developer with just ONE course. HTML, CSS, Javascript, Node, React, MongoDB, Web3 and DApps','admin','admin','usercss/images/CourseImage/Web1.PNG',89),
('The Web Developer Bootcamp 2023', 'Now with over 10 hours of React content.  Just updated on May 15th, 2023.

Massive new React "expansion pack" covers: React basics, JSX, props, state, Vite, MaterialUI, hooks, useEffect, React design patterns, and more.

Hi! Welcome to the brand new version of The Web Developer Bootcamp, most popular web development course.  This course was just completely overhauled to prepare students for the 2023 job market, with over 60 hours of brand new content. This is the only course you need to learn web development. There are a lot of options for online developer training, but this course is without a doubt the most comprehensive and effective on the market.  Here''s why:

This is the only course taught by a professional bootcamp instructor with a track record of success.

92% of my in-person bootcamp students go on to get full-time developer jobs. Most of them are complete beginners when I start working with them.

The previous 2 bootcamp programs that I taught cost $14,000 and $21,000.  This course is just as comprehensive but with brand new content for a fraction of the price.

Everything I cover is up-to-date and relevant to 2022''s developer job market. This course does not cut any corners. I just spent 8 months redoing this behemoth of a course!

We build 13+ projects, including a gigantic production application called YelpCamp. No other course walks you through the creation of such a substantial application.

The course is constantly updated with new content, projects, and modules.  Think of it as a subscription to a never-ending supply of developer training.

You get to meet my cats and chickens!

When you''re learning to program you often have to sacrifice learning the exciting and current technologies in favor of the "beginner friendly" classes.  With this course, you get the best of both worlds.  This is a course designed for the complete beginner, yet it covers some of the most exciting and relevant topics in the industry.

Throughout the brand new version of the course we cover tons of tools and technologies including:

HTML5

CSS3

Flexbox

Responsive Design

JavaScript (all 2022 modern syntax, ES6, ES2018, etc.)

Asynchronous JavaScript - Promises, async/await, etc.

AJAX and single page apps

Bootstrap 4 and 5

ReactJS

SemanticUI

Bulma CSS Framework

DOM Manipulation

Unix(Command Line) Commands

NodeJS

NPM

ExpressJS

Templating

REST

SQL vs. NoSQL databases

MongoDB

Database Associations

Schema Design

Mongoose

Authentication From Scratch

Cookies & Sessions

Authorization

Common Security Issues - SQL Injection, XSS, etc.

Developer Best Practices

Deploying Apps

Cloud Databases

Image Upload and Storage

Maps and Geocoding

This course is also unique in the way that it is structured and presented. Many online courses are just a long series of "watch as I code" videos.  This course is different. I''ve incorporated everything I learned in my years of teaching to make this course not only more effective but more engaging. The course includes:

Lectures

Code-Alongs

Projects

Exercises

Research Assignments

Slides

Downloads

Readings

Too many pictures of my dog Rusty

If you have any questions, please don''t hesitate to contact me.  I got into this industry because I love working with people and helping students learn.  Sign up today and see how fun, exciting, and rewarding web development can be!',2199000,'5/19/2023','5/19/2023',4,3,'10 Hours of React just added. Become a Developer With ONE course - HTML, CSS, JavaScript, React, Node, MongoDB and More!','admin','admin','usercss/images/CourseImage/Web2.PNG',87),
('The Complete Web Developer in 2023: Zero to Mastery', 'Just Updated for 2023! Become a Fullstack Web Developer by learning the most in demand skills!  Graduates of this course are now working at companies like Google, Tesla, Amazon, Apple, Shopify, JP Morgan, Facebook + other top tech companies (...seriously).

Join a live online community of over 900,000+ developers and a course taught by an industry expert that has actually worked both in Silicon Valley and Toronto as a Senior Developer and Tech Lead.

This is the tutorial you''ve been looking for to become a modern web developer in 2023. It doesn''t just cover a small portion of the industry. This covers everything you need to know to get hired: from absolute zero knowledge to being able to put things on your resume that will allow you to live the life you want. 

Sounds too good to be true? Give me 5 minutes of your time to explain why I built this Web Development course and what is different here than thousands of other courses all over the internet:

I update the course every month to make sure you learn the most up to date skills! There is no wasted time here. We won''t be using outdated technologies like PHP, Wordpress and JQuery. Although still useful, outdated technologies like the above are low paying and demands for them are decreasing. In this course, you will learn the specific technologies that are the most in demand in the industry right now. These include tools and technologies used by the biggest tech companies like Google, Facebook, Instagram, etc… It is geared specifically for people that want to learn employable skills in 2023.


After finishing this course, you will be able to apply for developer roles, get a promotion, or upgrade your job title as a developer and earn a higher salary. We won''t be taking any shortcuts in this course. You are going to go from absolute zero: where you learn how the internet works. To mastery: where you build an image recognition app using a Machine Learning API (a subset of Artificial Intelligence) and all the other modern technologies that we learn in the course. Most students have commented how the projects in this course have impressed their interviewers and allowed them to get an offer.


This course is taught by an instructor who has worked in Silicon Valley, and one of the top tech companies in Toronto. I have built large scale applications, and have managed teams of developers. I am not an online marketer or a salesman, but a software developer who has worked directly with these technologies.  I love programming and believe that there needs to be a course out there that actually teaches valuable real life skills (because most of them are taught by teachers with no work experience).


Your time is valuable and you don''t want to spend thousands of dollars on a bootcamp. You want a course that outlines the best way to become a Web Developer, in simple and well explained terms, so that you fully understand topics instead of watching somebody on your screen and having no clue what is going on. I have taken the best pieces, tools, and practices that I have found over the years, and condensed everything into this course. 50 hours of videos doesn''t mean much if the instructor isn''t engaging or focuses on outdated topics. I made sure that everything covered in this course is efficient and focuses on getting you job ready as soon as possible! 


We have a thriving online chat community so you really feel like you are part of a classroom and not just watching videos by yourself. You will have a chance to communicate with fellow students, work on group projects together, and contribute to open source projects. Anytime you have a question, you can ask in many locations and get help right away (including from myself). 



The course is designed to give you employable skills so you can get a job. Here is what one student recently wrote after taking the course and being hired right away:

"I''m a self taught dev, who has been out of work for ~6 months. I had some family things that came up that prevented me from seeking permanent employment, so for awhile I was Postmates/Uber delivery driver.
 
After taking this course, I immediately got catapulted back to where I was before, but better equipped and with the knowledge to take on the next job. I had just finished the React section when I went to a recent interview, and it really helped me excel. As of today, I am officially re-employed back in the field, and it is all thanks to this course. I had a blast creating the final project, and FINALLY got around to learning SQL statements, and getting to use them in a project. I''m really ecstatic that Andrei went with teaching relational databases over something like MongoDB, which can also be fun, but is less practical for use on the job.   So thanks Andrei , I really enjoyed the course and will be making sure to share it with others who find it helpful. I''m also looking forward to the new ES10 content that was recently added, and going through the DB stuff again when I go to build a personal project." - J.C.



Think of this course like a Web Developer bootcamp. By the end, you will be comfortable using the below skills and you will be able to put them on your resume:

HTML/HTML5

CSS/CSS3

SemanticUI

Responsive Design

Flexbox

CSS Grid

Bootstrap 5

DOM Manipulation

Javascript (including ES6/ES7/ES8/ES9/ES10/ES2020/ES2021/ES2022)

Asynchronous JavaScript

HTTP/JSON/AJAX

React + Redux + React Hooks

Git + Github

Command Line

Node.js

Express.js

NPM

RESTful API Design

PostgresSQL

SQL

Authentication

Authorization

Scalable Infrastructure

Security

Production and Deployment



You will be taken through online videos and exercises where you will be able to do the following things by the end:

Build real complex applications and websites

Build an image recognition app so you can add it to your portfolio

Go into a job interview confident that you understand the fundamental building blocks of web development and the developer trends in 2023

Be able to go off on your own and grow your skills as a developer, having built a solid foundation

Learn how frontend, servers, and databases communicate and how they all fit together in the eco system

Build your own startup landing page

Go off and work remotely by being a freelance developer that can bid on projects



This course is the accumulation of all of my years working in the industry, learning, and teaching. There is so much information out there, so many opinions, and so many ways of doing things, that unless you have spent the last few years working with these technologies in a company, you will never fully understand. So this course is the answer to that exact problem for you: How to gain experience when you need experience to get hired? I have gone through thousands of coding books, online tutorials and bootcamps. Throughout the years I have taken notes on what has worked and what hasn''t, and I have created this course to narrow down the most efficient way to learn with the most relevant information. ',1999000,'5/19/2023','5/19/2023',4,4,'Learn to code and become a Web Developer in 2023 with HTML, CSS, Javascript, React, Node.js, Machine Learning & more!','admin','admin','usercss/images/CourseImage/Web3.PNG',87),
('Build Responsive Real-World Websites with HTML and CSS', '"Having gone through other related courses on other platforms, I can say this course is the most practical and readily applicable course on web design and development I have taken." — Bernie Pacis



Open a new browser tab, type in www.omnifood.dev, and take a look around. I will wait here...

...

Amazing, right? What if you knew exactly how to design and build a website like that, completely from scratch? How amazing would that be?

Well, I''m here to teach you HTML, CSS, and web design, all by building the stunning website that you just saw, step-by-step.

So, after finishing this course, you will know exactly how to build a beautiful, professional, and ready-to-launch website just like Omnifood, by following a 7-step process. And it will even look great on any computer, tablet, and smartphone.

But what if you want to build a completely different website? Well, no problem! I designed the course curriculum with exactly this goal: to enable you to design and build any website that you can think of, not just copy the course project.



So, in order to become a confident and independent developer, capable of building your own websites in the future, you will learn:

The fundamentals of modern and semantic HTML, CSS, and building layouts in a small separate project, which will prepare you for the main course project (www.omnifood.dev). This includes modern flexbox and CSS Grid!

How to design beautiful websites, by learning a web design framework I created just for this course. It consists of easy-to-use guidelines for design aspects like typography, colors, images, spacing, and more (this is like a small standalone course!).

How to use well-established website components and layout patterns in order to come up with professional-looking designs

How to make any website work on any mobile device, no matter the design and layout (responsive design)

How to use the 7 steps of building a professional website in practice: planning, sketching, designing, building, testing, optimizing, and launching

How to find and use free design assets such as images, fonts, and icons

Important developer skills such as reading documentation, fixing code errors on your own, and using professional web development tools

Does this sound like fun? Then join me and 200,000+ other developers and start building websites today!

Or are you not sold yet and need to know more? No problem, just keep reading...



[01] Why should you learn HTML and CSS in the first place?

Building websites allows you to do fun and creative work, from anywhere in the world, and it even pays well. Web development is one of the most future-proof and highest-paying industries in the world. And HTML and CSS is the entry point to this world!

But you already know all this, that''s why you want to learn HTML and CSS too. Well, you came to the right place!

This is the best and most complete course for starting your web development journey that you will find on Udemy. It''s an all-in-one package that takes you from knowing nothing about HTML and CSS, to building beautiful websites using tools and technologies that professional web developers use every single day.



[02] Why is this course so unique and popular?

Reason #1: The course is completely project-based

Simple demos are boring, and therefore you''re gonna learn everything by building actual projects! In the final project (www.omnifood.dev), together we hand-code a beautiful and responsive landing page for a fictional company that I made up just for the course.



Reason #2: You will not just learn how to code

Coding is great, but it''s not everything! That''s why we will go through the entire 7-step process of building and launching our website project.

So the huge Omnifood project will teach you real-world skills to build real-world HTML and CSS websites: how to plan projects and page layouts, how to implement designs using HTML and CSS techniques, how to write clean and organized code, how to optimize websites for good speed performance, and many more.

On top of that, this course has a huge focus on beautiful design. In fact, this is the only course on the market that focuses on both coding and designing, together.



Reason #3: I''m the right teacher for you

With the right guidance and a well-structured curriculum, building websites can be quite easy and fun to learn. With a bunch of random tutorials and YouTube videos? Not so much. And that''s where I come in.

My name is Jonas, I''m an experienced web developer and designer, and one of top instructors. I have been teaching this bestselling course since 2015 to over 200,000 developers, always listening to feedback and understanding exactly how students actually learn.

Using that feedback, I recently rebuilt this course from scratch and designed the ideal course curriculum for every type of student. It''s a unique blend of projects, deep explanations, theory lectures, and challenges. I''m sure you''re gonna love it!



[03] Why is this course so long?

Reason #1: I take time to explain every single concept that I teach, so that you actually learn, and not just copy code from the screen (this is a course, not a tutorial)

Reason #2: I go into topics that other HTML and CSS courses shy away from: professional web design, component and layout patterns, some CSS theory, website planning in theory and practice, and developer skills. I believe you need all of this to be successful!

Reason #3: There is a lot of repetition, so that you actually assimilate and practice what you learn. Practice is the single most important ingredient to learning, and therefore I provide plenty of opportunities for you to sharpen your skills



[04] Here is what''s also included in the package:

Up-to-date HD-quality videos, that are easy to search and reference (great for Business students)

Professional English captions (not the auto-generated ones)

Downloadable design assets + starter code and final code for each section

Downloadable slides for 20+ theory videos (not boring, I promise!)

Access to countless free design and development resources that I curated over many years

Free support in the course Q&A

10+ coding challenges to practice your new skills (solutions included)



[05] This course is for you if...

... you are a complete beginner with no idea of how to build a website.

... you already know a bit of HTML and CSS from some tutorials or videos, but struggle to put together a good-looking, complete website.

... you are a designer and want to expand your skills into HTML and CSS, because all your designer friends are learning how to code (they are smart!).

Basically, if you are an HTML and CSS master, and build the most beautiful websites in the world, then DON''T take the course. Everyone else: you should take the course, today.



So, does all of this sound great? Then join me and 200,000+ other developers and start your web development journey today!',1999000,'5/19/2023','5/19/2023',4,5,'Learn modern HTML5, CSS3 and web design by building a stunning website for your portfolio! Includes flexbox and CSS Grid','admin','admin','usercss/images/CourseImage/Web4.PNG',88),
('Ultimate Web Designer & Web Developer Course', 'Welcome to the Ultimate Web Designer & Web Developer Course! Are you ready to become a full-stack web designer in 2023? If so, you''re in the right place.

Our comprehensive course is taught by Brad Hussey, a Partner and experienced web designer with more than 500,000 students worldwide and over 10 years of experience as a professional web designer. From the basics of web design to front-end development skills, this A to Z course covers everything you need to know to succeed in the world of web design and development. It focuses on what you need to learn and avoids unnecessary details. With over 80,000 happy students, this course is trusted by beginners and experts alike.

In this course, you''ll learn how to use Adobe Photoshop, sketch professional wireframes, and code with HTML, CSS, JavaScript, and jQuery. You''ll also learn about responsive design using frameworks like Bootstrap and Tailwind CSS (coming soon). In addition to building your own project, you''ll work on over 23 designs, websites, and applications throughout the course.

What are some of the projects you will build?

In addition to working on your very own self-directed project that challenges you to use your new skills as you learn, you''ll be building over 23 custom projects throughout the course:

In Photoshop:

Design a custom web graphic

Design a custom business card

Design a modern landing page

Re-design a blog

In HTML5 & CSS3:

Multiple custom websites & web pages

Code the Google landing page

"Orbiting planets" animation in CSS3

A responsive "Startup Style" website

In Javascript & jQuery

A working "Tip Calculator"

An actual race car game

A "To-Do List" web application

In PHP & MySQL

Dynamic websites

An impressive application that fixes clickbait headlines

Working "login" and "logout" sequence

A profile page that pulls information from a database

Robust "Client Address Book" application that manages your clients'' information

Custom WordPress plugin

In AngularJS

Real Estate Listing Single-Page Application

In WordPress Plugins

Custom, real-world "survey" plugin

...and much more

Once you''ve mastered the front-end, we''ll delve into advanced skills like PHP, MySQL, WordPress, and custom WordPress plugin development. By the end of the course, you''ll have the skills and knowledge to start your own successful web design career, whether you want to work as a freelancer or at a design agency.

But it doesn''t end there! Our course also includes a career section that provides valuable tips, resources, and real-world guidance to help you succeed in your new career. With step-by-step instruction from one of the most experienced and passionate web design educators around, you''ll be well on your way to becoming a successful web designer.

So don''t wait any longer. Join our course today and start your journey to becoming a full-stack web designer in 2023!

See you on the inside!', 1999000,'5/19/2023','5/19/2023',4,2,'Become a Full-Stack Web Designer in 2023 - Learn Everything from Web Design Fundamentals to Front-End Web Development','admin','admin','usercss/images/CourseImage/Web5.PNG',88),
('Apple Mac Basics - The Complete Course for beginners', 'The Apple Mac OS for beginners course is designed with Apple Mac OS beginners in mind. The Apple Mac OS course is designed to take you from beginner to advanced so that you will be able to get the most out of your Apple Mac. This course can use this course as an Introduction to Mac OS for anyone who is new to Apple Mac. The tutorials can be used as a refresher course to get you back up to speed on Mac OS. This Apple Mac Basics Course is also great for anyone coming from Windows and are new to Mac OS and want

The course focuses on the main areas of Mac OS:

Desktop - The course looks at the main features of the Apple Mac OS desktop,

Systems Preferences - We will look at the most important parts of the Apple Mac OS system preferences and how to use them. This will allow you to be able to customise your MacBook to suit your needs,

Installing Programs - By the end of the course you will be able to install and remove programs on your Apple Mac.

Using and getting the most out of your MacBook or iMac.

We will look at time Machine. You will know how to make a correct and full back up of your Apple MacBook or iMac.

We will look at the features of iCloud and how you can use iCloud across your MacBook, iMac, iPhone and iPad.

The course looks at the most common used programs that are provided for free with your Apple Mac.

Apple Mac OS dictation is one the most impressive features of Mac OS. We will look at how to set it up and use it Properly.

All these features are included along with some great hints and tips to make you into a Mac super user. The Course will be updated as Apple update the Mac OS.', 1699000,'5/19/2023','5/19/2023',5,2,'The beginner guide to Apple Mac OS. Get the most out of your New Apple Mac.','admin','admin','usercss/images/CourseImage/OS1.PNG',85),
('The Complete Ubuntu Linux Server Administration Course !', '     Welcome to " The Complete Ubuntu Linux Server Administration Course " 

Master the Latest & Fastest Growing Ubuntu Linux Server and Become Master System Administrator.



What Students Say About the Course:- 

        Your Linux course changed my life, I got a job that I always wanted, I genuinely would like to thank you. Also, I am able to earn more than I need because of your brilliant course. Wish you good luck, do you have a Patreon account so that I can donate your dream project a little bit of money. ->  Suma Chandrashekar

      Great course, I have done all my lab with Debian 11.

              i am happy   -> Agboke Thibaut Adinon J.

       Thank you for the great content. Definitely the best and you know the stuff. I will happily recommend this course at every level.   -> MOMODOUN.

         

       

                Linux is an Operating system that was developed in the early 1990s by Linus Torvald at the University of Helsinki in Finland. Then it was further joined & modified by a group of thousands of computer geeks from all around the world. Currently, there are lots of Linux Distributions are available in the market like Redhat, Centos, Debian, etc. But now Ubuntu server is becoming more popular in these days because it is easy to use & free. Following are the main sections of the course which contain different tutorials in detail. 

   Ubuntu Server is generally used in many hosting companies for providing web hosting services. This operating system is the best operating system to learn server administration Because it''s easy to use and practice.

This course consists of 13 different sections and over 9.5 hours of HD videos in time Length.

                                              MAIN SECTIONS OF THE COURSE: -



Introduction.



Basics of Linux commands & File Structure.



File Management.



Process Management.

 

User & Group Management.



Disk Management.



Network Management.

. 

Setting up your own Web Server.



Setting up your own Mail Server.



Setting up your own DNS server.



Securing your Server.



Miscellaneous useful Stuff. ',1399000,'5/19/2023','5/19/2023',5,1,'Master the Ubuntu Linux Server from scratch from Beginners to Expert On Windows / Mac os / Linux !','admin','admin','usercss/images/CourseImage/OS2.PNG',86),
('Unleashing the Mac OS X Terminal for Absolute Beginners', 'Overview

This is a comprehensive course designed to show how to use the Terminal app in Mac OS X and many Bash shell commands, many overlap with Linux or other *nix variants.


The course currently covers the following:

Setup and installation of tools used in this course (outside the Terminal app)
How to navigate while in the Terminal (file and directory oriented)
How to manage files and directories (create, edit, delete, etc)
Temporarily elevating to admin rights when needed
Changing permissions on files and folders
Writing simple Bash scripts
Each one of these concepts is demonstrated in a methodological, step-by-step manner so you can follow along for easy learning.

Course Outline

Introduction provides an overview for the course.

Installation provides step-by-step instructions on how to setup Terminal and all the related tools for the course.

The Basics provides the first look at several core or foundational commands. While learn how to get around, manage files and even some simple ways to use the output of commands.

After the basics are covered, we dive into permissions related concepts by assuming admin user while we change permissions on files and folders.

Finally, we cover some more Advanced topics like writing a Bash shell script and customizing the Bash environment.

Course Features

Presentations provide audio/video training of conceptual ideas in each major area or introduction of new concepts.

Screencasts provide a video of the instructor''s computer system with any actions, commands, or screens displayed and narrated. There are several hours of screencat video content -- it makes up the vast majority of the course. Any command line based screencast will include a command listing in the lecture downloads.

At the end of each section is a document lecture with a listing of commands or a brief tutorial regarding the video content covered during that section.', 429000,'5/19/2023','5/19/2023',5,4,'A comprehensive, step-by-step guide to the Mac terminal and Bash environment specifically designed for novice Mac users','admin','admin','usercss/images/CourseImage/OS3.PNG',54),
('Apple Mac OS X Lion Server Tutorial - A Definitive Guide', 'A Verifiable Certificate of Completion is presented to all students who undertake this course.
This Apple OS X Lion Server training course will teach you how to install, configure and monitor OS X Lion Server. Whether you are setting it up for a school, home network or business, you will learn the ins and outs of using Lion Server to its fullest capabilities.

The video tutorial starts with the installation basic and advanced setup of your server. You will learn how to setup and configure a DNS server and DHCP service. You will learn about managing users and groups, using Profile Manager, client preferences, and configuring services. Chris also shows you how to manage your server using Server App throughout. As you dig deeper into Lion Server, you will learn how to configure a Time Machine service, setup file sharing using AFP, SMB, FTP and more. You will setup a Mail server, web hosting, Wiki server, Addressbook server, iCal server, iChat server and more!

By the conclusion of this computer based training tutorial for Apple OSX Lion Server, you will have learned everything you need to know to setup and manage an OSX Lion Server of your own! Working files are included with this training video course.

What You Will Learn 

- How to install and administer OS X Lion Server in a commercial environment.

- How to set up services and securely manage Mac services and users.

- How to set up Web Hosting, Wiki Server, iCal Server, File Sharing and a whole host of other important aspects of Mac Server . 

Who Should Take This Course

- Anyone who needs to share Mac services on a network of any size.

- Anyone who needs an understanding of using Mac Server in a commercial environment.

- Anyone who needs to share files and services Mac to Mac or Mac to PC .',429000,'5/19/2023','5/19/2023',5,3,'Learn how to unleash the power of OS X Lion Server','admin','admin','usercss/images/CourseImage/OS4.PNG',47),
('Master macOS Ventura - The Complete Course in 2023', 'Works smarter. Plays harder. Goes further. Thats the new motto of macOS Ventura and that''s exactly what we will follow in this course. You will learn how to work smarter and faster in such a fun and interactive way. You will discover powerful new ways of using macOS Ventura in completely redesigned and modern looking videos. 

MacOS is GREAT ... If You can use the whole potential of it!

I''m using Mac computer everyday for more than 10 years and still learning new techniques and shortcuts how to optimise my workflow and I want to share it all with you. When I bought my first MacBook after using Windows for many many years, it took me many hours to learn even basic functionalities in macOS and months before I became entirely comfortable with my Mac.

This course will take you from a beginner / intermediate to an advanced macOS user in no time!

Is this your first course from AppleOnlineAcademy, or you have already jumped on board with the previous macOS Monterey. Either way I''m sure you will learn something new. I have put together brand new course which includes almost double that much content than the previous one. You will find here over 100 video tutorials covering more than 10 hours of video instructions.

I don''t want to see you wasting so much time on such a powerful operating system. Join the AppleOnlineAcademy and be part of the community of more than 6000 students on Udemy. Yes I have already helped so many people become more comfortable and efficient in macOS

But I have even better news for you!

Head to the official AppleOnlineAcademy website and get this course for a SPECIAL PRICE!

Explore a redesigned and modern videos. With improved sound quality and graphics to help you better understand. Each tutorial clearly presents a topic and shows you how to use it in macOS. You can watch while trying out techniques for yourself. Presented by the appleonlineacademy website dedicated to helping people to understand and use Apple devices to their full potential.



What makes this course different?

It has unique style which makes video tutorials easy to follow

Always straight to the point and not wasting time by talking around

The course is supported by downloadable materials and other useful recourses

I offer full personalised support in Q&A section and also in closed facebook group for enrolled students

The most complex course in macOS Category on Udemy covering 150 different topics.', 1049000,'5/19/2023','5/19/2023',5,3,'Work smarter and find new ways to get more done on your Mac with this Complete and up-to-date course.','admin','admin','usercss/images/CourseImage/OS5.PNG',81)
GO



INSERT INTO [dbo].[Account_Admin] ([account_name] ,[account_username] ,[account_password] ,[account_role] ,[account_email] ,[account_phone] ,[account_avatar])
     VALUES
           (N'Quân',N'quan','123','0',N'quandc@gmail.com','0123456789','img/user.jpg'),
		   (N'Minh',N'minh','123','1',N'minhtqhe16001@fpt.edu.vn','0123456789','img/user.jpg'),
		   (N'admin',N'admin','123','0',N'admin@fpt.edu.vn','0123456789','img/user.jpg'),
		   (N'Minh',N'minh','123','1',N'minhtqhe16001@fpt.edu.vn','0123456789','img/user.jpg'),
		   (N'test',N'test','123','1',N'test@fpt.edu.vn','0123456789','img/user.jpg')
GO




INSERT INTO [dbo].[Account_Customer] ([customer_name],[customer_username],[customer_password],[customer_email],[customer_address],[customer_phone],[customer_dob],[customer_avatar], [customer_status])
VALUES 
('Cristiano Muirenn', 'Cristiano', '123','Cristiano62531@gmail.com', '3809 Wetzel Lane', '+44 7271 564966','4/5/1984', 'usercss/images/AvatarCustomer/avatar01.jpg', '0')

INSERT INTO [dbo].[Account_Customer] ([customer_name],[customer_username],[customer_password],[customer_email],[customer_address],[customer_phone],[customer_dob],[customer_avatar], [customer_status])
VALUES 
('Myrtle Tove', 'Myrtle', '123','Myrtle45245@gmail.com', '3502 Coal Road', '+44 7457 077508','3/9/1999', 'usercss/images/AvatarCustomer/avatar02.jpg', '0')
INSERT INTO [dbo].[Account_Customer] ([customer_name],[customer_username],[customer_password],[customer_email],[customer_address],[customer_phone],[customer_dob],[customer_avatar], [customer_status])
VALUES 
('Theodotos Abeni', 'Theodotos', '123','Theodotos85478@gmail.com', '662 Harvest Lane', '+44 7451 091983','8/28/1978', 'usercss/images/AvatarCustomer/avatar03.jpg', '0')
INSERT INTO [dbo].[Account_Customer] ([customer_name],[customer_username],[customer_password],[customer_email],[customer_address],[customer_phone],[customer_dob],[customer_avatar], [customer_status])
VALUES 
('Annie Gerardo', 'Annie', '123','Annie27346@gmail.com', '3799 Illinois Avenue', '+44 7911 035752','9/29/1978', 'usercss/images/AvatarCustomer/avatar04.jpg', '0')
INSERT INTO [dbo].[Account_Customer] ([customer_name],[customer_username],[customer_password],[customer_email],[customer_address],[customer_phone],[customer_dob],[customer_avatar], [customer_status])
VALUES 
('Youri Wernher', 'Youri', '123','Youri34212@gmail.com', '357 Stewart Street', '+44 7213 109283','3/12/1944', 'usercss/images/AvatarCustomer/avatar05.jpg', '0')
INSERT INTO [dbo].[Account_Customer] ([customer_name],[customer_username],[customer_password],[customer_email],[customer_address],[customer_phone],[customer_dob],[customer_avatar], [customer_status])
VALUES 
('Aiolos Karolina', 'Aiolos', '123','Aiolos38212@gmail.com', '4726 Washington Street', '+44 7911 876647','11/17/1964', 'usercss/images/AvatarCustomer/avatar06.jpg', '0')
INSERT INTO [dbo].[Account_Customer] ([customer_name],[customer_username],[customer_password],[customer_email],[customer_address],[customer_phone],[customer_dob],[customer_avatar], [customer_status])
VALUES 
('Alhaji Zosime', 'Alhaji', '123','Alhaji84561@gmail.com', '4301 Quincy Street', '+44 7459 517359','8/20/1987', 'usercss/images/AvatarCustomer/avatar07.jpg', '0')
INSERT INTO [dbo].[Account_Customer] ([customer_name],[customer_username],[customer_password],[customer_email],[customer_address],[customer_phone],[customer_dob],[customer_avatar], [customer_status])
VALUES 
('Nowell Elise', 'Nowell', '123','Nowell88574@gmail.com', '1592 Glenwood Avenue', '+44 7700 041099','5/23/1993', 'usercss/images/AvatarCustomer/avatar08.jpg', '0')
INSERT INTO [dbo].[Account_Customer] ([customer_name],[customer_username],[customer_password],[customer_email],[customer_address],[customer_phone],[customer_dob],[customer_avatar], [customer_status])
VALUES 
('Hanna Kresten', 'Hanna', '123','Hanna75521@gmail.com', '3358 Davis Court', '+44 7700 106226','10/5/1961', 'usercss/images/AvatarCustomer/avatar09.jpg', '0')
INSERT INTO [dbo].[Account_Customer] ([customer_name],[customer_username],[customer_password],[customer_email],[customer_address],[customer_phone],[customer_dob],[customer_avatar], [customer_status])
VALUES 
('Victoria Prakash', 'Victoria', '123','Victoria86575@gmail.com', '540 West Street', '+44 7700 027794','7/28/1990', 'usercss/images/AvatarCustomer/avatar10.jpg', '0')
INSERT INTO [dbo].[Account_Customer] ([customer_name],[customer_username],[customer_password],[customer_email],[customer_address],[customer_phone],[customer_dob],[customer_avatar], [customer_status])
VALUES 
('Damjana Kepa', 'Damjana', '123','Damjana51557@gmail.com', '4879 Whaley Lane', '+44 7393 422598','11/29/1986', 'usercss/images/AvatarCustomer/avatar11.jpg', '0')
INSERT INTO [dbo].[Account_Customer] ([customer_name],[customer_username],[customer_password],[customer_email],[customer_address],[customer_phone],[customer_dob],[customer_avatar], [customer_status])
VALUES 
('Nisha Iina', 'Nisha', '123','Nisha86572@gmail.com', '4718 Brookview Drive', '+44 7700 050723','1/2/1991', 'usercss/images/AvatarCustomer/avatar12.jpg', '0')
INSERT INTO [dbo].[Account_Customer] ([customer_name],[customer_username],[customer_password],[customer_email],[customer_address],[customer_phone],[customer_dob],[customer_avatar], [customer_status])
VALUES 
('Akosua Henry', 'Akosua', '123','Akosua98867@gmail.com', '1761 Mesa Drive', '+44 7700 017654','1/17/1993', 'usercss/images/AvatarCustomer/avatar13.jpg', '0')
INSERT INTO [dbo].[Account_Customer] ([customer_name],[customer_username],[customer_password],[customer_email],[customer_address],[customer_phone],[customer_dob],[customer_avatar], [customer_status])
VALUES 
('Anja Dajana', 'Anja', '123','Anja87551@gmail.com', '3385 Pinnickinnick Street', '+44 7911 205900','9/20/1944', 'usercss/images/AvatarCustomer/avatar14.jpg', '0')
INSERT INTO [dbo].[Account_Customer] ([customer_name],[customer_username],[customer_password],[customer_email],[customer_address],[customer_phone],[customer_dob],[customer_avatar], [customer_status])
VALUES 
('Sujay Amable', 'Sujay', '123','Sujay62838@gmail.com', '2730 Green Acres Road', '+44 7700 068949','5/29/2010', 'usercss/images/AvatarCustomer/avatar15.jpg', '0')
INSERT INTO [dbo].[Account_Customer] ([customer_name],[customer_username],[customer_password],[customer_email],[customer_address],[customer_phone],[customer_dob],[customer_avatar], [customer_status])
VALUES 
('Tsubame Ozzie', 'Tsubame', '123','Tsubame56348@gmail.com', '1510 Calico Drive', '+44 7911 855223','9/5/1996', 'usercss/images/AvatarCustomer/avatar16.jpg', '0')
INSERT INTO [dbo].[Account_Customer] ([customer_name],[customer_username],[customer_password],[customer_email],[customer_address],[customer_phone],[customer_dob],[customer_avatar], [customer_status])
VALUES 
('Henrikki Mariska', 'Henrikki', '123','Henrikki96632@gmail.com', '3512 Rainy Day Drive', '+44 7459 610502','3/29/1965', 'usercss/images/AvatarCustomer/avatar17.jpg', '0')
INSERT INTO [dbo].[Account_Customer] ([customer_name],[customer_username],[customer_password],[customer_email],[customer_address],[customer_phone],[customer_dob],[customer_avatar], [customer_status])
VALUES 
('Gib Siqiniq', 'Gib', '123','Gib23658@gmail.com', '1311 Hood Avenue', '+44 7457 727603','6/20/1960', 'usercss/images/AvatarCustomer/avatar18.jpg', '0')
INSERT INTO [dbo].[Account_Customer] ([customer_name],[customer_username],[customer_password],[customer_email],[customer_address],[customer_phone],[customer_dob],[customer_avatar], [customer_status])
VALUES 
('Alastar Paula', 'Alastar', '123','Alastar65844@gmail.com', '3186 Oak Drive', '+44 7360 624448','5/8/1992', 'usercss/images/AvatarCustomer/avatar19.jpg', '0')
INSERT INTO [dbo].[Account_Customer] ([customer_name],[customer_username],[customer_password],[customer_email],[customer_address],[customer_phone],[customer_dob],[customer_avatar], [customer_status])
VALUES 
('Klaudia Takondwa', 'Klaudia', '123','Klaudia62531@gmail.com', '2657 Dale Avenue', '+44 7457 910286','12/26/1975', 'usercss/images/AvatarCustomer/avatar20.jpg', '0')

INSERT INTO [dbo].[Account_Customer] ([customer_name],[customer_username],[customer_password],[customer_email],[customer_address],[customer_phone],[customer_dob],[customer_avatar], [customer_status])
VALUES 
('Anath Admetos', 'Anath', '123','Anath77785@gmail.com', '4557 State Street', '+44 7457 833431','7/1/1961', 'usercss/images/AvatarCustomer/avatar21.jpg', '0')
GO


INSERT INTO Comments (customer_id, course_id, comment_text, comment_date, comment_modified)
VALUES
    (1, 11, 'This course is amazing!', '2023-05-01', '2023-05-02'),
    (2, 13, 'I learned so much from this course.', '2023-05-03', '2023-05-04'),
    (3, 2, 'Highly recommended!', '2023-05-05', '2023-05-06'),
    (4, 14, 'Great course content!', '2023-05-07', '2023-05-08'),
    (2, 2, 'The instructor is very knowledgeable.', '2023-05-09', '2023-05-10'),
    (3, 3, 'I wish I had taken this course earlier.', '2023-05-11', '2023-05-12'),
    (1, 4, 'The exercises were challenging but rewarding.', '2023-05-13', '2023-05-14'),
    (5, 2, 'Highly informative and well-structured.', '2023-05-15', '2023-05-16'),
    (6, 17, 'I''m impressed with the course material.', '2023-05-17', '2023-05-18'),
    (4, 3, 'This course exceeded my expectations.', '2023-05-19', '2023-05-20'),
    (2, 4, 'I would recommend this course to anyone.', '2023-05-21', '2023-05-22'),
    (1, 25, 'The instructor explained complex topics very well.', '2023-05-23', '2023-05-24'),
    (3, 1, 'I''m glad I enrolled in this course.', '2023-05-25', '2023-05-26'),
	(10, 10, 'I found this course very helpful.', '2023-05-27', '2023-05-28'),
    (11, 1, 'The course materials are comprehensive.', '2023-05-29', '2023-05-30'),
    (12, 12, 'I''m impressed with the instructor''s teaching style.', '2023-06-01', '2023-06-02'),
    (13, 13, 'This course exceeded my expectations.', '2023-06-03', '2023-06-04'),
    (14, 4, 'I would highly recommend this course.', '2023-06-05', '2023-06-06'),
    (15, 15, 'The course content is very informative.', '2023-06-07', '2023-06-08'),
    (16, 16, 'I learned a lot from this course.', '2023-06-09', '2023-06-10'),
    (17, 7, 'The instructor is knowledgeable and engaging.', '2023-06-11', '2023-06-12'),
    (18, 18, 'This course helped me improve my skills.', '2023-06-13', '2023-06-14'),
    (19, 9, 'I''m satisfied with the course content and materials.', '2023-06-15', '2023-06-16')
GO


INSERT INTO [dbo].[Orders] ([customer_id],[order_date],[order_total_price],[payment_id])
     VALUES
           ('1','2023-07-01','480740',1),
		   ('2','2023-07-01','419700',0),
		   ('3','2023-07-01','470710',1)
GO

INSERT INTO [dbo].[OrderDetail] ([id],[course_price],[course_id])
     VALUES
           ('1','246870','1'),
		   ('1','233870','2'),
		   ('2','195860','3'),
		   ('2','223840','4'),
		   ('3','223840','5'),
		   ('3','246870','1')
GO

/*
INSERT INTO payment_method (payment_name)
VALUES
    (N'Thẻ ngân hàng'),
    (N'Ví điện tử MoMo'),
    (N'Ví điện tử ZaloPay'),
    (N'Ví điện tử AirPay'),
    (N'Ví điện tử Moca'),
    (N'Ví điện tử Ví MoMo'),
    (N'NgânLượng.vn'),
    (N'Bảo Kim'),
    (N'Payoo'),
    (N'VNPay'),
    (N'Ví điện tử ZotaPay'),
    (N'Ví điện tử VTC Pay'),
    (N'Ví điện tử OnCash'),
    (N'Ví điện tử Momo Wallet'),
    (N'Ví điện tử ZaloPay Wallet'),
    (N'Ví điện tử ViettelPay'),
    (N'Ví điện tử VinaPay'),
    (N'Ví điện tử PayME'),
    (N'Ví điện tử Bankplus'),
    (N'Ví điện tử SenPay')
GO






INSERT INTO [dbo].[Order_Status] ([order_status_name])
     VALUES
           ('Approved'),
		   ('Pending'),
		   ('Rejected')
GO



INSERT INTO [dbo].[Orders] ([customer_id] ,[payment_id] ,[order_date] ,[order_status_id] ,[order_total_price])
     VALUES
           ('1','2' ,'2023-05-25','1',3698000),
		   ('2','2','2023-05-25','2',3298000),
		   ('3','3','2023-05-25','3',3198000)
GO


INSERT INTO [dbo].[OrderDetail] ([order_id] ,[course_id])
     VALUES
           ('1','1'),
		   ('1','2'),
		   ('2','1'),
		   ('2','3'),
		   ('3','2'),
		   ('3','3')
GO
*/