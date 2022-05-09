package strategy;

public class Player {
  private final String name;
  private final Strategy strategy;
  private int winCount;
  private int loseCount;
  private int gameCount;

  // 名前と戦略を授けてプレイヤーをつくる
  public Player(String name, Strategy strategy) {
    this.name = name;
    this.strategy = strategy;
  }

  // 戦略にお伺いを立てて次の手を決める
  public Hand nextHand() {
    return this.strategy.nextHand();
  }

  // 勝った
  public void win() {
    this.strategy.study(true);
    this.winCount++;
    this.gameCount++;
  }

  // 負けた
  public void lose() {
    this.strategy.study(false);
    this.loseCount++;
    this.gameCount++;
  }

  // 引き分け
  public void even() {
    this.gameCount++;
  }

  @Override
  public String toString() {
    return String.format(
        "[name: %s games, %d win, %d lose]", this.gameCount, this.winCount, this.loseCount);
  }
}
