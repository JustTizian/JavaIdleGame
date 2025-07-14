public class Currency {

    long amount = 100;

    public void add(long _amount){
        this.amount += _amount;
    }

    public void subtract(long _amount){
        this.amount -= _amount;
    }

    public long getAmount(){
        return this.amount;
    }
}
