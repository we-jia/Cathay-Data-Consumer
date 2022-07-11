package com.example.dataconsuerexample;

import com.example.dataconsuerexample.component.DataConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.List;

@SpringBootApplication
public class DataConsuerExampleApplication implements CommandLineRunner {
    @Autowired
    private List<DataConsumer> dataConsumers;

    public static void main(String[] args) {
        SpringApplication.run(DataConsuerExampleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(dataConsumers.size());
        for (DataConsumer dataConsumer : dataConsumers) {
            // 因為這邊是blocking
            // 所以沒有辦法一次讓所有的bean都執行
            dataConsumer.consume();
        }
    }
}
