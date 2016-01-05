package com.orbitz.vault.secret;

import com.orbitz.vault.secret.model.Secret;
import retrofit.Retrofit;

import static com.orbitz.vault.util.Http.extract;
import static com.orbitz.vault.util.Http.handle;
import static com.orbitz.vault.util.Tokens.assertToken;

public class SecretClient {

    private Secrets secrets;
    private String token;

    public SecretClient(Retrofit retrofit, String token) {
        secrets = retrofit.create(Secrets.class);

        this.token = token;
    }

    public String getSecret(String name) {
        assertToken(token);
        return extract(secrets.getSecret(name, token)).getData().getValue();
    }

    public void writeSecret(String name, String value) {
        assertToken(token);
        handle(secrets.writeSecret(name, Secret.of(value), token));
    }
}
