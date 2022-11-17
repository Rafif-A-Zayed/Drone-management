package com.drones.controller;



import com.drones.business.v1.*;
import com.drones.controller.v1.DroneController;
import com.drones.repository.DroneRepository;
import com.drones.service.DroneService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = DroneController.class)
public class DroneControllerTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    RegisterDroneService registerDroneService;
    @MockBean
    LoadMedicationService loadMedicationService;
    @MockBean
    ListMedicationService listMedicationService;
    @MockBean
    GetBatteryLevelService getBatteryLevelService;
    @MockBean
    GetAvailableDronesService getAvailableDronesService;
    @MockBean
    GetDroneService getDroneService;

    @MockBean
    DroneService droneService;
    @MockBean
    DroneRepository droneRepository;

    @Test
    void testRegisterDrone() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/v1/drone").contentType(MediaType.APPLICATION_JSON_VALUE).content("{\n" +
                "\t\"serialNumber\":\"serial-A-1\",\n" +
                "\t\"wight\": 100,\n" +
                "\t\"capacity\": 50,\n" +
                "\t\"model\":\"Lightweight\"\n" +
                "}");
        mvc.perform(request).andExpect(status().isOk());

    }

    @Test
    void testLoadMedication() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.put("/v1/drone/ser1").contentType(MediaType.APPLICATION_JSON_VALUE).content("[{\n" +
                "\t\"code\":\"med-A-1\",\n" +
                "\t\"name\": \"_$sdddff\",\n" +
                "\t\"wight\": 50.0,\n" +
                "\t\"image\":\"Lightweight\"\n" +
                "}]");
        mvc.perform(request).andExpect(status().isOk());

    }



    @Test
    void testGetDrone() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/v1/drone/ser1");
          mvc.perform(request).andExpect(status().isOk());


    }

    @Test
    void testGetMedication() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/v1/drone/ser1/medication");
        mvc.perform(request).andExpect(status().isOk());

    }

    @Test
    void testGetBatteryLevel() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/v1/drone/ser1/battery");
        mvc.perform(request).andExpect(status().isOk());

    }

    @Test
    void testGetAvailableDrone() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/v1/drone/available");
        mvc.perform(request).andExpect(status().isOk());

    }


}
