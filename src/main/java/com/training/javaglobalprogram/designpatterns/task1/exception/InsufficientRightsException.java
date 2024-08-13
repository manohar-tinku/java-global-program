package com.training.javaglobalprogram.designpatterns.task1.exception;

import com.training.javaglobalprogram.designpatterns.task1.User;

public class InsufficientRightsException extends RuntimeException {
    public InsufficientRightsException(User user, String accessedPath) {
        super("User " + user.getUsername() + " does not have sufficient rights to access " + accessedPath);
    }
}
