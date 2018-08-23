package com.vehicle.service.model;

public class ServiceVehicle {		
		private int id;
		private String vehicle_number;
		private String model;
		private int vehicle_type_id;
		private int owner_id;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getVehicle_number() {
			return vehicle_number;
		}
		public void setVehicle_number(String vehicle_number) {
			this.vehicle_number = vehicle_number;
		}
		public String getModel() {
			return model;
		}
		public void setModel(String model) {
			this.model = model;
		}
		public int getVehicle_type_id() {
			return vehicle_type_id;
		}
		public void setVehicle_type_id(int vehicle_type_id) {
			this.vehicle_type_id = vehicle_type_id;
		}
		public int getOwner_id() {
			return owner_id;
		}
		public void setOwner_id(int owner_id) {
			this.owner_id = owner_id;
		}
		@Override
		public String toString() {
			return "ServiceVehicle [id=" + id + ", vehicle_number=" + vehicle_number + ", model=" + model
					+ ", vehicle_type_id=" + vehicle_type_id + ", owner_id=" + owner_id + "]";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + id;
			result = prime * result + ((model == null) ? 0 : model.hashCode());
			result = prime * result + owner_id;
			result = prime * result + ((vehicle_number == null) ? 0 : vehicle_number.hashCode());
			result = prime * result + vehicle_type_id;
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
			ServiceVehicle other = (ServiceVehicle) obj;
			if (id != other.id)
				return false;
			if (model == null) {
				if (other.model != null)
					return false;
			} else if (!model.equals(other.model))
				return false;
			if (owner_id != other.owner_id)
				return false;
			if (vehicle_number == null) {
				if (other.vehicle_number != null)
					return false;
			} else if (!vehicle_number.equals(other.vehicle_number))
				return false;
			if (vehicle_type_id != other.vehicle_type_id)
				return false;
			return true;
		}
		
 }
