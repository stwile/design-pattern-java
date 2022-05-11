package memento;

import memento.game.Gamer;
import memento.game.Memento;

public class Main {
  public static void main(String[] args) {
    Gamer gamer = new Gamer(100);
    Memento memento = gamer.createMemento();

    for (int i = 0; i < 100; i++) {
      System.out.printf("==== %d%n", i);
      System.out.printf("現状:%s%n", gamer);

      // ゲームを進める
      gamer.bet();

      System.out.printf("所持金は%d円になりました", gamer.getMoney());

      if (gamer.getMoney() > memento.getMoney()) {
        System.out.println("※だいぶ増えたので、現在の状態を保存しておこう！");
        memento = gamer.createMemento();
      } else if (gamer.getMoney() < memento.getMoney() / 2) {
        System.out.println("※だいぶ減ったので、以前の状態を復元しよう！");
        gamer.restoreMemento(memento);
      }

      try {
        Thread.sleep(1000);
      } catch (InterruptedException ignored) {
      }
    }
    System.out.println();
  }
}
