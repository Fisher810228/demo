package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayGroundTest {

  @Test
  public void testCompare(){
    Card card = new Card();
    card.setRank(new Rank(3));
    card.setSuit(Card.Suit.Club);
    Card card1 = new Card();
    card1.setRank(new Rank(2));
    card1.setSuit(Card.Suit.Club);
    assertEquals(1,card.compareTo(card1));
  }

  @Test
  public void testCompare1(){
    Card card = new Card();
    card.setRank(new Rank(3));
    card.setSuit(Card.Suit.Club);
    Card card1 = new Card();
    card1.setRank(new Rank(3));
    card1.setSuit(Card.Suit.Diamond);
    assertEquals(0,card.compareTo(card1));
  }

}