import java.util.*;
public class Player{
    Random r = new Random();
    public double cash;
    public boolean hardMode = false;
    private int[] dice;
    public int[] bid = {1,1};

    public Player(){
	cash = 500;
	dice = new int[6];
    }
    public Player(int a){
	cash = 500;
	dice = new int[a];
    }
    public Player(int a, boolean difficult){
	this(a);
	hardMode = difficult;
    }
    public double getCash(){
	return cash;
    }

    public String wordBid(){
	String s1 = "";
	String s2 = "";
	if(bid[1] == 0)
	    s1 = "zero";
	if(bid[1] == 1)
	    s1 = "one";
	if(bid[1] == 2)
	    s1 = "two";
	if(bid[1] == 3)
	    s1 = "three";
	if(bid[1] == 4)
	    s1 = "four";
	if(bid[1] == 5)
	    s1 = "five";
	if(bid[1] == 6)
	    s1 = "six";
	if(bid[1] == 7)
	    s1 = "seven";
	if(bid[1] == 8)
	    s1 = "eight";
	if(bid[1] == 9)
	    s1 = "nine";
	if(bid[1] == 10)
	    s1 = "ten";
	if(bid[1] > 10)
	    s1 = ""+bid[1];
	if(bid[0] == 1)
	    s2 = "ones";
	if(bid[0] == 2)
	    s2 = "twos";
	if(bid[0] == 3)
	    s2 = "threes";
	if(bid[0] == 4)
	    s2 = "fours";
	if(bid[0] == 5)
	    s2 = "fives";
	if(bid[0] == 6)
	    s2 = "sixes";
	if(bid[0] == -1)
	    return "liar";
	return s1 +" "+ s2;
    }
	

    public void addCash(double amount){
	cash += amount;
    }

    public void giveMoney(double amount, Player other){
	cash -= amount;
	other.addCash(amount);
    }
    /*
    public int[] bid(){
	int[] b = new int[2];
	System.out.println("enter face value (bid '-1' for liar)");
	Scanner s = new Scanner(System.in);
	b[0]=s.nextInt();
	if(b[0] != -1){
	    System.out.println("choose number of dice");
	    b[1] = s.nextInt();
	}
	bid = b;
	return b;
    }
    */

    public int[] bid(){
	int[] b = new int[2];
	System.out.println("enter face value (bid '-1' for liar)");
	Scanner s = new Scanner(System.in);
	b[0]=s.nextInt();
	if(b[0] != -1){
	    System.out.println("choose number of dice");
	    b[1] = s.nextInt();
	}
	bid = b;
	return b;
    }
    

    public boolean bid(int faceVal, int dieCount){
	int[] b = bid();
	if(faceVal <= 6 && b[0] <= 6 && b[0] > 0){
	    if((faceVal >= b[0] && dieCount < b[1])||(faceVal < b[0] && dieCount <= b[1])){
		bid = b;
		return true;
	    }
	}else{
	if(b[0] == -1){
	    bid = b;
	    return true;
	}
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
	bid[0] = 1;
	bid[1] = 1;
    }
    public void bidAI(int faceVal, int dieCount, int size){
	int a = howMany(faceVal) + (dice.length/4);
	for(int i = 0; i < (size - 2) * dice.length; i++){
	    if(r.nextInt(6) == 0)
		a++;
	}
	if(dieCount > a){
	    bid[0] = -1;
	}
	if(dieCount <= a){
	    boolean other = true;
	    for(int i = 0; i < 2; i++){
		int c = r.nextInt(size) + 1;
		int x = 2 * howMany(c) + 2;
		if(x > a){
		    other = false;
		    i++;
		    if(c > faceVal){
			bid[0] = c;
			bid[1] = (dieCount + howMany(c) / 3);
		    }else{
			bid[0] = c;
			bid[1] = (dieCount + 1);
		    }
		}
	    }
	    if(other){
		bid[0] = faceVal;
		bid[1] = (dieCount + 1);
	    }
	}
    }
    public void bidGod(Player[] Gamblers, int[] highBid){
	if(hardMode){
	    int a = 0;
	    for(int i = 0; i < Gamblers.length; i++){
		a+=Gamblers[i].howMany(highBid[0]);
	    }
	    if(a < highBid[1]){
		bid[0] = -1;
	    }else{
		if(a == highBid[1]){
		    int x = highBid[0] + 1;
		    boolean thisOne = false;
		    while(x < 7+highBid[0] && thisOne == false){
			if(x%7 == 0){
			    x++;
			}
			int a1 = 0;
			for(int i = 0; i < Gamblers.length; i++){
			    a1+=Gamblers[i].howMany(x%7);
			}
			if(x%7 > highBid[0]){
			    if(a1 >= highBid[0]){
				bid[0] = x%7;
				bid[1] = highBid[1];
				thisOne = true;
			    }
			}else{
			    if(a1 > highBid[0]){
				bid[0] = x%7;
				bid[1] = highBid[1] + 1;
				thisOne = true;
			    }
			}
			x++;
		    }
		    if(thisOne == false){
			bid[0] = -1;
		    }
		}else{
		    bid[0] = highBid[0];
		    bid[1] = highBid[1] + 1;
		}
	    }
	}else{
	    bidAI(highBid[0], highBid[1], Gamblers.length);
	}
    }
    public void bidDumb(int[] highBid){
	if(r.nextInt(10) < highBid[1]){
	    bid[0] = -1;
	}else{
	    if(r.nextInt(2) == 1){
		bid[0] = highBid[0];
		bid[1] = highBid[1] + r.nextInt(2) + 1;
	    }else{
		bid[0] = highBid[0]%6 + 1;
		bid[1] = highBid[1] + r.nextInt(1) + 1;
	    }
	}
    }
}
