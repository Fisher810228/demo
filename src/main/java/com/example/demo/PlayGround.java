package com.example.demo;

import java.util.HashMap;
import java.util.Map;

public class PlayGround {
  Map<Player, Card> showedCard = new HashMap<>();
  Card biggestCard;
  Player biggestCardHolder;

  public void addCard(Player player, Card card) {
    showedCard.put(player, card);
  }

  public Player result() {
    showedCard.forEach((player, card) -> {
      System.out.println(player.getName() + ":" + card);
      if (biggestCard != null) {
        if (biggestCard.compareTo(card) == 0) {

          biggestCardHolder = player;
          biggestCard = card;
        }
      } else {
        biggestCardHolder = player;
        biggestCard = card;
      }
    });
    System.out.println("Round winnere is " + biggestCardHolder.getName());
    return biggestCardHolder;
  }
}
