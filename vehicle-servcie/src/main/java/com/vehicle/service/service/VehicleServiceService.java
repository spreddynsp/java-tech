package com.vehicle.service.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicle.service.dao.OwnerTypeDao;
import com.vehicle.service.dao.VehicleServiceDao;
import com.vehicle.service.dao.VehicleTypeDao;
import com.vehicle.service.exception.NotAValidOwnerException;
import com.vehicle.service.model.Owner;
import com.vehicle.service.model.ServiceVehicle;

@Service
public class VehicleServiceService {
	Logger log =Logger.getLogger(VehicleServiceService.class.getName());
	
	@Autowired
	private VehicleServiceDao vehicleServiceDao; //=new VehicleServiceDao();
	private OwnerTypeDao ownertypeDao;// = new OwnerTypeDao();
	private VehicleTypeDao vehicleTypeDao;// =new VehicleTypeDao();
	
	public VehicleServiceService(VehicleServiceDao vehicleServiceDao, OwnerTypeDao ownertypeDao, VehicleTypeDao vehicleTypeDao) {
		this.vehicleServiceDao = vehicleServiceDao;
		this.ownertypeDao=ownertypeDao;
		this.vehicleTypeDao=vehicleTypeDao;
	}
	
	public int enrollVehicleForService(ServiceVehicle serviceVehicle) throws NotAValidOwnerException {
		Owner owner=null;
		int InsertInd=1;
		if(null != serviceVehicle) {		
		log.logp(Level.INFO, "VehicleServiceService", "enrollVehicleForService", "entered into enrollVehicleForService");
				
		if(0 < serviceVehicle.getOwner_id()) {
			owner = ownertypeDao.getVehicleOwner(serviceVehicle.getOwner_id());
		}else {
			throw new NotAValidOwnerException();
		}
		
		if(owner.getCity().equals("AMARAVATHI")) {
			ownertypeDao.deleteVehicleOwner(serviceVehicle.getOwner_id());
				
			}
		if(0 < serviceVehicle.getVehicle_type_id()) {
			vehicleTypeDao.getVehicleType(serviceVehicle.getVehicle_type_id()); 
		}
		InsertInd = vehicleServiceDao.insertServiceVehicle(serviceVehicle);
		}else {
			throw new NotAValidOwnerException();
		}
		
		
		log.logp(Level.INFO, "VehicleServiceService", "enrollVehicleForService", "Exit from enrollVehicleForService");
		return InsertInd;
	}
	
	public List<ServiceVehicle> getAllServcieVehicleList() {
		List<ServiceVehicle> serviceVehicle = null;
		log.logp(Level.INFO, "VehicleServiceService", "getAllServcieVehicleList", "entered into getAllServcieVehicleList");
		serviceVehicle = VehicleServiceDao.getListOfServiceVehicles();	
		log.logp(Level.INFO, "VehicleServiceService", "getAllServcieVehicleList", "Exit from getAllServcieVehicleList");
		return serviceVehicle;		
	}
}
