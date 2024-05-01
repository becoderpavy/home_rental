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

@WebServlet("/registerUser")
@MultipartConfig
public class RegisterUser extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String fn = req.getParameter("fullname");
			String em = req.getParameter("email");
			String mb = req.getParameter("mobno");
			String ps = req.getParameter("password");
			String ad = req.getParameter("address");
			String ci = req.getParameter("city");
			String st = req.getParameter("state");
			String pin = req.getParameter("pincode");
			String us=req.getParameter("userType");
			Part p = req.getPart("img");
			String img = p.getSubmittedFileName();
			
			Part p2 = req.getPart("idproof");
			String idproof = p2.getSubmittedFileName();

			User user = new User(fn, em, mb, ps, ad, ci, st, pin);
			user.setImage(img);
			user.setUser(us);
			user.setIdProof(idproof);
			
			UserDAO dao = new UserDAO(DBConnect.getConnection());
			HttpSession session = req.getSession();

			if (dao.checkEmail(em)) {

				if (dao.addUser(user)) {

					String path = req.getServletContext().getRealPath("") + "data" + File.separator + "img"
							+ File.separator + "profile_img" + File.separator + img;
					 System.out.println(path);
					File file = new File(path);
					p.write(path);
					String path2 = req.getServletContext().getRealPath("") + "data" + File.separator + "img"
							+ File.separator + "id_proof" + File.separator + idproof;
					 System.out.println(path2);
					File file2 = new File(path2);
					p2.write(path2);

					session.setAttribute("succMsg", "Register successfully");
					resp.sendRedirect("register.jsp");
				} else {
					session.setAttribute("errorMsg", "something wrong on server");
					resp.sendRedirect("register.jsp");
				}

			} else {
				session.setAttribute("errorMsg", "Email id already exist");
				resp.sendRedirect("register.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}