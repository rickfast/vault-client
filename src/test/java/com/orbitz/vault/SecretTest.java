package com.orbitz.vault;

import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class SecretTest extends TestSupport {

    @Test
    public void shouldWriteAndGetSecret() {
        Vault vault = vault();
        String secret = UUID.randomUUID().toString();
        String token = login();

        vault.secretClient(token).writeSecret("secret/whatever", secret);

        assertEquals(secret, vault.secretClient(token).getSecret("secret/whatever"));
    }
}
