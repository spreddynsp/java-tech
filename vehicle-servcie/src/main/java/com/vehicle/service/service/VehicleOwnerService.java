package com.vehicle.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicle.service.dao.OwnerTypeDao;
import com.vehicle.service.exception.NotAValidOwnerException;
import com.vehicle.service.model.Owner;

@Service
public class VehicleOwnerService {
	@Autowired
	private OwnerTypeDao ownerTypeDao;
	
	public Owner getVehicleOwner(int id) throws NotAValidOwnerException{
		Owner owner = null;
		if(0 >id) {
			owner =ownerTypeDao.getVehicleOwner(id);
		}		
		return owner;
	}
	
	public  List<Owner>  getAllVehicleOwners() {
		List<Owner> owners = null;
		owners = OwnerTypeDao.getListOfVehicleOwners();
		
		return owners;
	}
}
