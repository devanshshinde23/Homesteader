<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Farmer Dashboard | Homesteader</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
	
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
	
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
        
        /*cards hover effect */
        .card-link {
  text-decoration: none;
  color: inherit;
}

.scheme-card {
  transition: transform 0.3s, box-shadow 0.3s;
  cursor: pointer;
}

.scheme-card:hover {
  transform: translateY(-8px);
  box-shadow: 0 8px 20px rgba(0,0,0,0.2);
  background: #f0fff4; /* light green highlight */
}

/* Auto hover one by one (pulse effect) */
.scheme-card {
  animation: pulse 6s infinite;
}

.scheme-card:nth-child(1) { animation-delay: 0s; }
.scheme-card:nth-child(2) { animation-delay: 2s; }
.scheme-card:nth-child(3) { animation-delay: 4s; }

@keyframes pulse {
  0% { box-shadow: 0 0 0 rgba(0,0,0,0); }
  20% { box-shadow: 0 0 15px rgba(47,95,68,0.6); }
  40% { box-shadow: 0 0 0 rgba(0,0,0,0); }
  100% { box-shadow: 0 0 0 rgba(0,0,0,0); }
}
        
  .service-card {
  transition: transform 0.3s, box-shadow 0.3s;
  border-radius: 12px;
  background: #f9fff9;
  box-shadow: 0 4px 12px rgba(0,0,0,0.1);
  text-decoration: none;
  color: inherit;
}

.service-card:hover {
  transform: translateY(-6px);
  box-shadow: 0 8px 20px rgba(0,0,0,0.2);
  background: #e6ffe6;
}
      
   #requestModal .modal-dialog {
  --bs-modal-width: 520px; /* Bootstrap 5 variable */
  max-width: 90vw;          /* fallback for smaller screens */
}

#requestModal .modal-content {
  width: auto;
}

#requestModal .modal-body {
  padding: 1rem;
}

#requestModal .form-control,
#requestModal .form-select {
  max-width: 480px;
  margin-left: auto;
  margin-right: auto;
}
   

    </style>

</head>

<body>

    <!-- Sidebar -->
    <div class="sidebar">
        <h4 class="text-center mb-4"> Farmer Panel</h4>
        <a href="#"><i class="fa-solid fa-table-columns me-2"></i>Dashboard</a>
        <a href="AddCrop"><i class="fa-solid fa-wheat-awn me-2"></i>Add Crop</a>
        <a href="AddHerbs"><i class="fa-solid fa-leaf me-2"></i>Add Herbs </a>
        <a href="AddSeeds"><i class="fa-solid fa-seedling me-2"></i>Add Seeds Info</a>
        <a href="AddFertilizer"><i class="fa-solid fa-flask me-2"></i> Add Fertilizers Info</a>
        <a href="#"><i class="fa-solid fa-cloud-sun me-2"></i>Weather</a>
        <a href="javascript:void(0);" id="showRequestLink" > <i class="fa-solid fa-list me-2"></i> Show Request </a>
        
        <a href="#"><i class="fa-solid fa-landmark me-2"></i>Govt Schemes</a>
        <a href="#"><i class="fa-solid fa-headset me-2"></i>Support</a>
        <a href="javascript:void(0)" onclick="toggleChatbot()">
            <i class="fa-solid fa-robot me-2"></i> AI ChatBot</a>
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
                    <h6>Government Schemes</h6>
                    <p>View subsidies & benefits.</p>
                </div>
            </div>
        </div>

        <!-- Request Service Section -->
        <div class="mt-5">
            <h4 class="section-title">Request Services from Agencies</h4>

            <!-- Example agency card (loop through agencies in JSP) -->
            <c:forEach items="${agencies}" var="agency">
                <div class="card mb-3">
                    <div class="card-body">
                        <h5 class="card-title">${agency.name}</h5>
                        <p class="card-text">${agency.type} — ${agency.village}</p>
                        <button class="btn btn-success" data-bs-toggle="modal" data-bs-target="#requestModal"
                                data-agency-id="${agency.aid}">
                            Request Service
                        </button>
                    </div>
                </div>
            </c:forEach>

            <!-- Request Modal -->
            <div class="modal fade" id="requestModal" tabindex="-1">
                <div class="modal-dialog ">
                    <div class="modal-content">
                        <form action="/requests/create" method="post">
                            <div class="modal-header">
                                <h5 class="modal-title">Submit Service Request</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                            </div>
                            <div class="modal-body">
                                <input type="hidden" name="agencyId" id="agencyId">
                                <select name="type" class="form-select mb-2">
                                    <option>Seeds</option>
                                    <option>Fertilizer</option>
                                    <option>Equipment</option>
                                    <option>Crop Buyer</option>
                                </select>
                                <textarea name="details" class="form-control mb-2" placeholder="Enter details"></textarea>
                                <input type="number" name="quantity" class="form-control mb-2" placeholder="Quantity">
                                <input type="text" name="unit" class="form-control mb-2" placeholder="Unit (kg, bags)">
                                <input type="date" name="preferredDate" class="form-control mb-2">
                                <select name="deliveryMode" class="form-select mb-2">
                                    <option>Pickup</option>
                                    <option>Delivery</option>
                                </select>
                            </div>
                            <div class="modal-footer">
                                <button type="submit" class="btn btn-primary">Submit Request</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

        </div>

<!-- Hidden section for Count Cards + Request Table -->
<div id="requestSection" style="display:none;">

<h4 class="section-title">Incoming Buying Requests</h4>
    <!-- Count Cards -->
    <div class="row mb-3">
        <div class="col">
            <div class="card text-center">
                <div class="card-body">
                    <h5 class="section-title">Total Requests</h5>
                    <p>${totalRequests}</p>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card text-center">
                <div class="card-body">
                    <h5 class="section-title">Approved</h5>
                    <p>${approvedRequests}</p>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card text-center">
                <div class="card-body">
                    <h5 class="section-title">Pending</h5>
                    <p>${pendingRequests}</p>
                </div>
            </div>
        </div>
    </div>

    <!-- Request Table -->
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>Agency</th>
                <th>Product</th>
                <th>Quantity</th>
                <th>Status</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${requests}" var="r">
                <tr>
                    <td>${r.agency.username}</td>
                    <td>
                        <c:if test="${r.crop != null}">Crop: ${r.crop.cropName}</c:if>
                        <c:if test="${r.seed != null}">Seed: ${r.seed.seedName}</c:if>
                        <c:if test="${r.fertilizer != null}">Fertilizer: ${r.fertilizer.fertilizerName}</c:if>
                        <c:if test="${r.herb != null}">Herb: ${r.herb.herbName}</c:if>
                    </td>
                    <td>${r.quantity} ${r.unit}</td>
                    <td>
                        <c:choose>
                            <c:when test="${r.status eq 'Approved'}">
                                <span class="badge bg-success">Approved</span>
                            </c:when>
                            <c:when test="${r.status eq 'Rejected'}">
                                <span class="badge bg-danger">Rejected</span>
                            </c:when>
                            <c:otherwise>
                                <span class="badge bg-warning text-dark">Pending</span>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>


		
        <!-- Weather -->
        <div class="mt-5">
            <h4 class="section-title">Today's Weather</h4>
            <div class="card p-4">
                <h6>Today's Weather</h6>
                <h3 id="weather-info">Loading...</h3>
            </div>
        </div>

        <!-- Govt Schemes -->
        <div class="container mt-5">
            <h4 class="section-title">Government Schemes</h4>
            <div class="row g-4">
                <!-- PM-KISAN -->
                <div class="col-md-4">
                    <a href="https://pmkisan.gov.in/" target="_blank" class="card service-card text-center">
                        <div class="card-body">
                            <i class="fa-solid fa-hand-holding-dollar fa-2x mb-3 text-success"></i>
                            <h5>PM-KISAN Sanman Nidhi</h5>
                            <p>Direct income support for farmers.</p>
                            <button class="btn btn-outline-success mt-2">Visit PM-KISAN</button>
                        </div>
                    </a>
                </div>
                <!-- PMFBY -->
                <div class="col-md-4">
                    <a href="https://pmfby.gov.in/" target="_blank" class="card service-card text-center">
                        <div class="card-body">
                            <i class="fa-solid fa-shield-halved fa-2x mb-3 text-primary"></i>
                            <h5>Crop Insurance (PMFBY)</h5>
                            <p>Insurance against crop losses.</p>
                            <button class="btn btn-outline-primary mt-2">Visit PMFBY</button>
                        </div>
                    </a>
                </div>
                <!-- Soil Health Card -->
                <div class="col-md-4">
                    <a href="https://soilhealth.dac.gov.in/" target="_blank" class="card service-card text-center">
                        <div class="card-body">
                            <i class="fa-solid fa-seedling fa-2x mb-3 text-warning"></i>
                            <h5>Soil Health Card Scheme</h5>
                            <p>Improve soil fertility & productivity.</p>
                            <button class="btn btn-outline-warning mt-2">Visit Soil Health</button>
                        </div>
                    </a>
                </div>
            </div>
        </div>

        <!-- Footer -->
        <div class="footer">
            © 2025 Homesteader | Empowering Farmers
        </div>

    </div>

    <!-- Chatbot Widget -->
		<div id="chatbot-container" style="
			display : none;
		    position: fixed;
		    bottom: 20px;
		    right: 20px;
		    width: 300px;
		    background: #fff;
		    border: 1px solid #ccc;
		    border-radius: 10px;
		    box-shadow: 0 4px 12px rgba(0,0,0,0.2);
		    font-family: 'Segoe UI', sans-serif;		">
		    <div id="chatbot-header" style="background:#2f5f44; color:#fff; padding:10px; border-radius:10px 10px 0 0;">
		        Farmer Assistant 🤖
		    </div>
		    <div id="chatbot-messages" style="height:250px; overflow-y:auto; padding:10px; font-size:14px;"></div>
		    <div style="display:flex; border-top:1px solid #ccc;">
		        <input id="chatbot-input" type="text" placeholder="Ask me..." 
		               style="flex:1; border:none; padding:10px; font-size:14px;">
		        <button onclick="sendMessage()" style="background:#2f5f44; color:#fff; border:none; padding:10px;">Send</button>
		    </div>
		</div>
</body>
    
<script>
document.addEventListener('DOMContentLoaded', () => {
	  const requestModal = document.getElementById('requestModal');
	  requestModal.addEventListener('show.bs.modal', event => {
	    const button = event.relatedTarget; // Button that triggered the modal
	    const agencyId = button.getAttribute('data-agency-id');
	    document.getElementById('agencyId').value = agencyId;
	  });
	});


function toggleChatbot() {
    const chat = document.getElementById("chatbot-container");
    chat.style.display = (chat.style.display === "none" || chat.style.display === "") ? "block" : "none";
}

function sendMessage() {
    const input = document.getElementById("chatbot-input");
    const message = input.value.trim();
    if (!message) return;

    const chatBox = document.getElementById("chatbot-messages");
    chatBox.innerHTML += "<div style='color:green; margin:5px 0;'><b>You:</b> " + message + "</div>";

    // Call backend endpoint
    fetch("/chat?message=" + encodeURIComponent(message))
        .then(res => res.text())
        .then(reply => {
            chatBox.innerHTML += "<div style='color:#2f5f44; margin:5px 0;'><b>Bot:</b> " + reply + "</div>";
            chatBox.scrollTop = chatBox.scrollHeight;
        });

    input.value = "";
}

fetch("/weather?city=satara") 
	.then(res => res.json())
	.then(data => { 
	document.getElementById("weather-info").innerHTML =
		data.weather[0].description + ", " + data.main.temp + "°C"; });
		
		
		

document.getElementById("showRequestLink").addEventListener("click", function() {
    var section = document.getElementById("requestSection");
    if (section.style.display === "none") {
        section.style.display = "block";
        this.innerHTML = '<i class="fa-solid fa-eye-slash me-2"></i> Hide Request';
    } else {
        section.style.display = "none";
        this.innerHTML = '<i class="fa-solid fa-list me-2"></i> Show Request';
    }
});
</script>



</html>


