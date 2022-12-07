package com.sharmajee.FileUpload.response;

public class FileUploadResponse {

    private int status;
    private String message;
    private long timestamp;

    private String error;

    public FileUploadResponse() {}

    public FileUploadResponse(int status, String message, long timestamp,String error) {
        super();
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
        this.error = error;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
