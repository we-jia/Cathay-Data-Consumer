package com.example.dataconsuerexample.component;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class DataProvider {
    private int data;

    public List<Integer> provide() {
        if (data > 10000) {
            return Collections.emptyList();
        }

        List<Integer> rtnList = new ArrayList<>();
        for (int i = 0; i < 20; ++i) {
            rtnList.add(data++);
        }

        return rtnList;
    }
}
