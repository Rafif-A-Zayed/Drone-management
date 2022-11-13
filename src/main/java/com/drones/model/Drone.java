package com.drones.model;

import com.drones.enums.Model;
import com.drones.enums.State;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "drone")
@Entity
public class Drone {
    @Id
    @Column(name = "serial_number")
    @NotBlank(message = "Invalid Serial Number: Empty serial number")
    @NotNull(message = "Invalid Serial Number: Serial Number is NULL")
    String serialNumber;

    @Column(name = "state")
    State state;

    @Column(name = "model")
    @NotNull(message = "Invalid Model: Model is NULL")
    Model model;

    @Column(name = "wight")
    @Positive (message = "Invalid Wight: Wight is negative")
    @NotNull(message = "Invalid Wight: Wight is NULL")
    Double wight;

    @Column(name = "capacity")
    @Positive (message = "Invalid Capacity: Capacity is negative")
    @NotNull(message = "Invalid Capacity: Capacity is NULL")
    Double capacity;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)

    List<Medication> medications;
}
