package com.drones.service;

import com.drones.enums.State;

import com.drones.model.Drone;
import com.drones.repository.DroneRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DroneServiceTest {

    @Mock
    private DroneRepository droneRepository;

    private DroneService droneService;

    @BeforeEach
    void setUp() {
        this.droneService = new DroneServiceImpl(this.droneRepository);
    }

    @Test
    void getById() {
        droneService.get("");
        verify(droneRepository).findById("");

    }

    @Test
    void getByState() {
        droneService.getDroneByState(State.IDLE);
        verify(droneRepository).getDroneByState(State.IDLE);

    }

    @Test
    void saveDrone() {
        Drone drone = Drone.builder().build();
        droneService.save(drone);
        verify(droneRepository).save(drone);

    }

    @Test
    void saveAll() {
        List<Drone> droneList = new ArrayList<>(Collections.singletonList(Drone.builder().serialNumber("code-1").build()));
        droneService.saveAll(droneList);
        verify(droneRepository).saveAll(droneList);

    }

    @Test
    void getDroneBatteryLess() {
        droneService.getDroneBatteryLess(30.0);
        verify(droneRepository).findByCapacityLessThan(30.0);

    }

}
