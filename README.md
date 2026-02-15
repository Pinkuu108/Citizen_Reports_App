# 🚀 Citizen Reports App – Spring Boot Project ✨

Citizen Reports App is a Spring Boot MVC web application designed to demonstrate backend-driven data processing and reporting workflows.

The application loads dropdown filter values dynamically from the MySQL database, ensuring that no business data is hardcoded. Users can perform multi-criteria searches, and results are fetched in real time using Spring Data JPA.

The system supports exporting filtered records into Excel (via Apache POI) and PDF (via OpenPDF). Generated reports are streamed to the browser for download and can also be sent as email attachments using Spring Boot Mail.

This project primarily highlights backend concepts including database interaction, dynamic query construction, report generation, and email integration, while using a minimal frontend only for user interaction.

🚀 Features  
🔹 Database-driven dropdown filters (no hardcoded values)  
🔹 Multi-criteria dynamic search using Spring Data JPA  
🔹 Instant result rendering  
🔹 Excel Export 📊 (Apache POI)  
🔹 PDF Export 📄 (OpenPDF)  
🔹 Email Reports 📧 (Spring Boot Mail)  
🔹 Clean Layered MVC Architecture  

🖥️ Tech Stack  

Backend  
🚀 Spring Boot ⚙️ Spring MVC 🗄️ Spring Data JPA ☕ Java  

Database  
🛢️ MySQL  

Reporting & Utilities  
📊 Apache POI 📄 OpenPDF 📧 Spring Boot Mail  

View Layer  
🖥️ JSP 🎯 JSTL 🎨 Bootstrap  

📂 Project Structure  

Reports_App/  
│  
├── controller/  
├── service/  
├── repository/  
├── entity/  
├── search/  
├── util/  
└── runner/  

⚙️ Application Workflow  

Runner Class → Database Initialization → Dropdown Values from DB → User Search Filters → Dynamic Results → Excel / PDF Export → Email Delivery

📸 Application Preview  

🖥 Front Page  
![Front Page](frontpage.jpeg)

🔎 Dynamic Search Result  
![Dynamic Search](dynamic_search.png)

📧 Email Report Preview  
![Mail Preview](mail.png)

⚙️ Setup Instructions  

1️⃣ Clone Repository  

git clone <your_repo_url>

2️⃣ Open Project  

Import into IntelliJ IDEA / Eclipse / STS

3️⃣ Configure Database (application.properties)

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

Run Spring Boot main class

6️⃣ Access Application  

http://localhost:8080/

🎯 Key Learning Highlights  

🔹 Database-driven UI design  
🔹 Dynamic search with Spring Data JPA  
🔹 Excel & PDF report generation  
🔹 Email integration with attachments  
🔹 Clean enterprise project structure  

👨‍💻 Author  

Pinku Prusty ✨  
☕ Java Developer  

🔗 LinkedIn: https://www.linkedin.com/in/pinkuna-prusty-55b487273/  
📧 Email: pinkunaprusty108@gmail.com
