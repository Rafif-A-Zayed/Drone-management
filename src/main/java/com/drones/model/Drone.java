package com.drones.model;

import com.drones.enums.Model;
import com.drones.enums.State;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Drone {
    @Id
    String serialNumber;
    State state;
    Model model;
    Double wight;
    Double capacity;

    @OneToMany()
    List<Medication> medications;
}
