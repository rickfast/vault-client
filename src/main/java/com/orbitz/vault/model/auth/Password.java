package com.orbitz.vault.model.auth;

/**
 * Created by rfast on 12/31/15.
 */
public class Password {

    private String password;

    public Password() {
    }

    public Password(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
