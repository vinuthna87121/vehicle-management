package com.vehiclemanagement.vehicle.management.domain;


	
	

	public class Vehicle {
	    private int id;
	    private String model;
	    private String brand;
	    private String registrationNumber;
	    private String type;
	    private String color;
	    private int year;
	    private String ownerName;
	    private String status;

	    // Constructors
	    public Vehicle() {
	    }

	    public Vehicle(int id, String model, String brand, String registrationNumber, String type, String color, int year, String ownerName, String status) {
	        this.id = id;
	        this.model = model;
	        this.brand = brand;
	        this.registrationNumber = registrationNumber;
	        this.type = type;
	        this.color = color;
	        this.year = year;
	        this.ownerName = ownerName;
	        this.status = status;
	    }

	    // Getters and Setters
	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getModel() {
	        return model;
	    }

	    public void setModel(String model) {
	        this.model = model;
	    }

	    public String getBrand() {
	        return brand;
	    }

	    public void setBrand(String brand) {
	        this.brand = brand;
	    }

	    public String getRegistrationNumber() {
	        return registrationNumber;
	    }

	    public void setRegistrationNumber(String registrationNumber) {
	        this.registrationNumber = registrationNumber;
	    }

	    public String getType() {
	        return type;
	    }

	    public void setType(String type) {
	        this.type = type;
	    }

	    public String getColor() {
	        return color;
	    }

	    public void setColor(String color) {
	        this.color = color;
	    }

	    public int getYear() {
	        return year;
	    }

	    public void setYear(int year) {
	        this.year = year;
	    }

	    public String getOwnerName() {
	        return ownerName;
	    }

	    public void setOwnerName(String ownerName) {
	        this.ownerName = ownerName;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }

	    @Override
	    public String toString() {
	        return "Vehicle{" +
	                "id=" + id +
	                ", model='" + model + '\'' +
	                ", brand='" + brand + '\'' +
	                ", registrationNumber='" + registrationNumber + '\'' +
	                ", type='" + type + '\'' +
	                ", color='" + color + '\'' +
	                ", year=" + year +
	                ", ownerName='" + ownerName + '\'' +
	                ", status='" + status + '\'' +
	                '}';
	    }
	}

