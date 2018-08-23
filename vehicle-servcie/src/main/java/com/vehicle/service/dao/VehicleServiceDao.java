package com.vehicle.service.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.vehicle.service.mapper.VehicleServiceMapper;
import com.vehicle.service.model.ServiceVehicle;
import com.vehicle.service.util.SessionUtil;

@Repository
public class VehicleServiceDao {
		
	public int insertServiceVehicle(ServiceVehicle vehicleService){
		int id=-1;
		if(null != vehicleService) {
	  SqlSession session = SessionUtil.getSqlSessionFactory().openSession();	
	  VehicleServiceMapper mapper = session.getMapper(VehicleServiceMapper.class);
	  id= mapper.insertServiceVehicle(vehicleService);
	  session.commit();
	  session.close();
		}
	  return id;
	}
	
	public static List<ServiceVehicle> getListOfServiceVehicles(){
		List<ServiceVehicle> serviceVehicles = null;		
	  SqlSession session = SessionUtil.getSqlSessionFactory().openSession();	
	  VehicleServiceMapper mapper = session.getMapper(VehicleServiceMapper.class);
	  serviceVehicles= mapper.getListOfServiceVehicles();
	  session.commit();
	  session.close();
		
	  return serviceVehicles;
	}
}
