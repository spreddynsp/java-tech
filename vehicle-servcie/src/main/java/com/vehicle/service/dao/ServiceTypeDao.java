package com.vehicle.service.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.vehicle.service.mapper.ServiceTypeMapper;
import com.vehicle.service.model.ServiceType;
import com.vehicle.service.util.SessionUtil;

@Repository
public class ServiceTypeDao {
	public static List<ServiceType> getAllServices() {
		List<ServiceType> serviceTypes = null;
		 SqlSession session = SessionUtil.getSqlSessionFactory().openSession();
		ServiceTypeMapper mapper = session.getMapper(ServiceTypeMapper.class);
		serviceTypes= mapper.getAllServices();	 
		  session.commit();
		  session.close();
		return serviceTypes;
		}
	public ServiceType getServcie(int service_id) {
		ServiceType serviceType = null;
		 SqlSession session = SessionUtil.getSqlSessionFactory().openSession();
		ServiceTypeMapper mapper = session.getMapper(ServiceTypeMapper.class);
		serviceType= mapper.getServcie(service_id);	 
		  session.commit();
		  session.close();		  
		  return serviceType;
	}
	public int insertNewService(ServiceType serviceType) {
		int isInserted=0;
		SqlSession session = SessionUtil.getSqlSessionFactory().openSession();
		ServiceTypeMapper mapper = session.getMapper(ServiceTypeMapper.class);
		isInserted= mapper.insertNewService(serviceType);	 
		  session.commit();
		  session.close();		  
		  return isInserted;
	}
}

