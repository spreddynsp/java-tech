package com.vehicle.service.mockito;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import com.vehicle.service.dao.OwnerTypeDao;
import com.vehicle.service.dao.VehicleServiceDao;
import com.vehicle.service.dao.VehicleTypeDao;
import com.vehicle.service.exception.NotAValidOwnerException;
import com.vehicle.service.model.ServiceVehicle;
import com.vehicle.service.service.VehicleServiceService;


@RunWith(MockitoJUnitRunner.class)
public class VehicleServiceServiceTest1 {
	
	Logger log =Logger.getLogger(VehicleServiceServiceTest1.class.getName());
	
	@Mock
	VehicleServiceDao vehicleServiceDao;
	@Mock
	OwnerTypeDao ownertypeDao;
	@Mock
	VehicleTypeDao vehicleTypeDao;
	
	@InjectMocks
	VehicleServiceService vehicleServiceService;
	ServiceVehicle serviceVehicle=null;
	@Spy
	ArrayList<ServiceVehicle> serviceVehiclesSpy=null;
	
	@Before
	public void setup() {
		serviceVehicle =  new ServiceVehicle();
		serviceVehicle.setId(20);
		serviceVehicle.setModel("2018");
		serviceVehicle.setVehicle_number("TN23DE9203");
		serviceVehicle.setOwner_id(2);
		serviceVehicle.setVehicle_type_id(3);
		
		
	}
	
	@Test(expected = NotAValidOwnerException.class)
	public void testNotAValidOwnerException() throws NotAValidOwnerException {
		
		
		doThrow(new NotAValidOwnerException()).when(ownertypeDao).getVehicleOwner(2);
		vehicleServiceService.enrollVehicleForService(serviceVehicle);
	}
	
	public void testLIstOFServcies() {
		//serviceVehiclesSpy= new ArrayList<ServiceVehicle>();
			
		serviceVehiclesSpy = (ArrayList<ServiceVehicle>) vehicleServiceService.getAllServcieVehicleList();
		
		when(serviceVehiclesSpy.size()).thenReturn(20);
		when(serviceVehiclesSpy.get(2)).thenReturn(serviceVehicle);
		Assert.assertEquals(20, serviceVehiclesSpy.size());
		
		
		
		
		
		}
	}
		