package com.vehicle.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.vehicle.service.model.ServiceMan;
@Component
public interface ServiceMenMapper {
	static final String insertServiceMan = "INSERT  INTO SERVICEMEN(ID, FIRST_NAME, LAST_NAME) VALUES (#{id}, #{first_name}, #{last_name})";
	static final String retriveServcieMen="SELECT ID, FIRST_NAME,LAST_NAME FROM SERVICEMEN";
	static final String deleteServcieMen="DELETE FROM SERVICEMEN WHERE ID=#{id}";
	
	@Insert(insertServiceMan)
	public int addServcieMan(ServiceMan servcieMan);
	
	@Results({
		@Result(property = "id", column = "ID"),
        @Result(property = "first_name", column = "FIRST_NAME"),
        @Result(property = "last_name", column = "LAST_NAME")
	})	
	@Select(retriveServcieMen)
	public List<ServiceMan> retriveServcieMen();
	
	@Delete(deleteServcieMen)
	public int deleteServiceMan(int id);
}
