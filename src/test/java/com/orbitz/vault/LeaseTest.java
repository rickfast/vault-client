package com.orbitz.vault;

import com.orbitz.vault.secret.model.SecretResponse;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class LeaseTest extends TestSupport {

    @Test
    public void shouldRenewMySqlLease() {
        Vault vault = vault();
        String token = login();

        SecretResponse response =
                vault.secretClient(token).getSecret("mysql/creds/readonly");

        String leaseId = response.getLeaseId();

        assertEquals(leaseId, vault.sysClient(token).renewLease(leaseId, 1L, TimeUnit.HOURS).getLeaseId());
    }
}
