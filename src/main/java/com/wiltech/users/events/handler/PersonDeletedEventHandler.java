package com.wiltech.users.events.handler;

import com.wiltech.users.UserAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import com.wiltech.people.events.PersonDeletedEvent;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class PersonDeletedEventHandler {

    @Autowired
    private UserAppService userAppService;

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void handlePersonCreatedEvent(final PersonDeletedEvent personDeletedEvent) {

        // TODO remove this and replace with user delete action, people deletion should not exists
        userAppService.deleteById(personDeletedEvent.getUserId());
    }
}
