import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {

    private String username;
    private String password;
    public static ArrayList<User> userArrayList = new ArrayList<User>();
    private byte permission;
    /*
     PERMISSION LEVELS:
     1: Basic User (e.g. Receptionist)
     2: Intermediate User (e.g. Manager)
     3: Advanced User (e.g. Accountant, GM)
     4: Full-permission User (e.g. Director)
     5+: Admin (Full-permission + hidden functionality)
     */

    public User(String name, String pass, byte perm) {
        username = name;
        password = pass;
        permission = perm;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", permission=" + permission +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte getPermission() {
        return permission;
    }

    public void setPermission(byte permission) {
        this.permission = permission;
    }
}
