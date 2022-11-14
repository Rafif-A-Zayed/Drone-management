package com.drones.repository;

import com.drones.enums.Model;
import com.drones.enums.State;
import com.drones.model.Drone;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class DroneRepoTest {

    @Autowired
    private DroneRepository droneRepository;


    @Test
    void isDroneExitsById() {
        droneRepository.deleteAll();
        Drone drone = Drone.builder().state(State.IDLE).capacity(100.0)
                .wight(300.0).model(Model.Heavyweight).serialNumber("SER-1").build();
        droneRepository.save(drone);
       Optional <Drone> droneResOpt = droneRepository.findById("SER-1");
        assertThat(droneResOpt.isPresent()).isTrue();
    }

    @Test
    void getByState() {
        droneRepository.deleteAll();
        List<Drone> droneList = new ArrayList<>(3);
        Drone drone1 = Drone.builder().state(State.IDLE).capacity(100.0)
                .wight(300.0).model(Model.Heavyweight).serialNumber("SER-1").build();
        droneList.add(drone1);
        Drone drone2 = Drone.builder().state(State.IDLE).capacity(100.0)
                .wight(300.0).model(Model.Heavyweight).serialNumber("SER-2").build();
        droneList.add(drone2);
        Drone drone3 = Drone.builder().state(State.LOADING).capacity(100.0)
                .wight(300.0).model(Model.Heavyweight).serialNumber("SER-3").build();
        droneList.add(drone3);
        droneRepository.saveAll(droneList);
        List <Drone> droneStateList = droneRepository.getDroneByState(State.LOADING);
        assertThat(droneStateList.get(0).getState().compareTo(State.LOADING) == 0).isTrue();
    }

    @Test
    void findByCapacityLessThan() {
        droneRepository.deleteAll();
        List<Drone> droneList = new ArrayList<>(3);
        Drone drone1 = Drone.builder().state(State.IDLE).capacity(20.0)
                .wight(300.0).model(Model.Heavyweight).serialNumber("SER-1").build();
        droneList.add(drone1);
        Drone drone2 = Drone.builder().state(State.IDLE).capacity(11.0)
                .wight(300.0).model(Model.Heavyweight).serialNumber("SER-2").build();
        droneList.add(drone2);
        Drone drone3 = Drone.builder().state(State.LOADING).capacity(100.0)
                .wight(300.0).model(Model.Heavyweight).serialNumber("SER-3").build();
        droneList.add(drone3);
        droneRepository.saveAll(droneList);
        List <Drone> droneStateList = droneRepository.findByCapacityLessThan(30.0);
        assertThat(droneStateList.size() == 2).isTrue();
    }

}
