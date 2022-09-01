package com.example.demo;

import java.util.Collections;

public class AIPlayer extends Player {
  @Override
  public void select(int i) {
    Collections.shuffle(handCards);
    selectedCard = handCards.remove(0);
  }
}
