package com.servlet.user;

import java.io.File;
import java.io.IOException;

import com.dao.UserDAO;
import com.entity.Booking;
import com.util.DBConnect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

@WebServlet("/bookRoom")
@MultipartConfig
public class BookRoom extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		String student = req.getParameter("student");
		String college = req.getParameter("college");
		int userId = Integer.parseInt(req.getParameter("userId"));
		int roomId = Integer.parseInt(req.getParameter("roomId"));
		int ownerId = Integer.parseInt(req.getParameter("ownerId"));

		Part part = req.getPart("idProof");
		String file = part.getSubmittedFileName();

		Booking b = new Booking();
		b.setName(name);
		b.setEmail(email);
		b.setAddress(address);
		b.setIdProof(file);
		b.setStudent(student);
		b.setCollege(college);
		b.setUserId(userId);
		b.setRoomId(roomId);
		b.setOwnerId(ownerId);
		b.setPayment("Pending");
		b.setStatus("Pending");

		UserDAO dao = new UserDAO(DBConnect.getConnection());
		boolean saveBooking = dao.saveBooking(b);
		HttpSession session = req.getSession();
		if (saveBooking) {
			if(part!=null)
			{
				String path = req.getServletContext().getRealPath("") + "data" + File.separator + "img"
						+ File.separator + "id_proof" + File.separator + file;
				// System.out.println(path);
				File files = new File(path);
				part.write(path);
			}
			session.setAttribute("succMsg", "Booking success");
		}
		resp.sendRedirect("booking.jsp?id=" + roomId);

	}

}
