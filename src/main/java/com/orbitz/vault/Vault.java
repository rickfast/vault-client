package com.orbitz.vault;

import com.orbitz.vault.model.InitResponse;
import com.orbitz.vault.model.SealStatus;
import retrofit.Retrofit;

public class Vault
{
    private String host;
    private Initialization initialization;
    private Seal seal;

    private Vault(String host) {
        this.host = host;

        Retrofit retrofit = new Retrofit.Builder().baseUrl(host).build();

        initialization = retrofit.create(Initialization.class);
        seal = retrofit.create(Seal.class);
    }

    public InitResponse init() {
        return initialization.init();
    }

    public SealStatus getSealStatus() {
        return seal.getSealStatus();
    }

    public void seal() {
        seal.seal();
    }

    public SealStatus unseal(String key) {
        return seal.unseal(key);
    }

    public SealStatus unseal(boolean reset) {
        return seal.unseal(reset);
    }

    public static class Builder {

        private String host = "localhost";

        public static Builder builder() {
            return new Builder();
        }

        public Builder host(String host) {
            this.host = host;

            return this;
        }

        public Vault build() {
            return new Vault(host);
        }
    }
}
