package com.vehicle.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.stereotype.Component;

import com.vehicle.service.model.ServiceVehicle;

@Component
public interface VehicleServiceMapper {
	
	static final String insertServcieVehicle="INSERT  INTO SERVICE_VEHICLES (ID, V_NUMBER, MODEL, vehicle_TYPE_id, owner_id) VALUES (#{id}, #{vehicle_number}, #{model}, #{vehicle_type_id}, #{owner_id})";
	static final String getListOfServiceVehicles="SELECT ID, V_NUMBER, MODEL, VEHICLE_TYPE_ID, OWNER_ID FROM SERVICE_VEHICLES";	
		@Insert(insertServcieVehicle)
		@SelectKey(statement="SELECT SERVICE_VEHICLES_SEQ.NEXTVAL FROM DUAL", resultType = int.class, before = true, keyProperty = "id")
		@Options(useGeneratedKeys=true, keyProperty="id", keyColumn="ID")
		public int insertServiceVehicle(ServiceVehicle serviceVehicle);
		
		@Results({
			 @Result(property = "id", column = "ID"),
	        @Result(property = "vehicle_number", column = "V_NUMBER"),
	        @Result(property = "model", column = "MODEL"),
	        @Result(property = "vehicle_type_id", column = "VEHICLE_TYPE_ID"),
	        @Result(property = "owner_id", column = "OWNER_ID")
		})
		@Select(getListOfServiceVehicles)
		public List<ServiceVehicle> getListOfServiceVehicles();
	}
