package com.vehicle.service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vehicle.service.dao.ServiceMenDao;
import com.vehicle.service.model.ServiceMan;

@Service("serviceManServcie")
public class ServiceManServcie {
	private ServiceMenDao serviceMenDao = null;
	
	public List<ServiceMan> getServiceMenDetails() {
		List<ServiceMan> serviceMen=null;
		
		serviceMen = ServiceMenDao.getListOfServiceMen();
		return serviceMen;
		}
	
	public int insertServiceMan(ServiceMan serviceMan) {
		int flag =0;
		if(null != serviceMan) {
			flag= serviceMenDao.insertServiceMan(serviceMan);
		}
		return flag;
	}
	
	public void deleteServiceMan(int id) {			
		if(0 < id) {
			serviceMenDao.deleteServiceMan(id);		
		
			}	
	}
}


