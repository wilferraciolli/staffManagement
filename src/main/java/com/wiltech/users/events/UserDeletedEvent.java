package com.wiltech.users.events;

import com.wiltech.libraries.core.Event;
import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotNull;

/**
 * The type User created event.
 */
@Value
@Builder
public class UserDeletedEvent implements Event {

    @NotNull
    private Long userId;

}
