package com.wiltech.users.events;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.wiltech.libraries.core.Event;
import lombok.Builder;
import lombok.Value;

/**
 * The type User updated event.
 */
@Value
@Builder
public class UserUpdatedEvent implements Event {

    @NotNull
    private Long userId;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String email;

    private Boolean active;

    private LocalDate dateOfBirth;

    private List<String> roleIds;

}
