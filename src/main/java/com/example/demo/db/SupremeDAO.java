package com.example.demo.db;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class SupremeDAO {
    private boolean isConnected;
    @PostConstruct
    public void initializeConnection() {
        System.out.println("initializeConnection called from ResourceConnectionManager");

        isConnected = false;

    }
    @PreDestroy
    public void destroy(){
        System.out.println("DAO is distroyed");
    }

}
