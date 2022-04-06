package com.wiltech.users.profile;

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
 * The type User profile resource.
 */
@JsonRootName("userProfile")
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode
@ToString
public class UserProfileResource extends BaseDTO {

    private Long id;
    private Long personId;
    private String firstName;
    private String lastName;
}
