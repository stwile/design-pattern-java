package strategy;

public class Main {
  public static void main(String[] args) {
    if (args.length != 2) {
      System.out.println("Usage: java Main randomSeed1 randomSeed2");
      System.out.println("Example: java Main 314 15");
      System.exit(0);
    }

    int seed1 = Integer.parseInt(args[0]);
    int seed2 = Integer.parseInt(args[1]);

    Player player1 = new Player("Taro", new WinningStrategy(seed1));
    Player player2 = new Player("Hana", new ProbStrategy(seed2));

    for (int i = 0; i < 10000; i++) {
      Hand nextHand1 = player1.nextHand();
      Hand nextHand2 = player2.nextHand();

      if (nextHand1.isStrongerThan(nextHand2)) {
        System.out.printf("Winner: %s", player1);
        player1.win();
        player2.lose();
      } else if (nextHand2.isStrongerThan(nextHand1)) {
        System.out.printf("Winner: %s", player2);
        player1.lose();
        player2.win();
      } else {
        System.out.println("Even...");
        player1.even();
        player2.even();
      }
    }
    System.out.println("Total Result");
    System.out.println(player1);
    System.out.println(player2);
  }
}
