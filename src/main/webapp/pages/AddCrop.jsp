<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Add Crop</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet">
</head>

<body class="bg-light">

<div class="container mt-5">
    <div class="card shadow">
        <div class="card-header bg-success text-white text-center">
            <h4>Add Crop Details</h4>
        </div>

        <div class="card-body">

            <!-- IMPORTANT: JSP form action -->
            <form action="${pageContext.request.contextPath}/saveCrop"
                  method="post">

                <!-- Crop Name -->
                <div class="mb-3">
                    <label class="form-label">Crop Name</label>
                    <input type="text"
                           name="cropName"
                           class="form-control"
                           required>
                </div>

                <!-- Crop Type -->
                <div class="mb-3">
                    <label class="form-label">Crop Type</label>
                    <select name="cropType" class="form-control" required>
                        <option value="">--Select--</option>
                        <option value="Kharif">Kharif</option>
                        <option value="Rabi">Rabi</option>
                        <option value="Zaid">Zaid</option>
                    </select>
                </div>

                <!-- Quantity -->
                <div class="mb-3">
                    <label class="form-label">Quantity (Kg)</label>
                    <input type="number"
                           name="quantity"
                           class="form-control"
                           required>
                </div>

                <!-- Price -->
                <div class="mb-3">
                    <label class="form-label">Price per Kg</label>
                    <input type="number"
                           name="price"
                           class="form-control"
                           step="0.01"
                           required>
                </div>

                <!-- Buttons -->
                <div class="text-center">
                    <button type="submit" class="btn btn-success">
                        Save Crop
                    </button>
                    <a href="${pageContext.request.contextPath}/FarmerDash"
                       class="btn btn-secondary">
                        Cancel
                    </a>
                </div>

            </form>

        </div>
    </div>
</div>

</body>
</html>
