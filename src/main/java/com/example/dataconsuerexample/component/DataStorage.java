package com.example.dataconsuerexample.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Component
public class DataStorage {
    @Autowired
    private DataProvider dataProvider;

    private boolean hasData = true;

    private Queue<Integer> queue = new LinkedList<>();

    public synchronized Integer getData() {
        if (!hasData || !queue.isEmpty()) {
            return queue.poll();
        }

        List<Integer> fetchingData = dataProvider.provide();
        if (fetchingData.isEmpty()) {
            queue.add(null);
        } else {
            queue.addAll(fetchingData);
        }
        return queue.poll();
    }
}
