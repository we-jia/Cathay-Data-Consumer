package com.example.dataconsuerexample.config;

import com.example.dataconsuerexample.component.DataConsumer;
import com.example.dataconsuerexample.component.DataStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DataConsumerRegistry {
    @Value("${num:5}")
    private int dataConsumerNum;

    @Autowired
    private DataStorage dataStorage;

    @Bean
    public List<DataConsumer> initDataConsumers() {
        List<DataConsumer> dataConsumers = new ArrayList<>(dataConsumerNum);
        for (int i = 1; i <= dataConsumerNum; ++i) {
            dataConsumers.add(new DataConsumer(i, dataStorage));
        }
        return dataConsumers;
    }
}
