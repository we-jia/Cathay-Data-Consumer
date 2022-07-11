package com.example.dataconsuerexample.component;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DataConsumer implements Runnable {
    private int consumerId;

    private DataStorage dataStorage;

    public void consume() throws InterruptedException {
        Integer data = dataStorage.getData();
        while (data != null) {
            System.out.println("consumerId : " + consumerId + ", and data : " + data);
            Thread.sleep(500);
            data = dataStorage.getData();
        }
    }

    @Override
    public void run() {
        Integer data = dataStorage.getData();
        while (data != null) {
            System.out.println("consumerId : " + consumerId + ", and data : " + data);
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            data = dataStorage.getData();
        }
    }
}
