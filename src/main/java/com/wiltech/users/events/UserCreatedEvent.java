package com.wiltech.users.events;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.wiltech.libraries.core.Event;
import lombok.Builder;
import lombok.Value;

/**
 * The type User created event.
 */
@Value
@Builder
public class UserCreatedEvent implements Event {

    @NotNull
    private Long userId;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String email;

    private LocalDate dateOfBirth;

}
