package com.example.demo;

public class RealPlayer extends Player{
  @Override
  public void select(int i) {
    selectedCard = handCards.get(i);
  }
}
