package com.drones.model;

import com.drones.enums.Model;
import com.drones.enums.State;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Drone {
    State state;
    Model model;
    String serialNumber;
    Double wight;
    Double capacity;

    List<Medication> medications;
}
