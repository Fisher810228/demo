package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {
  protected Card selectedCard;
  protected List<Card> handCards = new ArrayList<>();
  private String name;
  private int point;
  private int exchangeCount = 0;
  private HandCardExchange handCardExchange;

  public HandCardExchange getHandCardExchange() {
    return handCardExchange;
  }


  public List<Card> getHandCards() {
    return handCards;
  }

  public void setHandCards(List<Card> handCards) {
    this.handCards = handCards;
  }

  public int getExchangeCount() {
    return exchangeCount;
  }

  public abstract void select(int i);

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void addPoint(int point) {
    this.point += point;
  }

  public int getPoint() {
    return this.point;
  }

  public void exchangeHands(Player changePlayer, int changeRound) {
    exchangeCount++;
    this.handCardExchange = new HandCardExchange();
    handCardExchange.setChangePlayer(changePlayer);
    handCardExchange.setChangeRound(changeRound);
    List<Card> afterHandCards = changePlayer.getHandCards();
    List<Card> beforeHandCards = this.getHandCards();
    this.setHandCards(afterHandCards);
    changePlayer.setHandCards(beforeHandCards);

  }

  public Card show() {
    handCards.remove(selectedCard);
    return selectedCard;
  }

  public void showHandCards() {
    for (int j = 0; j < handCards.size(); j++) {
      Card card = handCards.get(j);
      System.out.println(j + ":" + card);
    }
  }
}
