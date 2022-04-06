package com.wiltech.users.events.handler;

import com.wiltech.security.authentication.events.UserRegisteredEvent;
import com.wiltech.users.UserAppService;
import com.wiltech.users.UserResource;
import com.wiltech.users.UserRoleType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import static java.util.Arrays.asList;

/**
 * The type User registered event handler.
 */
@Service
@Slf4j
public class UserRegisteredEventHandler {

    @Autowired
    private UserAppService userAppService;

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void handleUserRegisteredEvent(final UserRegisteredEvent event) {

        log.error("Handle user registered event");
        this.createUser(event);
    }

    private void createUser(final UserRegisteredEvent user) {

        this.userAppService.create(UserResource.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .username(user.getEmail())
                .password(user.getPassword())
                .dateOfBirth(user.getDateOfBirth())
                .active(true)
                .roleIds(asList(UserRoleType.ROLE_USER.name()))
                .build());
    }
}
