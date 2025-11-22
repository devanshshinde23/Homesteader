<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Admin Register | Homesteader</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link rel="stylesheet" href="/assets/css/adminRegister.css">
</head>

<body class="admin-bg">

    <div class="container d-flex justify-content-center align-items-center vh-100">

        <div class="admin-card shadow-lg p-4">

            <h2 class="text-center text-success fw-bold mb-2">Register Admin</h2>
            <p class="text-center text-muted mb-4">Create a new admin account</p>

            <!-- Admin Registration Form -->
            <form action="/saveAdmin" method="post">

                <div class="mb-3">
                    <label class="form-label fw-semibold">Full Name</label>
                    <input type="text" class="form-control custom-input" name="Aname" placeholder="Enter full name" required>
                </div>

                <div class="mb-3">
                    <label class="form-label fw-semibold">Email</label>
                    <input type="email" class="form-control custom-input" name="Aemail" placeholder="Enter email" required>
                </div>

                <div class="mb-3">
                    <label class="form-label fw-semibold">Username</label>
                    <input type="text" class="form-control custom-input" name="Ausername" placeholder="Create username" required>
                </div>

                <div class="mb-3">
                    <label class="form-label fw-semibold">Password</label>
                    <input type="password" class="form-control custom-input" name="Apassword" placeholder="Create password" required>
                </div>
                
                <div class="mb-3">
                    <label class="form-label fw-semibold">Confirm Password</label>
                    <input type="password" class="form-control custom-input" name="Acpassword" placeholder="Confirm password" required>
                </div>

                <button type="submit" class="btn btn-success w-100 fw-bold login-btn">Register</button>
            </form>

            <p class="text-center mt-3 small">
                Already have an account? 
                <a href="/adminLogin" class="text-success fw-semibold">Login here</a>
            </p>

        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>

<Style> 

/* Background */
.admin-bg {
    background: linear-gradient(rgba(0, 128, 0, 0.4), rgba(0, 128, 0, 0.6)),
                url('https://images.unsplash.com/photo-1501004318641-b39e6451bec6')
                center/cover no-repeat;
}

/* Registration Card */
/* Smaller & Shorter Registration Card */
.admin-card {
	
    width: 450px;          /* Smaller width */
    padding: 10px;         /* Compact padding */
    background: #ffffffd8;
    border: 1px solid #c2eac2;
    backdrop-filter: blur(6px);
    border-radius: 12px;
    transition: 0.3s ease-in-out;
    min-height: 450px;     /* Shorter height */
    height :600px;
}

.admin-card:hover {
    transform: translateY(-5px);
    box-shadow: 0px 8px 20px rgba(0, 0, 0, 0.2);
}

/* Input Fields - Compact */
.custom-input {
    height: 40px;          /* Slightly smaller */
    border-radius: 6px;
    border: 1px solid #9dd89d;
}

.login-btn {
    height: 40px;          /* Smaller button */
    border-radius: 6px;
    transition: 0.3s;
}

.mb-3 {
height :60px;
}

</Style>