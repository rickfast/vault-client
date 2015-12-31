package com.orbitz.vault;

import com.orbitz.vault.model.SealStatus;
import retrofit.http.GET;
import retrofit.http.PUT;
import retrofit.http.Query;

interface Seal {

    @GET("/sys/seal-status")
    SealStatus getSealStatus();

    @GET("/sys/seal")
    void seal();

    @PUT("/sys/unseal")
    SealStatus unseal(@Query("key") String key);

    @PUT("/sys/unseal")
    SealStatus unseal(@Query("reset") boolean reset);
}
