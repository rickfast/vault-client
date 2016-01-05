package com.orbitz.vault;

import com.orbitz.vault.auth.LoginFailedException;
import com.orbitz.vault.auth.UserPassClient;

import java.util.Optional;

public class TestSupport {

    private Optional<String> token = Optional.empty();
    private Optional<Vault> vault = Optional.empty();

    protected String token() {
        return token.orElseGet(() -> {
            Vault vault1 = vault();
            UserPassClient userPassClient = vault1.userPass();

            try {
                return userPassClient.login("rickfast", "foo");
            } catch (LoginFailedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    protected Vault vault() {
        return vault.orElseGet(() -> Vault.Builder.builder().build());
    }
}
