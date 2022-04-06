package com.wiltech.people.events.handler;

import com.wiltech.exceptions.EntityNotFoundException;
import com.wiltech.people.Person;
import com.wiltech.people.PersonRepository;
import com.wiltech.users.events.UserUpdatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * The type Use updated event handler.
 */
@Component
@Slf4j
public class UserUpdatedEventHandler {

    @Autowired
    private PersonRepository repository;

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void handleUserUpdatedEvent(final UserUpdatedEvent event) {
// TODO not working, fix
        Person person = repository.findByUserId(event.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("Could not find person for given user id"));

        //TODO no username/email changes to be allowed
        person.updatePersonDetails(event.getFirstName(), event.getLastName(), event.getEmail(), event.getDateOfBirth());
    }
}
