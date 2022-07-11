package com.example.dataconsuerexample.component;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DataConsumer {
    private int consumerId;

    private DataStorage dataStorage;

    public void consume() throws InterruptedException {
        Integer data = dataStorage.getData();
        while (data != null) {
            System.out.println("consumerId : " + consumerId  + ", and data : " + data);
            Thread.sleep(500);
            data = dataStorage.getData();
        }
    }
}
