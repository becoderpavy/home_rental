package com.servlet.user;

import java.io.File;
import java.io.IOException;

import com.dao.UserDAO;
import com.entity.User;
import com.util.DBConnect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

@WebServlet("/updateprofile")
@MultipartConfig
public class UpdateProfile extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String fn = req.getParameter("fullname");
			String em = req.getParameter("email");
			String mb = req.getParameter("mobno");
			String ad = req.getParameter("address");
			String ci = req.getParameter("city");
			String st = req.getParameter("state");
			String pin = req.getParameter("pincode");
			int id = Integer.parseInt(req.getParameter("id"));

			Part p = req.getPart("img");
			String fileName = "";

			UserDAO dao = new UserDAO(DBConnect.getConnection());

			if (p.getSubmittedFileName().isEmpty()) {
				fileName = dao.getUser(id).getImage();
			} else {
				fileName = p.getSubmittedFileName();
			}

			User user = new User(fn, em, mb, "", ad, ci, st, pin);
			user.setId(id);
			user.setImage(fileName);

			HttpSession session = req.getSession();

			if (dao.updateUser(user)) {
				User user1 = dao.getUser(id);
				session.setAttribute("userObj", user1);
				session.setAttribute("succMsgp", "Profile Update successfully");

				if (!p.getSubmittedFileName().isEmpty()) {
					String path = req.getServletContext().getRealPath("") + "data" + File.separator + "img"
							+ File.separator + "profile_img" + File.separator + fileName;
					//System.out.println(path);
					File file = new File(path);
					p.write(path);
				}

				resp.sendRedirect("edit_profile.jsp");
			} else {
				session.setAttribute("errorMsgp", "something wrong on server");
				resp.sendRedirect("edit_profile.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
