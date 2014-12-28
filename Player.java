import java.util.*;
public class Player{
    Random r = new Random();
    private double cash;
    private int[] dice = new int[6];
    public int[] bid = {0,0};

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
    public int[] bid(){
	int[] b = new int[2];
	System.out.println("make bid");
	Scanner s = new Scanner(System.in);
	for(int i = 0; i < 2; i++){
	    b[i] = s.nextInt();
	}
	return b; 
    }
    public boolean bid(int faceVal, int dieCount){
	int[] b = bid();
	if(faceVal <= 6 && b[0] <= 6 && b[0] > 0){
	    if((faceVal < b[0] && dieCount <= b[1])||(faceVal <= b[0] && dieCount < b[1])){
		bid = b;
		return true;
	    }
	}
	if(b[0] == -1){
	    bid = b;
	    System.out.println("liar");
	    return true;
	}
	bid[0] = -1;
	System.out.println("invalid bid,<liar called>");
	return false;
	
    }
    public void roll(){
	for(int i = 0; i < dice.length; i++){
	    dice[i] = r.nextInt(6) + 1;
	}
    }
    public int[] getBid(){
	return bid;
    }
    public int howMany(int a){
	int x = 0;
	for(int i = 0; i < dice.length; i++){
	    if(dice[i] == a){
		x++;
	    }
	}
	return x;
    }
    public int[] getDice(){
	return dice;
    }
    public void reset(){
	bid[0] = 0;
	bid[1] = 0;
    }
}