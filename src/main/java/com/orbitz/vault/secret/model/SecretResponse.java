package com.orbitz.vault.secret.model;

public class SecretResponse {

    private String leaseId;
    private Boolean renewable;
    private Long leaseDuration;
    private Secret data;

    public String getLeaseId() {
        return leaseId;
    }

    public void setLeaseId(String leaseId) {
        this.leaseId = leaseId;
    }

    public Boolean getRenewable() {
        return renewable;
    }

    public void setRenewable(Boolean renewable) {
        this.renewable = renewable;
    }

    public Long getLeaseDuration() {
        return leaseDuration;
    }

    public void setLeaseDuration(Long leaseDuration) {
        this.leaseDuration = leaseDuration;
    }

    public Secret getData() {
        return data;
    }

    public void setData(Secret data) {
        this.data = data;
    }
}
