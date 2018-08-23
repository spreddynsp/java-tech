package com.vehicle.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.vehicle.service.exception.NotAValidOwnerException;
import com.vehicle.service.model.ServiceVehicle;
import com.vehicle.service.service.VehicleServiceService;

@Controller
public class VehicleServiceController {
	@Autowired
	private VehicleServiceService vehicleService;
	
	@GetMapping("/vehicleServiceForm")
    public String initNewServiceForm() {
		
        return "vehicleServieForm";
    }

    @PostMapping("/VehicleServcie")
    public String processNewVisitForm(ServiceVehicle serviceVehicle) throws NotAValidOwnerException {
    	
		if(serviceVehicle !=null) {
			vehicleService.enrollVehicleForService(serviceVehicle);
		}
		return null;
        
         
    }

}
