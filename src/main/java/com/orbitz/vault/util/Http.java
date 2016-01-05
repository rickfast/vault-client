package com.orbitz.vault.util;

import retrofit.Call;
import retrofit.Response;

import java.io.IOException;

public class Http {

    public static <T> T extract(Call<T> call) {
        Response<T> response;
        try {
            response = call.execute();
        } catch (IOException e) {
            throw new VaultApiException(e);
        }

        if(response.isSuccess()) {
            return response.body();
        } else {
            throw new VaultApiException(response.code(), response.message());
        }
    }

    public static void handle(Call<Void> call) {
        Response<Void> response;
        try {
            response = call.execute();
        } catch (IOException e) {
            throw new VaultApiException(e);
        }

        if(!response.isSuccess()) {
            throw new VaultApiException(response.code(), response.message());
        }
    }
}
