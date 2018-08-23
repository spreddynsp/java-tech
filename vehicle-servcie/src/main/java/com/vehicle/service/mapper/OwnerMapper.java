package com.vehicle.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.vehicle.service.model.Owner;


	@Component
	public interface OwnerMapper {
		static final String insertVehicleOwner = "INSERT  INTO owners (ID,FIRST_NAME,LAST_NAME,ADDRESS,CITY,TELEPHONE)VALUES (#{id}, #{first_name}, #{last_name}, #{address}, #{city}, #{telephone})";
		static final String retriveVehicleOwners = "SELECT ID, FIRST_NAME,LAST_NAME, ADDRESS,CITY,TELEPHONE FROM OWNERS";
		//static final String retriveVehicleOwners = "SELECT ID, FIRST_NAME,LAST_NAME, ADDRESS,CITY,TELEPHONE FROM OWNERS";
		static final String deleteVehicleOwner = "DELETE FROM OWNERS WHERE ID=#{id}";
		static final String getVehicleOwner = "SELECT ID, FIRST_NAME,LAST_NAME, ADDRESS,CITY,TELEPHONE FROM OWNERS WHERE ID = #{id}";
		
		@Insert(insertVehicleOwner)
		public int addVehicleOwner(Owner owner);
		
		@Results({
			@Result(property = "id", column = "ID"),
	        @Result(property = "first_name", column = "FIRST_NAME"),
	        @Result(property = "last_name", column = "LAST_NAME"),
	        @Result(property = "address", column = "ADDRESS"),
	        @Result(property = "city", column = "CITY"),
	        @Result(property = "telephone", column = "TELEPHONE")
	        
		})	
		@Select(retriveVehicleOwners)
		public List<Owner> retriveVehicleOwners();
		
		@Results({
			@Result(property = "id", column = "ID"),
	        @Result(property = "first_name", column = "FIRST_NAME"),
	        @Result(property = "last_name", column = "LAST_NAME"),
	        @Result(property = "address", column = "ADDRESS"),
	        @Result(property = "city", column = "CITY"),
	        @Result(property = "telephone", column = "TELEPHONE")
	        
		})	
		@Select(getVehicleOwner)
		public Owner getVehicleOwner(int id);
		
		@Delete(deleteVehicleOwner)
		public int deleteVehicleOwner(int id);
	}

	/*private int id;
	private String first_name;
	private String last_name;
	private String address;
	private String city;
	private String telephone;
*/

