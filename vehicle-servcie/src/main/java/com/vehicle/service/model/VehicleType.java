package com.vehicle.service.model;

public class VehicleType {
	
	private int vehicle_id;
	private String vehicle_type;
	public int getVehicle_id() {
		return vehicle_id;
	}
	public void setVehicle_id(int vehicle_id) {
		this.vehicle_id = vehicle_id;
	}
	public String getVehicle_type() {
		return vehicle_type;
	}
	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}
	@Override
	public String toString() {
		return "Vehicles [vehicle_id=" + vehicle_id + ", vehicle_type=" + vehicle_type + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + vehicle_id;
		result = prime * result + ((vehicle_type == null) ? 0 : vehicle_type.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VehicleType other = (VehicleType) obj;
		if (vehicle_id != other.vehicle_id)
			return false;
		if (vehicle_type == null) {
			if (other.vehicle_type != null)
				return false;
		} else if (!vehicle_type.equals(other.vehicle_type))
			return false;
		return true;
	}
	

}
