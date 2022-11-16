package com.drones.model;

import com.drones.enums.Model;
import com.drones.enums.State;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;

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
    @Audited
    String serialNumber;

    @Column(name = "state")
    @Audited
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
    @Audited
    Double capacity;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_drone")
    Set<Medication> medications;
}
