package com.wiltech.people.events;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PersonUpdatedEvent implements Serializable {

    private Long id;

    private Long userId;

    private String firstName;

    private String lastName;

    private String email;

    private LocalDate dateOfBirth;

    private String genderId;

    private String maritalStatusId;

    private Integer numberOfDependants;

    private String phoneNumber;

}
