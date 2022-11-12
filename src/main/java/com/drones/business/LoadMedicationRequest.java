package com.drones.business;


import com.drones.model.Medication;
import lombok.AccessLevel;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import java.util.List;

@Getter
@Setter

@SuperBuilder()
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoadMedicationRequest extends Request{
    List<Medication> medicationList;

}
