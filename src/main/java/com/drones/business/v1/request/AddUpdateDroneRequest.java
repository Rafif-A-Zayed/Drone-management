package com.drones.business.v1.request;

import com.drones.enums.Model;
import com.drones.enums.State;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.validation.constraints.*;
@Getter
@Setter
@SuperBuilder()
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddUpdateDroneRequest extends Request{

    @NotBlank(message = "Invalid Serial Number: Empty serial number")
    @NotNull(message = "Invalid Serial Number: Serial Number is NULL")
    @Size(max = 100, message = "Invalid Serial Number: Serial Number exceeds length limit")

    String serialNumber;


    State state;

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
}
