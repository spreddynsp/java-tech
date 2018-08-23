package com.vehicle.service.cache;

import com.vehicle.service.dao.OwnerTypeDao;
import com.vehicle.service.dao.ServiceMenDao;
import com.vehicle.service.dao.ServiceTypeDao;
import com.vehicle.service.dao.VehicleServiceDao;
import com.vehicle.service.model.ServiceType;

public class CacheLoader {

	private static Cache<Object,Object>  cache=ServiceCache.getInstance();
	
	public static  void loadDataIntoServiceCache() {
		
		cache.put("OWNERS", OwnerTypeDao.getListOfVehicleOwners());
		System.out.println("OWNERS retrived");
		cache.put("SERVICEMEN", ServiceMenDao.getListOfServiceMen());
		System.out.println("SERVICEMEN retrived");
		cache.put("SERVICETYPE", ServiceTypeDao.getAllServices());
		System.out.println("SERVICETYPE retrived");
		cache.put("SERVICEVEHICLE",VehicleServiceDao.getListOfServiceVehicles() );
		System.out.println("SERVICEVEHICLE retrived");
				
	}
	public static void main(String[] args) {
		loadDataIntoServiceCache();
	}
}
