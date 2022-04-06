package com.wiltech.people.events;

import lombok.Builder;
import lombok.Value;

import java.io.Serializable;

@Value
@Builder
public class PersonDeletedEvent implements Serializable {

    private Long id;

    private Long userId;

    private String email;
}
