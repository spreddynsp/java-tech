package com.vehicle.service.model;

public class VehicleServiceRequest {
	
	private int request_id;
	private String VehicleType;
	private String owner_first_name;
	private String owner_last_name;
	private String model;
	private String vehicle_number;
	public int getRequest_id() {
		return request_id;
	}
	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}
	public String getVehicleType() {
		return VehicleType;
	}
	public void setVehicleType(String vehicleType) {
		VehicleType = vehicleType;
	}
	public String getOwner_first_name() {
		return owner_first_name;
	}
	public void setOwner_first_name(String owner_first_name) {
		this.owner_first_name = owner_first_name;
	}
	public String getOwner_last_name() {
		return owner_last_name;
	}
	public void setOwner_last_name(String owner_last_name) {
		this.owner_last_name = owner_last_name;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getVehicle_number() {
		return vehicle_number;
	}
	public void setVehicle_number(String vehicle_number) {
		this.vehicle_number = vehicle_number;
	}
	
	

}
