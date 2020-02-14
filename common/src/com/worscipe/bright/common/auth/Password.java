package com.worscipe.bright.common.auth;

import org.mindrot.jbcrypt.BCrypt;

//BCrypt is an acceptable hashing strategy for a future Spring Security implementation. 
// https://www.baeldung.com/java-password-hashing

public class Password {
    private static final int ROUNDS = 12;

    public static String hash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(ROUNDS));
    }

    public static boolean check(String password, String hash) {
        return BCrypt.checkpw(password, hash);
    }

    public static boolean validateLength(String password) {
        return password.length() >= 4;
    }
}