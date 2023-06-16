package com.example.drift;

public class AggressiveDriftStrategy implements DriftStrategy {
    @Override
    public void drift() {
        System.out.println("Performing aggressive drift!");
    }
}
