package com.example.drift;

import java.util.Random;
//Clasa de participanti la drift
public class DriftParticipant {
    private String name;//Nume
    private DriftStrategy driftStrategy;
    private int score;//Scor

    //Participant
    public DriftParticipant(String name) {
        this.name = name;
        this.score = 0;
    }

    //Alegerea strategiei de drift
    public void chooseRandomStrategy() {
        Random random = new Random();
        int strategyChoice = random.nextInt(2);

        if (strategyChoice == 0) {
            driftStrategy = new AggressiveDriftStrategy();
        } else {
            driftStrategy = new SmoothDriftStrategy();
        }
    }

    //Drift start
    public void performDrift() {
        System.out.println(name + " is performing drift:");

        // Verificare pentru strategia agresivă
        if (driftStrategy instanceof AggressiveDriftStrategy) {
            Random random = new Random();
            int accidentChance = random.nextInt(10);

            if (accidentChance == 0) {
                System.out.println(name + " had an accident!");
                score -= 20; // Scădere scor în caz de accident
                return;
            }
        }

        // Verificare pentru strategia lină
        if (driftStrategy instanceof SmoothDriftStrategy) {
            Random random = new Random();
            int carStopChance = random.nextInt(10);

            if (carStopChance == 0) {
                System.out.println(name + "'s car stopped working!");
                score -= 10; // Scădere scor în caz de oprire a mașinii
                return;
            }
        }

        driftStrategy.drift();
        score += (driftStrategy instanceof AggressiveDriftStrategy) ? 15 : 10; // Incrementare scor în funcție de strategie
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
