package io.github.tomaskul.dddroomwithviewapplication;

import io.github.tomaskul.dddroomwithviewdomain.MyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RoomWithViewApplication {

    private static MyService service;
    public static void main(String[] args) {
        SpringApplication.run(RoomWithViewApplication.class, args);
        service.helloWorld();
    }
}
