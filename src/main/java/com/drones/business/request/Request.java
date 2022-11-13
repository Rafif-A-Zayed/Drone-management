package com.drones.business.request;

import com.drones.model.Drone;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder()
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Request {

    protected String serialNumber;
    protected Drone drone;
}
