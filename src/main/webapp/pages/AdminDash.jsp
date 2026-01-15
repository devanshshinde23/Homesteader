
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>HomeSteader Admin Dashboard</title>

<!-- Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

<style>
body {
	background-color: #f4f6f9;
	font-family: "Segoe UI", sans-serif;
}

/* Sidebar Style */
.sidebar {
	position: fixed;
	top: 0;
	left: 0;
	width: 260px;
	height: 100vh;
	background-color: #1e3a2a;
	padding-top: 80px;
	color: #fff;
	overflow-y: auto;
}

.sidebar a {
	display: block;
	padding: 12px 20px;
	font-size: 15px;
	color: #d1fae5;
	text-decoration: none;
}

.sidebar a:hover {
	background-color: #14532d;
	color: #fff;
}

.sidebar hr {
	border-color: #2f5f44;
}

/* Content Area */
.content {
	margin-left: 260px;
	padding: 20px;
}

.card {
	border-radius: 12px;
}

.navbar-brand {
	font-weight: bold;
	font-size: 22px;
}

.table thead {
	background-color: #2f5f44;
	color: white;
}

.mb-4 {
	padding: 50px;
}

<!--
Table css --> /* Dark overlay */ .overlay {
	background: rgba(0, 0, 0, 0.55);
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	z-index: -1;
}

.container-box {
	background: rgba(255, 255, 255, 0.20);
	padding: 25px;
	border-radius: 15px;
	backdrop-filter: blur(12px);
	box-shadow: 0 8px 20px rgba(0, 0, 0, 0.3);
}

.table {
	background-color: rgba(255, 255, 255, 0.85);
	border-radius: 8px;
	overflow: hidden;
}

.table th {
	background-color: #2f5f44;
	color: white;
	text-align: center;
}

.table-hover tbody tr:hover {
	background-color: #d9ecff;
	transform: scale(1.01);
	transition: 0.2s ease-in-out;
}

.btn-outline-primary:hover {
	background-color: #007bff;
	color: white;
}

.btn-outline-danger:hover {
	background-color: #dc3545;
	color: white;
}

.search-box {
	display: flex;
	gap: 10px;
	margin-bottom: 20px;
}
</style>
</head>

<body>

	<!-- NAVBAR -->
	<nav class="navbar navbar-dark bg-success fixed-top">


		<div class="container-fluid">
			<span class="navbar-brand"><i class="fa-solid fa-leaf"></i>
				Homesteader Admin Dashboard</span> <a href="FLogout"
				class="btn btn-light btn-sm">Logout</a>
		</div>

	</nav>

	<!-- SIDEBAR -->
	<div class="sidebar">

		<a href="#"><i class="fa-solid fa-chart-line me-2"></i> Dashboard</a>


		<a href="${pageContext.request.contextPath}/Viewfarmer"><i
			class="fa-solid fa-building me-2"></i> View Farmers </a> <a
			href="ViewAgroAgencies"><i class="fa-solid fa-building me-2"></i>
			View Agro Agencies</a>

		<hr>

		<a href="AddCrop"><i class="fa-solid fa-wheat-awn me-2"></i> Add Crops Info</a>
		 <a href="AddHerbs"><i class="fa-solid fa-leaf me-2"></i> Add Herbs 	Info</a> 
		 <a href="#"><i class="fa-solid fa-carrot me-2"></i> Add 	Vegetables Info</a> 
			<a href="AddSeeds"><i class="fa-solid fa-seedling me-2"></i>Add 	Seeds Info</a>
			 <a href="#"><i class="fa-solid fa-apple-whole me-2"></i>Add Fruits Info</a> 
			 <a href="#"><i class="fa-solid fa-flask me-2"></i>Add Fertilizers Info</a>
			  <a href="#"><i class="fa-solid fa-indian-rupee-sign me-2"></i> Update Market Prices</a>
		<a href="#"><i class="fa-solid fa-cloud-sun-rain me-2"></i> Add
			Climate Changes</a> <a href="#"><i
			class="fa-solid fa-mountain-sun me-2"></i> Add Soil Analysis</a> <a
			href="#"><i class="fa-solid fa-comments me-2"></i> Farmer
			Feedback</a>

		<hr>

		<a href="#"><i class="fa-solid fa-calendar-day me-2"></i> Daily
			Reports</a> <a href="#"><i class="fa-solid fa-calendar-week me-2"></i>
			Weekly Reports</a> <a href="#"><i
			class="fa-solid fa-calendar-days me-2"></i> Monthly Reports</a> <a
			href="#"><i class="fa-solid fa-file-excel me-2"></i> Download
			Excel Report</a>

	</div>

	<!-- MAIN CONTENT -->
	<div class="content mt-4">

		<h2 class="mb-4">DashBoard Overview</h2>

		<!-- TOP CARDS -->
		<div class="row">

			<div class="col-md-3">
				<div class="card shadow-sm p-3">
					<h6>Total Agro Agencies</h6>
					<h3>
						<i class="fa-solid fa-building me-2"></i> ${agencyCount}
				
					</h3>
				</div>
			</div>

			<div class="col-md-3">
				<div class="card shadow-sm p-3">
					<h6>New Farmer Feedback</h6>
					<h3>
						<i class="fa-solid fa-comments me-2"></i> 18
					</h3>
				</div>
			</div>

			<div class="col-md-3">
				<div class="card shadow-sm p-3">
					<h6>Pending Soil Reports</h6>
					<h3>
						<i class="fa-solid fa-mountain-sun me-2"></i> 7
					</h3>
				</div>
			</div>

			<div class="col-md-3">
				<div class="card shadow-sm p-3">
					<h6>Market Price Updates</h6>
					<h3>
						<i class="fa-solid fa-indian-rupee-sign me-2"></i> 5
					</h3>
				</div>
			</div>

		</div>

   		<div class="overlay">
		<c:if test="${showFarmers}">
			

				<div class="container mt-5">
					<div class="container-box">

						<h2 class="text-center text-black  mb-4">Farmer Registration
							Records</h2>
						<div class="d-flex mb-3">
					    <!-- Search by Village -->
					    <form action="SearchByVillage" method="get" class="d-flex me-3">
					        <input type="text" name="fregion" class="form-control me-2"
					               placeholder="Search By Village">
					        <button type="submit" class="btn btn-light">Search</button>
					    </form>
					
					    <!-- Search by Farmer Name -->
					    <form action="SearchByFarmerName" method="get" class="d-flex">
					        <input type="text" name="fname" class="form-control me-2"
					               placeholder="Search By Farmer Name">
					        <button type="submit" class="btn btn-light">Search</button>
					    </form>
					    </div>
						<table class="table table-bordered table-hover text-center">
							<thead>
								<tr>
									<th>ID</th>
									<th>Farmer Name</th>
									<th>Email</th>
									<th>Mobile</th>
									<th>Village</th>
									<th>Username</th>
									<th>Action</th>
								</tr>
							</thead>

							<tbody>
								<c:forEach items="${farmers}" var="e">
									<tr>
										<td><c:out value="${e.fid}" /></td>
										<td><c:out value="${e.fname}" /></td>
										<td><c:out value="${e.femail}" /></td>
										<td><c:out value="${e.fMobileNo}" /></td>
										<td><c:out value="${e.fregion}" /></td>
										<td><c:out value="${e.fusername}" /></td>

										<td><a href="FarmerDetails/${e.fid}"
											class="btn btn-outline-primary btn-sm">View</a> <a
											href="Deletedata/${e.fid}"
											class="btn btn-outline-danger btn-sm">Delete</a></td>
									</tr>
								</c:forEach>
							</tbody>

						</table>

					</div>
				</div>
			
		</c:if>

		<c:if test="${showAgency}">
			

				<div class="container mt-5">
					<div class="container-box">

						<h2 class="text-center text-black mb-4">Agro Agencies Records</h2>

						<div class="search-box">
							<input type="text" name="sdob" class="form-control" id="dob"
								placeholder="Search by Region">
							<button type="submit" class="btn btn-light">Find</button>
						</div>

						<table class="table table-bordered table-hover text-center">

							
							<thead>
								<tr>
									<th>Id</th>
									<th>Agency Name</th>
									<th>Owner Name</th>
									<th>Register No</th>
									<th>Agency Type</th>
									<th>MOB_NO</th>
									<th>Address</th>
									<th>UserName</th>
									<th>Status </th>
									<th>Action</th>
								</tr>

							</thead>

							<tbody>
								<c:forEach items="${agency}" var="e">
									<tr>
										<td><c:out value="${e.aid}" /></td>
										<td><c:out value="${e.name}" /></td>
										<td><c:out value="${e.ownerName}" /></td>
										<td><c:out value="${e.registerNo}" /></td>
										<td><c:out value="${e.type}" /></td>
										<td><c:out value="${e.mobileNo}" /></td>
										<td><c:out value="${e.address}" /></td>
										<td><c:out value="${e.username }"></c:out></td>
										<td><c:out value="${e.status }"></c:out></td>
										
										<td><a href="EditData/${e.aid}"
											class="btn btn-outline-primary btn-sm">Edit</a> <a
											href="Deletedata/${e.aid}"
											class="btn btn-outline-danger btn-sm">Delete</a></td>
									</tr>
								</c:forEach>
							</tbody>

						</table>
					</div>
				</div>

			
		</c:if>
		
</div>

</body>
</html>
