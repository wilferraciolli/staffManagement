package com.wiltech.people.events.handler;

import com.wiltech.exceptions.DomainException;
import com.wiltech.people.PersonRepository;
import com.wiltech.users.events.UserDeletedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * The type User created event handler.
 */
@Component
@Slf4j
public class UserDeletedEventHandler {

    @Autowired
    private PersonRepository repository;

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void handleUserDeletedEvent(final UserDeletedEvent event) {

        repository.findByUserId(event.getUserId())
                .ifPresentOrElse(p -> repository.delete(p),
                        () -> new DomainException(String.format("Could not find person for use %s", event.getUserId())));

    }

}
