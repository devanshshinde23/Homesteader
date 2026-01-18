<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Agency Requests</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4">
    <h2>Incoming Farmer Requests</h2>

    <table class="table table-bordered">
        <thead>
            <tr>
                <th>Farmer</th>
                <th>Type</th>
                <th>Details</th>
                <th>Quantity</th>
                <th>Preferred Date</th>
                <th>Delivery Mode</th>
                <th>Status</th>
                <th>Update</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${requests}" var="req">
                <tr>
                    <td>${req.farmer.fname}</td>
                    <td>${req.type}</td>
                    <td>${req.details}</td>
                    <td>${req.quantity} ${req.unit}</td>
                    <td>${req.preferredDate}</td>
                    <td>${req.deliveryMode}</td>
                    <td>${req.status}</td>
                    <td>
                        <form action="/requests/update/${req.id}" method="post">
                            <select name="status" class="form-select">
                                <option ${req.status == 'Pending' ? 'selected' : ''}>Pending</option>
                                <option ${req.status == 'Approved' ? 'selected' : ''}>Approved</option>
                                <option ${req.status == 'Rejected' ? 'selected' : ''}>Rejected</option>
                            </select>
                            <button type="submit" class="btn btn-primary btn-sm">Update</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
