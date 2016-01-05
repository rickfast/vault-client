package com.orbitz.vault;

import com.orbitz.vault.auth.LoginFailedException;
import com.orbitz.vault.auth.UserPassClient;

public class TestSupport {

    protected String login() {
        Vault vault1 = vault();
        UserPassClient userPassClient = vault1.userPassAuth();

        try {
            return userPassClient.login("rickfast", "foo");
        } catch (LoginFailedException e) {
            throw new RuntimeException(e);
        }
    }

    protected Vault vault() {
        return Vault.Builder.builder().build();
    }
}
