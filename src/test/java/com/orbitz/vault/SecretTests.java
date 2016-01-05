package com.orbitz.vault;

import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class SecretTests extends TestSupport {

    @Test
    public void shouldWriteAndGetSecret() {
        Vault vault = vault();
        String secret = UUID.randomUUID().toString();
        String token = login();

        vault.secret(token).writeSecret("whatever", secret);

        assertEquals(secret, vault.secret(token).getSecret("whatever"));
    }
}
