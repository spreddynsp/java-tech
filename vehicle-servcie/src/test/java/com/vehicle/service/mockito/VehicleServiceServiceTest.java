package com.vehicle.service.mockito;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

import com.vehicle.service.dao.OwnerTypeDao;
import com.vehicle.service.dao.VehicleServiceDao;
import com.vehicle.service.dao.VehicleTypeDao;
import com.vehicle.service.exception.NotAValidOwnerException;
import com.vehicle.service.model.Owner;
import com.vehicle.service.model.ServiceVehicle;
import com.vehicle.service.service.VehicleServiceService;


@RunWith(MockitoJUnitRunner.class)
public class VehicleServiceServiceTest {
	@Mock
	VehicleServiceDao vehicleServiceDao;
	@Mock
	OwnerTypeDao ownertypeDao;
	@Mock
	VehicleTypeDao vehicleTypeDao;
	
	@InjectMocks
	VehicleServiceService vehicleServiceService;
	
	@Test
	public void testEnrollVehicleService() throws NotAValidOwnerException {
		ServiceVehicle serviceVehicle =  new ServiceVehicle();
		serviceVehicle.setId(20);
		serviceVehicle.setModel("2018");
		serviceVehicle.setVehicle_number("TN23DE9203");
		serviceVehicle.setOwner_id(2);
		serviceVehicle.setVehicle_type_id(3);
		
		Owner owner = new Owner();
		owner.setId(2);
		owner.setFirst_name("SALEEM");
		owner.setLast_name("BASHA");
		owner.setCity("CHENNAI");
		owner.setAddress("velachery");
		owner.setTelephone("234567876");
		
		
		
		when(ownertypeDao.getVehicleOwner(2)).thenReturn(owner);
		
		//when(ownertypeDao.deleteVehicleOwner(owner.getId())).thenReturn(1);
		
		//when(vehicleServiceService.enrollVehicleForService(serviceVehicle)).thenReturn(1);
		int expected =vehicleServiceService.enrollVehicleForService(serviceVehicle);
		
		verify(ownertypeDao, times(1)).getVehicleOwner(serviceVehicle.getOwner_id());
		verify(ownertypeDao, atLeastOnce()).getVehicleOwner(serviceVehicle.getOwner_id());
		verify(ownertypeDao, atLeast(1)).getVehicleOwner(serviceVehicle.getOwner_id());
		verify(ownertypeDao, atMost(1)).getVehicleOwner(serviceVehicle.getOwner_id());
		Assert.assertEquals(0, expected);
		
		
	}

	
}