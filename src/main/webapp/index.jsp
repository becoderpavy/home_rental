<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Rental : Home Page</title>
<%@include file="component/css.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<%@include file="component/navbar.jsp"%>
	<div
		class="container-fluid p-4 mt-5 bg-custom bg-primary border-outline-white">
		<div class="row">
			<div class="col-md-8 offset-md-2">
				<form action="search.jsp" method="post">
					<div class="input-group">
						<input type="text" class="form-control" name="ch">
						<button class="btn btn-light ms-2 col-md-2 text-dark">
							<i class="fa-solid fa-magnifying-glass"></i> Search
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>


	<div class="container-fluid mt-1">
		<div class="row">

			<div class="col-md-2">
				<div class="card">
					<div class="card-body">
						<div>
							<p class="fs-5 text-center">Categories</p>
							<div class="list-group" style="width: 100%;">
								<a href="product.jsp?ca=all"
									class="list-group-item list-group-item-action "
									aria-current="true"> All </a> <a href="product.jsp?ca=1Bhk"
									class="list-group-item list-group-item-action">PG </a> <a
									href="product.jsp?ca=1Bhk"
									class="list-group-item list-group-item-action">Hotel </a>
									<a
									href="product.jsp?ca=1Bhk"
									class="list-group-item list-group-item-action">Apartment </a>

							</div>
						</div>
						<div class="mt-3">
							<p class="fs-5 text-center">Room Type</p>
							<div class="list-group" style="width: 100%;">
								<a href="product.jsp?ca=all"
									class="list-group-item list-group-item-action "
									aria-current="true"> All </a> <a href="product.jsp?ca=1Bhk"
									class="list-group-item list-group-item-action">1 BHK </a> <a
									href="product.jsp?ca=1Bhk"
									class="list-group-item list-group-item-action">2 BHK </a>

							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="col-md-10 p-0">
				<div class="card">
					<div class="card-body">
						<p class="fs-4 text-center">Home</p>
						<div class="row">

							<div class="col-md-3 mt-3">
								<div class="card card-sh">
									<div class="card-body">
										<div id="carouselExample" class="carousel slide">
											<div class="carousel-inner">
												<div class="carousel-item active">
													<img src="data/img/product_img/home1.jpg" width="100%"
														height="150px" class="d-block w-100" alt="...">
												</div>
												<div class="carousel-item">
													<img src="data/img/product_img/home2.jpg" width="100%"
														height="150px" class="d-block w-100" alt="...">
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


										<p class="text-center">
											<a href="home.jsp" class="fs-5 text-decoration-none">Royal White
												House </a> <br> &#8377;2000/Month <a href="#"
												class="text-decoration-none text-success"><i
												class="fa-solid fa-location-dot"></i></a>
										</p>
									</div>
								</div>
							</div>

							<!-- Remove  -->
							<div class="col-md-3 mt-3">
								<div class="card card-sh">
									<div class="card-body">
										<div id="carouselExample" class="carousel slide">
											<div class="carousel-inner">
												<div class="carousel-item active">
													<img src="data/img/product_img/home3.jpg" width="100%"
														height="150px" class="d-block w-100" alt="...">
												</div>
												<div class="carousel-item">
													<img src="data/img/product_img/home4.jpg" width="100%"
														height="150px" class="d-block w-100" alt="...">
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
										<p class="text-center">
											<a href="#" class="fs-5 text-decoration-none">Royal White
												House </a> <br> &#8377;2000/Month <a href="#"
												class="text-decoration-none text-success"><i
												class="fa-solid fa-location-dot"></i></a>
										</p>
									</div>
								</div>
							</div>

							<div class="col-md-3 mt-3">
								<div class="card card-sh">
									<div class="card-body">
										<div id="carouselExample1" class="carousel slide">
											<div class="carousel-inner">
												<div class="carousel-item active">
													<img src="data/img/product_img/home2.jpg" width="100%"
														height="150px" class="d-block w-100" alt="...">
												</div>
												<div class="carousel-item">
													<img src="data/img/product_img/home1.jpg" width="100%"
														height="150px" class="d-block w-100" alt="...">
												</div>

											</div>
											<button class="carousel-control-prev" type="button"
												data-bs-target="#carouselExample1" data-bs-slide="prev">
												<span class="carousel-control-prev-icon" aria-hidden="true"></span>
												<span class="visually-hidden">Previous</span>
											</button>
											<button class="carousel-control-next" type="button"
												data-bs-target="#carouselExample1" data-bs-slide="next">
												<span class="carousel-control-next-icon" aria-hidden="true"></span>
												<span class="visually-hidden">Next</span>
											</button>
										</div>
										<p class="text-center">
											<a href="#" class="fs-5 text-decoration-none">Royal White
												House </a> <br> &#8377;2000/Month <a href="#"
												class="text-decoration-none text-success"><i
												class="fa-solid fa-location-dot"></i></a>
										</p>
									</div>
								</div>
							</div>

							<div class="col-md-3 mt-3">
								<div class="card card-sh">
									<div class="card-body">
										<img src="data/img/product_img/home1.jpg" width="100%"
											height="150px">
										<p class="text-center">
											<a href="#" class="fs-5 text-decoration-none">Royal White
												House </a> <br> &#8377;2000/Month <a href="#"
												class="text-decoration-none text-success"><i
												class="fa-solid fa-location-dot"></i></a>
										</p>
									</div>
								</div>
							</div>

							<div class="col-md-3 mt-3">
								<div class="card card-sh">
									<div class="card-body">
										<img src="data/img/product_img/home1.jpg" width="100%"
											height="150px">
										<p class="text-center">
											<a href="#" class="fs-5 text-decoration-none">Royal White
												House </a> <br> &#8377;2000/Month <a href="#"
												class="text-decoration-none text-success"><i
												class="fa-solid fa-location-dot"></i></a>
										</p>
									</div>
								</div>
							</div>

							<div class="col-md-3 mt-3">
								<div class="card card-sh">
									<div class="card-body">
										<img src="data/img/product_img/home1.jpg" width="100%"
											height="150px">
										<p class="text-center">
											<a href="#" class="fs-5 text-decoration-none">Royal White
												House </a> <br> &#8377;2000/Month <a href="#"
												class="text-decoration-none text-success"><i
												class="fa-solid fa-location-dot"></i></a>
										</p>
									</div>
								</div>
							</div>

							<div class="col-md-3 mt-3">
								<div class="card card-sh">
									<div class="card-body">
										<img src="data/img/product_img/home1.jpg" width="100%"
											height="150px">
										<p class="text-center">
											<a href="#" class="fs-5 text-decoration-none">Royal White
												House </a> <br> &#8377;2000/Month <a href="#"
												class="text-decoration-none text-success"><i
												class="fa-solid fa-location-dot"></i></a>
										</p>
									</div>
								</div>
							</div>

							<div class="col-md-3 mt-3">
								<div class="card card-sh">
									<div class="card-body">
										<img src="data/img/product_img/home1.jpg" width="100%"
											height="150px">
										<p class="text-center">
											<a href="#" class="fs-5 text-decoration-none">Royal White
												House </a> <br> &#8377;2000/Month <a href="#"
												class="text-decoration-none text-success"><i
												class="fa-solid fa-location-dot"></i></a>
										</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>