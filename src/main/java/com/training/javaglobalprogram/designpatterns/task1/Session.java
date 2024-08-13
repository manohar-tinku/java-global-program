package com.training.javaglobalprogram.designpatterns.task1;

public class Session {
    private User user;
    private long creationTime;
    private String sessionId;

    public Session(User user) {
        this.user = user;
        this.creationTime = System.currentTimeMillis();
        this.sessionId = generateSessionId();
    }

    public User getUser() {
        return user;
    }

    public long getCreationTime() {
        return creationTime;
    }

    public String getSessionId() {
        return sessionId;
    }

    private String generateSessionId() {
        return getUser().getUsername() + "-" + getCreationTime();
    }

    @Override
    public String toString() {
        return "Session{" +
                "user=" + user +
                ", creationTime=" + creationTime +
                ", sessionId='" + sessionId + '\'' +
                '}';
    }
}
