package com.training.javaglobalprogram.designpatterns.task1;

import com.training.javaglobalprogram.designpatterns.task1.exception.InsufficientRightsException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SessionManagerTest {
    private static SessionManager sessionManager;
    private static User adminUser;
    private static User normalUser;

    @BeforeAll
    public static void setUp() {
        sessionManager = new SessionManager();
        adminUser = new User("manohar");
        normalUser = new User("guru");
    }

    @Test
    public void testCreateSessionWithAdminUser(){
        Session session = sessionManager.createSession(adminUser,"/adminpath");
        assertEquals(adminUser,session.getUser());
    }

    @Test
    void testCreateSessionWithNormalUser() {
        Session session = sessionManager.createSession(normalUser, "/userpath");
        assertEquals(normalUser, session.getUser());
    }

    @Test
    void testCreateSessionWithInsufficientRights() {
        assertThrows(InsufficientRightsException.class, () -> {
            sessionManager.createSession(normalUser, "/adminpath");
        });
    }
}
