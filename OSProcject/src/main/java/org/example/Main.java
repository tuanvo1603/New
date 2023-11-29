package org.example;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Main {
    private static final int TICKETS = 20;
    public static ArrayList<Thread> threads = new ArrayList<Thread>();
    public static ArrayDeque<Booking> virtualBooking = new ArrayDeque<>();

    public static ArrayList<ArrayDeque<Booking>> virtualQueue = new ArrayList<>();

    public static int getMinimalSizeQueue(ArrayList<ArrayDeque<Booking>> virtualQueue) {
        int min = 0;
        for(int i = 0; i < 15; i++) {
            if(min > virtualQueue.get(i).size()) {
                min = virtualQueue.get(i).size();
            }
        }
        return min;
    }

    public static void main(String[] args) {

        for(int i = 0; i < 15; i++) {
            Thread thread = null;
            threads.add(thread);
        }

        for(int i = 0; i < 1000; i++) {
            Booking booking = new Booking();
            virtualBooking.add(booking);
        }

        for(int i = 0; i < 1000; i++) {
            virtualQueue.get(getMinimalSizeQueue(virtualQueue)).add(virtualBooking.getFirst());
            for(i = 0; i < 15; i++) {

            }

        }

    }
}