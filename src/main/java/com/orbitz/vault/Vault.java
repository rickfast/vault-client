package com.orbitz.vault;

import com.orbitz.vault.auth.UserPass;
import com.orbitz.vault.model.InitResponse;
import com.orbitz.vault.model.SealStatus;
import com.orbitz.vault.util.AuthTokenMissingException;
import retrofit.Retrofit;

public class Vault
{
    public static final String X_VAULT_TOKEN = "X-Vault-Token";

    private String host;
    private String token;
    private Initialization initialization;
    private Seal seal;
    private Retrofit retrofit;

    private Vault(String host, String token) {
        this.host = host;
        this.token = token;

        retrofit = new Retrofit.Builder().baseUrl(host).build();

        initialization = retrofit.create(Initialization.class);
        seal = retrofit.create(Seal.class);
    }

    private void assertToken() {
        if(token == null) {
            throw new AuthTokenMissingException();
        }
    }

    public UserPass userPass() {
        return new UserPass(retrofit);
    }

    public void setToken(String token) {
        this.token = token;
    }

    public InitResponse init() {
        assertToken();
        return initialization.init(token);
    }

    public SealStatus getSealStatus() {
        assertToken();
        return seal.getSealStatus(token);
    }

    public void seal() {
        assertToken();
        seal.seal(token);
    }

    public SealStatus unseal(String key) {
        assertToken();
        return seal.unseal(key, token);
    }

    public SealStatus unseal(boolean reset) {
        assertToken();
        return seal.unseal(reset, token);
    }

    public static class Builder {

        private String host = "localhost";
        private String token;

        public static Builder builder() {
            return new Builder();
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
