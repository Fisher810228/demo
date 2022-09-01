package com.example.demo;

import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
    PokerGame pokerGame = new PokerGame(List.of(new RealPlayer()));
    pokerGame.start();
  }

}
