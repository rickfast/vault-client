package com.orbitz.vault.model;

import com.google.gson.annotations.SerializedName;

public class InitResponse {

    @SerializedName("initialize")
    private boolean initialized;

    public boolean isInitialized() {
        return initialized;
    }

    public void setInitialized(boolean initialized) {
        this.initialized = initialized;
    }
}
