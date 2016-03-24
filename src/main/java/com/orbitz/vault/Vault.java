package com.orbitz.vault;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import com.orbitz.vault.auth.AuthClients;
import com.orbitz.vault.secret.SecretClient;
import com.orbitz.vault.sys.SysClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Vault
{
    private Retrofit retrofit;

    private ConcurrentMap<String, SysClient> sysClients =
            new ConcurrentHashMap<>();
    private ConcurrentMap<String, SecretClient> secretClients =
            new ConcurrentHashMap<>();

    private Vault(String host, int port) throws MalformedURLException {
        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory
                        .create(new GsonBuilder()
                                .setFieldNamingPolicy(FieldNamingPolicy
                                        .LOWER_CASE_WITH_UNDERSCORES).create()))
                .baseUrl(new URL("http", host, port, "").toExternalForm())
                .build();
    }

    public SysClient sysClient(String token) {
        return sysClients.computeIfAbsent(token,
                (t) -> new SysClient(retrofit, t));
    }

    public SecretClient secretClient(String token) {
        return secretClients.computeIfAbsent(token,
                (t) -> new SecretClient(retrofit, t));
    }

    public AuthClients authClients() {
        return new AuthClients(retrofit);
    }

    public static class Builder {

        private String host = "localhost";
        private int port = 8200;

        public static Builder builder() {
            return new Builder();
        }

        private Builder() {

        }

        public Builder host(String host) {
            this.host = host;

            return this;
        }

        public Builder port(int port) {
            this.port = port;

            return this;
        }

        public Vault build() {
            try {
                return new Vault(host, port);
            } catch (MalformedURLException e) {
                throw new RuntimeException("Bad Vault hostname");
            }
        }
    }
}
