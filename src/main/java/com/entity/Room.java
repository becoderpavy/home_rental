package com.entity;

public class Room {

	private int id;
	private String title;
	private String category;
	private String roomType;
	private String description;
	private String email;
	private String mobileNumber;
	private Double monthlyCost;
	private String locationLink;
	private String distance;
	private String address;
	private String city;
	private String state;
	private String pincode;
	private int ownerId;
	private String status;

	public Room() {
		super();
	}

	public Room(String title, String category, String roomType, String description, String email, String mobileNumber,
			Double monthlyCost, String locationLink, String distance, String address, String city, String state,
			String pincode, int ownerId) {
		super();
		this.title = title;
		this.category = category;
		this.roomType = roomType;
		this.description = description;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.monthlyCost = monthlyCost;
		this.locationLink = locationLink;
		this.distance = distance;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.ownerId = ownerId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Double getMonthlyCost() {
		return monthlyCost;
	}

	public void setMonthlyCost(Double monthlyCost) {
		this.monthlyCost = monthlyCost;
	}

	public String getLocationLink() {
		return locationLink;
	}

	public void setLocationLink(String locationLink) {
		this.locationLink = locationLink;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

}
