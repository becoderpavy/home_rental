package com.servlet.user;

import java.io.IOException;

import com.dao.UserDAO;
import com.entity.User;
import com.util.DBConnect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			String em = req.getParameter("email");
			String ps = req.getParameter("password");

			UserDAO dao = new UserDAO(DBConnect.getConnection());
			HttpSession session = req.getSession();

			if ("admin@gmail.com".equals(em) && "admin".equals(ps)) {
				User us = new User();
				us.setFullName("Admin");
				session.setAttribute("adminObj", us);
				resp.sendRedirect("admin/");
			} else {

				User user = dao.login(em, ps);
				if (user != null) {
					if (user.getUser().equalsIgnoreCase("Owner")) {
						session.setAttribute("userObj", user);
						resp.sendRedirect("owner/index.jsp");
					} else {
						session.setAttribute("userObj", user);
						resp.sendRedirect("index.jsp");
					}
				} else {
					session.setAttribute("errorMsg", "invalid email and password");
					resp.sendRedirect("login.jsp");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}