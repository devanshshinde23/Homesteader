<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Herbs</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet">

    <!-- Custom CSS -->
    <style>
        body {
            background: linear-gradient(to right, #f1f8e9, #e8f5e9);
            min-height: 100vh;
            
            
        }

        .card {
            border-radius: 18px;
        }

        .card-header {
            background: #2e7d32;
            border-radius: 18px 18px 0 0;
        }

        .form-label {
            font-weight: 600;
            color: #1b5e20;
        }

        .btn-success {
            font-size: 18px;
            border-radius: 30px;
        }
        
        
        /* Common style for all form controls */
input, textarea, select {
    width: 100%;
    padding: 8px;
    margin-top: 5px;
    border: 1px solid #ccc;
    border-radius: 4px;
    font-size: 14px;
    box-sizing: border-box;
}

/* Optional: add focus effect */
input:focus, textarea:focus, select:focus {
    border-color: #66afe9;
    outline: none;
    box-shadow: 0 0 5px rgba(102,175,233,.6);
}
    
    
    .form-card {
    background: url('herbs-bg.jpg') no-repeat center center;
    background-size: cover;          /* makes image fill the form */
    padding: 30px;
    border-radius: 12px;
    box-shadow: 0 8px 20px rgba(0,0,0,0.2);
    width: 400px;
    color: #fff;                     /* text color for readability */
    position: relative;
}

/* Add a semi-transparent overlay for better contrast */
.form-card::before {
    content: "";
    position: absolute;
    top: 0; left: 0; right: 0; bottom: 0;
    background: rgba(0,0,0,0.4);     /* dark overlay */
    border-radius: 12px;
    z-index: 0;
}

.form-card * {
    position: relative;
    z-index: 1;                      /* ensures text stays above overlay */
}
        
    </style>
</head>

<body>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-lg-6 col-md-8">

            <div class="card shadow-lg">
                <div class="card-header text-white text-center">
                    <h3>🌱 Add Seeds</h3>
                </div>

                <div class="card-body p-4">

                    <!-- NORMAL HTML FORM -->
                    <form action="saveSeed" method="post">
						
						<!-- Farmer ID handling -->
							<c:if test="${not empty farmerId}">
								<!-- Farmer login: hidden field -->
								<input type="hidden" name="farmerId" value="${farmerId}" />
							</c:if>
							<c:if test="${empty farmerId}">
								<!-- Admin login: dropdown of farmers -->
								<div class="mb-3">
									<label class="form-label">Select Farmer</label> <select
										name="farmerId" class="form-control" required>
										<option value="">--Select Farmer--</option>
										<c:forEach var="farmer" items="${farmers}">
											<option value="${farmer.fid}">${farmer.fname}</option>
										</c:forEach>
									</select>
								</div>
							</c:if>
                        <!-- Herb Name -->
                        <div class="mb-3">
                            <label class="form-label">Seed Name</label>
                            <input type="text"
                                   name="seedName"
                                   class="form-control"
                                   placeholder="Enter Seed Name"
                                   required>
                        </div >
							
							<!-- Crop Type -->
		                <div class="mb-3">
		                    <label class="form-label">Seed Type</label>
		                    <select name="category" class="form-control" required>
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
                                   placeholder="Enter quantity"
                                   required>
                        </div>

                        <!-- Price -->
                        <div class="mb-3">
                            <label class="form-label">Price (₹ per Kg)</label>
                            <input type="number"
                                   name="price"
                                   class="form-control"
                                   placeholder="Enter price"
                                   required>
                        </div>

                        <!-- Submit Button -->
                        <div class="d-grid mt-4">
                            <button type="submit" class="btn btn-success">
                                Save Seed
                            </button>
                        </div>

                    </form>

                </div>

            </div>

        </div>
    </div>
</div>

</body>
</html>
