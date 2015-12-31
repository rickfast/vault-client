package com.orbitz.vault.sys;

import com.orbitz.vault.sys.model.Mount;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.POST;
import retrofit.http.Path;

import java.util.Map;

import static com.orbitz.vault.Vault.X_VAULT_TOKEN;

interface Mounts {

    @GET("/v1/sys/mounts")
    Map<String, Mount> getMounts(@Header(X_VAULT_TOKEN) String token);

    @GET("/v1/sys/mounts/{mountPoint}/tune")
    Mount.Config getConfig(@Path("mountPoint") String mountPoint,
                           @Header(X_VAULT_TOKEN) String token);

    @POST("/v1/sys/mounts/{mountPoint}")
    void mount(@Path("mountPoint") String mountPoint,
               @Body Mount mount,
               @Header(X_VAULT_TOKEN) String token);

    @POST("/v1/sys/mounts/{mountPoint}/tune")
    void tune(@Path("mountPoint") String mountPoint,
              @Body Mount.Config config,
              @Header(X_VAULT_TOKEN) String token);
}
