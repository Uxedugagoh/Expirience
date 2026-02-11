package com.example.task849;

public class Seats {
    public static int maxDistToClosest(int[] seats) {
        int prevV = seats[0];
        int prevI = 0;
        int maxdistance = 0;
        for (int i = 1; i < seats.length; i++) {
            if ((seats[i] == 1) && prevV == 1) {
                maxdistance = Math.max(maxdistance, ((i - prevI) / 2));
                prevV = seats[i];
                prevI = i;
            }
            if (seats[i] == 1 && prevV == 0) {
                maxdistance = Math.max(maxdistance, (i - prevI));
                prevV = seats[i];
                prevI = i;
            }
        }
        if (seats[seats.length - 1] == 0) {
            maxdistance = Math.max(maxdistance, (seats.length - 1 - prevI));
        }
        return maxdistance;
    }
}