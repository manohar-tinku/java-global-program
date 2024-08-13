package com.training.javaglobalprogram.designpatterns.task1;

import com.training.javaglobalprogram.designpatterns.task1.config.ServerConfig;

public class AccessChecker {
    private static AccessChecker instance;

    public static AccessChecker getInstance() {
        if (instance == null) {
            synchronized (AccessChecker.class) {
                if (instance == null) {
                    instance = new AccessChecker();
                }
            }
        }
        return instance;
    }

    private ServerConfig config = ServerConfig.getInstance();

    private AccessChecker() {

    }

    public boolean mayAccess(User user, String path) {
        String userLevel = config.getAccessLevel(user);
        if (userLevel.equals("admin") && path.startsWith("/adminpath")) {
            return true;
        } else if (userLevel.equals("user") && path.startsWith("/userpath")) {
            return true;
        }
        return false;
    }
}