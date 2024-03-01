package com.revature.java8.streams;

import java.util.*;

class Party {
    String name;
    int votes;
    int seats;

    Party(String name) {
        this.name = name;
        this.votes = 0;
        this.seats = 0;
    }
}

class Booth {
    String name;
    Map<String, Party> partyMap;

    Booth(String name) {
        this.name = name;
        this.partyMap = new HashMap<>();
    }

    void addVote(String partyName, int votes) {
        if (!partyMap.containsKey(partyName)) {
            partyMap.put(partyName, new Party(partyName));
        }
        Party party = partyMap.get(partyName);
        party.votes += votes;
    }

    void calculateWinner() {
        Party winner = null;
        int maxVotes = 0;

        for (Party party : partyMap.values()) {
            if (party.votes > maxVotes) {
                maxVotes = party.votes;
                winner = party;
            }
        }

        System.out.println(name + " Winner: " + winner.name + "-" + winner.votes);
        winner.seats++;
    }
}

public class VotingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Party> partyMap = new HashMap<>();
        List<Booth> boothList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String boothName = input[0];
            String partyName = input[1];
            int votes = Integer.parseInt(input[2]);

            if (!partyMap.containsKey(partyName)) {
                partyMap.put(partyName, new Party(partyName));
            }

            Party party = partyMap.get(partyName);
            party.votes += votes;

            Booth booth = null;
            for (Booth b : boothList) {
                if (b.name.equals(boothName)) {
                    booth = b;
                    break;
                }
            }

            if (booth == null) {
                booth = new Booth(boothName);
                boothList.add(booth);
            }

            booth.addVote(partyName, votes);
        }

        for (Booth booth : boothList) {
            booth.calculateWinner();
        }

        System.out.println("\nTotal Votes:");
        for (Party party : partyMap.values()) {
            System.out.println(party.name + "-" + party.votes);
        }

        System.out.println("\nTotal Seats:");
        for (Party party : partyMap.values()) {
            System.out.println(party.name + "-" + party.seats);
        }
    }
}
