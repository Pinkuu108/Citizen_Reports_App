# 🚀 Citizen Reports App – Spring Boot Project ✨

Citizen Reports App is a Spring Boot MVC web application that provides dynamic search and reporting capabilities for citizen plan data.  
The application uses database-driven dropdown filters (no hardcoded values) to ensure flexibility and scalability. Users can perform multi-criteria searches, view results instantly, export reports to PDF & Excel, and share reports via email.

------------------------------------------------------------

📸 APPLICATION PREVIEW

### 🖥 Front Page
![Front Page](frontpage.jpeg)

### 🔎 Dynamic Search Result
![Dynamic Search](dynamic_search.png)

### 📧 Email Report Preview
![Mail Preview](mail.png)

------------------------------------------------------------

🌟 FEATURES

✨ Database-driven dropdown filters  
✨ Dynamic multi-criteria search  
✨ Instant result display  
✨ PDF report generation 📄  
✨ Excel report generation 📊  
✨ Email integration 📧  
✨ Clean layered architecture (MVC)

------------------------------------------------------------

🛠 TECH STACK

Backend  
🔹 Java  
🔹 Spring Boot  
🔹 Spring MVC  
🔹 Spring Data JPA  

Database  
🔹 MySQL  

Reporting  
🔹 Apache POI (Excel)  
🔹 OpenPDF (PDF)

View Layer  
🔹 JSP  
🔹 JSTL  

------------------------------------------------------------

📥 HOW TO CLONE & RUN THE PROJECT

1️⃣ Clone Repository

git clone <your_repo_url>

2️⃣ Open Project

Import into IntelliJ IDEA / Eclipse / Spring Tool Suite

3️⃣ Configure Database

Update src/main/resources/application.properties

Example:

spring.datasource.url=jdbc:mysql://localhost:3306/your_database  
spring.datasource.username=your_username  
spring.datasource.password=your_password  

4️⃣ Configure Mail (Required for Email Feature)

spring.mail.host=smtp.gmail.com  
spring.mail.port=587  
spring.mail.username=your_email@gmail.com  
spring.mail.password=your_app_password  

⚠ Use Gmail App Password (NOT normal password)

5️⃣ Run Application

Run the Spring Boot main class

6️⃣ Access in Browser

http://localhost:8080/

------------------------------------------------------------

📦 REQUIRED DEPENDENCIES

🔹 spring-boot-starter-web  
🔹 spring-boot-starter-data-jpa  
🔹 spring-boot-starter-mail  
🔹 mysql-connector-j  
🔹 poi-ooxml (Excel Export)  
🔹 openpdf (PDF Export)  
🔹 tomcat-embed-jasper (JSP Support)  
🔹 jakarta.servlet.jsp.jstl (JSTL Support)  
🔹 lombok (Optional)

------------------------------------------------------------

🎯 PROJECT PURPOSE

This project demonstrates:

🚀 Spring Boot MVC Architecture  
🚀 Database-driven UI design  
🚀 Dynamic search using JPA  
🚀 Report generation (PDF & Excel)  
🚀 Email sending with Spring Boot  
🚀 Clean enterprise application structure

------------------------------------------------------------

👨‍💻 AUTHOR

Pinku Prusty  
Java Developer ✨

🔗 LinkedIn: https://www.linkedin.com/in/pinkuna-prusty-55b487273/  
📧 Email: pinkunaprusty108@gmail.com
