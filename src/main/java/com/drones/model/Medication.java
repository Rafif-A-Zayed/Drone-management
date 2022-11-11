package com.drones.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Pattern;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Medication {

    @Pattern(regexp = "^[a-zA-Z0-9_.-]*$")
    String name;
    double wight;
    @Pattern(regexp = "^[a-zA-Z0-9_.-]*$")
    String code;
    String image;
}
