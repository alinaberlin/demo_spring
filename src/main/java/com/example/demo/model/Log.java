package com.example.demo.model;

import java.util.Date;

public class Log {
     private int id;
    private String host;
    private String headers;
    private String body;
    private int status_code;
    private Date created_at;
    private Date updated_at;
    private String response;

    public Log(String host, String headers, String body, int status_code, Date created_at, Date updated_at, String response) {
        this.host = host;
        this.headers = headers;
        this.body = body;
        this.status_code = status_code;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.response = response;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getHeaders() {
        return headers;
    }

    public void setHeaders(String headers) {
        this.headers = headers;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public java.sql.Date getCreated_at() {
        return (java.sql.Date) created_at;
    }

    public void setCreated_at() {
        this.created_at = created_at;
    }

    public java.sql.Date getUpdated_at() {
        return (java.sql.Date) updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public String getResponse(){
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
