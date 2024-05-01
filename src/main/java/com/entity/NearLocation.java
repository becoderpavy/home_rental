package com.entity;

public class NearLocation {

	private int id;
	private int roomId;
	private String name;
	private String distance;

	public NearLocation(int id, int roomId, String name, String distance) {
		super();
		this.id = id;
		this.roomId = roomId;
		this.name = name;
		this.distance = distance;
	}

	public NearLocation() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

}
