package com.orbitz.vault;

import com.orbitz.vault.auth.UserPass;
import com.orbitz.vault.model.InitResponse;
import com.orbitz.vault.model.SealStatus;
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

    public UserPass userPass() {
        return new UserPass(retrofit);
    }

    public void setToken(String token) {
        this.token = token;
    }

    public InitResponse init() {
        return initialization.init(token);
    }

    public SealStatus getSealStatus() {
        return seal.getSealStatus(token);
    }

    public void seal() {
        seal.seal(token);
    }

    public SealStatus unseal(String key) {
        return seal.unseal(key, token);
    }

    public SealStatus unseal(boolean reset) {
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
