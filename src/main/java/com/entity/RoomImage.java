package com.entity;

public class RoomImage {

	private int id;

	private int roomId;

	private String image;

	public RoomImage(int roomId, String image) {
		super();
		this.roomId = roomId;
		this.image = image;
	}

	public RoomImage(int id, int roomId, String image) {
		super();
		this.id = id;
		this.roomId = roomId;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
