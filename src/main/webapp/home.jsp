<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="component/css.jsp"%>
</head>
<body>
	<%@include file="component/navbar.jsp"%>


	<div class="container card-sh" style="margin-top: 70px">
		<div class="row">
			<p class="fs-3 text-center">Room Details</p>

			<div class="col-md-12 paint-card p-5">
				<div class="row">
					<div class="col-md-6">
						<div class="row">
							<div id="carouselExample" class="carousel slide">
								<div class="carousel-inner">
									<div class="carousel-item active">
										<img src="data/img/product_img/home1.jpg" width="100%"
											height="350px" class="d-block w-100" alt="...">
									</div>
									<div class="carousel-item">
										<img src="data/img/product_img/home2.jpg" width="100%"
											height="350px" class="d-block w-100" alt="...">
									</div>

								</div>
								<button class="carousel-control-prev" type="button"
									data-bs-target="#carouselExample" data-bs-slide="prev">
									<span class="carousel-control-prev-icon" aria-hidden="true"></span>
									<span class="visually-hidden">Previous</span>
								</button>
								<button class="carousel-control-next" type="button"
									data-bs-target="#carouselExample" data-bs-slide="next">
									<span class="carousel-control-next-icon" aria-hidden="true"></span>
									<span class="visually-hidden">Next</span>
								</button>
							</div>
							<!-- <div class="col-md-6 p-2">
								<img alt="" src="data/img/product_img/home1.jpg" width="100%"
									height="200px">
							</div>
							 <div class="col-md-6 p-2">
								<img alt="" src="data/img/product_img/home1.jpg" width="100%"
									height="200px">
							</div>

							<div class="col-md-6 p-2">
								<img alt="" src="data/img/product_img/home1.jpg" width="100%"
									height="200px">
							</div>

							<div class="col-md-6 p-2">
								<img alt="" src="data/img/product_img/home1.jpg" width="100%"
									height="200px">
							</div> -->
						</div>
						<div class="bg-light mt-3 p-3 card-sh">
							<p class="fs-5 tex-center">Near By Places</p>
							<table class="table table-borderless">
								<thead>
									<tr>
										<th scope="col">Places</th>
										<th scope="col">Distances</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<th scope="row">School</th>
										<td>1.5 KM</td>
									</tr>
									<tr>
										<th scope="row">College</th>
										<td>1.5 KM</td>
									</tr>
									<tr>
										<th scope="row">Shopping Mall</th>
										<td>1.5 KM</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>

					<div class="col-md-6">
						<p class="fs-3">Royal White House</p>
						<p>
							<span class="fw-bold">Description : </span><br>1BHK Fully
							Furnished Flat for Rent in HSR Layout. This Rental House has 1
							Bedroom with an attached Bathroom, a Modular Kitchen, and a hall.
							The Bedroom is bright, quite spacious, warm, cozy, and
							comfortable with a double bed and wardrobe. The bed is
							well-furnished with a comfortable mattress. A Modular Kitchen
							with basic utensils(Cooker, Vessel, Tawa, Kadai, Serving spoons,
							Small spoons, Fork, Plates, Glasses, Knife, Peeling Knife,
							Chapathi Roller). Comes with a washroom which has an option of a
							hot and cold shower. This 1BHK flat is suitable for families,
							Bachelors and is also Couples Friendly. You can Book this flat on
							Daily Basis, Short Term & Long term and that too Without any
							brokerage.
						</p>
						<p>
							<span class="fw-bold"> Product Details: </span> <br>Status :


							<span class="badge bg-success">Available</span>

							<!-- <span class="badge bg-warning">Not Available</span> -->
							<br> Category : PG<br> Room Type : 1 BHK
						</p>
						<p class="fs-5 fw-bold">
							Price :&nbsp; &nbsp; &nbsp; &nbsp;<i class="fas fa-rupee-sign"></i>
							2000/Month
						</p>




						<button class="btn btn-danger col-md-12">Book</button>

						<!-- <button disabled class="btn btn-danger col-md-12">Booked</button> -->






					</div>
				</div>
			</div>

		</div>
	</div>
</body>
</html>