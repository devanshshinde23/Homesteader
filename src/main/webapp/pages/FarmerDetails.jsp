<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Farmer Registration Records </title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"/>

  <style>
    /* Background Image */
    body {
      /* background-image: url('https://images.unsplash.com/photo-1501004318641-b39e6451bec6'); */
      background-color : white;
      
      background-size: cover;
      background-position: center;
      background-attachment: absolute;
      font-family: 'Segoe UI', sans-serif;
    }

    /* Dark overlay */
    .overlay {
      /*background: rgba(0, 0, 0, 0.55);*/
      position: absoulte;
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
      background-color: #2f5f44; /*#f4f6f9  #2f5f44*/
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

      <h2 class="text-center text-black  mb-4">Farmer Details </h2>

	
	
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
        
          <tr>
            <td><c:out value="${fd.fid}" /></td>
            <td><c:out value="${fd.fname}" /></td>
            <td><c:out value="${fd.femail}" /></td>
            <td><c:out value="${fd.fMobileNo}" /></td>
            <td><c:out value="${fd.fregion}" /></td>
            <td><c:out value="${fd.fusername}" /></td>

            <td>
              <a href="EditData/${fd.fid}" class="btn btn-outline-primary btn-sm">View</a>
              <a href="Deletedata/${fd.fid}" class="btn btn-outline-danger btn-sm">Delete</a>
            </td>
          </tr>
        
        </tbody>

      </table>
    </div>
  </div>


  <div class="container mt-5">
    <div class="container-box">

      <h2 class="text-center text-black mb-4">Crpos Records</h2>

	
	
      <table class="table table-bordered table-hover text-center">
        <thead >
          <tr>
            <th>ID</th>
            <th>Crop Name</th>
            <th>Type </th>
            <th>Quantity</th>
            <th>Price</th>
            
            <th>Action</th>
          </tr>
        </thead>

        <tbody>
        <c:forEach items="${fd.crops}" var="e">
          <tr>
            <td><c:out value="${e.cropId}" /></td>
            <td><c:out value="${e.cropName}" /></td>
            <td><c:out value="${e.cropType}" /></td>
            <td><c:out value="${e.quantity}" /></td>
            <td><c:out value="${e.price}" /></td>
            

            <td>
              <a href="EditData/${e.cropId}" class="btn btn-outline-primary btn-sm">View</a>
              <a href="Deletedata/${e.cropId}" class="btn btn-outline-danger btn-sm">Delete</a>
            </td>
          </tr>
        </c:forEach>
        </tbody>

      </table>
    </div>
  </div>
  
  <div class="container mt-5">
    <div class="container-box">

      <h2 class="text-center text-black mb-4">Herbs Records</h2>

	
	
      <table class="table table-bordered table-hover text-center">
        <thead >
          <tr>
            <th>ID</th>
            <th>Herbs Name</th>
            <th>Type </th>
            <th>Quantity</th>
            <th>Price</th>
            
            <th>Action</th>
          </tr>
        </thead>

        <tbody>
        <c:forEach items="${fd.herbs}" var="e">
          <tr>
            <td><c:out value="${e.herbid}" /></td>
            <td><c:out value="${e.herbName}" /></td>
            <td><c:out value="${e.category}" /></td>
            <td><c:out value="${e.quantity}" /></td>
            <td><c:out value="${e.price}" /></td>
            

            <td>
              <a href="EditData/${e.herbid}" class="btn btn-outline-primary btn-sm">View</a>
              <a href="Deletedata/${e.herbid}" class="btn btn-outline-danger btn-sm">Delete</a>
            </td>
          </tr>
        </c:forEach>
        </tbody>

      </table>
    </div>
  </div>


<div class="container mt-5">
    <div class="container-box">

      <h2 class="text-center text-black mb-4">Seeds Records</h2>

	
	
      <table class="table table-bordered table-hover text-center">
        <thead >
          <tr>
            <th>ID</th>
            <th>Seeds Name</th>
            <th>Category</th>
            <th>Quantity</th>
            <th>Price</th>
            
            <th>Action</th>
          </tr>
        </thead>

        <tbody>
        <c:forEach items="${fd.seeds}" var="e">
          <tr>
            <td><c:out value="${e.seedid}" /></td>
            <td><c:out value="${e.seedName}" /></td>
            <td><c:out value="${e.category}" /></td>
            <td><c:out value="${e.quantity}" /></td>
            <td><c:out value="${e.price}" /></td>
            

            <td>
              <a href="EditData/${e.seedid}" class="btn btn-outline-primary btn-sm">View</a>
              <a href="Deletedata/${e.seedid}" class="btn btn-outline-danger btn-sm">Delete</a>
            </td>
          </tr>
        </c:forEach>
        </tbody>

      </table>
    </div>
  </div>

<div class="container mt-5">
    <div class="container-box">

      <h2 class="text-center text-black mb-4">Fertilizers Records</h2>

	
	
      <table class="table table-bordered table-hover text-center">
        <thead >
          <tr>
            <th>ID</th>
            <th>Fertilizer Name</th>
            <th>Category</th>
            <th>Quantity</th>
            <th>Price</th>
            
            <th>Action</th>
          </tr>
        </thead>

        <tbody>
        <c:forEach items="${fd.fertilizer}" var="e">
          <tr>
            <td><c:out value="${e.fertilizerId}" /></td>
            <td><c:out value="${e.fertilizerName}" /></td>
            <td><c:out value="${e.category}" /></td>
            <td><c:out value="${e.quantity}" /></td>
            <td><c:out value="${e.price}" /></td>
            

            <td>
              <a href="EditData/${e.fertilizerId}" class="btn btn-outline-primary btn-sm">View</a>
              <a href="Deletedata/${e.fertilizerId}" class="btn btn-outline-danger btn-sm">Delete</a>
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
