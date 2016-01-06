package com.orbitz.vault.auth;

import retrofit.Retrofit;

public class AuthClients {

    private Retrofit retrofit;

    public AuthClients(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    public UserPassClient userPass() {
        return new UserPassClient(retrofit);
    }
}
