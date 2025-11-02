package com.drones.controller;



import com.drones.business.v1.*;
import com.drones.controller.v1.DroneController;
import com.drones.repository.DroneRepository;
import com.drones.security.JwtTokenUtil;
import com.drones.service.DroneService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DroneControllerTest {

    @Autowired
    JwtTokenUtil JwtTokenUtil;
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
        String token = JwtTokenUtil.generateToken("test");
        RequestBuilder request = MockMvcRequestBuilders.post("/v1/drone")
                .header("Authorization", "Bearer " + token)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content("{\n" +
                "\t\"serialNumber\":\"serial-A-1\",\n" +
                "\t\"wight\": 100,\n" +
                "\t\"capacity\": 50,\n" +
                "\t\"model\":\"Lightweight\"\n" +
                "}");
        mvc.perform(request).andExpect(status().isOk());

    }

    @Test
    void testLoadMedication() throws Exception {
        String token = JwtTokenUtil.generateToken("test");
        RequestBuilder request = MockMvcRequestBuilders.put("/v1/drone/ser1")
                .header("Authorization", "Bearer " + token)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content("[{\n" +
                "\t\"code\":\"MED_A_1\",\n" +
                "\t\"name\": \"rafif\",\n" +
                "\t\"wight\": 50.0,\n" +
                "\t\"image\":\"Lightweight\"\n" +
                "}]");
        mvc.perform(request).andExpect(status().isOk());

    }



    @Test
    void testGetDrone() throws Exception {
        String token = JwtTokenUtil.generateToken("test");
        RequestBuilder request = MockMvcRequestBuilders.get("/v1/drone/ser1")
                .header("Authorization", "Bearer " + token);
          mvc.perform(request).andExpect(status().isOk());


    }

    @Test
    void testGetMedication() throws Exception {
        String token = JwtTokenUtil.generateToken("test");
        RequestBuilder request = MockMvcRequestBuilders.get("/v1/drone/ser1/medication")
                .header("Authorization", "Bearer " + token);
        mvc.perform(request).andExpect(status().isOk());

    }

    @Test
    void testGetBatteryLevel() throws Exception {
        String token = JwtTokenUtil.generateToken("test");
        RequestBuilder request = MockMvcRequestBuilders.get("/v1/drone/ser1/battery")
                .header("Authorization", "Bearer " + token);
        mvc.perform(request).andExpect(status().isOk());

    }

    @Test
    void testGetAvailableDrone() throws Exception {
        String token = JwtTokenUtil.generateToken("test");
        RequestBuilder request = MockMvcRequestBuilders.get("/v1/drone/available")
                .header("Authorization", "Bearer " + token);
        mvc.perform(request).andExpect(status().isOk());

    }


}
