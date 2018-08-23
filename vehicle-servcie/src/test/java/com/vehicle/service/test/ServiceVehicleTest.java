package com.vehicle.service.test;

import org.omg.CORBA.VersionSpecHelper;

import com.vehicle.service.cache.Cache;
import com.vehicle.service.cache.CacheLoader;
import com.vehicle.service.cache.ServiceCache;
import com.vehicle.service.model.VehicleServiceRequest;

public class ServiceVehicleTest {
	 private Cache<Object,Object>  cache=ServiceCache.getInstance();
	public static void main(String[] args) {
		
		CacheLoader.loadDataIntoServiceCache();
		
		VehicleServiceRequest vehicleServiceRequest= new VehicleServiceRequest();
		vehicleServiceRequest.setRequest_id(23);
		
		
		
	}

}
