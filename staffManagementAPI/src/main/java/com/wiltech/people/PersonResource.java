package com.wiltech.people;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.wiltech.libraries.rest.BaseDTO;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The type Person resource.
 */
@JsonRootName("person")
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode
@ToString
public class PersonResource extends BaseDTO {

    private Long id;

    private Long userId;

    @JsonProperty("firstName")
    @NotNull
    @Size(max = 80, message = "First name cannot have more than {max} characters")
    private String firstName;

    @NotNull
    @Size(max = 80, message = "Last name cannot have more than {max} characters")
    private String lastName;

    @NotNull(message = "Email name cannot be null.")
    private String email;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    private PersonGenderType genderId;

    private PersonMaritalStatusType maritalStatusId;

    private Integer numberOfDependants;

    private String phoneNumber;

    private Boolean allowedOnCall;

    private Boolean fullyTrained;

    private Boolean allowedSpecialShift;

}
