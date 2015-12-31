package com.orbitz.vault;

import com.orbitz.vault.auth.UserPassClient;
import com.orbitz.vault.secret.SecretClient;
import com.orbitz.vault.sys.SysClient;
import com.orbitz.vault.util.AuthTokenMissingException;
import retrofit.Retrofit;

public class Vault
{
    public static final String X_VAULT_TOKEN = "X-Vault-Token";

    private String token;
    private Retrofit retrofit;

    private Vault(String host, String token) {
        this.token = token;

        retrofit = new Retrofit.Builder().baseUrl(host).build();
    }

    private void assertToken() {
        if(token == null) {
            throw new AuthTokenMissingException();
        }
    }

    public SysClient sys() {
        return new SysClient(retrofit, token);
    }

    public SecretClient secret() {
        return new SecretClient(retrofit, token);
    }

    public UserPassClient userPass() {
        return new UserPassClient(retrofit);
    }

    public void setToken(String token) {
        this.token = token;
    }

    public static class Builder {

        private String host = "localhost";
        private String token;

        public static Builder builder() {
            return new Builder();
        }

        private Builder() {

        }

        public Builder host(String host) {
            this.host = host;

            return this;
        }

        public Builder token(String token) {
            this.token = token;

            return this;
        }

        public Vault build() {
            return new Vault(host, token);
        }
    }
}
