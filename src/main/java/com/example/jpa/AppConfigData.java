package com.example.jpa;
import lombok.*;


public class AppConfigData {
    private final String connectionUrl;

    public AppConfigData(String connectionUrl) {
        this.connectionUrl = connectionUrl;
    }

}
