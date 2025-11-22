<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Admin Login | Homesteader</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link rel="stylesheet" href="/assets/css/adminLogin.css">
</head>

<body class="admin-bg">

    <div class="container d-flex justify-content-center align-items-center vh-100">
        <div class="admin-card shadow-lg p-4">

            <h2 class="text-center text-success fw-bold mb-2">Admin Panel</h2>
            <p class="text-center text-muted mb-4">Login to access admin dashboard</p>

            <!-- Login Form -->
            <form action="checkAdminData" method="post">

                <div class="mb-3">
                    <label class="form-label fw-semibold">Admin Username</label>
                    <input type="text" class="form-control custom-input" name="username" placeholder="Enter admin username" required>
                </div>

                <div class="mb-3">
                    <label class="form-label fw-semibold">Password</label>
                    <input type="password" class="form-control custom-input" name="password" placeholder="Enter password" required>
                </div>

                <button type="submit" class="btn btn-success w-100 fw-bold login-btn">Login</button>
            </form>

            <p class="text-center mt-3 small">
                Go back to <a href="/" class="text-success fw-semibold">Home</a>
            </p>

        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>

<style>
/* Background */
.admin-bg {
    background: linear-gradient(rgba(0, 128, 0, 0.4), rgba(0, 128, 0, 0.6)),
                url('https://images.unsplash.com/photo-1501004318641-b39e6451bec6') 
                center/cover no-repeat;
}

/* Card */
.admin-card {
    width: 380px;
    background: #ffffffd8;
    backdrop-filter: blur(6px);
    border-radius: 12px;
    transition: 0.3s ease-in-out;
    border: 1px solid #c2eac2;
}

.admin-card:hover {
    transform: translateY(-7px);
    box-shadow: 0px 10px 25px rgba(0, 0, 0, 0.25);
}

/* Input fields */
.custom-input {
    height: 45px;
    border-radius: 8px;
    border: 1px solid #9dd89d;
    transition: 0.3s;
}

.custom-input:focus {
    border-color: #2e8b57;
    box-shadow: 0 0 5px rgba(46, 139, 87, 0.5);
}

/* Login button */
.login-btn {
    height: 45px;
    border-radius: 8px;
    transition: 0.3s;
}

.login-btn:hover {
    transform: scale(1.05);
    background-color: #2e8b57;
}

</style>
