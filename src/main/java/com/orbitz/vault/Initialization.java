package com.orbitz.vault;

import com.orbitz.vault.model.InitResponse;
import retrofit.http.GET;

interface Initialization {

    @GET("/sys/init")
    InitResponse init();
}
