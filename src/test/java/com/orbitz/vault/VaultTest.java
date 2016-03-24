package com.orbitz.vault;

import com.orbitz.vault.auth.LoginFailedException;
import com.orbitz.vault.secret.SecretClient;
import com.orbitz.vault.sys.SysClient;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class VaultTest extends TestSupport {

    @Test
    public void shouldInit() throws LoginFailedException {
        Vault vault = vault();

        assertTrue(vault.sys(login()).init().isInitialized());
    }

    @Test
    public void shouldGetSecretClient() {
        SecretClient secretClient = vault().secret(login());

        assertNotNull(secretClient);
    }

    @Test
    public void shouldGetSysClient() {
        SysClient sysClient = vault().sys(login());

        assertNotNull(sysClient);
    }
}
