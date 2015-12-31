package com.orbitz.vault;

import com.orbitz.vault.auth.UserPassClient;
import com.orbitz.vault.secret.SecretClient;
import com.orbitz.vault.sys.SysClient;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

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
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(new URL("http", host, port, "").toExternalForm())
                .build();
    }

    public SysClient sys(String token) {
        return sysClients.computeIfAbsent(token,
                (t) -> new SysClient(retrofit, t));
    }

    public SecretClient secret(String token) {
        return secretClients.computeIfAbsent(token,
                (t) -> new SecretClient(retrofit, t));
    }

    public UserPassClient userPass() {
        return new UserPassClient(retrofit);
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
