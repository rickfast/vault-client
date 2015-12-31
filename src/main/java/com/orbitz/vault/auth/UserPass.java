package com.orbitz.vault.auth;

import com.orbitz.vault.model.auth.LoginResponse;
import com.orbitz.vault.model.auth.Password;
import retrofit.Retrofit;
import retrofit.http.Body;
import retrofit.http.POST;
import retrofit.http.Path;

public class UserPass {

    private Api api;

    public UserPass(Retrofit retrofit) {
        api = retrofit.create(Api.class);
    }

    public String login(String username, String password) throws LoginFailedException {
        try {
            LoginResponse loginResponse =
                    api.login(username, new Password(password));

            return loginResponse.getAuth().getClientToken();
        } catch (Exception ex) {
            throw new LoginFailedException();
        }
    }

    private interface Api {

        @POST("/v1/sys/auth/userpass/login/{username}")
        LoginResponse login(@Path("username") String username,
                            @Body Password password);
    }
}
