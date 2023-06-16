package com.example.drift;

import java.util.ArrayList;
import java.util.List;

public class DriftCompetition {
    private List<DriftEventObserver> observers;

    public DriftCompetition() {
        observers = new ArrayList<>();
    }

    public void addObserver(DriftEventObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(DriftEventObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(DriftEvent event) {
        for (DriftEventObserver observer : observers) {
            observer.update(event);
        }
    }

    public void startCompetition() {
        System.out.println();
        System.out.println("The drift competition has started!");
        notifyObservers(new DriftEvent("Drift competition started! Prepare for the battle!"));
    }
}
