package com.drones.business.v1.request;

import com.drones.model.Drone;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder()
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Request {

    protected String serialNumber;
    protected Drone drone;
}
