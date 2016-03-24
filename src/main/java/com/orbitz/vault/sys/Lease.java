package com.orbitz.vault.sys;

import com.orbitz.vault.sys.model.RenewResponse;
import com.orbitz.vault.sys.model.Renewal;
import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.Headers;
import retrofit.http.PUT;
import retrofit.http.Path;

public interface Lease {

    @PUT("/v1/sys/renew/{leaseId}")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json"
    })
    Call<RenewResponse> renewLease(@Path("leaseId") String leaseId);

    @PUT("/v1/sys/renew/{leaseId}")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json"
    })
    Call<RenewResponse> renewLease(@Path("leaseId") String leaseId,
                             @Body Renewal renewal);
}
