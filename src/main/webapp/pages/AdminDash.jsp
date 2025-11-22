<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Agro Admin Dashboard</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

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
            background-color: #198754;
            color: white;
        }
        
        .mb-4 {
        padding : 50px;
        
        }
    </style>
</head>

<body>

<!-- NAVBAR -->
<nav class="navbar navbar-dark bg-success fixed-top">
    <div class="container-fluid">
        <span class="navbar-brand"><i class="fa-solid fa-leaf"></i> Homesteader Admin Dashboard</span>
        <button class="btn btn-light btn-sm">Logout</button>
    </div>
</nav>

<!-- SIDEBAR -->
<div class="sidebar">

    <a href="#"><i class="fa-solid fa-chart-line me-2"></i> Dashboard</a>

    
    <a href="#"><i class="fa-solid fa-user-plus me-2"></i> Register Sub Admin</a>
    <a href="#"><i class="fa-solid fa-building me-2"></i> View Agro Agencies</a>

    <hr>

    <a href="#"><i class="fa-solid fa-wheat-awn me-2"></i> Add Crops Info</a>
    <a href="#"><i class="fa-solid fa-leaf me-2"></i> Add Herbs Info</a>
    <a href="#"><i class="fa-solid fa-carrot me-2"></i> Add Vegetables Info</a>
    <a href="#"><i class="fa-solid fa-seedling me-2"></i> Add Seeds Info</a>
    <a href="#"><i class="fa-solid fa-apple-whole me-2"></i> Add Fruits Info</a>
    <a href="#"><i class="fa-solid fa-flask me-2"></i> Add Fertilizers Info</a>

    <a href="#"><i class="fa-solid fa-indian-rupee-sign me-2"></i> Update Market Prices</a>
    <a href="#"><i class="fa-solid fa-cloud-sun-rain me-2"></i> Add Climate Changes</a>
    <a href="#"><i class="fa-solid fa-mountain-sun me-2"></i> Add Soil Analysis</a>

    <a href="#"><i class="fa-solid fa-comments me-2"></i> Farmer Feedback</a>

    <hr>

    <a href="#"><i class="fa-solid fa-calendar-day me-2"></i> Daily Reports</a>
    <a href="#"><i class="fa-solid fa-calendar-week me-2"></i> Weekly Reports</a>
    <a href="#"><i class="fa-solid fa-calendar-days me-2"></i> Monthly Reports</a>
    <a href="#"><i class="fa-solid fa-file-excel me-2"></i> Download Excel Report</a>

</div>

<!-- MAIN CONTENT -->
<div class="content mt-4">

    <h2 class="mb-4">Dashboard Overview</h2>

    <!-- TOP CARDS -->
    <div class="row">

        <div class="col-md-3">
            <div class="card shadow-sm p-3">
                <h6>Total Agro Agencies</h6>
                <h3><i class="fa-solid fa-building me-2"></i> 32</h3>
            </div>
        </div>

        <div class="col-md-3">
            <div class="card shadow-sm p-3">
                <h6>New Farmer Feedback</h6>
                <h3><i class="fa-solid fa-comments me-2"></i> 18</h3>
            </div>
        </div>

        <div class="col-md-3">
            <div class="card shadow-sm p-3">
                <h6>Pending Soil Reports</h6>
                <h3><i class="fa-solid fa-mountain-sun me-2"></i> 7</h3>
            </div>
        </div>

        <div class="col-md-3">
            <div class="card shadow-sm p-3">
                <h6>Market Price Updates</h6>
                <h3><i class="fa-solid fa-indian-rupee-sign me-2"></i> 5</h3>
            </div>
        </div>

    </div>

    <!-- TABLE SECTION -->
    <div class="card mt-4 shadow-sm">
        <div class="card-header bg-success text-white">
            Recently Added Crop Information
        </div>

        <div class="card-body">

            <table class="table table-hover table-striped">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Crop Name</th>
                        <th>Category</th>
                        <th>Region</th>
                        <th>Updated By</th>
                        <th>Actions</th>
                    </tr>
                </thead>

                <tbody>
                    <tr>
                        <td>1</td>
                        <td>Wheat</td>
                        <td>Grain</td>
                        <td>Pune</td>
                        <td>Admin</td>
                        <td>
                            <button class="btn btn-primary btn-sm"><i class="fa-solid fa-pen"></i></button>
                            <button class="btn btn-danger btn-sm"><i class="fa-solid fa-trash"></i></button>
                        </td>
                    </tr>

                    <tr>
                        <td>2</td>
                        <td>Tomato</td>
                        <td>Vegetable</td>
                        <td>Satara</td>
                        <td>Sub Admin</td>
                        <td>
                            <button class="btn btn-primary btn-sm"><i class="fa-solid fa-pen"></i></button>
                            <button class="btn btn-danger btn-sm"><i class="fa-solid fa-trash"></i></button>
                        </td>
                    </tr>

                    <tr>
                        <td>3</td>
                        <td>Turmeric</td>
                        <td>Herb</td>
                        <td>Nagpur</td>
                        <td>Admin</td>
                        <td>
                            <button class="btn btn-primary btn-sm"><i class="fa-solid fa-pen"></i></button>
                            <button class="btn btn-danger btn-sm"><i class="fa-solid fa-trash"></i></button>
                        </td>
                    </tr>
                </tbody>

            </table>

        </div>
    </div>

</div>

</body>
</html>
