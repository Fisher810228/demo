package com.example.demo;

public class Card implements Comparable<Card> {
  Suit suit;
  Rank rank;

  @Override
  public String toString() {
    return suit.name() + " " + rank.getNumber();
  }

  public Suit getSuit() {
    return suit;
  }

  public void setSuit(Suit suit) {
    this.suit = suit;
  }

  public Rank getRank() {
    return rank;
  }

  public void setRank(Rank rank) {
    this.rank = rank;
  }

  @Override
  public int compareTo(Card o) {
    if (this.suit.order > o.suit.order) {
      return 1;
    } else if (this.suit == o.suit) {
      if (this.rank.getNumber() > o.rank.getNumber()) {
        return 1;
      }
    }
    return 0;
  }

  public enum Suit {
    Club(1),
    Diamond(2),
    Heart(3),
    Spade(4);
    public int order;

    Suit(int order) {
      this.order = order;
    }
  }
}
