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

@WebServlet("/chngps")
public class ChangePassword extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String newPass = req.getParameter("newpassword");
			String oldPass = req.getParameter("oldpassword");
			int id = Integer.parseInt(req.getParameter("id"));

			UserDAO dao = new UserDAO(DBConnect.getConnection());
			HttpSession session = req.getSession();

			if (dao.checkOldPasssword(id, oldPass)) {
				if (dao.updateNewPasssword(id, newPass)) {
					User user1 = dao.getUser(id);
					session.setAttribute("userObj", user1);
					session.setAttribute("succMsg", "Password change successfully");
					resp.sendRedirect("edit_profile.jsp");
				} else {
					session.setAttribute("errorMsg", "something wrong on server");
					resp.sendRedirect("edit_profile.jsp");
				}
			} else {
				session.setAttribute("errorMsg", "wrong old password");
				resp.sendRedirect("edit_profile.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
