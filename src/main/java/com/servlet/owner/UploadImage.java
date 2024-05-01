package com.servlet.owner;

import java.io.File;
import java.io.IOException;

import com.dao.RoomDAO;
import com.entity.RoomImage;
import com.util.DBConnect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

@WebServlet("/uploadImage")
@MultipartConfig
public class UploadImage extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("rid"));
		Part part = req.getPart("img");

		String fileName = part.getSubmittedFileName();

		RoomImage img = new RoomImage(id, fileName);

		RoomDAO dao = new RoomDAO(DBConnect.getConnection());
		boolean saveImage = dao.saveImage(img);
		HttpSession session = req.getSession();
		if (saveImage) {
			if (part != null) {
				String path = req.getServletContext().getRealPath("") + "data" + File.separator + "img" + File.separator
						+ "product_img" + File.separator + fileName;
				// System.out.println(path);
				File file = new File(path);
				part.write(path);
			}
			session.setAttribute("succMsg", "Image uploaded");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
		}
		resp.sendRedirect("owner/image_upload.jsp?id=" + id);
	}

}
