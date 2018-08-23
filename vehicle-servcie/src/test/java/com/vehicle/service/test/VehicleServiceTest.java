package com.vehicle.service.test;

import com.vehicle.service.dao.OwnerTypeDao;
import com.vehicle.service.dao.VehicleServiceDao;
import com.vehicle.service.dao.VehicleTypeDao;
import com.vehicle.service.exception.NotAValidOwnerException;
import com.vehicle.service.model.ServiceVehicle;
import com.vehicle.service.service.VehicleServiceService;

public class VehicleServiceTest {
	public static void main(String[] args) throws NotAValidOwnerException {
		VehicleServiceDao vehicleServiceDao = new VehicleServiceDao();
		OwnerTypeDao ownertypeDao = new OwnerTypeDao();
		VehicleTypeDao vehicleTypeDao = new VehicleTypeDao();
		VehicleServiceService service = new VehicleServiceService(vehicleServiceDao,ownertypeDao,vehicleTypeDao);
		ServiceVehicle serviceVehicle =new ServiceVehicle();
		serviceVehicle.setModel("2018");
		serviceVehicle.setOwner_id(5);
		serviceVehicle.setVehicle_number("TN22DJ2018");
		serviceVehicle.setVehicle_type_id(4);
		
		System.out.println("Service request is " +service.enrollVehicleForService(serviceVehicle));
	}
}
