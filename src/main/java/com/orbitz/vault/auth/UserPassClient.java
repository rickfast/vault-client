package com.orbitz.vault.auth;

import com.orbitz.vault.auth.model.LoginResponse;
import com.orbitz.vault.auth.model.Password;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

import static com.orbitz.vault.util.Http.extract;

public class UserPassClient {

    private Api api;

    UserPassClient(Retrofit retrofit) {
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
