package com.backoffice.backoffice.VO;

import org.springframework.http.HttpStatus;

public class ResponseStatus {
    Object response;
    Boolean success;
    String timestamp;
    HttpStatus status;
    String error;
    String message;
    String path;

    public ResponseStatus(){ }

    public void setResponse(Object response) {
        this.response = response;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Object getResponse() {
        return response;
    }

    public Boolean getSuccess() {
        return success;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }
}
