package com.drones.job;

import com.drones.model.Drone;
import com.drones.service.DroneService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;



@Component
@Slf4j
public class BatteryAuditJob {

    private static final double BATTERY_THRESHOLD = 30.0;
    @Autowired
    DroneService droneService;

    // assumption battery threshold to consider it has problem 30%
    // assumption run daily at 12:00 AM
    @Scheduled(cron = "0 0 * * * *")
    public void run() {
       log.info("{} job start ......", BatteryAuditJob.class.getSimpleName());
       List<Drone> droneList = droneService.getDroneBatteryLess(BATTERY_THRESHOLD);
       // publish event by droneList to be handled by
        // a notification service to send alert (EX.. email )  for responsible one

    }
}
