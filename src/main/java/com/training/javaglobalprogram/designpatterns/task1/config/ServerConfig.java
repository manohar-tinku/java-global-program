package com.training.javaglobalprogram.designpatterns.task1.config;

import com.training.javaglobalprogram.designpatterns.task1.User;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class ServerConfig {
    private static ServerConfig instance;

    private static String configFilePath = "C:\\Users\\Manohar_Mittapally\\Desktop\\Learn\\java-global-program\\src\\main\\resources\\com\\training\\javaglobalprogram\\designpatterns\\task1\\config.properties";
    private Map<String, String> userAccessLevels = new HashMap<>();

    public static ServerConfig getInstance() {
        if (instance == null) {
            synchronized (ServerConfig.class) {
                if (instance == null) {
                    instance = new ServerConfig();
                }
            }
        }
        return instance;
    }

    private ServerConfig() {
        loadConfig();
        validateConfig();
    }

    private void loadConfig() {
        Properties properties = new Properties();
        try {
            List<String> userRoles=Files.readAllLines(Paths.get(configFilePath));
            for(String userRole: userRoles){
                String user=userRole.split(",")[0];
                String role=userRole.split(",")[1];
                userAccessLevels.put(user,role);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load configuration", e);
        }

    }

    private void validateConfig() {
        for (Map.Entry<String, String> entry : userAccessLevels.entrySet()) {
            String username = entry.getKey();
            String accessLevel = entry.getValue();
            if (username == null || username.isEmpty() || accessLevel == null || accessLevel.isEmpty()) {
                throw new IllegalArgumentException("Invalid config entry for user: " + username);
            }
        }
    }

    public String getAccessLevel(User user) {
        return userAccessLevels.get(user.getUsername());
    }

}