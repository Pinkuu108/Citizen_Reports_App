# 🚀 Citizen Reports App – Spring Boot Project ✨

Citizen Reports App is a Spring Boot MVC web application that provides dynamic search and reporting capabilities for citizen plan data.

This project is strongly focused on backend development and demonstrates real-world enterprise concepts such as database-driven UI components, dynamic search, report generation, and email integration.

------------------------------------------------------------

🚀 FEATURES

✅ Database-driven dropdown filters (no hardcoded values)  
✅ Multi-criteria dynamic search using Spring Data JPA  
✅ Instant result rendering  
✅ Excel export using Apache POI 📊  
✅ PDF export using OpenPDF 📄  
✅ Emailing generated reports as attachments 📧  
✅ Clean layered architecture (MVC)

------------------------------------------------------------

🏗️ APPLICATION WORKFLOW

Data Initialization (Runner Class)  
↓  
Data Stored in MySQL Database  
↓  
Dropdown Values Loaded Dynamically  
↓  
User-driven Search Filters  
↓  
Dynamic Result Processing  
↓  
Export to Excel / PDF  
↓  
Email Report Delivery

------------------------------------------------------------

🖥️ TECH STACK

Backend  
🔹 Java  
🔹 Spring Boot  
🔹 Spring MVC  
🔹 Spring Data JPA  

Database  
🔹 MySQL  

Reporting  
🔹 Apache POI (Excel Generation)  
🔹 OpenPDF (PDF Generation)

View Layer  
🔹 JSP  
🔹 JSTL  
🔹 Bootstrap

------------------------------------------------------------

📸 APPLICATION PREVIEW

### 🖥 Front Page
![Front Page](frontpage.jpeg)

### 🔎 Dynamic Search Result
![Dynamic Search](dynamic_search.png)

### 📧 Email Report Preview
![Mail Preview](mail.png)

------------------------------------------------------------

⚙️ HOW TO RUN THE PROJECT

1️⃣ Clone Repository

git clone <your_repo_url>

2️⃣ Open Project

Import into IntelliJ IDEA / Eclipse / Spring Tool Suite

3️⃣ Configure Database

Update **src/main/resources/application.properties**

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

6️⃣ Access Application

http://localhost:8080/

------------------------------------------------------------

📦 REQUIRED DEPENDENCIES

✔ spring-boot-starter-web  
✔ spring-boot-starter-data-jpa  
✔ spring-boot-starter-mail  
✔ mysql-connector-j  
✔ poi-ooxml (Excel Export)  
✔ openpdf (PDF Export)  
✔ tomcat-embed-jasper (JSP Support)  
✔ jakarta.servlet.jsp.jstl (JSTL Support)  
✔ lombok (Optional)

------------------------------------------------------------

🎯 PROJECT PURPOSE

This project demonstrates practical Spring Boot development concepts:

🚀 Spring Boot MVC Architecture  
🚀 Database-driven UI design  
🚀 Dynamic search using JPA  
🚀 Report generation (PDF & Excel)  
🚀 Email integration using Spring Boot  
🚀 Clean enterprise application structure

------------------------------------------------------------

👨‍💻 AUTHOR

Pinku Prusty  
Java Developer ✨

🔗 LinkedIn: https://www.linkedin.com/in/pinkuna-prusty-55b487273/  
📧 Email: pinkunaprusty108@gmail.com
