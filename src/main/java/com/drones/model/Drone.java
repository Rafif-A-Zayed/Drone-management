package com.drones.model;

import com.drones.enums.Model;
import com.drones.enums.State;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.envers.Audited;

import javax.persistence.*;
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
    @Audited
    String serialNumber;

    @Column(name = "state")
    @Audited
    State state;

    @Column(name = "model")
    Model model;

    @Column(name = "wight")
    Double wight;

    @Column(name = "capacity")
    @Audited
    Double capacity;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_drone")
    Set<Medication> medications;
}
