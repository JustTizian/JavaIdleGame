import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Game {

    public static Currency coins = new Currency();

    public Generator gen1 = new Generator(10);

    public void start(){
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                tick();
                printState();
            }
        }, 0, 1000);

        // Input thread
        new Thread(() -> {
            Scanner sc = new Scanner(System.in);
            while (true) {
                String input = sc.nextLine().trim().toLowerCase();

                if (input.equals("buy")) {
                    gen1.buy();
                } else if (input.equals("exit")) {
                    System.out.println("Exiting...");
                    timer.cancel();
                    break;
                } else {
                    System.out.println("Unknown command. Try 'buy' or 'exit'.");
                }
            }
            sc.close();
        }).start();
    }

    private void tick(){
        coins.add(gen1.produce());
    }

    private void printState() {
        System.out.println("Coins: " + coins.getAmount());
        System.out.println("Generator Amount: " + gen1.amount);
        System.out.println("Generator Price: " + gen1.price);

    }
}
