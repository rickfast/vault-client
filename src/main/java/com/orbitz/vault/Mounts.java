package com.orbitz.vault;

import com.orbitz.vault.model.Mount;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

import java.util.Map;

interface Mounts {

    @GET("/sys/mounts")
    Map<String, Mount> getMounts();

    @GET("/sys/mounts/{mountPoint}/tune")
    Mount.Config getConfig(@Path("mountPoint") String mountPoint);

    @POST("/sys/mounts/{mountPoint}")
    void mount(@Path("mountPoint") String mountPoint, @Body Mount mount);

    @POST("/sys/mounts/{mountPoint}/tune")
    void tune(@Path("mountPoint") String mountPoint, @Body Mount.Config config);
}
