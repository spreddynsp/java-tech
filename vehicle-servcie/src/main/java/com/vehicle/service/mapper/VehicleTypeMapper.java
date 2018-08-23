package com.vehicle.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.vehicle.service.model.VehicleType;

public interface VehicleTypeMapper {
	
	static final String insertNewService = "INSERT  INTO VEHICLES(VEHICLE_ID,VEHICLE_TYPE) VALUES (#{vehicle_id}, #{vehicle_type})";
	
	static final String getAllServices = "SELECT * FROM VEHICLES";
	
	static final String getServiceById = "SELECT VEHICLE_ID,VEHICLE_TYPE FROM SERVICES WHERE ID=#{vehicle_id}";
	@Results({
        @Result(property = "vehicle_id", column = "VEHICLE_ID"),
        @Result(property = "vehicle_type", column = "VEHICLE_TYPE")
       })
	@Select(getAllServices)
	public List<VehicleType> getAllVehicleTypes();
	
	@Results({
        @Result(property = "vehicle_id", column = "VEHICLE_ID"),
        @Result(property = "vehicle_type", column = "VEHICLE_TYPE")
       })
	
	@Select(getServiceById)
	public VehicleType getVehicleType(int vehicle_id);
	
	@Insert(insertNewService)
	public int insertVehicleType(VehicleType vehicle);
	
	}
