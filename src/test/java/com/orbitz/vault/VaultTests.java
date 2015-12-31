package com.orbitz.vault;

import org.junit.Test;

import static com.orbitz.vault.Vault.Builder.builder;

public class VaultTests {

    @Test
    public void shouldInit() {
        Vault vault = builder().build();

        vault.sys("hi").init();
    }
}
