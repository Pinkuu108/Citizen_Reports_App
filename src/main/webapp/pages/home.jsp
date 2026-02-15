<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
    <title>Reports App</title>

    <!-- Bootstrap Only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        /* ✅ Clearly Visible Background */
        body {
            background: #dbeafe;   /* Light blue (very visible) */
        }

        .container-box {
            background: white;
            padding: 25px;
            border-radius: 10px;
            margin-top: 30px;
            box-shadow: 0 6px 14px rgba(0, 0, 0, 0.15);
        }

        h3 {
            color: #1e3a8a;
            font-weight: 600;
        }

        .table thead {
            background-color: #1e3a8a;
            color: white;
        }
    </style>
</head>

<body>
<div class="container">

    <div class="container-box">

        <h3 class="mb-3">Reports Application</h3>

        <form:form action="search" modelAttribute="search" method="POST">

            <div class="row mb-3">

                <div class="col-md-3">
                    <label class="form-label">Plan Name</label>
                    <form:select path="planName" cssClass="form-select">
                        <form:option value="">-- Select --</form:option>
                        <form:options items="${names}"/>
                    </form:select>
                </div>

                <div class="col-md-3">
                    <label class="form-label">Plan Status</label>
                    <form:select path="citizenStatus" cssClass="form-select">
                        <form:option value="">-- Select --</form:option>
                        <form:options items="${status}"/>
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

            <input type="submit" value="Search" class="btn btn-primary"/>
            <a href="/" class="btn btn-secondary">Reset</a>

            <hr>

            <table class="table table-bordered table-striped">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Plan</th>
                        <th>Status</th>
                        <th>Gender</th>
                        <th>Start</th>
                        <th>End</th>
                        <th>Amount</th>
                    </tr>
                </thead>

                <tbody>

                    <c:forEach items="${plans}" var="p" varStatus="i">
                        <tr>
                            <td>${i.count}</td>
                            <td>${p.citizenName}</td>
                            <td>${p.planName}</td>
                            <td>${p.citizenStatus}</td>
                            <td>${p.gender}</td>
                            <td>${p.startDate}</td>
                            <td>${p.endDate}</td>
                            <td>${p.benefitAmount}</td>
                        </tr>
                    </c:forEach>

                    <c:if test="${empty plans}">
                        <tr>
                            <td colspan="8" class="text-center fw-bold text-danger">
                                No Records Found
                            </td>
                        </tr>
                    </c:if>

                </tbody>
            </table>

            <div class="text-end">
                Export:
                <a href="excel" class="btn btn-sm btn-success">Excel</a>
                <a href="pdf" class="btn btn-sm btn-danger">PDF</a>
            </div>

        </form:form>

    </div>
</div>
</body>
</html>
