package com.example.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PokerGame {

  public List<Player> playerList;
  public List<String> randomName = new ArrayList<>() {
    {
      add("Fish");
      add("John");
      add("Mike");
      add("Rudy");
    }
  };
  public Deck deck;

  private PlayGround playGround;

  public PokerGame(List<Player> realPlayer) {
    deck = new Deck();
    playerList = new ArrayList<>();
    playGround = new PlayGround();
    playerList.addAll(realPlayer);
    int aiPlayer = 4 - realPlayer.size();

    for (int i = 0; i < aiPlayer; i++) {
      playerList.add(new AIPlayer());
    }
    Collections.shuffle(playerList);
  }

  public List<Player> getPlayerList() {
    return playerList;
  }

  public void start() {
    playerNaming();
    deck.shuffle();
    playerDrawCard();
    for (int i = 0; i < 13; i++) {
      Player roundWinner = round(i);
      roundWinner.addPoint(1);
    }
    for (Player player : playerList) {
      System.out.println(player.getName() + ":" + player.getPoint());
    }
  }

  private Player round(int round) {
    Scanner scanner = new Scanner(System.in);
    for (Player player : playerList) {
      int cardIndex = 0;
      if (player.getClass() == RealPlayer.class) {
        if (player.getExchangeCount() == 0) {
          System.out.println("交換手牌嗎？(Y/N)");
          String change = scanner.next();
          if (change.equalsIgnoreCase("y")) {
            chaneHandCards(round, scanner, player);
          }
        } else if (player.getExchangeCount() == 1 && player.getHandCardExchange().changeBack(round)) {
          System.out.println("交換回來");
          player.exchangeHands(player.getHandCardExchange().getChangePlayer(), 0);
        }
        System.out.println("選擇一張卡出卡：");
        player.showHandCards();
        cardIndex = scanner.nextInt();
      }
      player.select(cardIndex);
      playGround.addCard(player, player.show());
    }
    return playGround.result();
  }

  private void chaneHandCards(int round, Scanner scanner, Player player) {
    System.out.println("換幾號選手？");
    for (int o = 0; o < playerList.size(); o++) {
      System.out.println(o + ":" + playerList.get(o).getName());
    }
    int i = scanner.nextInt();
    Player changeTargetPlayer = playerList.get(i);
    player.exchangeHands(changeTargetPlayer, round);
    System.out.println("交換成功囉");
  }

  private void playerDrawCard() {
    while (deck.getCardList().size() != 0) {
      for (Player player : playerList) {
        player.getHandCards().add(deck.draw());
      }
    }
  }

  private void playerNaming() {
    for (int i = 0; i < playerList.size(); i++) {
      Player player = playerList.get(i);
      if (player.getClass() == RealPlayer.class) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("請輸入不含空白的名字：");
        String name = scanner.nextLine();
        player.setName(name);
      } else {
        player.setName(randomName.get(i));
      }
    }
  }
}
