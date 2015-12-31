package com.orbitz.vault.secret.model;

public class Secret {

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static Secret of(String value) {
        Secret secret = new Secret();

        secret.setValue(value);

        return secret;
    }
}
