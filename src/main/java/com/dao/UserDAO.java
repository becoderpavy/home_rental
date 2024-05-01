package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.entity.Booking;
import com.entity.User;

public class UserDAO {
	private Connection conn;

	public UserDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addUser(User user) {
		boolean f = false;
		try {
			String sql = "insert into user(full_name,email,mobno,password,address,city,state,pincode,image,user,id_proof) values(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getFullName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getMobNo());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getAddress());
			ps.setString(6, user.getCity());
			ps.setString(7, user.getState());
			ps.setString(8, user.getPin());
			ps.setString(9, user.getImage());
			ps.setString(10, user.getUser());
			ps.setString(11, user.getIdProof());
			int id = ps.executeUpdate();
			if (id == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean updateUser(User user) {
		boolean f = false;
		try {
			String sql = "update user set full_name=?,email=?,mobno=?,address=?,city=?,state=?,pincode=?,image=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getFullName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getMobNo());
			ps.setString(4, user.getAddress());
			ps.setString(5, user.getCity());
			ps.setString(6, user.getState());
			ps.setString(7, user.getPin());
			ps.setString(8, user.getImage());
			ps.setInt(9, user.getId());

			int id = ps.executeUpdate();
			if (id == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public User login(String email, String password) {
		User user = null;
		try {
			String sql = "select * from user where email=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt(1));
				user.setFullName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setMobNo(rs.getString(4));
				user.setPassword(rs.getString(5));
				user.setAddress(rs.getString(6));
				user.setCity(rs.getString(7));
				user.setState(rs.getString(8));
				user.setPin(rs.getString(9));
				user.setImage(rs.getString(10));
				user.setUser(rs.getString(11));
				user.setIdProof(rs.getString(12));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public User getUser(int userId) {
		User user = null;
		try {
			String sql = "select * from user where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt(1));
				user.setFullName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setMobNo(rs.getString(4));
				user.setPassword(rs.getString(5));
				user.setAddress(rs.getString(6));
				user.setCity(rs.getString(7));
				user.setState(rs.getString(8));
				user.setPin(rs.getString(9));
				user.setImage(rs.getString(10));
				user.setUser(rs.getString(11));
				user.setIdProof(rs.getString(12));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public boolean checkEmail(String email) {
		boolean f = true;
		try {
			String sql = "select * from user where email=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean checkOldPasssword(int id, String oldpass) {
		boolean f = false;
		try {
			String sql = "select * from user where id=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, oldpass);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean updateNewPasssword(int id, String newpass) {
		boolean f = false;
		try {
			String sql = "update user set password=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, newpass);
			ps.setInt(2, id);
			int a = ps.executeUpdate();
			if (a == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean checkEmailAndMobForForgot(String email, String mobNo) {
		boolean f = false;
		try {
			String sql = "select * from user where email=? and mobno=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, mobNo);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean resetPasssword(String newpass, String email) {
		boolean f = false;
		try {
			String sql = "update user set password=? where email=?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, newpass);
			ps.setString(2, email);

			int a = ps.executeUpdate();

			if (a == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<User> getAllUser() {
		User user = null;
		List<User> list = new ArrayList<User>();
		try {
			String sql = "select * from user order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt(1));
				user.setFullName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setMobNo(rs.getString(4));
				user.setPassword(rs.getString(5));
				user.setAddress(rs.getString(6));
				user.setCity(rs.getString(7));
				user.setState(rs.getString(8));
				user.setPin(rs.getString(9));
				user.setImage(rs.getString(10));
				user.setUser(rs.getString(11));
				user.setIdProof(rs.getString(12));
				list.add(user);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean deleteUser(int id) {
		boolean f = false;
		try {
			String sql = "delete from user where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, id);

			int a = ps.executeUpdate();

			if (a == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean saveBooking(Booking booking) {
		boolean f = false;

		try {
			String sql = "insert into booking(name,email,address,idProof,student,college,payment,status,userId,roomId,ownerId,bookingDate) values(?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, booking.getName());
			ps.setString(2, booking.getEmail());
			ps.setString(3, booking.getAddress());
			ps.setString(4, booking.getIdProof());
			ps.setString(5, booking.getStudent());
			ps.setString(6, booking.getCollege());
			ps.setString(7, "No");
			ps.setString(8, booking.getStatus());
			ps.setInt(9, booking.getUserId());
			ps.setInt(10, booking.getRoomId());
			ps.setInt(11, booking.getOwnerId());
			ps.setString(12, LocalDate.now().toString());
			int id = ps.executeUpdate();
			if (id == 1)
				f = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<Booking> getBookingByOwner(int ownerId) {
		List<Booking> bookings = new ArrayList<Booking>();
		try {
			String sql = "select * from booking where ownerId=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ownerId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Booking b = new Booking();
				b.setId(rs.getInt(1));
				b.setName(rs.getString(2));
				b.setEmail(rs.getString(3));
				b.setAddress(rs.getString(4));
				b.setIdProof(rs.getString(5));
				b.setStudent(rs.getString(6));
				b.setCollege(rs.getString(7));
				b.setPayment(rs.getString(8));
				b.setStatus(rs.getString(9));
				b.setUserId(rs.getInt(10));
				b.setRoomId(rs.getInt(11));
				b.setOwnerId(rs.getInt(12));
				b.setBookingDate(rs.getString(13));
				bookings.add(b);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return bookings;
	}

	public List<Booking> getBookingByUser(int userId) {
		List<Booking> bookings = new ArrayList<Booking>();
		try {
			String sql = "select * from booking where userId=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Booking b = new Booking();
				b.setId(rs.getInt(1));
				b.setName(rs.getString(2));
				b.setEmail(rs.getString(3));
				b.setAddress(rs.getString(4));
				b.setIdProof(rs.getString(5));
				b.setStudent(rs.getString(6));
				b.setCollege(rs.getString(7));
				b.setPayment(rs.getString(8));
				b.setStatus(rs.getString(9));
				b.setUserId(rs.getInt(10));
				b.setRoomId(rs.getInt(11));
				b.setOwnerId(rs.getInt(12));
				b.setBookingDate(rs.getString(13));
				bookings.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookings;
	}

	public boolean updateBookingStatus(int id, String status) {
		boolean f = false;

		try {
			String sql = "update booking set status=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, status);
			ps.setInt(2, id);

			int update = ps.executeUpdate();
			if (update == 1)
				f = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean updateBookingPayment(int id, String payment) {
		boolean f = false;

		try {
			String sql = "update booking set payment=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, payment);
			ps.setInt(2, id);

			int update = ps.executeUpdate();
			if (update == 1)
				f = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

}