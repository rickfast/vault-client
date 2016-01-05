package com.orbitz.vault.util;

public class VaultApiException extends RuntimeException {

    public VaultApiException(int code, String message) {
        super(String.format("Vault request failed with status [%s]: %s",
                code, message));
    }

    public VaultApiException(Throwable throwable) {
        super("Vault request failed", throwable);
    }
}
