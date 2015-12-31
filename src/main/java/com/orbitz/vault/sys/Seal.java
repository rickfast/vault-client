package com.orbitz.vault.sys;

import com.orbitz.vault.sys.model.SealStatus;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.PUT;
import retrofit.http.Query;

import static com.orbitz.vault.util.Tokens.X_VAULT_TOKEN;

interface Seal {

    @GET("/v1/sys/seal-status")
    SealStatus getSealStatus(@Header(X_VAULT_TOKEN) String token);

    @GET("/v1/sys/seal")
    void seal(@Header(X_VAULT_TOKEN) String token);

    @PUT("/v1/sys/unseal")
    SealStatus unseal(@Query("key") String key,
                      @Header(X_VAULT_TOKEN) String token);

    @PUT("/v1/sys/unseal")
    SealStatus unseal(@Query("reset") boolean reset,
                      @Header(X_VAULT_TOKEN) String token);
}
