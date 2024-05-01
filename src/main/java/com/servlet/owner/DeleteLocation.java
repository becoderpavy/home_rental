package com.servlet.owner;

import java.io.IOException;

import com.dao.RoomDAO;
import com.util.DBConnect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteLoc")
public class DeleteLocation extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		int rid = Integer.parseInt(req.getParameter("rid"));
		RoomDAO dao = new RoomDAO(DBConnect.getConnection());
		Boolean deleteRoomImage = dao.deleteLocation(id);
		if (deleteRoomImage)
			req.getSession().setAttribute("succMsg", "Location deleted");
		resp.sendRedirect("owner/near_location.jsp?id=" + rid);
	}
}
