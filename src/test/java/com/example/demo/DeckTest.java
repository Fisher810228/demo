package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeckTest {

  @Test
  public void testDeskHave52Card() {
    Deck deck = new Deck();
    assertEquals(52, deck.getCardList().size());
  }

}