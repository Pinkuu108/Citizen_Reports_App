<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reports App</title>

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<body>

	<div class="container mt-4">

		<h3 class="mb-4">Welcome To Reports Application</h3>

		<!-- ✅ Spring Form START -->
		<form:form action="search" modelAttribute="search" method="POST">

			<div class="row mb-3">

				<!-- Plan Name -->
				<div class="col-md-3">
					<label class="form-label">Plan Name</label>
					<form:select path="planName" cssClass="form-select">
						<form:option value="">-- Select --</form:option>
						<form:options items="${names}"></form:options>
					</form:select>
				</div>

				<!-- Gender -->
				<div class="col-md-3">
					<label class="form-label">Gender</label>
					<form:select path="gender" cssClass="form-select">
						<form:option value="">-- Select --</form:option>
						<form:option value="Male">Male</form:option>
						<form:option value="Female">Female</form:option>
					</form:select>
				</div>

				<!-- Plan Status -->
				<div class="col-md-3">
					<label class="form-label">Plan Status</label>
					<form:select path="citizenStatus" cssClass="form-select">
						<form:option value="">-- Select --</form:option>
						<form:options items="${status}"></form:options>
					</form:select>
				</div>

			</div>

			<div class="row mb-3">

				<!-- Start Date -->
				<div class="col-md-3">
					<label class="form-label">Start Date</label>
					<form:input path="startDate" type="date" cssClass="form-control" />
				</div>

				<!-- End Date -->
				<div class="col-md-3">
					<label class="form-label">End Date</label>
					<form:input path="endDate" type="date" cssClass="form-control" />
				</div>

			</div>

			<!-- Button -->
			<div class="mb-3"  >
				<input type="submit" value="Search" class="btn btn-primary" /> <a
					href="/" class="btn btn-secondary">Reset</a>

			</div>
			<hr>


			<table class="table table-striped table-hover">

				<thead>
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
						<tr>
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
							<td colspan="8" style="text-align: center;">No Record's
								Found</td>
						</c:if>
					</tr>
				</tbody>
			</table>

			<hr>
       Expert:  <a href="">Excel</a>
			<a href="">pdf</a>

		</form:form>
		<!-- ✅ Spring Form END -->

	</div>

	<!-- Bootstrap JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
