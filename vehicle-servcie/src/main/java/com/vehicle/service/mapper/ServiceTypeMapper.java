package com.vehicle.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.vehicle.service.model.ServiceType;
@Component
public interface ServiceTypeMapper {
	
	static final String insertNewService = "INSERT  INTO SERVICES(ID,SERVICE) VALUES (#{id}, #{service})";
	
	static final String getAllServices = "SELECT ID,SERVICE FROM SERVICES";
	
	static final String getServiceById = "SELECT ID,SERVICE FROM SERVICES WHERE ID=#{service_id}";
	@Results({
        @Result(property = "service_id", column = "ID"),
        @Result(property = "service_name", column = "SERVICE")
       })
	@Select(getAllServices)
	public List<ServiceType> getAllServices();
	
	@Results({
        @Result(property = "service_id", column = "ID"),
        @Result(property = "service_name", column = "SERVICE")
       })
	
	@Select(getServiceById)
	public ServiceType getServcie(int service_id);
	
	@Insert(insertNewService)
	public int insertNewService(ServiceType servieType);
	
	

}
