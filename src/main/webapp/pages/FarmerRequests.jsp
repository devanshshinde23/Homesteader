<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Farmer Requests</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4">
    <h2>Your Service Requests</h2>

    <table class="table table-bordered">
        <thead>
            <tr>
                <th>Agency</th>
                <th>Type</th>
                <th>Details</th>
                <th>Status</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${requests}" var="req">
                <tr>
                    <td>${req.agency.name}</td>
                    <td>${req.type}</td>
                    <td>${req.details}</td>
                    <td>${req.status}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <a href="/FarmerDash" class="btn btn-secondary">Back to Dashboard</a>
</body>
</html>
