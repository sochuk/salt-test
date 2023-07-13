package com.salt.salttest.dto;

public class CustomResponse {
    private boolean success;
    private String message;
    private Object data;

    public CustomResponse(boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public CustomResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
        this.data = null;
    }

    public CustomResponse(boolean success) {
        this.success = success;
        this.message = "";
        this.data = null;
    }

    public CustomResponse() {
        this.success = false;
        this.message = "";
        this.data = null;
    }

    public CustomResponse(Object data) {
        this.success = true;
        this.message = "success";
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

