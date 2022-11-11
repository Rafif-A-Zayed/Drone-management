package com.drones.controller;

import com.drones.business.*;
import com.drones.model.Drone;
import com.drones.model.Medication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping()
    public void register(@RequestBody Drone drone) {
        registerDrone.execute(drone);
    }
    @PostMapping(value = "/{serialNumber}")
    public void loadMedication(@PathVariable String serialNumber,
                               @RequestBody List<Medication> medicationList) {
        loadMedicationService.execute(LoadMedicationRequest.builder().serialNumber(serialNumber).medicationList(medicationList).build());
    }
    @GetMapping(value = "/{serialNumber}/medication")
    public @ResponseBody List<Medication> getMedication(@PathVariable String serialNumber) {
       return listMedicationService.execute(serialNumber);
    }

    @GetMapping(value = "/{serialNumber}/battery")
    public @ResponseBody Double getBatteryLevel(@PathVariable String serialNumber) {
        return getBatteryLevelService.execute(serialNumber);
    }

    @GetMapping(value = "/available")
    public @ResponseBody List<Drone> getAvailableDrone() {
        return getAvailableDronesService.execute(null);
    }
}
