package com.servlet.owner;

import java.io.IOException;

import com.dao.RoomDAO;
import com.entity.NearLocation;
import com.util.DBConnect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/addLocation")
@MultipartConfig
public class AddNearLocation extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("rid"));
		String name = req.getParameter("name");
		String distance = req.getParameter("distance");

		NearLocation loc = new NearLocation();
		loc.setName(name);
		loc.setDistance(distance);
		loc.setRoomId(id);

		RoomDAO dao = new RoomDAO(DBConnect.getConnection());
		boolean saveLoc = dao.saveNearLocation(loc);
		HttpSession session = req.getSession();
		if (saveLoc) {
			session.setAttribute("succMsg", "Location added");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
		}
		resp.sendRedirect("owner/near_location.jsp?id=" + id);
	}

}
