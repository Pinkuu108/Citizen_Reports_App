<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reports App</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">

<style>

    body {
        background: linear-gradient(135deg, #4facfe, #00f2fe);
        font-family: 'Segoe UI', Tahoma, sans-serif;
    }

    .container {
        background: white;
        padding: 30px;
        border-radius: 18px;
        box-shadow: 0 10px 35px rgba(0,0,0,0.18);
        margin-top: 25px;
    }

    h3 {
        text-align: center;
        font-weight: 700;
        color: #2c3e50;
        margin-bottom: 30px;
    }

    .form-section {
        background: linear-gradient(135deg, #f6f9ff, #eef3ff);
        padding: 20px;
        border-radius: 14px;
        box-shadow: 0 3px 10px rgba(0,0,0,0.05);
        margin-bottom: 20px;
    }

    .form-label {
        font-weight: 600;
        color: #34495e;
    }

    .form-control,
    .form-select {
        border-radius: 10px;
        border: 1px solid #dcdde1;
        transition: 0.2s;
    }

    .form-control:focus,
    .form-select:focus {
        border-color: #4facfe;
        box-shadow: 0 0 0 0.15rem rgba(79, 172, 254, 0.25);
    }

    .btn-primary {
        background: linear-gradient(45deg, #4facfe, #00c6ff);
        border: none;
        border-radius: 10px;
        padding: 7px 22px;
        font-weight: 600;
    }

    .btn-secondary {
        border-radius: 10px;
        font-weight: 600;
        padding: 7px 22px;
    }

    th, td {
        text-align: center;
        vertical-align: middle;
    }

    tbody tr:hover {
        transform: scale(1.01);
    }

    .no-records {
        color: red;
        font-weight: 600;
        font-size: 16px;
    }

    /* Export Links */
    .export-links {
        margin-top: 15px;
        text-align: right;
    }

    .export-links a {
        text-decoration: none;
        font-weight: 600;
        margin-left: 15px;
        color: #0d6efd;
    }

    .export-links a:hover {
        text-decoration: underline;
    }

</style>

</head>

<body>

<div class="container">

    <h3>Welcome To Reports Application</h3>

    <form:form action="search" modelAttribute="search" method="POST">

        <div class="form-section">

            <div class="row mb-3">

                <div class="col-md-3">
                    <label class="form-label">Plan Name</label>
                    <form:select path="planName" cssClass="form-select">
                        <form:option value="">-- Select --</form:option>
                        <form:options items="${names}"/>
                    </form:select>
                </div>

                <div class="col-md-3">
                    <label class="form-label">Gender</label>
                    <form:select path="gender" cssClass="form-select">
                        <form:option value="">-- Select --</form:option>
                        <form:option value="Male">Male</form:option>
                        <form:option value="Female">Female</form:option>
                    </form:select>
                </div>

                <div class="col-md-3">
                    <label class="form-label">Plan Status</label>
                    <form:select path="citizenStatus" cssClass="form-select">
                        <form:option value="">-- Select --</form:option>
                        <form:options items="${status}"/>
                    </form:select>
                </div>

            </div>

            <div class="row mb-3">

                <div class="col-md-3">
                    <label class="form-label">Start Date</label>
                    <form:input path="startDate" type="date" cssClass="form-control"/>
                </div>

                <div class="col-md-3">
                    <label class="form-label">End Date</label>
                    <form:input path="endDate" type="date" cssClass="form-control"/>
                </div>

            </div>

            <div>
                <input type="submit" value="Search" class="btn btn-primary"/>
                <a href="/" class="btn btn-secondary">Reset</a>
            </div>

        </div>

        <hr>

        <table class="table table-striped table-hover">

            <thead class="table-dark">
                <tr>
                    <th>Id</th>
                    <th>citizenName</th>
                    <th>Plan_Name</th>
                    <th>Status</th>
                    <th>Gender</th>
                    <th>Start_Date</th>
                    <th>End_Date</th>
                    <th>BenefitAmount</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach items="${plans}" var="plan" varStatus="index">
                    <tr class="
                        ${plan.citizenStatus == 'APPROVED' ? 'table-success' : ''}
                        ${plan.citizenStatus == 'DENIED' ? 'table-danger' : ''}
                        ${plan.citizenStatus == 'TERMINATED' ? 'table-warning' : ''}
                    ">
                        <td>${index.count}</td>
                        <td>${plan.citizenName}</td>
                        <td>${plan.planName}</td>
                        <td>${plan.citizenStatus}</td>
                        <td>${plan.gender}</td>
                        <td>${plan.startDate}</td>
                        <td>${plan.endDate}</td>
                        <td>${plan.benefitAmount}</td>
                    </tr>
                </c:forEach>

                <tr>
                    <c:if test="${empty plans}">
                        <td colspan="8" class="no-records">
                            No Record's Found
                        </td>
                    </c:if>
                </tr>
            </tbody>

        </table>

        <!-- ✅ EXPORT LINKS RESTORED -->
        <div class="export-links">
            Export:
            <a href="excel">Excel</a>
            <a href="pdf">PDF</a>
        </div>

    </form:form>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
