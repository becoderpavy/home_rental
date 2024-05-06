package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.entity.Category;
import com.entity.NearLocation;
import com.entity.Room;
import com.entity.RoomImage;
import com.entity.RoomType;

public class RoomDAO {

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	public RoomDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public List<Category> getAllCategory() {
		List<Category> list = new ArrayList<>();
		try {
			String sql = "select * from category";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Category ca = new Category(rs.getInt(1), rs.getString(2));
				list.add(ca);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<RoomType> getAllRoomType() {
		List<RoomType> list = new ArrayList<>();
		try {
			String sql = "select * from room_type";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				RoomType ca = new RoomType(rs.getInt(1), rs.getString(2));
				list.add(ca);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public int saveRoom(Room room) {
		int id = 0;
		try {
			String sql = "insert into room(title,category,roomType,description,email,mobileNumber,monthlyCost,locationLink,distance,address,city,state,pincode,ownerId,status) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, room.getTitle());
			ps.setString(2, room.getCategory());
			ps.setString(3, room.getRoomType());
			ps.setString(4, room.getDescription());
			ps.setString(5, room.getEmail());
			ps.setString(6, room.getMobileNumber());
			ps.setDouble(7, room.getMonthlyCost());
			ps.setString(8, room.getLocationLink());
			ps.setString(9, room.getDistance());
			ps.setString(10, room.getAddress());
			ps.setString(11, room.getCity());
			ps.setString(12, room.getState());
			ps.setString(13, room.getPincode());
			ps.setInt(14, room.getOwnerId());
			ps.setString(15, "Available");
			int save = ps.executeUpdate();
			if (save == 1) {
				ResultSet generatedKeys = ps.getGeneratedKeys();
				if (generatedKeys.next()) {
					id = generatedKeys.getInt(1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	public Boolean updateRoom(Room room) {
		Boolean f = false;
		try {
			String sql = "update room  set title=?,category=?,roomType=?,description=?,email=?,mobileNumber=?,monthlyCost=?,locationLink=?,distance=?,address=?,city=?,state=?,pincode=?,status=? where id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, room.getTitle());
			ps.setString(2, room.getCategory());
			ps.setString(3, room.getRoomType());
			ps.setString(4, room.getDescription());
			ps.setString(5, room.getEmail());
			ps.setString(6, room.getMobileNumber());
			ps.setDouble(7, room.getMonthlyCost());
			ps.setString(8, room.getLocationLink());
			ps.setString(9, room.getDistance());
			ps.setString(10, room.getAddress());
			ps.setString(11, room.getCity());
			ps.setString(12, room.getState());
			ps.setString(13, room.getPincode());
			ps.setString(14, room.getStatus());
			ps.setInt(15, room.getId());
			int save = ps.executeUpdate();
			if (save == 1)
				f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<Room> getAllRoom() {
		List<Room> rooms = null;
		try {
			String sql = "select * from room";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			rooms = getRoom(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rooms;
	}

	public List<Room> getRoomBySearch(String ch) {
		List<Room> rooms = null;
		String sql = "select * from room where title like ? or description like ? or category like ? or roomType like ? or  address like ? or city like ? or pincode like ? or state like ? order by id desc";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + ch + "%");
			ps.setString(2, "%" + ch + "%");
			ps.setString(3, "%" + ch + "%");
			ps.setString(4, "%" + ch + "%");
			ps.setString(5, "%" + ch + "%");
			ps.setString(6, "%" + ch + "%");
			ps.setString(7, "%" + ch + "%");
			ps.setString(8, "%" + ch + "%");
			rs = ps.executeQuery();
			rooms = getRoom(rs);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rooms;
	}

	public List<Room> getRoomByCategory(String category) {
		List<Room> rooms = null;
		try {
			String sql = "select * from room where category=?";
			ps.setString(1, category);
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			rooms = getRoom(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rooms;
	}

	public List<Room> getRoomByRoomType(String roomType) {
		List<Room> rooms = null;
		try {
			String sql = "select * from room where roomType=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, roomType);
			rs = ps.executeQuery();
			rooms = getRoom(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rooms;
	}

	public List<Room> getAllRoomByCategory(String category) {
		List<Room> rooms = null;
		try {
			String sql = "select * from room category=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, category);
			rs = ps.executeQuery();
			rooms = getRoom(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rooms;
	}

	public List<Room> getAllRoomByType(String roomType) {
		List<Room> rooms = null;
		try {
			String sql = "select * from room roomType=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, roomType);
			rs = ps.executeQuery();
			rooms = getRoom(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rooms;
	}

	private List<Room> getRoom(ResultSet rs) throws SQLException {
		List<Room> rooms = new ArrayList<>();
		while (rs.next()) {
			Room rm = new Room();
			rm.setId(rs.getInt(1));
			rm.setTitle(rs.getString(2));
			rm.setCategory(rs.getString(3));
			rm.setRoomType(rs.getString(4));
			rm.setDescription(rs.getString(5));
			rm.setEmail(rs.getString(6));
			rm.setMobileNumber(rs.getString(7));
			rm.setMonthlyCost(rs.getDouble(8));
			rm.setLocationLink(rs.getString(9));
			rm.setDistance(rs.getString(10));
			rm.setAddress(rs.getString(11));
			rm.setCity(rs.getString(12));
			rm.setState(rs.getString(13));
			rm.setPincode(rs.getString(14));
			rm.setOwnerId(rs.getInt(15));
			rm.setStatus(rs.getString(16));
			rooms.add(rm);
		}
		return rooms;
	}

	public Room getRoomDetailsById(int id) {
		Room rm = null;
		try {
			String sql = "select * from room where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				rm = new Room();
				rm.setId(rs.getInt(1));
				rm.setTitle(rs.getString(2));
				rm.setCategory(rs.getString(3));
				rm.setRoomType(rs.getString(4));
				rm.setDescription(rs.getString(5));
				rm.setEmail(rs.getString(6));
				rm.setMobileNumber(rs.getString(7));
				rm.setMonthlyCost(rs.getDouble(8));
				rm.setLocationLink(rs.getString(9));
				rm.setDistance(rs.getString(10));
				rm.setAddress(rs.getString(11));
				rm.setCity(rs.getString(12));
				rm.setState(rs.getString(13));
				rm.setPincode(rs.getString(14));
				rm.setOwnerId(rs.getInt(15));
				rm.setStatus(rs.getString(16));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rm;
	}

	public Boolean deleteRoom(int id) {
		boolean f = false;
		try {
			ps = conn.prepareStatement("delete from room where id=?");
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if (i == 1)
				f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean saveImage(RoomImage img) {
		boolean f = false;
		try {
			String sql = "insert into room_image(room_id,image) values(?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, img.getRoomId());
			ps.setString(2, img.getImage());
			int i = ps.executeUpdate();
			if (i == 1)
				f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<RoomImage> getRoomImageByRoomId(int roomid) {
		List<RoomImage> images = new ArrayList<>();
		try {
			String sql = "select * from room_image where room_id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, roomid);
			rs = ps.executeQuery();
			while (rs.next()) {
				RoomImage img = new RoomImage(rs.getInt(1), rs.getInt(2), rs.getString(3));
				images.add(img);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return images;
	}

	public Boolean deleteRoomImage(int id) {
		boolean f = false;
		try {
			ps = conn.prepareStatement("delete from room_image where id=?");
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if (i == 1)
				f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean saveNearLocation(NearLocation loc) {
		boolean f = false;
		try {
			String sql = "insert into near_location(room_id,name,distance) values(?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, loc.getRoomId());
			ps.setString(2, loc.getName());
			ps.setString(3, loc.getDistance());
			int i = ps.executeUpdate();
			if (i == 1)
				f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<NearLocation> getNearLocation(int roomid) {
		List<NearLocation> locations = new ArrayList<>();
		try {
			String sql = "select * from near_location where room_id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, roomid);
			rs = ps.executeQuery();
			while (rs.next()) {
				NearLocation loc = new NearLocation(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4));
				locations.add(loc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return locations;
	}

	public Boolean deleteLocation(int id) {
		boolean f = false;
		try {
			ps = conn.prepareStatement("delete from near_location where id=?");
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if (i == 1)
				f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

}
