<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Farmer Register | Homesteader</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link rel="stylesheet" href="/assets/css/adminRegister.css">
</head>

<body class="admin-bg">

    <div class="container d-flex justify-content-center align-items-center vh-100">

        <div class="admin-card shadow-lg p-4">

            <h2 class="text-center text-success fw-bold mb-2">Farmer Admin</h2>
            <p class="text-center text-muted mb-4">Create a new  account</p>

            <!-- Farmer Registration Form -->
            <form action="/savefarmer" method="post">

                <div class="mb-3">
                    <label class="form-label fw-semibold">Full Name</label>
                    <input type="text" class="form-control custom-input" name="fname" placeholder="Enter full name" required>
                </div>
                
                <div class="mb-3">
                    <label class="form-label fw-semibold">Mobile No</label>
                    <input type="text" class="form-control custom-input" name="fMobileNo" placeholder="Enter Mobile_no" required>
                </div>

                <div class="mb-3">
                    <label class="form-label fw-semibold">Email</label>
                    <input type="email" class="form-control custom-input" name="femail" placeholder="Enter Email" required>
                </div>
                
                <div class="mb-3">
                    <label class="form-label fw-semibold">Region</label>
                    <input type="text" class="form-control custom-input" name="fregion" placeholder="Enter Region" required>
                </div>

                <div class="mb-3">
                    <label class="form-label fw-semibold">Username</label>
                    <input type="text" class="form-control custom-input" name="fusername" placeholder="Create Username" required>
                </div>

                <div class="mb-3">
                    <label class="form-label fw-semibold">Password</label>
                    <input type="password" class="form-control custom-input" name="fpassword" placeholder="Create Password" required>
                </div>
                
                <div class="mb-3">
                    <label class="form-label fw-semibold">Confirm Password</label>
                    <input type="password" class="form-control custom-input" name="fcpassword" placeholder="Confirm Password" required>
                </div>

                <button type="submit" class="btn btn-success w-100 fw-bold login-btn">Register</button>
            </form>

            <p class="text-center mt-3 small">
                Already have an account? 
                <a href="/FarmerLogin" class="text-success fw-semibold">Login here</a>
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

	padding:150px;
    background: linear-gradient(rgba(0, 128, 0, 0.3), rgba(0, 128, 0, 0.5)),
                url('https://images.unsplash.com/photo-1501004318641-b39e6451bec6')
                center/cover no-repeat;
    min-height: 150vh;
    
}

/* Registration Card */
.admin-card {
    width: 420px;
    background: #ffffffd8;
    padding: 30px 25px;
    border-radius: 12px;
    border: 1px solid #c2eac2;
    backdrop-filter: blur(4px);
    box-shadow: 0px 4px 15px rgba(0,0,0,0.2);
    transition: 0.3s ease-in-out;
    
    
    
}

.admin-card:hover {
    transform: translateY(-4px);
    box-shadow: 0px 10px 25px rgba(0, 0, 0, 0.25);
}

/* Input Fields */
.custom-input {
    height: 38px;
    border: 1px solid #8fd78f;
    border-radius: 6px;
}

.custom-input:focus {
    border-color: #2d6a4f;
    box-shadow: 0 0 4px rgba(45, 106, 79, 0.6);
}

/* Button */
.login-btn {
    height: 40px;
    border-radius: 6px;
    font-weight: 600;
    background: #198754;
    transition: 0.3s ease-in-out;
}

.login-btn:hover {
    background: #146c43;
}

/* Form Spacing */
.mb-3 {
    margin-bottom: 14px !important;
}

</style>


