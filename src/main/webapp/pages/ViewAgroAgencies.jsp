
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Agency Registration Records </title>
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

<div class="overlay"></div>

  <div class="container mt-5">
    <div class="container-box">

      <h2 class="text-center text-white mb-4">Farmer Registration Records</h2>

      <div class="search-box">
        <input type="text" name="sdob" class="form-control" id="dob" placeholder="Search by Region">
        <button type="submit" class="btn btn-light">Find</button>
      </div>

      <table class="table table-bordered table-hover text-center">

			<thead>
				<tr>
					<td>Id</td>
					<td>Agency Name</td>
					<td>Owner Name</td>
					<td>Register No</td>
					<td>Agency Type</td>
					<td>MOB_NO</td>
					<td>Address</td>
					<td>UserName</td>
				</tr>
				
			</thead>
			
			<tbody>
			<c:forEach items="${temp}" var="e">
				<td><c:out value="${e.aid}" /></td>
				<td><c:out value="${e.aname}" /></td>
				<td><c:out value="${e.aownerName}" /></td>
				<td><c:out value="${e.aregisterNo}" /></td>
				<td><c:out value="${e.atype}" /></td>
				<td><c:out value="${e.amobno}" /></td>
				<td><c:out value="${e.aaddress}" /></td>
				<td><c:out value="${e.ausername }"></c:out></td>

            <td>
              <a href="EditData/${e.aid}" class="btn btn-outline-primary btn-sm">Edit</a>
              <a href="Deletedata/${e.aid}" class="btn btn-outline-danger btn-sm">Delete</a>
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
















