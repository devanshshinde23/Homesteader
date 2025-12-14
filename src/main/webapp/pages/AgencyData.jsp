<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Agency Profile</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"/>

    <style>
        body {
            background: #f0f4f7;
        }
        .profile-card {
            max-width: 600px;
            margin: auto;
            margin-top: 60px;
            background: white;
            border-radius: 15px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.1);
            padding: 30px;
        }
        .profile-icon {
            font-size: 80px;
            color: #0d6efd;
        }
    </style>
</head>

<body>

<div class="profile-card text-center">

    <i class="bi bi-person-circle profile-icon"></i>

    <h2 class="mt-3">${user.aname}</h2>
    <p class="text-muted">Agro Agency</p>

    <hr>

    <div class="text-start">

        <p><strong>Owner Name:</strong> ${user.aownerName}</p>
        <p><strong>Register Number:</strong> ${user.aregisterNo}</p>
        <p><strong>Agency Type:</strong> ${user.atype}</p>
        <p><strong>Mobile No:</strong> ${user.amobno}</p>
        <p><strong>Address:</strong> ${user.aaddress}</p>
        <p><strong>Username:</strong> ${user.ausername}</p>

    </div>

    <hr>

    <a href="AgencyDash" class="btn btn-primary w-100 mb-2">Back to Dashboard</a>
    <a href="Logout" class="btn btn-danger w-100">Logout</a>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css">

</body>
</html>
