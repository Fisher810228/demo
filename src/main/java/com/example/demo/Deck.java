package com.example.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

  private List<Card> cardList;

  public Deck() {
    cardList = new ArrayList<>();
    for (Card.Suit suit : Card.Suit.values()) {
      for (int rankIndex = 1; rankIndex <= 13; rankIndex++) {
        Card card = new Card();
        card.setSuit(suit);
        card.setRank(new Rank(rankIndex));
        cardList.add(card);
      }
    }
  }

  public List<Card> getCardList() {
    return cardList;
  }

  public void setCardList(List<Card> cardList) {
    this.cardList = cardList;
  }

  public void shuffle() {
    Collections.shuffle(cardList);
  }

  public Card draw() {
    return cardList.remove(0);
  }
}
