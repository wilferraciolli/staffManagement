/*
 * (c) Midland Software Limited 2019
 * Name     : UserRegisteredEvent.java
 * Author   : ferraciolliw
 * Date     : 12 Nov 2019
 */
package com.wiltech.security.authentication.events;

import com.wiltech.libraries.core.Event;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

/**
 * The type User registered event.
 */
@Value
@Builder
public class UserRegisteredEvent implements Event {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private LocalDate dateOfBirth;
}

