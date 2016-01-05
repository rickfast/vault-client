package com.orbitz.vault.secret;

import com.orbitz.vault.secret.model.Secret;
import com.orbitz.vault.secret.model.SecretResponse;
import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.Path;

import static com.orbitz.vault.util.Tokens.X_VAULT_TOKEN;

interface Secrets {

    @GET("/v1/secret/{name}")
    @Headers({"Accept: application/json"})
    Call<SecretResponse> getSecret(@Path("name") String name,
                                   @Header(X_VAULT_TOKEN) String token);

    @POST("/v1/secret/{name}")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json"
    })
    Call<Void> writeSecret(@Path("name") String name,
                           @Body Secret secret,
                           @Header(X_VAULT_TOKEN) String token);
}
