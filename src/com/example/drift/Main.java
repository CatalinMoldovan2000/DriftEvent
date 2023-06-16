package com.example.drift;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Observer Pattern
        DriftCompetition driftCompetition = new DriftCompetition();
        Spectator spectator1 = new Spectator("Alex");
        Spectator spectator2 = new Spectator("Andrei");
        driftCompetition.addObserver(spectator1);
        driftCompetition.addObserver(spectator2);
        driftCompetition.startCompetition();

        // Strategy Pattern
        List<DriftParticipant> participants = new ArrayList<>();
        participants.add(new DriftParticipant("Anton"));
        participants.add(new DriftParticipant("Paul"));

        // Alegeri random pentru strategiile de drift utilizate de participanti
        for (DriftParticipant participant : participants) {
            participant.chooseRandomStrategy();
        }

        // Incepe runda si se calculeaza scorul
        for (int i = 0; i < 5; i++) {
            System.out.println("\nRound " + (i + 1) + " begins:");

            for (DriftParticipant participant : participants) {
                participant.performDrift();
            }
        }

        // Afisare scoreboard și selectare castigator
        System.out.println("\nFinal Scores:");

        int maxScore = Integer.MIN_VALUE;
        List<DriftParticipant> winners = new ArrayList<>();

        for (DriftParticipant participant : participants) {
            int score = participant.getScore();
            System.out.println(participant.getName() + ": " + score);

            if (score > maxScore) {
                maxScore = score;
                winners.clear();
                winners.add(participant);
            } else if (score == maxScore) {
                winners.add(participant);
            }
        }

        // Verifică dacă există egalitate
        if (winners.size() > 1) {
            System.out.println("\nIt's a tie! The competition will be reorganized.");

            // Reorganizează concursul până când se determină un câștigător unic
            while (winners.size() > 1) {
                System.out.println("\nReorganizing the competition...");

                // Alegere random a strategiilor pentru participanții cu scorul maxim
                for (DriftParticipant winner : winners) {
                    winner.chooseRandomStrategy();
                }

                // Incepe runda si se calculeaza scorul
                for (int i = 0; i < 5; i++) {
                    System.out.println("\nRound " + (i + 1) + " begins:");

                    for (DriftParticipant winner : winners) {
                        winner.performDrift();
                    }
                }

                maxScore = Integer.MIN_VALUE;
                winners.clear();

                // Calculare scoruri actualizate și determinare câștigător
                for (DriftParticipant participant : participants) {
                    int score = participant.getScore();
                    System.out.println(participant.getName() + ": " + score);

                    if (score > maxScore) {
                        maxScore = score;
                        winners.clear();
                        winners.add(participant);
                    } else if (score == maxScore) {
                        winners.add(participant);
                    }
                }
            }
        }

        System.out.println("\nThe winner is: " + winners.get(0).getName());
    }
}