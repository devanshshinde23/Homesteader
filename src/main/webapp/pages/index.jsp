<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Homesteader - Smart Agriculture Portal</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link rel="stylesheet" href="/assets/css/style.css">

</head>

<body>

    <!-- NAVBAR -->
<nav class="navbar navbar-expand-lg navbar-dark bg-success shadow-sm">
    <div class="container">
        <a class="navbar-brand fw-bold" href="#">Homesteader</a>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">

                <li class="nav-item">
                    <a class="nav-link active" href="#">Home</a>
                </li>

                <!-- ⭐ Login Dropdown START -->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle fw-bold" href="#" id="loginDropdown"
                        role="button" data-bs-toggle="dropdown">
                        Login
                    </a>

                    <ul class="dropdown-menu dropdown-menu-end">
                        <li><a class="dropdown-item" href="/farmerLogin">Farmer Login</a></li>
                        <li><a class="dropdown-item" href="/adminLogin">Admin Login</a></li>
                        <li><a class="dropdown-item" href="/agencyLogin">Agency Login</a></li>
                    </ul>
                </li>
                <!-- ⭐ Login Dropdown END -->

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle fw-bold" href="#" id="loginDropdown"
                        role="button" data-bs-toggle="dropdown">
                        Register
                    </a>

                    <ul class="dropdown-menu dropdown-menu-end">
                        <li><a class="dropdown-item" href="/farmerRegister">Farmer Register</a></li>
                        <li><a class="dropdown-item" href="/adminRegister">Admin Register</a></li>
                        <li><a class="dropdown-item" href="/agencyRegister">Agency Register</a></li>
                    </ul>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="#features">Features</a>
                </li>

            </ul>
        </div>
    </div>
</nav>

    <!-- HERO SECTION -->
    <header class="hero-section d-flex align-items-center">
        <div class="container text-center text-white">
            <h1 class="display-4 fw-bold">Smart Farming Starts Here</h1>
            <p class="lead">Digital assistance for farmers, agencies, and admins.</p>
            <a href="/register" class="btn btn-light btn-lg mt-3 fw-bold">Get Started</a>
        </div>
    </header>

    <!-- ABOUT SECTION -->
    <section class="py-5">
        <div class="container text-center">
            <h2 class="fw-bold">About Homesteader</h2>
            <p class="mt-3 text-muted">
                Homesteader connects farmers, agencies, and administrators with real-time agricultural
                information, crop advisory, soil & climate updates, and training support.
            </p>
        </div>
    </section>

    <!-- FEATURES SECTION -->
    <section id="features" class="py-5 bg-light">
        <div class="container">
            <h2 class="text-center fw-bold mb-4">Platform Features</h2>

            <div class="row g-4">

                <!-- Card 1 -->
                <div class="col-md-3">
                    <div class="card feature-card text-center p-3 shadow-sm">
                        <h5 class="fw-bold">Market Prices</h5>
                        <p>View latest mandi prices for crops across regions.</p>
                    </div>
                </div>

                <!-- Card 2 -->
                <div class="col-md-3">
                    <div class="card feature-card text-center p-3 shadow-sm">
                        <h5 class="fw-bold">Soil & Climate</h5>
                        <p>Get accurate soil information and weather updates.</p>
                    </div>
                </div>

                <!-- Card 3 -->
                <div class="col-md-3">
                    <div class="card feature-card text-center p-3 shadow-sm">
                        <h5 class="fw-bold">Training Requests</h5>
                        <p>Request training programs from certified agencies.</p>
                    </div>
                </div>

                <!-- Card 4 -->
                <div class="col-md-3">
                    <div class="card feature-card text-center p-3 shadow-sm">
                        <h5 class="fw-bold">Agro Agencies</h5>
                        <p>Connect with agencies for seeds, fertilizers & advice.</p>
                    </div>
                </div>

            </div>
        </div>
    </section>

    <!-- FOOTER -->
    <footer class="bg-success text-white text-center py-3">
        <p class="mb-0">© 2025 Homesteader | Smart Agriculture Portal</p>
    </footer>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>

</html>
<style>
/* Hero section banner */
.hero-section {
    height: 80vh;
    background: url('https://images.unsplash.com/photo-1501004318641-b39e6451bec6') center/cover no-repeat;
    text-shadow: 2px 2px 5px rgba(0,0,0,0.7);
}

/* Feature card hover animation */
.feature-card {
    transition: all 0.3s ease-in-out;
    border-radius: 10px;
}

.feature-card:hover {
    transform: translateY(-7px);
    background-color: #e9ffe8;
}

/* Smooth navbar animation */
.navbar {
    transition: 0.3s;
}

.navbar-brand {
    letter-spacing: 1px;
    font-size: 1.5rem;
}

</style>