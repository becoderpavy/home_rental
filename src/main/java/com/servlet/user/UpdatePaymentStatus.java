package com.servlet.user;

import java.io.IOException;

import com.dao.UserDAO;
import com.util.DBConnect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/updatePaymentStatus")
public class UpdatePaymentStatus extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		String status = "yes";

		UserDAO dao = new UserDAO(DBConnect.getConnection());
		boolean updateBookingStatus = dao.updateBookingPayment(id, status);
		HttpSession session = req.getSession();
//		if (updateBookingStatus) {
//			session.setAttribute("succMsg", "Payment success");
//		}
		resp.sendRedirect("booking_success.jsp");
	}

}
