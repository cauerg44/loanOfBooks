package com.cauegarcia.system.dto;

import java.time.Instant;

public class CustomizedError {

    private Instant timestamp;
    private Integer status;
    private String error;
    private String path;

    public CustomizedError(Instant timestamp, Integer status, String error, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.path = path;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getPath() {
        return path;
    }
}
