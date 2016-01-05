package com.orbitz.vault.auth;

import com.orbitz.vault.auth.model.LoginResponse;
import com.orbitz.vault.auth.model.Password;
import retrofit.Call;
import retrofit.Retrofit;
import retrofit.http.Body;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.Path;

import static com.orbitz.vault.util.Http.extract;

public class UserPassClient {

    private Api api;

    public UserPassClient(Retrofit retrofit) {
        api = retrofit.create(Api.class);
    }

    public String login(String username, String password) throws LoginFailedException {
        try {
            LoginResponse response =
                    extract(api.login(username, new Password(password)));

            return response.getAuth().getClientToken();
        } catch (Exception ex) {
            throw new LoginFailedException();
        }
    }

    private interface Api {

        @POST("/v1/auth/userpass/login/{username}")
        @Headers({
                "Content-Type: application/json",
                "Accept: application/json"
        })
        Call<LoginResponse> login(@Path("username") String username,
                                  @Body Password password);
    }
}
