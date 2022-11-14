package com.drones.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "medication")
public class Medication {

    @Id
    @Column(name = "code")
   // @Pattern(regexp = "^[a-zA-Z0-9_.-]*$",message = "Invalid Code")
    @NotBlank(message = "Invalid Code: Empty Code")
    @NotNull(message = "Invalid Code: Code is NULL")
    String code;

    @Column(name = "name")
   // @Pattern(regexp = "^[a-zA-Z0-9_.-]*$", message = "Invalid Name")
    @NotBlank(message = "Invalid Name: Empty name")
    @NotNull(message = "Invalid Name: Name is NULL")
    String name;
    @Column(name = "wight")
    @NotNull(message = "Invalid Wight: Wight is NULL")
    Double wight;

    @Column(name = "image")
    String image;
}
