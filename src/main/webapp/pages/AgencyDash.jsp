<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Agro Agency Dashboard</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"/>

    <!-- Icons -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css"/>

    <style>

<!--
        body {
            background-color: #eef5f0;
            font-family: "Segoe UI", sans-serif;
        }

        /* Sidebar */
        .sidebar {
            height: 100vh;
            width: 250px;
            position: fixed;
            background: #0d6efd;
            color: white;
            padding-top: 25px;
        }

        .sidebar a {
            text-decoration: none;
            font-size: 18px;
            color: white;
            padding: 12px 25px;
            display: block;
        }

        .sidebar a:hover {
            background: #0b5ed7;
        }

        /* Content */
        .content-area {
            margin-left: 260px;
            padding: 30px;
        }

        .card-custom {
            border-radius: 12px;
            background-color: white;
            box-shadow: 0 3px 10px rgba(0,0,0,0.1);
        }

        .topbar {
            background: white;
            padding: 12px 25px;
            border-radius: 12px;
            box-shadow: 0 3px 8px rgba(0,0,0,0.1);
            margin-bottom: 20px;
        }

        .badge-status {
            font-size: 13px;
            padding: 5px 10px;
        } 
    </style>

</head>

<body>

<!-- NAVBAR -->
<!--  
	<nav class="navbar navbar-dark bg-success fixed-top">


		<div class="container-fluid">
			<span class="navbar-brand"><i class="fa-solid fa-leaf"></i>
				Homesteader Admin Dashboard</span> <a href="FLogout"
				class="btn btn-light btn-sm">Logout</a>
		</div>

	</nav>
	-->
<!-- Sidebar -->
<div class="sidebar">
    <h3 class="text-center mb-4">
        <i class="bi bi-building"></i> Agro Agency
    </h3>

    <a href="#"><i class="bi bi-speedometer2"></i> Dashboard</a>
    <a href="#"><i class="bi bi-person-lines-fill"></i> Farmers</a>
    <a href="#"><i class="bi bi-mortarboard"></i> Students</a>
    <a href="#"><i class="bi bi-journal-check"></i> Training Requests</a>
    <a href="#"><i class="bi bi-gear"></i> Settings</a>

    <hr style="color: white;">

    <a href="Alogout"><i class="bi bi-power"></i> Logout</a>
</div>

<!-- Content -->
<div class="content-area">

    <!-- Topbar -->
    <div class="topbar d-flex justify-content-between align-items-center">
        <h4 class="fw-bold">Welcome, ${user.aname }</h4>

        <div class="d-flex align-items-center">
            <a href="AgencyData/${user.aname }"class="me-3 fw-bold">Agency Profile</a>
            <i class="bi bi-person-circle fs-3 text-primary"></i>
        </div>
    </div>

    <!-- Dashboard Cards -->
    <div class="row mb-4">

        <div class="col-md-4">
            <div class="card card-custom p-3">
                <h5>Total Requests</h5>
                <h3 class="text-primary fw-bold">${totalRequests}</h3>
            </div>
        </div>

        <div class="col-md-4">
            <div class="card card-custom p-3">
                <h5>Approved</h5>
                <h3 class="text-success fw-bold">${approved}</h3>
            </div>
        </div>

        <div class="col-md-4">
            <div class="card card-custom p-3">
                <h5>Pending</h5>
                <h3 class="text-warning fw-bold">${pending}</h3>
            </div>
        </div>

    </div>

    <!-- Search Bar -->
    <div class="card card-custom p-4 mb-4">
        <h5 class="mb-3">Search Training Requests</h5>
        <form method="get" action="searchRequests">
            <div class="row">

                <div class="col-md-4">
                    <input type="text" name="name" class="form-control" placeholder="Search by Name">
                </div>

                <div class="col-md-4">
                    <select name="status" class="form-control">
                        <option value="">Filter by Status</option>
                        <option value="Pending">Pending</option>
                        <option value="Approved">Approved</option>
                        <option value="Rejected">Rejected</option>
                    </select>
                </div>

                <div class="col-md-4">
                    <button class="btn btn-primary w-100">
                        <i class="bi bi-search"></i> Search
                    </button>
                </div>

            </div>
        </form>
    </div>

    <!-- Training Requests Table -->
    <div class="card card-custom p-4">
        <h4 class="mb-3">Training Requests</h4>

        <table class="table table-hover">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Mobile</th>
                <th>Category</th>
                <th>Training Type</th>
                <th>Date</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach items="${trainingRequests}" var="t">
                <tr>
                    <td>${t.reqId}</td>
                    <td>${t.name}</td>
                    <td>${t.mobile}</td>
                    <td>${t.category}</td>
                    <td>${t.trainingType}</td>
                    <td>${t.preferredDate}</td>

                    <td>
                        <span class="badge 
                              ${t.status == 'Approved' ? 'bg-success' : 
                                t.status == 'Rejected' ? 'bg-danger' : 'bg-warning text-dark'} 
                              badge-status">
                            ${t.status}
                        </span>
                    </td>

                    <td>
                        <a href="approve/${t.reqId}" class="btn btn-success btn-sm">Approve</a>
                        <a href="reject/${t.reqId}" class="btn btn-danger btn-sm">Reject</a>
                    </td>

                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
