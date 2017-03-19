package app.user;

import com.sun.org.apache.xml.internal.security.utils.Base64;

import java.security.SecureRandom;

import static java.util.Objects.hash;

/**
 * Created by David on 2017-03-18.
 */
public class User {
    private String username;
    private int hashedpassword;
    private static final int saltLen = 32;
    private static final int desiredKeyLen = 256;


    public User(String username, String password) {
        this.username = username;
        hashedpassword = hash(password);
   }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getHashedpassword() {
        return hashedpassword;
    }

    public void setHashedpassword(String password) {
        hashedpassword = hash(password);
    }







}
