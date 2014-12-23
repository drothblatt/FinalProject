import java.util.Random;

public class Player{
    private double cash;
    private boolean liar;
    private int[] dice;
    Random r = new Random();

    public Player(){
	cash = 500;   
    }

    public String getCash(){
	return "$" + cash;
    }

    /*
    public void setCash(double amount){
	cash = amount;
    }
    */

    public void addCash(double amount){
	cash += amount;
    }

    public void giveMoney(double amount, Player other){
	cash -= amount;
	other.addCash(amount);
    }

    public int[] makeBid(){
	int[] bid = new int[2];
	for (int i = 0; i < bid.length; i++){
	    bid[i] = r.nextInt(3);
	}
	return bid; 
    }
    
    public int[] getDice(){
	return dice;
    }
}

    