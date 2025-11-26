<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Agency Registration</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background: url("https://images.unsplash.com/photo-1501004318641-b39e6451bec6?auto=format&fit=crop&w=1350&q=80") center/cover no-repeat;
            font-family: 'Segoe UI';
        }
        .card {
            margin-top: 50px;
            border-radius: 15px;
            box-shadow: 0px 5px 20px rgba(0,0,0,0.2);
        }
        .form-control:focus {
            border-color: #4CAF50;
            box-shadow: 0 0 5px rgba(76,175,80,0.5);
        }
        h2 {
            color: #2e7d32;
            font-weight: bold;
        }
    </style>
</head>

<body>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">

            <div class="card p-4">
                <h2 class="text-center mb-4">Agency Registration</h2>

                <form action="saveAgency" method="post">

                    <!-- Agency Name -->
                    <div class="mb-3">
                        <label class="form-label">Agency Name</label>
                        <input type="text" name="aname" class="form-control" required>
                    </div>

                    <!-- Owner Name -->
                    <div class="mb-3">
                        <label class="form-label">Owner Name</label>
                        <input type="text" name="aownerName" class="form-control" required>
                    </div>

                    <!-- Register Number -->
                    <div class="mb-3">
                        <label class="form-label">Registration Number</label>
                        <input type="number" name="aregisterNo" class="form-control" required>
                    </div>

                    <!-- Agency Type -->
                    <div class="mb-3">
                        <label class="form-label">Agency Type</label>
                        <select name="atype" class="form-select" required>
                            <option value="">Select Type</option>
                            <option>Fertilizer Supplier</option>
                            <option>Pesticide Supplier</option>
                            <option>Seed Supplier</option>
                            <option>Organic Products</option>
                            <option>Equipment Dealer</option>
                        </select>
                    </div>

                    <!-- Mobile No -->
                    <div class="mb-3">
                        <label class="form-label">Mobile Number</label>
                        <input type="text" name="amobno" maxlength="10" class="form-control" required>
                    </div>

                    <!-- Address -->
                    <div class="mb-3">
                        <label class="form-label">Address</label>
                        <textarea name="aaddress" class="form-control" rows="2" required></textarea>
                    </div>

                    <!-- Username -->
                    <div class="mb-3">
                        <label class="form-label">Username</label>
                        <input type="text" name="ausername" class="form-control" required>
                    </div>

                    <!-- Password -->
                    <div class="mb-3">
                        <label class="form-label">Password</label>
                        <input type="password" name="apassword" class="form-control" required>
                    </div>

                    <!-- Submit Button -->
                    <div class="d-grid">
                        <button type="submit" class="btn btn-success btn-lg">Register</button>
                    </div>

                </form>

            </div>

        </div>
    </div>
</div>

</body>
</html>
