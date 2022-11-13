package com.drones.controller;

import com.drones.business.*;
import com.drones.business.request.LoadMedicationRequest;
import com.drones.business.request.Request;
import com.drones.model.Drone;
import com.drones.model.Medication;
import com.drones.util.AppConstant;
import com.drones.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/drone")
public class DroneController {


    @Autowired
    RegisterDroneService registerDrone;
    @Autowired
    LoadMedicationService loadMedicationService;
    @Autowired
    ListMedicationService listMedicationService;

    @Autowired
    GetBatteryLevelService getBatteryLevelService;
    @Autowired
    GetAvailableDronesService getAvailableDronesService;

    @Autowired
    GetDroneService getDroneService;

    @PostMapping()
    public  Response<Void> register(@RequestBody @Valid Drone drone) {
        return Response.<Void>builder().message(AppConstant.SUCCESS_MSG)
                .status(AppConstant.SUCCESS_CODE)
                .body( registerDrone.execute(drone)).build();
    }
    @PutMapping(value = "/{serialNumber}")
    public Response<Void> loadMedication(@PathVariable String serialNumber,
                               @RequestBody List<@Valid Medication> medicationList) {
        return Response.<Void>builder().message(AppConstant.SUCCESS_MSG)
                .status(AppConstant.SUCCESS_CODE)
                .body(loadMedicationService.execute(LoadMedicationRequest.builder().serialNumber(serialNumber).medicationList(medicationList).build())).build();
    }

    @GetMapping(value = "/{serialNumber}")
    public Response<Drone> getDrone(@PathVariable String serialNumber) {
        return Response.<Drone>builder().message(AppConstant.SUCCESS_MSG)
                .status(AppConstant.SUCCESS_CODE)
                .body(getDroneService.execute(serialNumber)).build();
    }
    @GetMapping(value = "/{serialNumber}/medication")
    public @ResponseBody Response<List<Medication>> getMedication(@PathVariable String serialNumber) {
        return Response.<List<Medication>>builder().message(AppConstant.SUCCESS_MSG)
                .status(AppConstant.SUCCESS_CODE)
                .body(listMedicationService.execute(Request.builder().serialNumber(serialNumber).build()) ).build();

    }

    @GetMapping(value = "/{serialNumber}/battery")
    public @ResponseBody Response<Double> getBatteryLevel(@PathVariable String serialNumber) {
        return Response.<Double>builder().message(AppConstant.SUCCESS_MSG)
                .status(AppConstant.SUCCESS_CODE)
                .body( getBatteryLevelService.execute(Request.builder().serialNumber(serialNumber).build())).build();
    }

    @GetMapping(value = "/available")
    public @ResponseBody Response<List<Drone> >  getAvailableDrone() {
        return Response.<List<Drone> >builder().message(AppConstant.SUCCESS_MSG)
                .status(AppConstant.SUCCESS_CODE)
                .body( getAvailableDronesService.execute(null)).build();
    }
}
