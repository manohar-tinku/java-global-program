package com.training.javaglobalprogram.designpatterns.task1;

import com.training.javaglobalprogram.designpatterns.task1.exception.InsufficientRightsException;

public class SessionManager {
    private AccessChecker access = AccessChecker.getInstance();

    public Session createSession(User user, String accessedPath) {
        if (access.mayAccess(user, accessedPath)) {
            return new Session(user);
        } else {
            throw new InsufficientRightsException(user, accessedPath);
        }
    }
}