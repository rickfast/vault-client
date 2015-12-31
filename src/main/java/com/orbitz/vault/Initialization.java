package com.orbitz.vault;

import com.orbitz.vault.model.InitResponse;
import retrofit.http.GET;
import retrofit.http.Header;

import static com.orbitz.vault.Vault.X_VAULT_TOKEN;

interface Initialization {

    @GET("/v1/sys/init")
    InitResponse init(@Header(X_VAULT_TOKEN) String token);
}
