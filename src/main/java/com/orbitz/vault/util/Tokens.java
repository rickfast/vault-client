package com.orbitz.vault.util;

public class Tokens {

    public static void assertToken(String token) {

        if(token == null) {
            throw new AuthTokenMissingException();
        }
    }
}
