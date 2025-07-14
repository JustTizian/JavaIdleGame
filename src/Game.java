import java.util.Timer;
import java.util.TimerTask;

public class Game {

    public Currency coins = new Currency();

    public void start(){
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                tick();
                printState();
            }
        }, 0, 1000);
    }

    private void printState() {
        System.out.println("Coins: " + coins.getAmount());
    }

    public void tick(){
        coins.add(10);
    }
}
