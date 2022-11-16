package com.drones.util;

import com.drones.enums.Model;
import com.drones.enums.State;
import com.drones.model.Drone;
import com.drones.model.Medication;
import com.drones.service.DroneService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.*;

@Component
@Slf4j
public class AppStartupRunner implements ApplicationRunner {
    @Autowired
    DroneService droneService;

    public static double CAPACITY = 100.0;
    public static int MAX_WEIGHT = 300;

    public static int MAX_MEDICATION_WEIGHT = 100;
    public static String SERIAL_NUMBER_PATTERN = "serial-{0}";

    public static String MEDICATION_CODE_PATTERN = "MED_CODE_{0}_{1}";

    public static String MEDICATION_NAME_PATTERN = "MED-NAME-{0}-{1}";

    Model[] models = Model.values();
    public static int MAX_MODEL = 4;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("#######  APP startup logic #######");
        Random random = new Random();
        List<Drone> droneList = new ArrayList<>(5);

        for (int i = 1; i <= 5; i++) {
            Drone drone = getDrone(i, random);
            if (i % 4 == 0) {
                // add medication for that drone
                drone.setState(State.LOADED);
                drone.setMedications(getMedicationList(i,drone.getWight(), random));
            }
            droneList.add(drone);

        }

        droneService.saveAll(droneList);

    }

    private Drone getDrone(int i, Random random) {
        return Drone.builder().state(State.IDLE)
                .capacity(CAPACITY)
                .wight((double)random.nextInt(MAX_WEIGHT)+200)
                .model(models[random.nextInt(MAX_MODEL)])
                .serialNumber(MessageFormat.format(SERIAL_NUMBER_PATTERN, i))
                .build();

    }

    private Set<Medication> getMedicationList(int i, double droneWight, Random random) {

        Set<Medication> medications = new HashSet<>(3);

        double sum = 0.0;
        for (int j = 0; j < 3; j++) {
            Medication medication = getMedication(i, j,droneWight, sum, random);
            sum += medication.getWight();
            medications.add(medication);
        }
        return medications;

    }

    private Medication getMedication(int i, int j, double droneWight, double sum,  Random random) {
        Medication medication =  Medication.builder()
                .code(MessageFormat.format(MEDICATION_CODE_PATTERN, i, j))
                .name(MessageFormat.format(MEDICATION_NAME_PATTERN, i, j))

                .build();

        double wight = (double)random.nextInt(MAX_MEDICATION_WEIGHT)+ 30;

        sum = sum + wight;

        while (sum > droneWight ){
            sum -= wight;
            wight = (double)random.nextInt(MAX_MEDICATION_WEIGHT)+ 30;
            sum += wight;
        }
        medication.setWight(wight);

        return medication;

    }
}
