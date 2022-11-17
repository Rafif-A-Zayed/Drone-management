package com.drones.controller.v1;

import com.drones.business.*;
import com.drones.business.request.LoadMedicationRequest;
import com.drones.business.request.Request;
import com.drones.model.Drone;
import com.drones.model.Medication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "/v1/drone")
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
    public @ResponseBody Drone register(@RequestBody @Valid Drone drone) {
        return registerDrone.execute(drone);
    }
    @PutMapping(value = "/{serialNumber}")
    public Void loadMedication(@PathVariable String serialNumber,
                               @RequestBody Set<@Valid Medication> medicationList) {
        return loadMedicationService.execute(LoadMedicationRequest.builder().serialNumber(serialNumber).medicationList(medicationList).build());
    }

    @GetMapping(value = "/{serialNumber}")
    public Drone getDrone(@PathVariable String serialNumber) {
        return getDroneService.execute(serialNumber);
    }
    @GetMapping(value = "/{serialNumber}/medication")
    public @ResponseBody Set<Medication> getMedication(@PathVariable String serialNumber) {
        return listMedicationService.execute(Request.builder().serialNumber(serialNumber).build());

    }

    @GetMapping(value = "/{serialNumber}/battery")
    public @ResponseBody Double getBatteryLevel(@PathVariable String serialNumber) {
        return getBatteryLevelService.execute(Request.builder().serialNumber(serialNumber).build());
    }

    @GetMapping(value = "/available")
    public @ResponseBody List<Drone> getAvailableDrone() {
        return getAvailableDronesService.execute(null);
    }
}
