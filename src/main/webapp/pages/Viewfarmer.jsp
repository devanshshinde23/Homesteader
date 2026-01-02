<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Farmer Registration Records </title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"/>

  <style>
    /* Background Image */
    body {
      background-image: url('https://images.unsplash.com/photo-1501004318641-b39e6451bec6');
      background-size: cover;
      background-position: center;
      background-attachment: fixed;
      font-family: 'Segoe UI', sans-serif;
    }

    /* Dark overlay */
    .overlay {
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
      box-shadow: 0 8px 20px rgba(0,0,0,0.3);
    }

    .table {
      background-color: rgba(255, 255, 255, 0.85);
      border-radius: 8px;
      overflow: hidden;
    }

    .table th {
      background-color: #007bff;
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

<div class="overlay">

  <div class="container mt-5">
    <div class="container-box">

      <h2 class="text-center text-white mb-4">Farmer Registration Records</h2>

	<form action="FindByVillage" method="post">
      
        <input type="text" name="x" class="form-control"  placeholder="Search by Village ">
        <button type="submit" class="btn btn-outline-primary btn-sm">Find</button>
      
	</form> 
	
      <table class="table table-bordered table-hover text-center">
        <thead >
          <tr>
            <th>ID</th>
            <th>Farmer Name</th>
            <th>Email</th>
            <th>Mobile</th>
            <th>Region</th>
            <th>Username</th>
            <th>Action</th>
          </tr>
        </thead>

        <tbody>
        <c:forEach items="${temp}" var="e">
          <tr>
            <td><c:out value="${e.fid}" /></td>
            <td><c:out value="${e.fname}" /></td>
            <td><c:out value="${e.femail}" /></td>
            <td><c:out value="${e.fMobileNo}" /></td>
            <td><c:out value="${e.fregion}" /></td>
            <td><c:out value="${e.fusername}" /></td>

            <td>
              <a href="EditData/${e.fid}" class="btn btn-outline-primary btn-sm">View</a>
              <a href="Deletedata/${e.fid}" class="btn btn-outline-danger btn-sm">Delete</a>
            </td>
          </tr>
        </c:forEach>
        </tbody>

      </table>
    </div>
  </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
