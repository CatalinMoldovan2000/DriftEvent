package com.example.drift;

public class SmoothDriftStrategy implements DriftStrategy {
    @Override
    public void drift() {
        System.out.println("Performing smooth drift!");
    }
}
