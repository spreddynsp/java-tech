package com.vehicle.service.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicle.service.dao.VehicleTypeDao;
import com.vehicle.service.mapper.VehicleTypeMapper;
import com.vehicle.service.model.VehicleType;
import com.vehicle.service.util.SessionUtil;

@Service
public class VehicleTypeService {
	@Autowired
	private VehicleTypeDao vehicleTypeDao;
	
	public static List<VehicleType> getAllServices() {
		List<VehicleType> VehicleTypes = null;
		 SqlSession session = SessionUtil.getSqlSessionFactory().openSession();
		VehicleTypeMapper mapper = session.getMapper(VehicleTypeMapper.class);
		VehicleTypes= mapper.getAllVehicleTypes();	 
		  session.commit();
		  session.close();
		return VehicleTypes;
		}
	public VehicleType getServcie(int vehicle_id) {
		VehicleType VehicleType = null;
		 SqlSession session = SessionUtil.getSqlSessionFactory().openSession();
		VehicleTypeMapper mapper = session.getMapper(VehicleTypeMapper.class);
		VehicleType= mapper.getVehicleType(vehicle_id);	 
		  session.commit();
		  session.close();		  
		  return VehicleType;
	}
	public int insertNewService(VehicleType VehicleType) {
		int isInserted=0;
		SqlSession session = SessionUtil.getSqlSessionFactory().openSession();
		VehicleTypeMapper mapper = session.getMapper(VehicleTypeMapper.class);
		isInserted= mapper.insertVehicleType(VehicleType);	 
		  session.commit();
		  session.close();		  
		  return isInserted;
	}
	
}
