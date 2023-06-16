package com.example.drift;
// Spectatorii
public class Spectator implements DriftEventObserver {
    private String name;

    public Spectator(String name) {
        this.name = name;
    }

    @Override
    public void update(DriftEvent event) {
        System.out.println(name + " received drift event: " + event.getMessage());
    }
}
