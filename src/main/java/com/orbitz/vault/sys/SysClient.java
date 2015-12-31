package com.orbitz.vault.sys;

import com.orbitz.vault.sys.model.InitResponse;
import com.orbitz.vault.sys.model.SealStatus;
import retrofit.Retrofit;

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
        return initialization.init(token);
    }

    public SealStatus getSealStatus() {
        assertToken(token);
        return seal.getSealStatus(token);
    }

    public void seal() {
        assertToken(token);
        seal.seal(token);
    }

    public SealStatus unseal(String key) {
        assertToken(token);
        return seal.unseal(key, token);
    }

    public SealStatus unseal(boolean reset) {
        assertToken(token);
        return seal.unseal(reset, token);
    }
}
