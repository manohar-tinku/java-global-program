Consider a simple server implementation which uses the Singleton Pattern.
The following code deals with the creation of new user sessions.
Your job is to complete the implementation according to the comments and to write unit tests for the 'createSession' method. Optionally, add multi-threading support to the implementation.
public class AccessChecker {
private static AccessChecker instance;

public static AccessChecker getInstance() {
if (instance == null) {
// create instance
}
return instance;
}

private ServerConfig config = ServerConfig.getInstance();

private AccessChecker() {
// initialization..
}

public boolean mayAccess(User user, String path) {
String userLevel = config.getAccessnNLevel(user);
// check if level suffices
}
// ...


}
public class ServerConfig {
private static ServerConfig instance;

private static String configFilePath = "...";

public static ServerConfig getInstance() {
if (instance == null) {
// create instance
}
return instance;
}

private ServerConfig() {
// load configuration from file
// validate
}

public String getAccessLevel(User u) {
...
}
// ...


}
public class SessionManager {
private AccessChecker access = AccessChecker.getInstance();

public Session createSession(User user, String accessedPath) {
if (access.mayAccess(user, accessedPath)) {
return new Session(user);
} else {
throw new InsufficientRightsException(user, accessedPath);
}
}
// ...


}