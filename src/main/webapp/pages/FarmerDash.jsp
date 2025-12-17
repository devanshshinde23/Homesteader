<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Farmer Dashboard | Homesteader</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">

    <!-- Icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

    <style>
        body {
            background: #eef7ee;
            font-family: "Poppins", sans-serif;
        }

        /* Sidebar */
        .sidebar {
            width: 230px;
            height: 100vh;
            background: #2d7a32;
            position: fixed;
            top: 0;
            left: 0;
            padding-top: 30px;
            color: white;
        }

        .sidebar a {
            display: block;
            color: white;
            padding: 12px 20px;
            text-decoration: none;
            font-size: 16px;
        }

        .sidebar a:hover {
            background: #256428;
        }

        /* Top Header */
        .header {
            margin-left: 230px;
            background: #ffffff;
            padding: 15px 30px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            box-shadow: 0px 2px 5px rgba(0,0,0,0.1);
        }

        /* Dashboard Cards */
        .card-box {
            padding: 25px;
            text-align: center;
            border-radius: 12px;
            background: white;
            box-shadow: 0px 4px 10px rgba(0,0,0,0.1);
            transition: 0.3s;
            cursor: pointer;
        }

        .card-box:hover {
            transform: translateY(-5px);
            background: #e8ffe9;
        }

        .card-box i {
            font-size: 40px;
            margin-bottom: 10px;
            color: #2d7a32;
        }

        /* Main Content Area */
        .content-area {
            margin-left: 230px;
            padding: 30px;
        }

        .section-title {
            font-weight: 600;
            margin-bottom: 15px;
            color: #2d7a32;
        }

        .footer {
            text-align: center;
            padding: 15px;
            margin-top: 30px;
            font-size: 14px;
            color: #2d7a32;
        }

    </style>

</head>
<body>

    <!-- Sidebar -->
    <div class="sidebar">
        <h4 class="text-center mb-4"> Farmer Panel</h4>
        <a href="#"><i class="fa-solid fa-table-columns me-2"></i>Dashboard</a>
        <a href="AddCrop"><i class="fa-solid fa-seedling me-2"></i>Add Crop</a>
        <a href="AddHerbs"><i class="fa-solid fa-shop me-2"></i>Add Herbs </a>
        <a href="#"><i class="fa-solid fa-cloud-sun me-2"></i>Weather</a>
        <a href="#"><i class="fa-solid fa-landmark me-2"></i>Govt Schemes</a>
        <a href="#"><i class="fa-solid fa-headset me-2"></i>Support</a>
        <a href="Logout" class="mt-4"><i class="fa-solid fa-right-from-bracket me-2"></i>Logout</a>
    </div>

    <!-- Header -->
    <div class="header">
        <h5 class="m-0">Welcome, ${kk }</h5>
        <i class="fa-solid fa-circle-user fa-2x text-success"></i>
    </div>

    <!-- Main Content -->
    <div class="content-area">

        <!-- Dashboard Cards -->
        <h4 class="section-title">Quick Actions</h4>
        <div class="row g-4">
            <div class="col-md-3">
                <div class="card-box">
                    <i class="fa-solid fa-seedling"></i>
                    <h6>Crop Management</h6>
                    <p>Manage sowing & harvesting.</p>
                </div>
            </div>

            <div class="col-md-3">
                <div class="card-box">
                    <i class="fa-solid fa-shop"></i>
                    <h6>Sell Products</h6>
                    <p>Sell crops at best prices.</p>
                </div>
            </div>

            <div class="col-md-3">
                <div class="card-box">
                    <i class="fa-solid fa-cloud-sun"></i>
                    <h6>Weather Updates</h6>
                    <p>Plan farming using weather.</p>
                </div>
            </div>

            <div class="col-md-3">
                <div class="card-box">
                    <i class="fa-solid fa-landmark"></i>
                    <h6>Govt Schemes</h6>
                    <p>View subsidies & benefits.</p>
                </div>
            </div>
        </div>

        <!-- Weather -->
        <div class="mt-5">
            <h4 class="section-title">Today's Weather</h4>
            <div class="card p-4">
                <h5>🌤️ Sunny, 29°C</h5>
                <p>Good day for irrigation and outdoor work.</p>
            </div>
        </div>

        <!-- Govt Schemes -->
        <div class="mt-5">
            <h4 class="section-title">Government Schemes</h4>
            <div class="card p-4">
                <ul>
                    <li>PM-KISAN Samman Nidhi Yojana</li>
                    <li>Crop Insurance (PMFBY)</li>
                    <li>Soil Health Card Scheme</li>
                </ul>
            </div>
        </div>

        <!-- Footer -->
        <div class="footer">
            © 2025 Homesteader | Empowering Farmers
        </div>

    </div>

</body>
</html>
