package org.example;

import java.util.Random;

public class Booking extends Thread{
    public Long processTime() {
        Random random = new Random();
        return random.nextLong(1, 11000);
    }
    @Override
    public void run() {
        try {
            this.sleep(this.processTime());
            System.out.println("Booking successfully");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
