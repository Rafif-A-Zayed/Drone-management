package com.drones.business;

import com.drones.model.Medication;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoadMedicationRequest {

    @NotBlank (message = "Invalid value")
    String serialNumber;
    @NotEmpty (message = "Provide at least one medication")
    List<Medication> medicationList;

}
