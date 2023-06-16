package com.example.drift;

public class DriftEvent {
    private String message;

    public DriftEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
