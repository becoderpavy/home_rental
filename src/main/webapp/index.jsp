<%@page import="com.entity.RoomImage"%>
<%@page import="com.entity.Room"%>
<%@page import="com.entity.RoomType"%>
<%@page import="com.util.DBConnect"%>
<%@page import="com.entity.Category"%>
<%@page import="com.dao.RoomDAO"%>
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
									aria-current="true"> All </a>

								<%
								RoomDAO dao = new RoomDAO(DBConnect.getConnection());
								List<Category> list = dao.getAllCategory();
								for (Category c : list) {
								%>
								<a href="product.jsp?ca=1Bhk"
									class="list-group-item list-group-item-action"><%=c.getName()%>
								</a>
								<%
								}
								%>


			

							</div>
						</div>
						<div class="mt-3">
							<p class="fs-5 text-center">Room Type</p>
							<div class="list-group" style="width: 100%;">

								<a href="product.jsp?ca=all"
									class="list-group-item list-group-item-action "
									aria-current="true"> All </a>

								<%
								List<RoomType> rooms = dao.getAllRoomType();
								for (RoomType r : rooms) {
								%>
								<a href="product.jsp?ca=1Bhk"
									class="list-group-item list-group-item-action"><%=r.getName()%>
								</a>
								<%
								}
								%>

								<a href="product.jsp?ca=1Bhk"
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
							<%
							RoomDAO roomDao = new RoomDAO(DBConnect.getConnection());
							List<Room> rms = roomDao.getAllRoom();
							for (Room rm : rms) {
								List<RoomImage> images = dao.getRoomImageByRoomId(rm.getId());
								if (images.size() > 0) {
							%>
							<div class="col-md-3 mt-3">
								<div class="card card-sh">
									<div class="card-body">
										<div id="carouselExample" class="carousel slide">
											<div class="carousel-inner">
												<%
												for (RoomImage img : images) {
												%>
												<div class="carousel-item active">
													<img src="data/img/product_img/<%=img.getImage()%>"
														width="100%" height="150px" class="d-block w-100"
														alt="...">
												</div>
												<%
												}
												%>
												<!-- <div class="carousel-item active">
													<img src="data/img/product_img/"
														width="100%" height="150px" class="d-block w-100"
														alt="...">
												</div> -->
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
											<a href="home.jsp?id=<%=rm.getId() %>" class="fs-5 text-decoration-none">Royal
												White House </a> <br> &#8377;<%=rm.getMonthlyCost() %>/Month <a href="#"
												class="text-decoration-none text-success"><i
												class="fa-solid fa-location-dot"></i></a>
										</p>
									</div>
								</div>
							</div>
							<%
							}
							}
							%>





						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>