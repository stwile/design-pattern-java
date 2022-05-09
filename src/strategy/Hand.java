package strategy;

public enum Hand {
  ROCK("グー", 1),
  SCISSORS("チョキ", 2),
  PAPER("パー", 3);

  private final String name; // じゃんけんの手の名前
  private final int handValue; // じゃんけんの手の値

  private static final Hand[] hands = {ROCK, SCISSORS, PAPER};

  private Hand(String name, int handValue) {
    this.name = name;
    this.handValue = handValue;
  }

  // 手の値からenum定数を得る
  public static Hand getHand(int handValue) {
    return hands[handValue];
  }

  public boolean isStrongerThan(Hand h) {
    if (this == h) {
      return false;
    }
    return (this.handValue + 1) % 3 == h.handValue;
  }

  @Override
  public String toString() {
    return this.name;
  }
}
