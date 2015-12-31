package com.orbitz.vault;

import com.orbitz.vault.model.Secret;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.POST;
import retrofit.http.Path;

import static com.orbitz.vault.Vault.X_VAULT_TOKEN;

interface Secrets {

    @GET("/v1/sys/secret/{name}")
    Secret getSecret(@Path("name") String name,
                     @Header(X_VAULT_TOKEN) String token);

    @POST("/v1/sys/secret/{name}")
    void writeSecret(@Path("name") String name,
                     @Body Secret secret,
                     @Header(X_VAULT_TOKEN) String token);
}
