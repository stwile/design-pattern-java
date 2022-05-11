package memento.game;

import java.util.ArrayList;
import java.util.List;

public class Memento {
  private final int money;
  private final List<String> fruits;

  public int getMoney() {
    return money;
  }

  public Memento(int money) {
    this.money = money;
    this.fruits = new ArrayList<>();
  }

  void addFruit(String fruit) {
    fruits.add(fruit);
  }

  public List<String> getFruits() {
    return new ArrayList<>(fruits);
  }
}
