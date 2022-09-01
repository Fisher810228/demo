package com.example.demo;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PokerGameTest {

  @Test
  public void PokerHave4Player() {
    PokerGame pokerGame = new PokerGame(List.of(new RealPlayer()));
    assertEquals(4, pokerGame.getPlayerList().size());
  }

  @Test
  public void PlayerHaveName() {
    PokerGame pokerGame = new PokerGame(List.of(new RealPlayer()));
    pokerGame.start();
    for (Player player : pokerGame.getPlayerList()) {
      assertNotNull(player.getName());
    }
  }

  @Test
  public void PlayerHave13CardInHands() {
    PokerGame pokerGame = new PokerGame(List.of(new RealPlayer()));
    pokerGame.start();
    for (Player player : pokerGame.getPlayerList()) {
      assertEquals(13, player.getHandCards().size());
    }
  }

}