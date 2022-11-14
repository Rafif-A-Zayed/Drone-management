package com.drones.model;

import com.drones.enums.Model;
import com.drones.enums.State;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "drone")
public class Drone {
    @Id
    @Column(name = "serial_number")
    @NotBlank(message = "Invalid Serial Number: Empty serial number")
    @NotNull(message = "Invalid Serial Number: Serial Number is NULL")
    @Size(max = 100, message = "Invalid Serial Number: Serial Number exceeds length limit")
    String serialNumber;

    @Column(name = "state")
    State state;

    @Column(name = "model")
    @NotNull(message = "Invalid Model: Model is NULL")
    Model model;

    @Column(name = "wight")
    @Positive(message = "Invalid Wight: Wight is negative")
    @NotNull(message = "Invalid Wight: Wight is NULL")
    @Max(value = 500, message = "Invalid Wight: Wight exceeds the limit 500")
    Double wight;

    @Column(name = "capacity")
    @Positive(message = "Invalid Capacity: Capacity is negative")
    @NotNull(message = "Invalid Capacity: Capacity is NULL")
    @Max(value = 500, message = "Invalid Capacity: Capacity exceeds the limit 100")
    Double capacity;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    List<Medication> medications;
}
