package com.vehicle.service.dao;

import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.vehicle.service.mapper.ServiceMenMapper;
import com.vehicle.service.model.ServiceMan;
import com.vehicle.service.util.SessionUtil;

@Repository("serviceMenDao")
public class ServiceMenDao {
	public int insertServiceMan(ServiceMan serviceMan){
		int flag=-1;
		if(null != serviceMan) {
	  SqlSession session = SessionUtil.getSqlSessionFactory().openSession();	
	  ServiceMenMapper mapper = session.getMapper(ServiceMenMapper.class);
	  flag= mapper.addServcieMan(serviceMan);
	  session.commit();
	  session.close();
		}
	  return flag;
	}
	
	public static List<ServiceMan> getListOfServiceMen(){
		List<ServiceMan> serviceMen = null;
	  SqlSession session = SessionUtil.getSqlSessionFactory().openSession();	
	  ServiceMenMapper mapper = session.getMapper(ServiceMenMapper.class);
	  serviceMen= mapper.retriveServcieMen();
	  session.commit();
	  session.close();
	
		return serviceMen;
	}

	public int deleteServiceMan(int id){
		int is_deleted = 0;
		if(0 > id) {
		try {
	  SqlSession session = SessionUtil.getSqlSessionFactory().openSession();	
	  ServiceMenMapper mapper = session.getMapper(ServiceMenMapper.class);
	  is_deleted= mapper.deleteServiceMan(id);
	  session.commit();
	  session.close();
		}catch(Exception e) {
			
		}
		}
		
	  return is_deleted;
	}

}
