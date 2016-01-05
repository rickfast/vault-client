package com.orbitz.vault.sys;

import com.orbitz.vault.sys.model.InitResponse;
import com.orbitz.vault.sys.model.Status;
import retrofit.Retrofit;

import java.io.IOException;

import static com.orbitz.vault.util.Http.extract;
import static com.orbitz.vault.util.Tokens.assertToken;

public class SysClient {

    private Initialization initialization;
    private Seal seal;
    private String token;

    public SysClient(Retrofit retrofit, String token) {
        initialization = retrofit.create(Initialization.class);
        seal = retrofit.create(Seal.class);

        this.token = token;
    }

    public InitResponse init() {
        assertToken(token);
        try {
            return initialization.init(token).execute().body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Status getSealStatus() {
        assertToken(token);
        return extract(seal.getSealStatus(token));
    }

    public void seal() {
        assertToken(token);
        seal.seal(token);
    }

    public Status unseal(String key) {
        assertToken(token);
        return extract(seal.unseal(key, token));
    }

    public Status unseal(boolean reset) {
        assertToken(token);
        return extract(seal.unseal(reset, token));
    }
}
