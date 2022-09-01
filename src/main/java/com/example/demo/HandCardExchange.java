package com.example.demo;

public class HandCardExchange {
  private int changeRound;

  public boolean changeBack(int round){
    return round == changeRound + 3;
  }
  public int getChangeRound() {
    return changeRound;
  }

  public void setChangeRound(int changeRound) {
    this.changeRound = changeRound;
  }

  public Player getChangePlayer() {
    return changePlayer;
  }

  public void setChangePlayer(Player changePlayer) {
    this.changePlayer = changePlayer;
  }

  private Player changePlayer;
}
