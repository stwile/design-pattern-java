package strategy;

import java.util.Random;

public class ProbStrategy implements Strategy {
  private final Random random;
  private int prevHandValue = 0;
  private int currentHandValue = 0;
  private final int[][] history = {
    {
      1, 1, 1,
    },
    {
      1, 1, 1,
    },
    {
      1, 1, 1,
    },
  };

  public ProbStrategy(int seed) {
    this.random = new Random(seed);
  }

  @Override
  public Hand nextHand() {
    this.prevHandValue = this.currentHandValue;
    final int handValue = this.getHandValue();
    this.currentHandValue = handValue;
    return Hand.getHand(handValue);
  }

  private int getHandValue() {
    int bet = random.nextInt(getSum(this.currentHandValue));
    if (bet < this.history[this.currentHandValue][0]) {
      return 0;
    }
    if (bet < this.history[this.currentHandValue][0] + this.history[this.currentHandValue][1]) {
      return 1;
    }
    return 2;
  }

  private int getSum(int handValue) {
    int sum = 0;
    for (int i = 0; i < 3; i++) {
      sum += history[handValue][i];
    }
    return sum;
  }

  @Override
  public void study(boolean win) {
    if (win) {
      history[this.prevHandValue][this.currentHandValue]++;
    } else {
      history[this.prevHandValue][(this.currentHandValue + 1) % 3]++;
      history[this.prevHandValue][(this.currentHandValue + 2) % 3]++;
    }
  }
}
