package com.orbitz.vault.sys;

import com.orbitz.vault.sys.model.InitResponse;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Headers;

import static com.orbitz.vault.util.Tokens.X_VAULT_TOKEN;

interface Initialization {

    @GET("/v1/sys/init")
    @Headers({ "Accept: application/json" })
    Call<InitResponse> init(@Header(X_VAULT_TOKEN) String token);
}
