package com.servlet.owner;

import java.io.IOException;

import com.dao.RoomDAO;
import com.entity.Room;
import com.util.DBConnect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/updateRoom")
public class UpdateRoom extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String title = req.getParameter("title");
		String category = req.getParameter("category");
		String roomType = req.getParameter("roomType");
		String description = req.getParameter("description");
		String email = req.getParameter("email");
		String mobileNumber = req.getParameter("mobileNumber");
		Double monthlyCost = Double.parseDouble(req.getParameter("monthlyCost"));
		String locationLink = req.getParameter("locationLink");
		String distance = req.getParameter("distance");
		String address = req.getParameter("address");
		String city = req.getParameter("city");
		String state = req.getParameter("state");
		String pincode = req.getParameter("pincode");
		int ownerId = Integer.parseInt(req.getParameter("ownerId"));
		int id = Integer.parseInt(req.getParameter("id"));

		Room room = new Room(title, category, roomType, description, email, mobileNumber, monthlyCost, locationLink,
				distance, address, city, state, pincode, ownerId);
		room.setId(id);

		HttpSession session = req.getSession();

		RoomDAO dao = new RoomDAO(DBConnect.getConnection());
		boolean f = dao.updateRoom(room);
		if (f) {
			session.setAttribute("succMsg", "Room update success");
		} else {
			session.setAttribute("errorMsg", "Something wrong on server");
		}
		resp.sendRedirect("owner/edit_room.jsp?id=" + room.getId());
	}

}
