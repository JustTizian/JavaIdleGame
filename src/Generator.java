public class Generator {

    long rate;
    int amount;
    int price = 100;

    Generator(long _rate){
        this.rate = _rate;
        amount = 0;
    }

    public long produce(){
        return rate * amount;
    }

    public void buy(){
        if(Game.coins.getAmount() >= this.price){
            this.amount++;
            Game.coins.subtract(this.price);
            this.price = (int) Math.floor(this.price*1.15);
        }
    }
}
