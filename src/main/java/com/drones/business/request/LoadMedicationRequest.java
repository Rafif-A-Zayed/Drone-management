package com.drones.business.request;


import com.drones.model.Medication;
import lombok.AccessLevel;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import java.util.Set;

@Getter
@Setter

@SuperBuilder()
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoadMedicationRequest extends Request {
    Set<Medication> medicationList;

}
