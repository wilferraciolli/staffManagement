package com.wiltech.security.jwt.refresh.events.handler;

import com.wiltech.people.events.PersonDeletedEvent;
import com.wiltech.security.jwt.refresh.RefreshTokenService;
import com.wiltech.users.events.UserDeletedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * The type Used deleted event handler. User deketed event handler to remove refresh tokens when a user was deleted.
 */
@Component
@Slf4j
public class UserPersonDeletedEventHandler {

    @Autowired
    private RefreshTokenService refreshTokenService;

    /**
     * Handle user deleted event.
     * @param userDeletedEvent the user deleted event
     */
    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void handleUserDeletedEvent(final UserDeletedEvent userDeletedEvent) {

       refreshTokenService.deleteRefreshTokenByUserId(userDeletedEvent.getUserId());
    }

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void handlePersonDeletedEvent(final PersonDeletedEvent personDeletedEvent) {

        refreshTokenService.deleteRefreshTokenByUserId(personDeletedEvent.getUserId());
    }
}
