package app.user;

import com.sun.org.apache.xml.internal.security.utils.Base64;

import java.security.SecureRandom;

import static java.util.Objects.hash;

/**
 * Created by David on 2017-03-18.
 */
public class User {
    private String username;
    private String hashedpassword;
    private static final int saltLen = 32;
    private static final int desiredKeyLen = 256;


    public User(String username, String password) {
        this.username = username;
        try {
            hashedpassword = getSaltedHash(password);
        }
        catch (Exception e) {
            System.err.println("InvalidPassword" + e.getMessage());
        }

   }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHashedpassword() {
        return hashedpassword;
    }

    public void setHashedpassword(String password) {
        try {
            hashedpassword = getSaltedHash(password);
        }
        catch (Exception e) {
            System.err.println("InvalidPassword" + e.getMessage());
        }
    }






    public static String getSaltedHash(String password) throws Exception {
        byte [] salt = SecureRandom.getInstance("SHA1PRNG").generateSeed(saltLen);
        // stores salt with the password
        return Base64.encode(salt) + "$" + hash(password, salt);

    }


}
