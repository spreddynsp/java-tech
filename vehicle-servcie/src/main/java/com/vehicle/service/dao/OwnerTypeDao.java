package com.vehicle.service.dao;

import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.vehicle.service.exception.NotAValidOwnerException;
import com.vehicle.service.mapper.OwnerMapper;
import com.vehicle.service.model.Owner;
import com.vehicle.service.util.SessionUtil;

@Repository("ownerTypeDaoImpl")
public class OwnerTypeDao {

	public int insertServiceMan(Owner owner){
		int flag = -1;
		if(null != owner) {
	  SqlSession session = SessionUtil.getSqlSessionFactory().openSession();	
	  OwnerMapper mapper = session.getMapper(OwnerMapper.class);
	 mapper.addVehicleOwner(owner);
	  session.commit();
	  session.close();
		}
	  return flag;
	}
	
	public static List<Owner> getListOfVehicleOwners(){
		List<Owner> owners = null;
		
	  SqlSession session = SessionUtil.getSqlSessionFactory().openSession();	
	  OwnerMapper mapper = session.getMapper(OwnerMapper.class);
	  owners= mapper.retriveVehicleOwners();	 
	  session.commit();
	  session.close();
	  if(null != owners) {
		  //return Arrays.asList(owners);
	  }
		
	  return owners;
	}
	
	public Owner getVehicleOwner(int id) throws NotAValidOwnerException {
		Owner owner = null;
		if(0 < id) {
		  SqlSession session = SessionUtil.getSqlSessionFactory().openSession();	
		  OwnerMapper mapper = session.getMapper(OwnerMapper.class);
		  owner= mapper.getVehicleOwner(id);	 
		  session.commit();
		  session.close();
		}
		return owner;
	}

	public int deleteVehicleOwner(int id){
		int is_deleted = 0;
		if(0 < id) {
		try {
	  SqlSession session = SessionUtil.getSqlSessionFactory().openSession();	
	  OwnerMapper mapper = session.getMapper(OwnerMapper.class);
	  is_deleted= mapper.deleteVehicleOwner(id);
	  session.commit();
	  session.close();
		}catch(Exception e) {
			
		}
		}
		
	  return is_deleted;
	}
}
